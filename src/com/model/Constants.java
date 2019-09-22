package com.model;

public interface Constants {
    int MAX_COUNT_OF_ALL_LINES = 100000;
    String INLINE_SPLITTER = " ";
    String SERVICE_AND_QUESTION_SPLITTER = "\\.";
    String DATE_SPLITTER = "\\-";

    String SERVICE_VALIDATION_REGEX = "(([1-9]|10)(\\.[1-3])?)";
    String SERVICE_VALIDATION_QUERY_REGEX  = "(([1-9]|10)(\\.[1-3])?)|\\*";
    String QUESTION_VALIDATION_REGEX = "(([1-9]|10)(\\.([1-9]|1[0-9]|20)(\\.[1-5])?)?)";
    String QUESTION_VALIDATION_FOR_QUERY_REGEX = "(([1-9]|10)(\\.([1-9]|1[0-9]|20)(\\.[1-5])?)?)|\\*";
    String DATE_VALIDATION_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)$";
    String DATE_PERIOD_VALIDATION_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)\\-(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)$";
    String DATE_FORMAT = "dd.MM.yyyy";
    String TIME_VALIDATION_REGEX = "\\d+";

    String OUTPUT_NOT_DEFINED = "-";
    String SPECIAL_VALUE = "*";
}
