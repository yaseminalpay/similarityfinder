package com.labfolder.similarityfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntityException badRequest(Exception ex) {
        return new ResponseEntityException(400,
                ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntityException notFound(Exception ex) {
        return new ResponseEntityException(404,
                ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntityException internalServerError(Exception ex) {
        return new ResponseEntityException(500,
                ex.getMessage());
    }
}
