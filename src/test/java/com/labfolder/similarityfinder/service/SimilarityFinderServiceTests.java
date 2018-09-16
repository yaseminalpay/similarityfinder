package com.labfolder.similarityfinder.service;

import com.labfolder.similarityfinder.model.SimilarityInput;
import com.labfolder.similarityfinder.model.SimilarityResult;
import org.assertj.core.util.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimilarityFinderServiceTests {

    @InjectMocks
    SimilarityFinderService sut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_similarities_when_levenshtein_distance_is_1() {
        SimilarityInput input =  new SimilarityInput("Word Words Wor word", "Word");
        SimilarityResult result = sut.findSimilarities(input);
        Set<String> expected = new HashSet<>(Arrays.asList("Words", "Wor", "word"));
        Assert.assertEquals("Could not find similarity when distance is 1", expected, result.getSimilarWords());
        Assert.assertEquals("Could not find frequency", 1, result.getFrequency());
    }

    @Test
    public void should_not_find_similarities_when_levenshtein_distance_is_more_than_1() {
        SimilarityInput input =  new SimilarityInput("Wo words Word", "Word");
        SimilarityResult result = sut.findSimilarities(input);
        Set<String> expected = Sets.newHashSet();
        Assert.assertEquals("Could not find similarity when distance is 1", expected, result.getSimilarWords());
        Assert.assertEquals("Could not find frequency", 1, result.getFrequency());
    }

    @Test
    public void should_find_similarities_when_words_are_same_with_different_case() {
        SimilarityInput input =  new SimilarityInput("Word Word Word word", "Word");
        SimilarityResult result = sut.findSimilarities(input);
        Set<String> expected = new HashSet<>(Arrays.asList("word"));
        Assert.assertEquals("Could not find similarity when words are the same with different case", expected, result.getSimilarWords());
        Assert.assertEquals("Could not find frequency", 3, result.getFrequency());
    }

    @Test
    public void should_return_0_values_when_no_similarities_found() {
        SimilarityInput input =  new SimilarityInput("Word Word Word word", "Apple");
        SimilarityResult result = sut.findSimilarities(input);
        Set<String> expected = Sets.newHashSet();
        Assert.assertEquals("Similarity not empty", expected, result.getSimilarWords());
        Assert.assertEquals("Frequency is not zero", 0, result.getFrequency());
    }

}
