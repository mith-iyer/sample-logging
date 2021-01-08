package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.model.ErrorResponse;

public interface ErrorHandlerService {
    ErrorResponse createErrorObject(String title, String detail);
}
