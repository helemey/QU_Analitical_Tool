package com.model.dataType.Line;

import com.model.dataType.Question;
import com.model.dataType.ResponseType;
import com.model.dataType.Service;

public abstract class GeneralRequest {
    private Service service;
    private Question questionType;
    private ResponseType responseType;

    public Service getService() {
        return service;
    }

    public Question getQuestionType() {
        return questionType;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setQuestionType(Question questionType) {
        this.questionType = questionType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
}
