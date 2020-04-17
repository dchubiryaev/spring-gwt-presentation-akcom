package com.bidding.client.application.form;

import com.bidding.client.service.FormService;
import com.bidding.client.service.UserForm;
import com.bidding.client.service.UserFormResponse;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.InlineCheckBox;
import org.gwtbootstrap3.client.ui.TextBox;

import javax.inject.Inject;

public class FormView extends ViewWithUiHandlers<FormUiHandlers> implements FormPresenter.MyView {
    interface Binder extends UiBinder<Widget, FormView> {
    }

    @UiField
    TextBox fname;

    @UiField
    TextBox lname;

    @UiField
    InlineCheckBox isHuman;

    @Inject
    FormView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    native void consoleLog(String message) /*-{
        console.log("me:" + message);
    }-*/;

    @UiHandler("button")
    public void saveClick(ClickEvent eventfirst) {
        consoleLog("Click " + fname.getValue() + lname.getValue() + isHuman.getFormValue());

        FormService service = GWT.create(FormService.class);
        UserForm userForm = new UserForm(fname.getValue(), lname.getValue(), isHuman.getValue());

        service.order(userForm, new MethodCallback<UserFormResponse>() {

            public void onSuccess(Method method, UserFormResponse response) {
                consoleLog("onSuccess : " + response.response);
            }

            public void onFailure(Method method, Throwable exception) {
                consoleLog("FAIL " + exception.getMessage());
            }
        });
    }

}
