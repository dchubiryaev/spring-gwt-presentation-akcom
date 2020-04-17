package com.bidding.server.dispatch;

import com.bidding.server.auth.CurrentAppUserProvider;
import com.bidding.shared.action.GetCurrentUserAction;
import com.bidding.shared.action.GetCurrentUserResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetCurrentUserHandler extends AbstractAuthHandler<GetCurrentUserAction, GetCurrentUserResult> {
    @Inject
    public GetCurrentUserHandler(CurrentAppUserProvider currentAppUserProvider) {
        super(GetCurrentUserAction.class, currentAppUserProvider);
    }

    @Override
    public GetCurrentUserResult execute(GetCurrentUserAction action, ExecutionContext context) throws ActionException {
        return new GetCurrentUserResult(getCurrentUserDto());
    }

}