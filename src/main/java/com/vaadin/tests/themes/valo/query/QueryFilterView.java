package com.vaadin.tests.themes.valo.query;

import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.base.constants.ConditionConstants;
import ve.com.pt.base.constants.GeneralConstants;
import ve.com.pt.base.core.Condition;
import ve.com.pt.base.views.BaseFilterUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Vista de filtros para consultas
 * Created by ypetrilli on 23/05/2016.
 * Modified by ypetrilli on 01/08/2016.
 */
public class QueryFilterView extends BaseFilterUI implements GeneralConstants, ConditionConstants, Upload.Receiver{

    private TextField code;
    private TextField type;
    private TextField subType;

    public QueryFilterView() {
        super();
        setTitle("QUERY_FILTER_VIEW_TITLE");
    }

    /**
     * Construye el formulario con todos los campos correspondientes a la funcionalidad de la vista.
     * Los campos son: código, tipo, subtipo.
     */
    @Override
    public void buildForm() {
        super.buildForm();
        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT, false);
        Condition condition;
        code = new TextField("CODE_LABEL");
        code.setWidth("40%");
//        code.setInputPrompt(CODE_QUERY_INPUT_PROMPT);
        code.setMaxLength(249);
        condition = new Condition();
        condition.setRelop(CONDITION_EQ);
//        condition.setAttribute(ATTRIBUTE_CODE);
        code.setData(condition);
        code.setValidationVisible(true);
        code.setImmediate(true);
//        code.addValidator(new RegexpValidator(ONLY_LETTERS_NUMBERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
        form.addComponent(code);

        type = new TextField("TYPE_LABEL");
//        type.setInputPrompt(TYPE_QUERY_INPUT_PROMPT);
        type.setWidth("40%");
        type.setMaxLength(100);
        condition = new Condition();
        condition.setRelop(CONDITION_LIKE);
//        condition.setAttribute(ATTRIBUTE_TYPE);
        type.setData(condition);
        type.setImmediate(true);
        type.setValidationVisible(true);
//        type.addValidator(new RegexpValidator(ONLY_LETTERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
        form.addComponent(type);

        subType = new TextField("SUBTYPE_LABEL");
//        subType.setInputPrompt(SUBTYPE_QUERY_INPUT_PROMPT);
        subType.setWidth("40%");
        subType.setMaxLength(100);
        condition = new Condition();
        condition.setRelop(CONDITION_LIKE);
//        condition.setAttribute(ATTRIBUTE_SUBTYPE);
        subType.setData(condition);
        subType.setImmediate(true);
        subType.setValidationVisible(true);
//        subType.addValidator(new RegexpValidator(ONLY_LETTERS_AND_SPECIFIC_CHARACTERS, INVALID_CHARACTERS));
        form.addComponent(subType);

        Upload upload = new Upload("something", this);
        form.addComponent(upload);
    }

    @Override
    public OutputStream receiveUpload(String s, String s1) {
        FileOutputStream output = null;

        try{
            output = new FileOutputStream("C:\\Users\\lrodriguez\\Desktop\\"+s);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Valida los datos ingresados y recolecta la data en la entidad a ser procesada en el servicio correspondiente.
     *
     * @param entity
     * @return
     */
//    @Override
//    public boolean onSave(Object entity) {
//        List<TextField> fields = new ArrayList<>();
//        fields.add(code);
//        fields.add(type);
//        fields.add(subType);
//        for (int i = 0; i < fields.size(); i++) {
//            TextField textField = fields.get(i);
//            if (!textField.isValid()) {
//                textField.setRequiredError(INVALID_CHARACTERS);
//                xNotification.setTitle(NO_VALID_INFORMATION);
//                xNotification.Show(Failure);
//                return false;
//            }
//        }
//        return super.onSave(entity);
//    }

    /**
     * Carga todos los campos especificados en su estado inicial.
     *
     * @return
     */
//    @Override
//    public boolean onClean() {
//        code.setValue(EMPTY_STRING);
//        type.setValue(EMPTY_STRING);
//        subType.setValue(EMPTY_STRING);
//        return true;
//    }

}