package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.model.WorkshopSession;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees();

    Attendee getAttendeeById(Long attendeeId);

    List<Attendee> createAttendee(Attendee attendee);

    WorkshopSession subscribeToWorkshopSession(Long sessionId, Attendee attendee);
}
