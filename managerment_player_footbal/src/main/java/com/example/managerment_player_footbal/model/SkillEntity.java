package com.example.managerment_player_footbal.model;


import javax.persistence.*;

@Entity
@Table(name = "skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillId;
    @Column
    private String skillName;

    public SkillEntity() {
    }

    public SkillEntity(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
