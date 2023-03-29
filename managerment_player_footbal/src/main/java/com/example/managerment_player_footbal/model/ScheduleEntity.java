package com.example.managerment_player_footbal.model;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;
    @Column
    private int classId;
    @Column
    private int subjectId;
    @Column
    private Date scheduleDate;
    @Column
    private Time startTime;
    @Column
    private Time endTime;
    @Column
    private String location;
    @Column
    private String trainingDescription;

    public ScheduleEntity() {
    }

    public ScheduleEntity(int scheduleId, int classId, int subjectId, Date scheduleDate,
                          Time startTime, Time endTime, String location, String trainingDescription) {
        this.scheduleId = scheduleId;
        this.classId = classId;
        this.subjectId = subjectId;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.trainingDescription = trainingDescription;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }
}
