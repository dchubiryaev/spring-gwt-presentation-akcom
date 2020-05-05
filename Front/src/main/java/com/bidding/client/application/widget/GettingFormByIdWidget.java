package com.bidding.client.application.widget;

import com.google.gwt.user.client.ui.Button;
import org.gwtbootstrap3.client.ui.InputGroup;
import org.gwtbootstrap3.client.ui.InputGroupButton;
import org.gwtbootstrap3.client.ui.TextBox;

import java.util.function.Consumer;

public class GettingFormByIdWidget extends InputGroup {
    InputGroupButton groupButton = new InputGroupButton();
    Button getButton = new Button("Get");
    TextBox inputTextHolder = new TextBox();

    public GettingFormByIdWidget() {
        super();
        groupButton.add(getButton);
        this.add(groupButton);
        this.add(inputTextHolder);
    }

    public void setConsumer(Consumer<Integer> service) {
        getButton.addClickHandler(event -> onClick(service));
    }

    private void onClick(Consumer<Integer> service) {
        String id = inputTextHolder.getValue();
        service.accept(Integer.valueOf(id));
    }
}