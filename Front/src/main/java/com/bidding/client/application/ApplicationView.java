package com.bidding.client.application;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.Navbar;

import javax.inject.Inject;

class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers>
    implements ApplicationPresenter.MyView {

  interface Binder extends UiBinder<Widget, ApplicationView> {}

  @UiField
  SimplePanel main;

  @UiField
  Navbar bar = new Navbar();

  @Inject
  ApplicationView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
    bindSlot(ApplicationPresenter.SLOT_MAIN, main);
  }
}
