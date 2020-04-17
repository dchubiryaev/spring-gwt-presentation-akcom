package com.bidding.client.application.form;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class FormModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(FormPresenter.class, FormPresenter.MyView.class, FormView.class,
                FormPresenter.MyProxy.class);
    }
}
