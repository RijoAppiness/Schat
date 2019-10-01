package com.example.schat.models;

import androidx.annotation.Nullable;

import java.util.Date;

import javax.xml.transform.Templates;

public class UserProfile {
    private String username,nickname,stat_string;
    private Date lastseen_date;

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        UserProfile userProfile = (UserProfile)obj;
        return userProfile.username.equals(this.username) && userProfile.nickname.equals(this.nickname);
    }

    public Date getLastseen_date() {
        return lastseen_date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLastseen_date(Date lastseen_date) {
        this.lastseen_date = lastseen_date;
    }

    public String getStat_string() {
        return stat_string;
    }

    public void setStat_string(String stat_string) {
        this.stat_string = stat_string;
    }
}


