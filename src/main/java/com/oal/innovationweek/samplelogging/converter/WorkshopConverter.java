package com.oal.innovationweek.samplelogging.converter;

import com.oal.innovationweek.samplelogging.model.Workshop;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkshopConverter {
    public WorkshopConverter() {
    }

    public static Workshop entityToModel(com.oal.innovationweek.samplelogging.domain.Workshop workshop) {
        Workshop model = new Workshop();
        model.setWorkshopId(workshop.getWorkshopId());
        model.setWorkshopName(workshop.getWorkshopName());

        return model;
    }

    public static List<Workshop> entityToModel(List<com.oal.innovationweek.samplelogging.domain.Workshop> workshop) {
        return workshop.stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    public static com.oal.innovationweek.samplelogging.domain.Workshop modelToEntity(Workshop workshop) {
        com.oal.innovationweek.samplelogging.domain.Workshop model = new com.oal.innovationweek.samplelogging.domain.Workshop();
        model.setWorkshopId(workshop.getWorkshopId());
        model.setWorkshopName(workshop.getWorkshopName());

        return model;
    }

    public static List<com.oal.innovationweek.samplelogging.domain.Workshop> modelToEntity(List<Workshop> workshop) {
        return workshop.stream().map(x -> modelToEntity(x)).collect(Collectors.toList());
    }
}