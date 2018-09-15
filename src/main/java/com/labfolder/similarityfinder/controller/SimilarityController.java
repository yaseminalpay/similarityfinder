package com.labfolder.similarityfinder.controller;

import com.labfolder.similarityfinder.model.SimilarityInput;
import com.labfolder.similarityfinder.model.SimilarityResult;
import com.labfolder.similarityfinder.service.SimilarityFinderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequestMapping(value = "api/v1/eln")
public class SimilarityController {

    @Autowired
    SimilarityFinderService similarityFinderService;

    @RequestMapping(value = "/similarity", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SimilarityResult> findSimilarities(final @RequestBody @Valid SimilarityInput similarityInput) {
        log.info("Finding similarities in {} for keyword {}", similarityInput.getNotebookEntry(), similarityInput.getKeyword());
        SimilarityResult result = similarityFinderService.findSimilarities(similarityInput);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
