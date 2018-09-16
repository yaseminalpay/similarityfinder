package com.labfolder.similarityfinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarityInput {
    @NotNull
    @NotEmpty
    String notebookEntry;
    @NotNull
    @NotEmpty
    String keyword;
}

