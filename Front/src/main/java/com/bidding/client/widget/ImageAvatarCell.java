package com.bidding.client.widget;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/*
* BugFix google avatar image, set image size by hardcode;
* */
public class ImageAvatarCell extends AbstractCell<String> {
  private static Template template;

  public ImageAvatarCell() {
    super(new String[0]);
    if (template == null) {
      template = (Template) GWT.create(Template.class);
    }

  }

  public void render(Context context, String value, SafeHtmlBuilder sb) {
    if (value != null) {
      sb.append(template.img(value));
    }
  }

  interface Template extends SafeHtmlTemplates {
    @com.google.gwt.safehtml.client.SafeHtmlTemplates.Template("<img class=\"avatar-img\" src=\"{0}\"/>")
    SafeHtml img(String var1);
  }
}
