package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.model.WorkshopSession;

import java.util.List;

public interface WorkshopSessionService {
    List<WorkshopSession> getAllWorkshopSessions();

    WorkshopSession getWorkshopSessionById(Long workshopSessionId);

    List<WorkshopSession> createWorkshopSession(WorkshopSession session);

    WorkshopSession updateWorkshopSession(Long sessionId, Attendee attendee);
}
