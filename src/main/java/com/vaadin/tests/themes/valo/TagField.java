package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.tokenfield.TokenField;

import java.util.Set;

public class TagField extends VerticalLayout implements View {
    public TagField() {
        setMargin(true);

        Label h1 = new Label("TagField");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        row.setSpacing(true);

        TokenField tagField = new TokenField() {
            @Override
            protected void onTokenInput(Object tokenId) {
                Set<Object> set = (Set<Object>) getValue();
                if (set != null && set.contains(tokenId.toString())){
                    Notification.show(getTokenCaption(tokenId)
                            + " ya existe");
                }
                else {
                    super.addToken(tokenId);
                }
            }

            @Override
            protected void rememberToken(String tokenId) {
                String[] tokens = tokenId.split(",");
                for (String token : tokens) {
                    token = token.trim();
                    if (token.length() > 0) {
                        super.rememberToken(token);
                    }
                }
            }
            protected void onTokenClicked(final Object tokenId) {
                // default removes w/o dialog
            }
            protected void onTokenDelete(Object tokenId) {
                this.removeToken(tokenId);
            }
            protected void configureTokenButton(Object tokenId,
                                                Button button) {
                super.configureTokenButton(tokenId, button);
/*                // custom caption
                button.setCaption(getTokenCaption(tokenId) + " <"
                        + tokenId + ">");
                // width
                button.setWidth("100%");*/
            }
        };
        tagField.setStyleName(TokenField.STYLE_TOKENFIELD); // remove fake textfield look
        tagField.setSizeFull();
//        tagField.setContainerDataSource(tokens); // 'address book'
//        tagField.setTokenCaptionPropertyId("name"); // use container item property "name" in input
        tagField.setInputPrompt("Ingrese parámetro");
        tagField.setRememberNewTokens(true);
        tagField.setFilteringMode(FilteringMode.CONTAINS);

        row.addComponent(tagField);

        addComponent(row);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
