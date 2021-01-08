package com.oal.innovationweek.samplelogging.converter;

import com.oal.innovationweek.samplelogging.model.Attendee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendeeConverter {
    public AttendeeConverter() {
    }

    public static Attendee entityToModel(com.oal.innovationweek.samplelogging.domain.Attendee attendee) {
        Attendee model = new Attendee();
        model.setAttendeeId(attendee.getAttendeeId());
        model.setFirstName(attendee.getFirstName());
        model.setLastName(attendee.getLastName());
        model.setEmailAddress(attendee.getEmailAddress());

        return model;
    }

    public static List<Attendee> entityToModel(List<com.oal.innovationweek.samplelogging.domain.Attendee> attendee) {
        return attendee.stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    public static com.oal.innovationweek.samplelogging.domain.Attendee modelToEntity(Attendee attendee) {
        com.oal.innovationweek.samplelogging.domain.Attendee entity = new com.oal.innovationweek.samplelogging.domain.Attendee();
        entity.setAttendeeId(attendee.getAttendeeId());
        entity.setFirstName(attendee.getFirstName());
        entity.setLastName(attendee.getLastName());
        entity.setEmailAddress(attendee.getEmailAddress());

        return entity;
    }

    public static List<com.oal.innovationweek.samplelogging.domain.Attendee> modelToEntity(List<Attendee> attendee) {
        return attendee.stream().map(x -> modelToEntity(x)).collect(Collectors.toList());
    }
}
