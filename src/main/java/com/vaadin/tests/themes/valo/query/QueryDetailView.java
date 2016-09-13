package com.vaadin.tests.themes.valo.query;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.base.constants.GeneralConstants;
import ve.com.pt.base.core.XNotification;
import ve.com.pt.base.views.BaseDetailUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Vista detalle/nuevo de consultas
 * Created by ypetrilli on 23/05/2016.
 * Modified by ypetrilli on 01/08/2016.
 */
public class QueryDetailView extends BaseDetailUI implements GeneralConstants{
    private TextField code;
    private TextField type;
    private TextField subType;
    private TextArea sql;
//    private QueryService queryService;
    private XNotification xNotification;

    public QueryDetailView() {
        super();
        setTitle("QUERY_DETAIL_VIEW_TITLE");
//        model = new QueryModel();
        xNotification = new XNotification();
    }

    /**
     * Enlaza cada uno de los atributos de la entidad correspondiente con cada uno de los campos del formulario para posteriormente
     * setear la información contenida.
     */
    private void bindBean() {
//        binder = new BeanFieldGroup<>(Query.class);
//        binder.setItemDataSource(entity);
//        binder.bind(code, "ATTRIBUTE_CODE");
//        binder.bind(type, "ATTRIBUTE_TYPE");
//        binder.bind(subType, "ATTRIBUTE_SUBTYPE".toLowerCase());
//        binder.bind(sql, "ATTRIBUTE_SQLQUERY");
    }

    /**
     * Construye la vista con todos los campos del formulario inicializados en sus valores por defecto para insertar un nuevo registro.
     *
     * @return
     */
    @Override
    public boolean preNew() {
        setTitle("NEW_QUERY_TITLE");
//        entity = new Query();
        bindBean();
        return super.preNew();
    }

    /**
     * Construye la vista a partir del id de la entidad capturado en la grid para posteriormente buscar toda la información asociada
     * y cargarla en cada uno de los campos correspondientes para actualizar ese registro.
     *
     * @param entityId
     * @return
     */
    @Override
    public boolean preEdit(Long entityId) {
        setTitle("QUERY_DETAIL_VIEW_TITLE");
//        entity = (Query) model.findById(entityId).get(GeneralConstants.VALUE);
        bindBean();
        return super.preEdit(entityId);
    }

    /**
     * Construye el formulario con todos los campos correspondientes a la funcionalidad de la vista.
     * Los campos son: código, tipo, subtipo y sql.
     */
    @Override
    public void buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT, false);
        code = new TextField("CODE_LABEL");
//        code.setInputPrompt("CODE_QUERY_INPUT_PROMPT");
        code.setWidth("50%");
        code.setMaxLength(250);
//        code.addValidator(new RegexpValidator(ONLY_LETTERS_NUMBERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
        code.setRequired(true);
        code.setImmediate(true);
//        code.setNullRepresentation(EMPTY_STRING);
        form.addComponent(code);

        type = new TextField("TYPE_LABEL");
//        type.setInputPrompt(TYPE_QUERY_INPUT_PROMPT);
        type.setMaxLength(250);
        type.setWidth("50%");
        type.setImmediate(true);
//        type.addValidator(new RegexpValidator(ONLY_LETTERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
//        type.setNullRepresentation(EMPTY_STRING);
        form.addComponent(type);

        subType = new TextField("SUBTYPE_LABEL");
//        subType.setInputPrompt(SUBTYPE_QUERY_INPUT_PROMPT);
        subType.setMaxLength(250);
        subType.setWidth("50%");
        subType.setImmediate(true);
//        subType.addValidator(new RegexpValidator(ONLY_LETTERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
//        subType.setNullRepresentation(EMPTY_STRING);
        form.addComponent(subType);

        sql = new TextArea("SQL_LABEL");
//        sql.setInputPrompt(SQL_INPUT_PROMPT);
//        sql.setNullRepresentation(EMPTY_STRING);
        sql.setRequired(true);
        sql.setWidth("100%");
        sql.setRows(30);
        sql.setImmediate(true);
        sql.setValidationVisible(true);
//        sql.addValidator(new NullValidator(REQUIRED_FIELD, false));
        form.addComponent(sql);
        form.addComponent(new Label("EMPTY_STRING"));
    }

    /**
     * Deshabilita los componentes del footer que se cargan por defecto provenientes de la clase base.
     *
     * @param showFooter
     */
    @Override
    public void buildFooter(boolean showFooter) {
        super.buildFooter(showFooter);
    }
}