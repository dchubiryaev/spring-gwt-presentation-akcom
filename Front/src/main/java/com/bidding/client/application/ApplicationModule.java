package com.bidding.client.application;

import com.bidding.client.application.admin.AdminModule;
import com.bidding.client.application.form.FormModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    bindPresenter(
        ApplicationPresenter.class,
        ApplicationPresenter.MyView.class,
        ApplicationView.class,
        ApplicationPresenter.MyProxy.class);

    install(new AdminModule());
    install(new FormModule());
  }
}
