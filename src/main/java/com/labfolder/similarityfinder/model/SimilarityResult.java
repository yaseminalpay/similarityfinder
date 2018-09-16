package com.labfolder.similarityfinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarityResult {
    private String keyword;
    private long frequency;
    private Set<String> similarWords;
}
