package com.labfolder.similarityfinder.controller;

import com.labfolder.similarityfinder.model.SimilarityInput;
import com.labfolder.similarityfinder.model.SimilarityResult;
import com.labfolder.similarityfinder.service.SimilarityFinderService;
import org.assertj.core.util.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SimilarityControllerTests {

    @InjectMocks
    SimilarityController sut;

    @Mock
    SimilarityFinderService similarityFinderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_get_similarity_from_similarity_service() {
        SimilarityInput input = new SimilarityInput("entry", "keyword");
        SimilarityResult result = new SimilarityResult("keyword", 0, Sets.newHashSet());
        Mockito.when(similarityFinderService.findSimilarities(input)).thenReturn(result);
        ResponseEntity<SimilarityResult> response = sut.findSimilarities(input);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(result, response.getBody());
    }

    @Test(expected = Error.class)
    public void should_throw_400_when_entry_is_blank() {
        SimilarityInput input = new SimilarityInput("", "keyword");
        ResponseEntity<SimilarityResult> response = sut.findSimilarities(input);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test(expected = Error.class)
    public void should_throw_400_when_keyword_is_blank() {
        SimilarityInput input = new SimilarityInput("entry", "");
        ResponseEntity<SimilarityResult> response = sut.findSimilarities(input);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}
