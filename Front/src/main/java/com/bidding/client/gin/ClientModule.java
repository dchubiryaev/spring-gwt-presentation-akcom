package com.bidding.client.gin;

import com.bidding.client.application.ApplicationModule;
import com.bidding.client.place.NameTokens;
import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    install(
        new DefaultModule.Builder()
            .defaultPlace(NameTokens.HOME)
            .errorPlace(NameTokens.HOME)
            .unauthorizedPlace(NameTokens.HOME)
            .build());

    install(new RpcDispatchAsyncModule());
    install(new ApplicationModule());

    // bind(ResourceLoader.class).asEagerSingleton();

  }
}
