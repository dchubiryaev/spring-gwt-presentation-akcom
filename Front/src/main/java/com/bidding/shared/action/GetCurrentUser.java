package com.bidding.shared.action;

import com.bidding.shared.dto.UserDto;
import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.Out;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

@GenDispatch(isSecure = false, serviceName = UnsecuredActionImpl.DEFAULT_SERVICE_NAME)
public class GetCurrentUser {
    @Out(1)
    UserDto currentUserDto;
}

