package tokenfield.src.org.vaadin.tokenfield;
import com.vaadin.ui.ComboBox;

public abstract class TokenComboBox extends ComboBox {

    private static final long serialVersionUID = 8382983756053298383L;

    protected TokenField.InsertPosition insertPosition;

    public TokenComboBox(TokenField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        this.setVisible(false);
    }


    public void setTokenInsertPosition(TokenField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        requestRepaint();
    }

    abstract protected void onDelete();

}
