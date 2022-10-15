package com.tn2x.hungt2009a;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feedbacks")
public class Feedbacks {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String email;
    private String type;
    private Integer response_status;
    private String description;

    public Feedbacks(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getResponse_status() {
        return response_status;
    }

    public void setResponse_status(Integer response_status) {
        this.response_status = response_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
