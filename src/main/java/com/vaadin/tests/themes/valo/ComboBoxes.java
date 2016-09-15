/*
 * Copyright 2000-2013 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addons.comboboxmultiselect.ComboBoxMultiselect;

import java.util.ArrayList;
import java.util.List;

public class ComboBoxes extends VerticalLayout implements View {
    public ComboBoxes() {
        setMargin(true);

        Label h1 = new Label("Combo Boxes");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        row.setSpacing(true);
        addComponent(row);

        ComboBox combo = new ComboBox("Normal");
        combo.setInputPrompt("You can type here");
        combo.setContainerDataSource(ValoThemeUI.generateContainer(200, false));
        combo.setNullSelectionAllowed(false);
        combo.select(combo.getItemIds().iterator().next());
        combo.setItemCaptionPropertyId(ValoThemeUI.CAPTION_PROPERTY);
        combo.setItemIconPropertyId(ValoThemeUI.ICON_PROPERTY);
        combo.setItemIcon(combo.getItemIds().iterator().next(),
                new ThemeResource("../runo/icons/16/document.png"));
        row.addComponent(combo);

        CssLayout group = new CssLayout();
        group.setCaption("Grouped with a Button");
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        row.addComponent(group);

        combo = new ComboBox();
        combo.setInputPrompt("You can type here");
        combo.setContainerDataSource(ValoThemeUI.generateContainer(200, false));
        combo.setNullSelectionAllowed(false);
        combo.select(combo.getItemIds().iterator().next());
        combo.setItemCaptionPropertyId(ValoThemeUI.CAPTION_PROPERTY);
        combo.setItemIconPropertyId(ValoThemeUI.ICON_PROPERTY);
        combo.setWidth("240px");
        group.addComponent(combo);
        Button today = new Button("Do It");
        group.addComponent(today);

        combo = new ComboBox("Small");
        combo.setInputPrompt("You can type here");
        combo.setContainerDataSource(ValoThemeUI.generateContainer(200, false));
        combo.setItemCaptionPropertyId(ValoThemeUI.CAPTION_PROPERTY);
        combo.setItemIconPropertyId(ValoThemeUI.ICON_PROPERTY);
        combo.addStyleName(ValoTheme.COMBOBOX_SMALL);
        row.addComponent(combo);

        combo = new ComboBox("Large");
        combo.setInputPrompt("You can type here");
        combo.setContainerDataSource(ValoThemeUI.generateContainer(200, false));
        combo.setItemCaptionPropertyId(ValoThemeUI.CAPTION_PROPERTY);
        combo.setItemIconPropertyId(ValoThemeUI.ICON_PROPERTY);
        combo.addStyleName(ValoTheme.COMBOBOX_LARGE);
        row.addComponent(combo);

/*        List<Bean> list = new ArrayList<Bean>();
        Bean vaadin = new Bean(2L, "Vaadin”);
                list.add(new Bean(1L, "Java"));
        list.add(vaadin);
        list.add(new Bean(4L, "Addon"));*/

// Initialize the ComboBoxMultiselect
        final ComboBoxMultiselect comboBoxMultiselect = new ComboBoxMultiselect();
        comboBoxMultiselect.setInputPrompt("Type here");
        comboBoxMultiselect.setCaption("ComboBoxMultiselect");
//        comboBoxMultiselect.addItems(list);
//        comboBoxMultiselect.select(vaadin);

    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
