package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.model.ErrorResponse;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandlerServiceImpl implements ErrorHandlerService {

    @Override
    public ErrorResponse createErrorObject(String title, String detail) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTitle(title);
        errorResponse.setDetail(detail);

        return errorResponse;
    }
}
