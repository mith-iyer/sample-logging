package com.oal.innovationweek.samplelogging.converter;

import com.oal.innovationweek.samplelogging.model.Speaker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpeakerConverter {
    public SpeakerConverter() {
    }

    public static Speaker entityToModel(com.oal.innovationweek.samplelogging.domain.Speaker speaker) {
        Speaker model = new Speaker();
        model.setSpeakerId(speaker.getSpeakerId());
        model.setFirstName(speaker.getFirstName());
        model.setLastName(speaker.getLastName());
        model.setEmailAddress(speaker.getEmailAddress());

        return model;
    }

    public static List<Speaker> entityToModel(List<com.oal.innovationweek.samplelogging.domain.Speaker> speaker) {
       return speaker.stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    public static com.oal.innovationweek.samplelogging.domain.Speaker modelToEntity(Speaker speaker) {
        com.oal.innovationweek.samplelogging.domain.Speaker entity = new com.oal.innovationweek.samplelogging.domain.Speaker();
        entity.setSpeakerId(speaker.getSpeakerId());
        entity.setFirstName(speaker.getFirstName());
        entity.setLastName(speaker.getLastName());
        entity.setEmailAddress(speaker.getEmailAddress());

        return entity;
    }

    public static List<com.oal.innovationweek.samplelogging.domain.Speaker> modelToEntity(List<Speaker> speaker) {
        return speaker.stream().map(x -> modelToEntity(x)).collect(Collectors.toList());
    }
}
