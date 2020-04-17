package com.bidding.client.application.admin;

import com.bidding.client.application.ApplicationPresenter;
import com.bidding.client.dispatch.AsyncCallbackImpl;
import com.bidding.client.place.NameTokens;
import com.bidding.client.security.IsAdminGatekeeper;
import com.bidding.client.security.IsCustomerGatekeeper;
import com.bidding.shared.action.DeleteUserAction;
import com.bidding.shared.action.DeleteUserResult;
import com.bidding.shared.action.GetUsersAction;
import com.bidding.shared.action.GetUsersResult;
import com.bidding.shared.action.SetAdminAction;
import com.bidding.shared.action.SetAdminResult;
import com.bidding.shared.dto.UserDto;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import java.util.List;


public class AdminPresenter extends Presenter<AdminPresenter.MyView, AdminPresenter.MyProxy> implements AdminUiHandlers {
    interface MyView extends View, HasUiHandlers<AdminUiHandlers> {
        void displayUsers(List<UserDto> userList);

        void removeUser(UserDto userDto);

        void updateUser(UserDto userDto, UserDto updatedUserDto);
    }


    @ProxyStandard
    @UseGatekeeper(IsAdminGatekeeper.class)
    @NameToken(NameTokens.ADMIN)
    interface MyProxy extends ProxyPlace<AdminPresenter> {
    }

    @Inject
    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;
    private final IsAdminGatekeeper gatekeeper;

    @Inject
    AdminPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            DispatchAsync dispatcher,
            PlaceManager placeManager,
            IsAdminGatekeeper gatekeeper) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.dispatcher = dispatcher;
        this.placeManager = placeManager;
        this.gatekeeper = gatekeeper;
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();
        dispatcher.execute(new GetUsersAction(), new AsyncCallbackImpl<GetUsersResult>() {

            @Override
            public void onCustomSuccess(GetUsersResult result) {
                getView().displayUsers(result.getUsers());
            }

        });
    }

    @Override
    public void onUserDeleteUpdate(final UserDto userDto) {
        dispatcher.execute(new DeleteUserAction(userDto.getId()), new AsyncCallbackImpl<DeleteUserResult>() {

            @Override
            public void onCustomSuccess(DeleteUserResult result) {
                getView().removeUser(userDto);
            }
        });
    }

    @Override
    public void onIsAdminUpdate(final UserDto userDto, Boolean value) {
        dispatcher.execute(new SetAdminAction(userDto.getId(), value), new AsyncCallbackImpl<SetAdminResult>() {

            @Override
            public void onCustomSuccess(SetAdminResult result) {
                // TODO is it really has sense to update other user attributes from server?
                getView().updateUser(userDto, result.getUserDto());
            }
        });
    }
}
