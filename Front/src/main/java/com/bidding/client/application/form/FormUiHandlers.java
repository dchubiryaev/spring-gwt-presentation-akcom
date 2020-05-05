package com.bidding.client.application.form;

import com.bidding.client.service.UserForm;
import com.gwtplatform.mvp.client.UiHandlers;

import java.util.function.Consumer;

public interface FormUiHandlers extends UiHandlers {

    void saveForm(UserForm form);

    void getFormBiIdService(int id);

}
