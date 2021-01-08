package com.oal.innovationweek.samplelogging.converter;

import com.oal.innovationweek.samplelogging.model.WorkshopSession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkshopSessionConverter {
    public WorkshopSessionConverter() {
    }

    public static WorkshopSession entityToModel(com.oal.innovationweek.samplelogging.domain.WorkshopSession workshopSession) {
        WorkshopSession model = new WorkshopSession();
        model.setWorkshopSessionId(workshopSession.getWorkshopSessionId());
        model.setWorkshop(WorkshopConverter.entityToModel(workshopSession.getWorkshop()));
        model.setSpeaker(SpeakerConverter.entityToModel(workshopSession.getSpeaker()));
        model.setAttendees(AttendeeConverter.entityToModel(workshopSession.getAttendees()));
        model.setAttendeesMax(workshopSession.getAttendeesMax());
        model.setWorkshopSessionStartDate(workshopSession.getWorkshopSessionStartDate());
        model.setWorkshopSessionEndDate(workshopSession.getWorkshopSessionEndDate());

        return model;
    }

    public static List<WorkshopSession> entityToModel(List<com.oal.innovationweek.samplelogging.domain.WorkshopSession> workshopSession) {
        return workshopSession.stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    public static com.oal.innovationweek.samplelogging.domain.WorkshopSession modelToEntity(WorkshopSession workshopSession) {
        com.oal.innovationweek.samplelogging.domain.WorkshopSession entity = new com.oal.innovationweek.samplelogging.domain.WorkshopSession();
        entity.setWorkshopSessionId(workshopSession.getWorkshopSessionId());
        entity.setWorkshopId(workshopSession.getWorkshop().getWorkshopId());
        entity.setSpeakerId(workshopSession.getSpeaker().getSpeakerId());
        entity.setWorkshop(WorkshopConverter.modelToEntity(workshopSession.getWorkshop()));
        entity.setSpeaker(SpeakerConverter.modelToEntity(workshopSession.getSpeaker()));
        entity.setAttendees(AttendeeConverter.modelToEntity(workshopSession.getAttendees()));
        entity.setAttendeesMax(workshopSession.getAttendeesMax());
        entity.setWorkshopSessionStartDate(workshopSession.getWorkshopSessionStartDate());
        entity.setWorkshopSessionEndDate(workshopSession.getWorkshopSessionEndDate());

        return entity;
    }

    public static List<com.oal.innovationweek.samplelogging.domain.WorkshopSession> modelToEntity(List<WorkshopSession> workshopSession) {
        return workshopSession.stream().map(x -> modelToEntity(x)).collect(Collectors.toList());
    }
}
