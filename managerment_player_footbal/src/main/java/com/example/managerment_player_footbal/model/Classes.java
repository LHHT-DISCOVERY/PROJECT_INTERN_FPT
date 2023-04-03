package com.example.managerment_player_footbal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;


    @Min(value = 10, message = "Sô lượng học viên trong 1 lớp phải từ 10 thành viên  trở lên ")
    private int capacity;

    @Column(name = "className")
    @NotBlank(message = "Không được để trống")
    private String className;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được để trống")
    private Date startDate;

    @NotNull(message = "Không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    @JsonBackReference
    private Coach coach;


    @OneToMany(mappedBy = "classes")
    @JsonManagedReference
    private Set<Player> playerSet;

    @OneToMany(mappedBy = "classEntity")
    @JsonManagedReference
    private Set<TeamEntity> teamEntities;
    @OneToMany(mappedBy = "classes")
    @JsonManagedReference
    private Set<CoachRatingEntity> coachRatingEntities;

    public Classes() {
    }

    public Classes(int classId, int capacity, String className, Date startDate, Date endDate, Coach coach, Set<Player> playerSet, Set<TeamEntity> teamEntities, Set<CoachRatingEntity> coachRatingEntities) {
        this.classId = classId;
        this.capacity = capacity;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coach = coach;
        this.playerSet = playerSet;
        this.teamEntities = teamEntities;
        this.coachRatingEntities = coachRatingEntities;
    }


    public Classes(int classId, int capacity, String className, Date startDate, Date endDate, Coach coach) {
        this.classId = classId;
        this.capacity = capacity;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coach = coach;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<TeamEntity> getTeamEntities() {
        return teamEntities;
    }

    public void setTeamEntities(Set<TeamEntity> teamEntities) {
        this.teamEntities = teamEntities;
    }

    public Set<CoachRatingEntity> getCoachRatingEntities() {
        return coachRatingEntities;
    }

    public void setCoachRatingEntities(Set<CoachRatingEntity> coachRatingEntities) {
        this.coachRatingEntities = coachRatingEntities;
    }

    public void setPlayerSet(Set<Player> playerSet) {
        this.playerSet = playerSet;
    }
}
