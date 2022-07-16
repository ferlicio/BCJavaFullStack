package com.soulcode.Servicos.Controllers.Excetions;

import java.time.Instant;

public class StandardError {

    //modelo de exceção de como será exibido o erro

    private Instant timestamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;

    public StandardError(){}

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timetamp) {
        this.timestamp = timetamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
