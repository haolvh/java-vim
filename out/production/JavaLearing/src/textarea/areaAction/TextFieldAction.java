package textarea.areaAction;

import util.HighLightUtil;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
public class TextFieldAction implements DocumentListener {

    private JTextField jTextField;
    private JTextArea jTextArea;
    private String s;
    public TextFieldAction(JTextField jTextField,JTextArea jTextArea){
        this.jTextField = jTextField;
        this.jTextArea = jTextArea;
        Document document = this.jTextField.getDocument();
        document.addDocumentListener(this);
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        s = jTextField.getText();
        if(s.startsWith("/")&&!s.equals("/")){
            new HighLightUtil(jTextArea,s.substring(1,s.length())," ").find();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        s = jTextField.getText();
        if(s.contains("/")&&!s.equals("/")){
            s = s.substring(s.indexOf('/')+1,s.length());
            new HighLightUtil(jTextArea,s," ").find();
        }else if(s.equals("/")){
            Highlighter highlighter = jTextArea.getHighlighter();
            highlighter.removeAllHighlights();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
