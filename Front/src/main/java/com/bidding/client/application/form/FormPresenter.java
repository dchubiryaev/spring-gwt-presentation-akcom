package com.bidding.client.application.form;

import com.bidding.client.application.ApplicationPresenter;
import com.bidding.client.dispatch.AsyncCallbackImpl;
import com.bidding.client.event.LoginResetEvent;
import com.bidding.client.place.NameTokens;
import com.bidding.client.security.IsAdminGatekeeper;
import com.bidding.shared.action.SignOutAction;
import com.bidding.shared.action.SignOutResult;
import com.bidding.shared.dto.UserDto;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.bidding.client.application.form.FormPresenter.MyView;
import com.bidding.client.application.form.FormPresenter.MyProxy;

public class FormPresenter extends Presenter<MyView, MyProxy> implements FormUiHandlers {
    interface MyView extends View, HasUiHandlers<FormUiHandlers> {
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<FormPresenter> {
    }

    @Inject
    FormPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        getView().setUiHandlers(this);
    }
}


