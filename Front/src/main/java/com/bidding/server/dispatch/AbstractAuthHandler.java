package com.bidding.server.dispatch;

import com.bidding.server.ServerUtils;
import com.bidding.server.auth.CurrentAppUserProvider;
import com.bidding.server.domain.AppUser;
import com.bidding.shared.dto.UserDto;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;
import com.gwtplatform.dispatch.shared.ActionException;

public abstract class AbstractAuthHandler<A extends Action<R>, R extends Result> extends MyAbstractActionHandler<A, R> {

    protected final CurrentAppUserProvider currentAppUserProvider;

    public AbstractAuthHandler(final Class<A> actionType, final CurrentAppUserProvider currentAppUserProvider) {
        super(actionType);

        this.currentAppUserProvider = currentAppUserProvider;
    }

    protected UserDto getCurrentUserDto(AppUser appUser) throws ActionException {
        currentAppUserProvider.set(appUser);

        return getCurrentUserDto();
    }

    protected UserDto getCurrentUserDto() throws ActionException {
        AppUser appUser = getCurrenAppUser();
        return ServerUtils.createUserDto(appUser != null, appUser);
    }

    protected AppUser getCurrenAppUser() throws ActionException {
        if (currentAppUserProvider == null)
            throw new ActionException("currentAppUserProvider is null");
        AppUser appUser = currentAppUserProvider.get();
        return appUser;
    }
}