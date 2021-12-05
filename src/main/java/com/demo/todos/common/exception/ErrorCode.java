package com.demo.todos.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    NOT_AUTHORIZED(401, "Not Authorized"),
    INTERNAL_SERVER_ERROR(500, "Server error")
    ;

    private final int status;
    private final String error;

    ErrorCode(final int status, final String error) {
        this.error = error;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return this.error;
    }

}
