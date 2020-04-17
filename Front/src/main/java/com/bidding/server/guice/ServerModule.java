package com.bidding.server.guice;

import com.bidding.server.dispatch.MyHandlerModule;
import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new MyHandlerModule());
  }
}
