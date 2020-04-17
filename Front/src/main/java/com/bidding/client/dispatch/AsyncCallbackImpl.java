package com.bidding.client.dispatch;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AsyncCallbackImpl<T> implements AsyncCallback<T> {

  public void onFailure(Throwable caught) {
    Window.alert(caught.toString());
  }

  public void onSuccess(T result) {
    onCustomSuccess(result);
  }

  /** Overwrite to do something with result */
  protected abstract void onCustomSuccess(T result);
}
