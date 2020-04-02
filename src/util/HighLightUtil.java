package util;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class HighLightUtil {

    private JTextArea jTextArea;
    private String s1;
    private String s2;

    public HighLightUtil(JTextArea jTextArea, String s1,String s2) {
        this.s1= s1;
        this.s2= s2;
        jTextArea.setCaretPosition(0);
        this.jTextArea = jTextArea;
    }

    public void find() {
        Highlighter highlighter = jTextArea.getHighlighter();
        highlighter.removeAllHighlights();
        DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        String text = jTextArea.getText();
        int end = text.length();
        int len = s1.length();
        int start = 0;
        if (start == end)
            start = 0;
        for (; start <= end - len; start++) {
            if (text.substring(start, start + len).equals(s1)) {
                /*jTextArea.setSelectionStart(start);
                jTextArea.setSelectionEnd(start + len);*/
                try{
                    highlighter.addHighlight(start,start+len,painter);
                }catch (BadLocationException e){
                    e.printStackTrace();
                }
                start += len-1;
            }
        }
    }

    public void replace(){
        String text = jTextArea.getText();
        int end = text.length();
        int len = s1.length();
        int start = 0;
        if (start == end)
            start = 0;
        for (; start <= end - len; start++) {
            if (text.substring(start, start + len).equals(s1)) {
                /*jTextArea.setSelectionStart(start);
                jTextArea.setSelectionEnd(start + len);*/
                jTextArea.replaceRange(s2,start,start+len);
                end = jTextArea.getText().length();
                text = jTextArea.getText();
                start += s2.length()-1;
            }
        }
    }
}
