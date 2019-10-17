package com.example.schat.Utils;

import com.example.schat.models.UserProfile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DummyFactory {
    public static List<UserProfile> getDummyUserList(int size) {
        List<UserProfile> userProfiles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserProfile userProfile = new UserProfile();
            userProfile.setLastseen_date(new Date());
            userProfile.setNickname("Nickname " + i);
            userProfile.setStat_string("This is a status. this status is a dummy");
            userProfile.setUsername("Username" + i);

            userProfiles.add(userProfile);
        }
        return userProfiles;
    }
}
