package com.bidding.client.application.admin;

import com.bidding.shared.dto.UserDto;
import com.gwtplatform.mvp.client.UiHandlers;

interface AdminUiHandlers extends UiHandlers {
    void onUserDeleteUpdate(UserDto userDto);

    void onIsAdminUpdate(UserDto userDto, Boolean value);
}
