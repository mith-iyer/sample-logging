package com.oal.innovationweek.samplelogging.model;

import java.util.Date;
import java.util.List;

public class WorkshopSession {
    private Long workshopSessionId;
    private Workshop workshop;
    private Speaker speaker;
    private List<Attendee> attendees;
    private Integer attendeesMax;
    private Date workshopSessionStartDate;
    private Date workshopSessionEndDate;

    public Long getWorkshopSessionId() {
        return workshopSessionId;
    }

    public void setWorkshopSessionId(Long workshopSessionId) {
        this.workshopSessionId = workshopSessionId;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Integer getAttendeesMax() {
        return attendeesMax;
    }

    public void setAttendeesMax(Integer attendeesMax) {
        this.attendeesMax = attendeesMax;
    }

    public Date getWorkshopSessionStartDate() {
        return workshopSessionStartDate;
    }

    public void setWorkshopSessionStartDate(Date workshopSessionStartDate) {
        this.workshopSessionStartDate = workshopSessionStartDate;
    }

    public Date getWorkshopSessionEndDate() {
        return workshopSessionEndDate;
    }

    public void setWorkshopSessionEndDate(Date workshopSessionEndDate) {
        this.workshopSessionEndDate = workshopSessionEndDate;
    }
}
