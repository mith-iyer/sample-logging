package com.oal.innovationweek.samplelogging.repository;

import com.oal.innovationweek.samplelogging.domain.WorkshopSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WorkshopSessionRepository extends JpaRepository<WorkshopSession, Long> {

}
