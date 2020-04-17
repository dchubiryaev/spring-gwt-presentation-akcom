package com.bidding.server.dispatch;

import com.bidding.shared.action.DeleteUserAction;
import com.bidding.shared.action.GetCurrentUser;
import com.bidding.shared.action.GetCurrentUserAction;
import com.bidding.shared.action.GetUsersAction;
import com.bidding.shared.action.SetAdminAction;
import com.bidding.shared.action.SignOutAction;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class MyHandlerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {

    // Bind Action to Action Handler
    bindHandler(GetUsersAction.class, GetUsersHandler.class);
    bindHandler(DeleteUserAction.class, DeleteUserHandler.class);
    bindHandler(GetCurrentUserAction.class, GetCurrentUserHandler.class);
    bindHandler(SetAdminAction.class, SetAdminHandler.class);
    bindHandler(SignOutAction.class, SignOutHandler.class);
  }
}
