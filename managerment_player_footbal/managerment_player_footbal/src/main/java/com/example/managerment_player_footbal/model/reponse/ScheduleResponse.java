package com.example.managerment_player_footbal.model.reponse;

import java.sql.Date;

public class ScheduleResponse {
    private int scheduleId;
    private int classId;
    private int subjectId;
    private Date scheduleDate;
    private String startTime;
    private String endTime;
    private String location;
    private String trainingDescription;

    public ScheduleResponse() {
    }

    public ScheduleResponse(int scheduleId, int classId, int subjectId, Date scheduleDate,
                            String startTime, String endTime, String location, String trainingDescription) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
