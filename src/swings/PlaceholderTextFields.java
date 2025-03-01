package swings;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;
import java.awt.Font;

public class PlaceholderTextFields extends JTextField{
	 private final String placeholders;
	    private boolean showingPlaceholder;

	    public PlaceholderTextFields(String placeholder) {
	    	setFont(new Font("Tahoma", Font.BOLD, 12));
	        this.placeholders = placeholder;
	        this.showingPlaceholder = true;

	        setText(placeholder);
	        setForeground(new Color(255, 204, 102));

	        addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (showingPlaceholder) {
	                    setText("");
	                    setForeground(Color.BLACK);
	                    showingPlaceholder = false;
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (getText().isEmpty()) {
	                    setText(placeholder);
	                    setForeground(new Color(255, 204, 102));
	                    showingPlaceholder = true;
	                }
	            }
	        });
	    }

	    @Override
	    public String getText() {
	        return showingPlaceholder ? "" : super.getText();
	    }
}
