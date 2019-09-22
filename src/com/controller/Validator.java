package com.controller;

import com.model.Constants;
import com.model.dataType.ResponseType;

class Validator {
    boolean isWaitingTimeLineValid(String[] splitLine) {
        return isServiceValidForWTL(splitLine[1])
                && isQuestionValidForWTL(splitLine[2])
                && isResponseTypeValid(splitLine[3])
                && isDateValid(splitLine[4])
                && isTimeValid(splitLine[5]);
    }

    boolean isQueryValid(String[] separatedLine) {
        return isServiceValidForQuery(separatedLine[1])
                && isQuestionValidForQuery(separatedLine[2])
                && isResponseTypeValid(separatedLine[3])
                && isDatePeriodValid(separatedLine[4]);
    }

    private boolean isServiceValidForWTL(String service) {
        return service.matches(Constants.SERVICE_VALIDATION_REGEX);
    }

    private boolean isServiceValidForQuery(String service) {
        return service.matches(Constants.SERVICE_VALIDATION_QUERY_REGEX);
    }

    private boolean isQuestionValidForWTL(String question) {
        return question.matches(Constants.QUESTION_VALIDATION_REGEX);
    }

    private boolean isQuestionValidForQuery(String question) {
        return question.matches(Constants.QUESTION_VALIDATION_FOR_QUERY_REGEX);
    }

    private boolean isResponseTypeValid(String response) {
        return (ResponseType.valueOf(response) == ResponseType.N) || (ResponseType.valueOf(response) == ResponseType.P);
    }

    private boolean isDateValid(String date) {
        return date.matches(Constants.DATE_VALIDATION_REGEX);
    }

    private boolean isTimeValid(String time) {
        return time.matches(Constants.TIME_VALIDATION_REGEX);
    }

    private boolean isDatePeriodValid(String date) {
        return date.matches(Constants.DATE_VALIDATION_REGEX) || date.matches(Constants.DATE_PERIOD_VALIDATION_REGEX);
    }
}
