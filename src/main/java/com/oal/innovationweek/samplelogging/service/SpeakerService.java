package com.oal.innovationweek.samplelogging.service;

import com.oal.innovationweek.samplelogging.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> getAllSpeakers();

    Speaker getSpeakerById(Long speakerId);

    List<Speaker> createSpeaker(Speaker speaker);
}
