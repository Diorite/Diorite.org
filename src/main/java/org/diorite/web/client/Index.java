package org.diorite.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Index implements EntryPoint
{
    public void onModuleLoad()
    {
        final Button button = new Button("lel");
        RootPanel.get().add(button);
        System.out.println("WTF is this!");
        Window.alert("Hahsdfdsfds");
        button.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(final ClickEvent event)
            {
                button.setText(button.getText() + "1");
            }
        });
    }
}
