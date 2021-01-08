package com.oal.innovationweek.samplelogging.repository;

import com.oal.innovationweek.samplelogging.domain.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
