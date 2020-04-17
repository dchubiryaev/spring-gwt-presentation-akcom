package com.bidding.shared.dto;

import java.util.HashMap;

public class UserDto extends Dto {
    private static final long serialVersionUID = 1L;

    private boolean isLoggedIn;

    private String login;

    private String email;

    private String googleId;

    private boolean isAdmin;

    private String pictureURL;
    private String time;
    private String timeModified;

    public UserDto() {
        // not logged in user default values
        isLoggedIn = false;
        isAdmin = false;

    }

    public void setAttributes(boolean isLoggedIn, Long id, String login, boolean isAdmin, String pictureURL, String time ,String timeModified, String googleId , String email) {
        setId(id);
        this.isLoggedIn = isLoggedIn;
        this.login = login;
        this.isAdmin = isAdmin;
        this.pictureURL = pictureURL;
        this.time = time;
        this.googleId = googleId;
        this.email = email;
        this.timeModified = timeModified;
    }

    public String getTime() {
        return time;
    }

    public String getTimeModified(){
        return timeModified;
    }

    public String getLogin() {
        return login;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public String getGoogleId(){
        return googleId;
    }

    public void copyFrom(UserDto userToCopy) {
        isLoggedIn = userToCopy.isLoggedIn;
        setId(userToCopy.getId());
        login = userToCopy.login;
        pictureURL = userToCopy.pictureURL;
        isAdmin = userToCopy.isAdmin;
        time = userToCopy.time;
        googleId = userToCopy.googleId;
        email = userToCopy.email;
        timeModified = userToCopy.timeModified;
    }
}
