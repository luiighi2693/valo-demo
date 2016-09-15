package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Demo para switch button
 * Created by ypetrilli on 15/09/2016.
 */
public class ToolBarComponent extends VerticalLayout implements View {
    private VerticalLayout mainLayout;

    public ToolBarComponent() {
        Label h1 = new Label("Menu Bars");
        h1.addStyleName(ValoTheme.LABEL_H1);

        mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        MenuBar menuBar = getMenuBar();
        menuBar.setCaption("Normal style");
        addComponent(menuBar);

        mainLayout.addComponents(menuBar);

        addComponent(mainLayout);

    }

    static MenuBar getMenuBar() {
        MenuBar.Command click = (MenuBar.Command) selectedItem -> Notification.show("Clicked " + selectedItem.getText());

        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        final MenuBar.MenuItem file = menubar.addItem("File", null);
        final MenuBar.MenuItem newItem = file.addItem("New", null);
        file.addItem("Open file...", click);
        file.addSeparator();

        newItem.addItem("File", click);
        newItem.addItem("Folder", click);
        newItem.addItem("Project...", click);

        file.addItem("Close", click);
        file.addItem("Close All", click);
        file.addSeparator();

        file.addItem("Save", click);
        file.addItem("Save As...", click);
        file.addItem("Save All", click);

        final MenuBar.MenuItem edit = menubar.addItem("Edit", null);
        edit.addItem("Undo", click);
        edit.addItem("Redo", click).setEnabled(false);
        edit.addSeparator();

        edit.addItem("Cut", click);
        edit.addItem("Copy", click);
        edit.addItem("Paste", click);
        edit.addSeparator();

        final MenuBar.MenuItem find = edit.addItem("Find/Replace", null);

        find.addItem("Google Search", click);
        find.addSeparator();
        find.addItem("Find/Replace...", click);
        find.addItem("Find Next", click);
        find.addItem("Find Previous", click);

        MenuBar.Command check = (MenuBar.Command) selectedItem -> Notification.show(selectedItem.isChecked() ? "Checked"
                : "Unchecked");

        final MenuBar.MenuItem view = menubar.addItem("View", null);
        view.addItem("Show Status Bar", check).setCheckable(true);
        MenuBar.MenuItem title = view.addItem("Show Title Bar", check);
        title.setCheckable(true);
        title.setChecked(true);
        view.addItem("Customize Toolbar...", click);
        view.addSeparator();

        view.addItem("Actual Size", click);
        view.addItem("Zoom In", click);
        view.addItem("Zoom Out", click);

        TestIcon testIcon = new TestIcon(50);

        MenuBar.MenuItem fav = menubar.addItem("", check);
        fav.setIcon(testIcon.get());
        fav.setStyleName("icon-only");
        fav.setCheckable(true);
        fav.setChecked(true);

        fav = menubar.addItem("", check);
        fav.setIcon(testIcon.get());
        fav.setStyleName("icon-only");
        fav.setCheckable(true);
        fav.setCheckable(true);

        menubar.addItem("Attach", click).setIcon(FontAwesome.PAPERCLIP);
        menubar.addItem("Undo", click).setIcon(FontAwesome.UNDO);
        MenuBar.MenuItem redo = menubar.addItem("Redo", click);
        redo.setIcon(FontAwesome.REPEAT);
        redo.setEnabled(false);
        menubar.addItem("Upload", click).setIcon(FontAwesome.UPLOAD);

        return menubar;
    }

    static MenuBar getToolBar() {
        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");

        MenuBar.MenuItem fav = menubar.addItem("", null);
        fav.setIcon(FontAwesome.ALIGN_LEFT);
        fav.setStyleName("icon-only");
        fav.setCheckable(true);

        fav = menubar.addItem("", null);
        fav.setIcon(FontAwesome.ALIGN_CENTER);
        fav.setStyleName("icon-only");
        fav.setCheckable(true);

        fav = menubar.addItem("", null);
        fav.setIcon(FontAwesome.ALIGN_RIGHT);
        fav.setStyleName("icon-only");
        fav.setCheckable(true);

        MenuBar.MenuItem clip = menubar.addItem("", null);
        clip.setIcon(FontAwesome.PAPERCLIP);
        clip.setStyleName("icon-only");

        MenuBar.MenuItem undo = menubar.addItem("", null);
        undo.setIcon(FontAwesome.UNDO);
        undo.setStyleName("icon-only");

        MenuBar.MenuItem redo = menubar.addItem("", null);
        redo.setIcon(FontAwesome.REPEAT);
        redo.setEnabled(false);
        redo.setStyleName("icon-only");

        return menubar;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
