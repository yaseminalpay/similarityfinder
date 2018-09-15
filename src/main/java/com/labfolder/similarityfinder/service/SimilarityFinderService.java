package com.labfolder.similarityfinder.service;

import com.labfolder.similarityfinder.model.SimilarityInput;
import com.labfolder.similarityfinder.model.SimilarityResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SimilarityFinderService {

    private final String WORD_SPLITTER = "\\s+";
    private final int LEVENSHTEIN_THRESHOLD = 1;

    public SimilarityResult findSimilarities(SimilarityInput input) {
        final String keyword = input.getKeyword();
        final String[] words = input.getNotebookEntry().trim().split(WORD_SPLITTER);

        List<String> similarWords = Arrays.stream(words)
                .filter(word -> isWordsSimilar(word, keyword))
                .collect(Collectors.toList());
        log.info("Similar words found for keyword {} : {}", keyword, similarWords);

        long frequency = similarWords
                .stream()
                .filter(word -> keyword.equals(word))
                .count();
        log.info("Frequency for keyword {} : {}", keyword, frequency);

        Set<String> similarWordSet = new HashSet<>(similarWords);
        similarWordSet.remove(keyword);

        return new SimilarityResult(keyword, frequency, similarWordSet);
    }

    private boolean isWordsSimilar(String word1, String word2) {
        LevenshteinDistance levenshtein = new LevenshteinDistance(LEVENSHTEIN_THRESHOLD);
        return levenshtein.apply(word1, word2) != -1;
    }

}
