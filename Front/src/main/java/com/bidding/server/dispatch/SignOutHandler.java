package com.bidding.server.dispatch;

import com.bidding.server.auth.CurrentAppUserProvider;
import com.bidding.shared.action.SignOutAction;
import com.bidding.shared.action.SignOutResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.inject.Inject;

public class SignOutHandler extends AbstractAuthHandler<SignOutAction, SignOutResult> {

  @Inject
  public SignOutHandler(CurrentAppUserProvider currentAppUserProvider) {
    super(SignOutAction.class, currentAppUserProvider);
  }

  @Override
  public SignOutResult execute(SignOutAction action, ExecutionContext context)
      throws ActionException {

    clearCurrentUser();

    return new SignOutResult();
  }

  protected void clearCurrentUser() throws ActionException {
    if (currentAppUserProvider == null) {
      throw new ActionException("currentAppUserProvider is null");
    }

    currentAppUserProvider.set(null);
  }
}
