package com.bidding.client.application.form;

import com.bidding.client.application.widget.GettingFormByIdWidget;
import com.bidding.client.service.UserForm;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.InlineCheckBox;
import org.gwtbootstrap3.client.ui.TextBox;

import javax.inject.Inject;
import java.util.function.Consumer;

public class FormView extends ViewWithUiHandlers<FormUiHandlers> implements FormPresenter.MyView {
    interface Binder extends UiBinder<Widget, FormView> {
    }

    @UiField
    TextBox fname;

    @UiField
    TextBox lname;

    @UiField
    InlineCheckBox isHuman;

    @UiField
    GettingFormByIdWidget gettingFormById;

    @Inject
    FormView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        Consumer<Integer> consumer = id -> getUiHandlers().getFormBiIdService(id);
        this.gettingFormById.setConsumer(consumer);
    }

    @UiHandler("button")
    public void saveClick(ClickEvent eventfirst) {
        getUiHandlers().saveForm(new UserForm(fname.getValue(), lname.getValue(), isHuman.getValue()));
    }

}
