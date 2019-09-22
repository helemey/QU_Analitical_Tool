package com.model.dataType.Line;

import com.model.dataType.QueryDate;

public class Query extends GeneralRequest {

    private QueryDate queryDate;

    public void setQueryDate(QueryDate queryDate) {
        this.queryDate = queryDate;
    }

    public QueryDate getQueryDate() {
        return queryDate;
    }
}
