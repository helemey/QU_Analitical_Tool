package com.model.dataType;

import java.util.Date;

public class QueryDate {
    private Date dateFrom;
    private Date dateTo;

    public void setQueryDate(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public void setQueryDate(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public boolean isDatePeriodEquals(Date line) {
        if (this.dateTo == null) {
            return this.dateFrom.equals(line);
        } else return this.dateFrom.before(line) && this.dateTo.after(line);
    }
}