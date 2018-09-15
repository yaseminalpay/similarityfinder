package com.labfolder.similarityfinder.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntityException {
    private int code;
    private String description;

    public ResponseEntityException(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
