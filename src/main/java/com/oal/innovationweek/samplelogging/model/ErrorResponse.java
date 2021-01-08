package com.oal.innovationweek.samplelogging.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
    private String title;
    private String detail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}