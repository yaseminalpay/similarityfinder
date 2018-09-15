package com.labfolder.similarityfinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SimilarityInput {
    @NotNull
    String notebookEntry;
    @NotNull
    String keyword;
}

