package com.example.doan.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @SerializedName("id")
    public int id;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("level")
    public int level;
    @SerializedName("value")
    public String value;
}
