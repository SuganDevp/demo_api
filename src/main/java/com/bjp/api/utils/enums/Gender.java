package com.bjp.api.utils.enums;

public enum Gender {
    M("Male"),F("Female");
    public final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
