package com.perez.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private byte value;
    @Column(name = "soft_skill")
    private boolean softSkill;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getValue() {
        return this.value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public boolean isSoftSkill() {
        return this.softSkill;
    }

    public void setSoftSkill(boolean soft) {
        this.softSkill = soft;
    }

}
