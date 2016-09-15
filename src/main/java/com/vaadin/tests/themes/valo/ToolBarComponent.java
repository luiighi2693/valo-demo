package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Demo para switch button
 * Created by ypetrilli on 15/09/2016.
 */
public class ToolBarComponent extends VerticalLayout implements View {
    private VerticalLayout mainLayout;

    public ToolBarComponent() {
        Label h1 = new Label("Tool Bar");
        h1.addStyleName(ValoTheme.LABEL_H1);

        mainLayout = new VerticalLayout();
        setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.addComponent(h1);

        MenuBar menuBar = getMenuBar();
        addComponent(menuBar);
        mainLayout.addComponents(menuBar);

        Label label = new Label(
                "<pre>      MenuBar menubar = new MenuBar();\n" +
                        "      menubar.setWidth(\"100%\");\n" +
                        "      MenuBar.MenuItem file = menubar.addItem(\"File\", null);\n" +
                        "      MenuBar.MenuItem newItem = file.addItem(\"New\", null);\n" +
                        "      file.addItem(\"Open file...\", click);\n" +
                        "      file.addSeparator();\n" +
                        "\n" +
                        "      newItem.addItem(\"File\", click);\n" +
                        "      newItem.addItem(\"Folder\", click);\n" +
                        "      newItem.addItem(\"Project...\", click);\n" +
                        "\n" +
                        "      file.addItem(\"Close\", click);\n" +
                        "      file.addItem(\"Close All\", click);\n" +
                        "      file.addSeparator();\n" +
                        "\n" +
                        "      file.addItem(\"Save\", click);\n" +
                        "      file.addItem(\"Save As...\", click);\n" +
                        "      file.addItem(\"Save All\", click); </pre>",
                ContentMode.HTML);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(label);
        verticalLayout.setMargin(true);

        Panel panel = new Panel();
        panel.setContent(verticalLayout);

        addComponents(mainLayout,panel);

    }

    static MenuBar getMenuBar() {
        MenuBar.Command click = (MenuBar.Command) selectedItem -> Notification.show("Clicked " + selectedItem.getText());

        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        MenuBar.MenuItem file = menubar.addItem("File", null);
        MenuBar.MenuItem newItem = file.addItem("New", null);
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


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
