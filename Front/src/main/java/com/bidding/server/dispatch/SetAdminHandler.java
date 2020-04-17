package com.bidding.server.dispatch;

import com.bidding.server.ServerUtils;
import com.bidding.server.dao.AppUserDao;
import com.bidding.server.domain.AppUser;
import com.bidding.shared.action.SetAdminAction;
import com.bidding.shared.action.SetAdminResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

public class SetAdminHandler extends MyAbstractActionHandler<SetAdminAction, SetAdminResult> {
    @Inject
    public SetAdminHandler() {
        super(SetAdminAction.class);
    }

    @Override
    public SetAdminResult execute(SetAdminAction action, ExecutionContext context) throws ActionException {

        AppUserDao appUserDao = new AppUserDao();

        AppUser appUser = appUserDao.get(action.getUserId());

        appUser.setAdmin(action.getValue());

        return new SetAdminResult(ServerUtils.createUserDto(true, appUserDao.saveAndReturn(appUser)));

    }

}
