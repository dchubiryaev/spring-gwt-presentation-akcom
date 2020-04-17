package com.bidding.client.security;

import com.bidding.client.event.LoginAuthenticatedEvent;
import com.bidding.client.event.LoginResetEvent;
import com.bidding.shared.dto.UserDto;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

import javax.inject.Inject;

abstract public class IsLoggedInGatekeeper implements Gatekeeper {
    private final EventBus eventBus;
    private UserDto userDto;

    @Inject
    public IsLoggedInGatekeeper(final EventBus eventBus) {
        this.eventBus = eventBus;

        this.eventBus.addHandler(LoginAuthenticatedEvent.getType(),
                event -> userDto = event.getCurrentUser());

        this.eventBus.addHandler(LoginResetEvent.getType(), event -> userDto = null);
    }

    @Override
    public boolean canReveal() {
        boolean loggedIn = false;
        if (userDto != null) {
            loggedIn = userDto.isLoggedIn();
        }
        return loggedIn;
    }

    public UserDto getCurrentUser() {
        return userDto;
    }
}