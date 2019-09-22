package com.controller;

import com.model.Constants;
import com.model.dataType.Line.Query;
import com.model.dataType.Line.WaitingTimeLine;

import java.util.ArrayList;

class AnalyticalTool {
    void executeQuery(Query query, ArrayList<WaitingTimeLine> waitingTimeLines) {
        int totalTimeOfSuitableLines = 0;
        int countOfSuitableLines = 0;
        double averageTime;
        int lineTime;
        for (WaitingTimeLine c : waitingTimeLines) {
            lineTime = timeOfSuitableLines(c, query);
            if (lineTime != 0) {
                totalTimeOfSuitableLines += lineTime;
                countOfSuitableLines++;
            }
        }

        if (countOfSuitableLines != 0) {
            averageTime = totalTimeOfSuitableLines / countOfSuitableLines;
            System.out.println(averageTime);
        } else System.out.println(Constants.OUTPUT_NOT_DEFINED);
    }

    private static int timeOfSuitableLines(WaitingTimeLine waitingTimeLine, Query query) {
        if (isRecordSuitable(waitingTimeLine, query)) {
            return waitingTimeLine.getTime();
        }
        return 0;
    }

    private static boolean isRecordSuitable(WaitingTimeLine c, Query query) {
        return ((query.getService().isServiceEquals(c.getService()))
                && (query.getQuestionType().isQuestionEquals(c.getQuestionType()))
                && (query.getResponseType().isResponseTypeEquals(c.getResponseType()))
                && (query.getQueryDate().isDatePeriodEquals(c.getDate())));
    }
}
