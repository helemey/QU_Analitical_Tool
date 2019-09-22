package com.controller;

import com.model.Constants;
import com.model.dataType.*;
import com.model.dataType.Line.Query;
import com.model.dataType.Line.WaitingTimeLine;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Parser implements Constants {
    private Validator validator = new Validator();

    void parse(BufferedReader br) {
        String[] separatedLine;
        String line;
        ArrayList<WaitingTimeLine> waitingTimeLines = new ArrayList<>();
        AnalyticalTool analyticalTool = new AnalyticalTool();
        try {
            while ((line = br.readLine()) != null) {
                separatedLine = line.split(INLINE_SPLITTER);
                if (RequestType.C.toString().equals(separatedLine[0])) {
                    waitingTimeLines.add(createWaitingTimeLine(separatedLine));
                } else if (RequestType.D.toString().equals(separatedLine[0])) {
                    analyticalTool.executeQuery(createQuery(separatedLine), waitingTimeLines);
                } else {
                    throw new Exception("Error: wrong type of line!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Query createQuery(String[] separatedLine) throws Exception {
        Query query = new Query();
        if (!validator.isQueryValid(separatedLine)) {
            throw new Exception("Error: Query is not valid!");
        }
        query.setService(parseService(separatedLine[1]));
        query.setQuestionType(parseQuestion(separatedLine[2]));
        query.setResponseType(parseResponse(separatedLine[3]));
        query.setQueryDate(parseDateRange(separatedLine[4]));
        return query;
    }

    private WaitingTimeLine createWaitingTimeLine(String[] separatedLine) throws Exception {
        WaitingTimeLine waitingTimeLine = new WaitingTimeLine();
        if (!validator.isWaitingTimeLineValid(separatedLine)) {
            throw new Exception("Error: Waiting Time Line is not valid!");
        }
        waitingTimeLine.setService(parseService(separatedLine[1]));
        waitingTimeLine.setQuestionType(parseQuestion(separatedLine[2]));
        waitingTimeLine.setResponseType(parseResponse(separatedLine[3]));
        waitingTimeLine.setDate(parseDate(separatedLine[4]));
        waitingTimeLine.setTime(parseTime(separatedLine[5]));
        return waitingTimeLine;
    }

    private Service parseService(String serviceLine) {
        Service service = new Service();
        String[] separatedServiceLine;
        separatedServiceLine = serviceLine.split(Constants.SERVICE_AND_QUESTION_SPLITTER, 0);
        if (separatedServiceLine.length == 2) {
            service.setService(separatedServiceLine[0], separatedServiceLine[1]);
        } else service.setService(separatedServiceLine[0]);
        return service;
    }

    private Question parseQuestion(String questionLine) {
        Question question = new Question();
        String[] separatedQuestionLine;
        separatedQuestionLine = questionLine.split(Constants.SERVICE_AND_QUESTION_SPLITTER);
        if (separatedQuestionLine.length == 3) {
            question.setQuestion(separatedQuestionLine[0], separatedQuestionLine[1], separatedQuestionLine[2]);
        } else if (separatedQuestionLine.length == 2) {
            question.setQuestion(separatedQuestionLine[0], separatedQuestionLine[1]);
        } else question.setQuestion(separatedQuestionLine[0]);
        return question;
    }

    private ResponseType parseResponse(String response) {
        if (ResponseType.P.toString().equals(response)) {
            return ResponseType.P;
        } else return ResponseType.N;
    }

    private Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat(Constants.DATE_FORMAT).parse(date);
    }

    private int parseTime(String time) {
        return Integer.parseInt(time);
    }

    private QueryDate parseDateRange(String dateRange) throws ParseException {
        QueryDate queryDate = new QueryDate();
        if (dateRange.length() > 10) {
            String[] separatedDateLine = dateRange.split(DATE_SPLITTER);
            queryDate.setQueryDate(
                    parseDate(separatedDateLine[0]),
                    parseDate(separatedDateLine[1]));
        } else {
            queryDate.setQueryDate(parseDate(dateRange));
        }
        return queryDate;
    }
}