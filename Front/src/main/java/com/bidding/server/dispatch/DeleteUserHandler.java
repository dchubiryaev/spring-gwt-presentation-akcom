package com.bidding.server.dispatch;

import com.bidding.server.dao.AppUserDao;
import com.bidding.shared.action.DeleteUserAction;
import com.bidding.shared.action.DeleteUserResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

public class DeleteUserHandler extends MyAbstractActionHandler<DeleteUserAction, DeleteUserResult> {
    @Inject
    public DeleteUserHandler() {
        super(DeleteUserAction.class);
    }

    @Override
    public DeleteUserResult execute(DeleteUserAction action, ExecutionContext context) throws ActionException {

        new AppUserDao().delete(action.getUserId());
        return new DeleteUserResult();
    }

}
