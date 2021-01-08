package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.converter.AttendeeConverter;
import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.model.WorkshopSession;
import com.oal.innovationweek.samplelogging.repository.AttendeeRepository;
import com.oal.innovationweek.samplelogging.repository.WorkshopSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final WorkshopSessionRepository workshopSessionRepository;
    private final WorkshopSessionService workshopSessionService;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository, WorkshopSessionRepository workshopSessionRepository, WorkshopSessionService workshopSessionService) {
        this.attendeeRepository = attendeeRepository;
        this.workshopSessionRepository = workshopSessionRepository;
        this.workshopSessionService = workshopSessionService;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return AttendeeConverter.entityToModel(attendeeRepository.findAll());
    }

    @Override
    public Attendee getAttendeeById(Long attendeeId) {
        com.oal.innovationweek.samplelogging.domain.Attendee attendee = attendeeRepository.findById(attendeeId).orElse(null);

        return null == attendee ? null : AttendeeConverter.entityToModel(attendee);
    }

    @Override
    public List<Attendee> createAttendee(Attendee attendee) {
        Long attendeeId = attendeeRepository.save(AttendeeConverter.modelToEntity(attendee)).getAttendeeId();

        return AttendeeConverter.entityToModel(attendeeRepository.findAll());
    }

    @Override
    @Transactional
    public WorkshopSession subscribeToWorkshopSession(Long sessionId, Attendee attendee) {
        com.oal.innovationweek.samplelogging.domain.WorkshopSession session = workshopSessionRepository.findById(sessionId).orElse(null);
        com.oal.innovationweek.samplelogging.domain.Attendee attendeeEntity = AttendeeConverter.modelToEntity(attendee);

        attendeeEntity.setSession(Collections.singletonList(session));
        attendeeRepository.saveAndFlush(attendeeEntity);

        return workshopSessionService.getWorkshopSessionById(sessionId);
    }
}
