package com.bidding.server.guice;

import com.bidding.server.servlet.Auth2callback;
import com.bidding.server.servlet.AuthServlet;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

public class DispatchServletModule extends ServletModule {

  @Override
  protected void configureServlets() {

    serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);

    bind(AuthServlet.class).in(Singleton.class);
    bind(Auth2callback.class).in(Singleton.class);
    serve("/auth").with(AuthServlet.class);
    serve("/oauth2callback").with(Auth2callback.class);

    bind(ObjectifyFilter.class).in(Singleton.class);
    filter("/*").through(ObjectifyFilter.class);
  }
}
