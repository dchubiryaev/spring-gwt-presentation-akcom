package com.bidding.server.dispatch;

import com.bidding.server.ServerUtils;
import com.bidding.server.dao.AppUserDao;
import com.bidding.server.domain.AppUser;
import com.bidding.shared.action.GetUsersAction;
import com.bidding.shared.action.GetUsersResult;
import com.bidding.shared.dto.UserDto;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetUsersHandler extends MyAbstractActionHandler<GetUsersAction, GetUsersResult> {
    @Inject
    public GetUsersHandler() {
        super(GetUsersAction.class);
    }

    @Override
    public GetUsersResult execute(GetUsersAction action, ExecutionContext context) throws ActionException {

        List<AppUser> appUsers = new AppUserDao().listAll();

        List<UserDto> userDtos = new ArrayList<UserDto>(appUsers.size());

        for (AppUser appUser : appUsers) {
            userDtos.add(ServerUtils.createUserDto(true, appUser));
        }
        return new GetUsersResult(userDtos);
    }

}
