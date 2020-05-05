package com.bidding.client.application.form;

import com.bidding.client.application.ApplicationPresenter;
import com.bidding.client.application.form.FormPresenter.MyProxy;
import com.bidding.client.application.form.FormPresenter.MyView;
import com.bidding.client.place.NameTokens;
import com.bidding.client.service.FormService;
import com.bidding.client.service.UserForm;
import com.google.appengine.api.users.User;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.function.Consumer;

public class FormPresenter extends Presenter<MyView, MyProxy> implements FormUiHandlers {

    interface MyView extends View, HasUiHandlers<FormUiHandlers> {
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<FormPresenter> {
    }

    @Inject
    FormPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        getView().setUiHandlers(this);
    }

    @Override
    public void saveForm(UserForm form) {
        FormService.execute().save(form, new MethodCallback<Integer>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                consoleLog("FAIL : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(Method method, Integer id) {
                Window.alert("Success id:" + id);
            }
        });
    }

    @Override
    public void getFormBiIdService(int id){
        FormService.execute().getById(id, new MethodCallback<UserForm>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                consoleLog("FAIL : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(Method method, UserForm userForms) {
                consoleLog("SUCCESS : " + userForms.toString());
            }
        });
    }

    native void consoleLog(String message) /*-{
        console.log("me:" + message);
    }-*/;
}


