package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.converter.SpeakerConverter;
import com.oal.innovationweek.samplelogging.model.Speaker;
import com.oal.innovationweek.samplelogging.repository.SpeakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(SpeakerServiceImpl.class);

    private final SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public List<Speaker> getAllSpeakers() {
        return SpeakerConverter.entityToModel(speakerRepository.findAll());
    }

    @Override
    public Speaker getSpeakerById(Long speakerId) {
        com.oal.innovationweek.samplelogging.domain.Speaker speaker = speakerRepository.findById(speakerId).orElse(null);

        log.info("Speaker exists: " + speaker == null);
        return speaker == null ? null : SpeakerConverter.entityToModel(speaker);
    }

    @Override
    public List<Speaker> createSpeaker(Speaker speaker) {
        Long speakerId = speakerRepository.save(SpeakerConverter.modelToEntity(speaker)).getSpeakerId();


        log.info("Speaker created with id: " + speakerId);
        return SpeakerConverter.entityToModel(speakerRepository.findAll());
    }
}
