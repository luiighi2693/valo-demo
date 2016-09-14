package com.vaadin.tests.themes.valo.test;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import eu.maxschuster.vaadin.autocompletetextfield.provider.CollectionSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.provider.MatchMode;
import ve.com.pt.base.new_views.DetailUI;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * TestDetail
 * Created by ypetrilli on 09/09/2016.
 */
public class TestDetail extends DetailUI {
    private TextField code;

    public TestDetail() {
        super();
        setTitle("Test Detalle/Nuevo");
    }

    @Override
    public void buildHeader(boolean showHeader) {
        super.buildHeader(true);
    }

    @Override
    public void buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT, false);

        code = new TextField("Código");
        code.setInputPrompt("código");
        form.addComponent(code);

        Collection<String> theJavas = Arrays.asList("Jav",
                "JavaScript",
                "Join Java",
                "JavaFX Script");

        AutocompleteSuggestionProvider suggestionProvider = new CollectionSuggestionProvider(theJavas, MatchMode.CONTAINS, true, Locale.US);

        AutocompleteTextField field = new AutocompleteTextField("Campo con autocompletado");
        field.setInputPrompt("text here");
        field.setSuggestionProvider(suggestionProvider);
        form.addComponent(field);
    }

    @Override
    public void buildHeaderGrid(boolean showHeaderGrid) {
        super.buildHeaderGrid(true);
        headerGrid.addComponents(new Button(FontAwesome.SEARCH), new Button(FontAwesome.PLUS));
    }

    @Override
    public void buildDetailGrid(boolean showDetailGrid) {
        super.buildDetailGrid(true);
        detailGrid.addColumn("Name", String.class);
        detailGrid.addColumn("Description", String.class);
        detailGrid.addColumn("Version", String.class);
        detailGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        detailGrid.addRow("com.vaadin", "vaadin-server", "7.4.0");
        detailGrid.addRow("com.vaadin", "vaadin-client-compiled", "7.4.0");
        detailGrid.addRow("com.vaadin", "vaadin-client", "7.7.0");
    }

    @Override
    public void buildFooter(boolean showFooter) {
        super.buildFooter(true);
    }
}