package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.converter.WorkshopSessionConverter;
import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.model.WorkshopSession;
import com.oal.innovationweek.samplelogging.repository.WorkshopSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.InternalServerErrorException;
import java.util.List;

@Service
public class WorkshopSessionServiceImpl implements WorkshopSessionService {
    private final WorkshopSessionRepository workshopSessionRepository;
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(WorkshopSessionServiceImpl.class);


    public WorkshopSessionServiceImpl(WorkshopSessionRepository workshopSessionRepository) {
        this.workshopSessionRepository = workshopSessionRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<WorkshopSession> getAllWorkshopSessions() {
        return WorkshopSessionConverter.entityToModel(workshopSessionRepository.findAll());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public WorkshopSession getWorkshopSessionById(Long workshopSessionId) {
        com.oal.innovationweek.samplelogging.domain.WorkshopSession workshopEntity = workshopSessionRepository.findById(workshopSessionId).orElse(null);

        return workshopEntity == null ? null : WorkshopSessionConverter.entityToModel(workshopEntity);
    }

    @Override
    public List<WorkshopSession> createWorkshopSession(WorkshopSession session) {
        com.oal.innovationweek.samplelogging.domain.WorkshopSession entity = WorkshopSessionConverter.modelToEntity(session);
        Long workshopSessionId = workshopSessionRepository.saveAndFlush(entity).getWorkshopSessionId();

        log.info("Workshop session created with id: " + workshopSessionId);
        return getAllWorkshopSessions();
    }

    @Override
    public WorkshopSession updateWorkshopSession(Long sessionId, Attendee attendee) throws InternalServerErrorException {
        com.oal.innovationweek.samplelogging.domain.WorkshopSession sessionEntity = workshopSessionRepository.findById(sessionId).orElse(null);

        if (null == sessionEntity) {
            return null;
        }

        if(sessionEntity.getAttendeesMax() <= sessionEntity.getAttendees().size()) {
            log.error("Workshop Session has reached max capacity. No more attendees can be added.");
            throw new InternalServerErrorException("Workshop Session has reached max capacity. No more attendees can be added.");
        }

        WorkshopSession session = WorkshopSessionConverter.entityToModel(sessionEntity);
        List<Attendee> attendees = session.getAttendees();
        attendees.add(attendee);
        session.setAttendees(attendees);
        sessionEntity = WorkshopSessionConverter.modelToEntity(session);
        workshopSessionRepository.saveAndFlush(sessionEntity);

        return getWorkshopSessionById(sessionId);
    }
}
