package com.oal.innovationweek.samplelogging.repository;

import com.oal.innovationweek.samplelogging.domain.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}
