package com.bidding.client.application;

import com.bidding.client.place.NameTokens;
import com.bidding.client.security.IsCustomerGatekeeper;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
        void isLogin(Boolean isLogin);
    }

    @ProxyStandard
    @NameToken(NameTokens.ADMIN)
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    private final PlaceManager placeManager;
    private final IsCustomerGatekeeper gatekeeper;

    public static final NestedSlot SLOT_MAIN = new NestedSlot();

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager,
            IsCustomerGatekeeper gatekeeper) {
        super(eventBus, view, proxy, RevealType.Root);
        this.gatekeeper = gatekeeper;
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReveal() {
        getView().isLogin(gatekeeper.canReveal());
        super.onReveal();
    }
}
