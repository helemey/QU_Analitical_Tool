package com.model.dataType;

public enum ResponseType {
    P, N;

    public boolean isResponseTypeEquals(ResponseType line) {
        return (this == line);
    }
}
