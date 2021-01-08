package com.oal.innovationweek.samplelogging.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Workshop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshopId;
    private String workshopName;

    @OneToOne
    @JoinColumn(name = "workshopId", referencedColumnName = "workshopId", updatable = false, insertable = false)
    @JsonBackReference
    private WorkshopSession session;

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public WorkshopSession getSession() {
        return session;
    }

    public void setSession(WorkshopSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "workshopId=" + workshopId +
                ", workshopName='" + workshopName + '\'' +
                '}';
    }
}
