package com.oal.innovationweek.samplelogging.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakerId;
    private String firstName;
    private String lastName;
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "speakerId", referencedColumnName = "speakerId", updatable = false, insertable = false)
    @JsonBackReference
    private WorkshopSession session;

    public Speaker() {
    }

    public Speaker(Long speakerId, String firstName, String lastName, String emailAddress) {
        this.speakerId = speakerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public WorkshopSession getSession() {
        return session;
    }

    public void setSession(WorkshopSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "speakerId=" + speakerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
