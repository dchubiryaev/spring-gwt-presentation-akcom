package com.bidding.shared.action;

import com.bidding.shared.dto.UserDto;
import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.annotation.Out;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

@GenDispatch(isSecure = false, serviceName = UnsecuredActionImpl.DEFAULT_SERVICE_NAME)
public class SetAdmin {

    @In(1)
    Long userId;
    @In(2)
    Boolean value;

    @Out(1)
    UserDto userDto;

}