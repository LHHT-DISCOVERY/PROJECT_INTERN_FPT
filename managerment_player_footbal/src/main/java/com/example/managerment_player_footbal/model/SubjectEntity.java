package com.example.managerment_player_footbal.model;


import javax.persistence.*;


@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    @Column(columnDefinition = "nvarchar(255)")
    private String subjectName;

    public SubjectEntity() {
    }

    public SubjectEntity(int subjectId, String subjectName, int time) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
