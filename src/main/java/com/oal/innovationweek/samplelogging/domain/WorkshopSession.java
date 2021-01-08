package com.oal.innovationweek.samplelogging.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkshopSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshopSessionId;
    private Long workshopId;
    private Long speakerId;
    private Integer attendeesMax;
    private Date workshopSessionStartDate;
    private Date workshopSessionEndDate;

    @OneToOne(mappedBy = "session")
    @JsonManagedReference
    private Workshop workshop;

    @OneToOne(mappedBy = "session")
    @JsonManagedReference
    private Speaker speaker;

    @ManyToMany(mappedBy = "session")
    @JsonManagedReference
    private List<Attendee> attendees;

    public Long getWorkshopSessionId() {
        return workshopSessionId;
    }

    public void setWorkshopSessionId(Long workshopSessionId) {
        this.workshopSessionId = workshopSessionId;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
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

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "WorkshopSession{" +
                "workshopSessionId=" + workshopSessionId +
                ", workshopId=" + workshopId +
                ", speakerId=" + speakerId +
                ", attendeesMax=" + attendeesMax +
                ", workshopSessionStartDate=" + workshopSessionStartDate +
                ", workshopSessionEndDate=" + workshopSessionEndDate +
                '}';
    }
}
