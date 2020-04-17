package com.bidding.server.domain;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AppUser extends DatastoreObject {

    private static final long serialVersionUID = 1L;

    @Index
    private String login;

    @Index
    private String email;

    @Index
    private String googleId;

    private boolean isAdmin = false;

    private String pictureURL;

    public AppUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureURL() {
        return pictureURL != null ? pictureURL : "/images/no-pic.gif";
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}

