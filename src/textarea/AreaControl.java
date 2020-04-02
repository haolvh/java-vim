package textarea;

import textarea.areaAction.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AreaControl extends JFrame {
    private JTextArea jTextArea;
    private JTextField jTextField;
    private JTextField jTextField1;
    private String fileName;
    private Integer fileSign;
    private String s = "\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~                                        　　　　　\n"+
            "~\n"+
            "~                                      　　　　　　\n"+
            "~\n"+
            "~                                     　　　　　　　　　\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "~\n"+
            "\n";
    private String ss = null;

    public AreaControl(JTextArea jTextArea,JTextField jTextField,JTextField jTextField1,String ss,String fileName,Integer fileSign){
        this.jTextArea = jTextArea;
        this.jTextField = jTextField;
        this.jTextField1 = jTextField1;
        this.ss = ss;
        this.fileName = fileName;
        this.fileSign = fileSign;
        control();
    }

    public void control(){
        new DefaultTextArea(jTextArea,ss,fileName,fileSign,jTextField);
        new TextFieldAction(jTextField,jTextArea);
        jTextArea.addCaretListener(new MyCareAction(jTextArea,jTextField1));
        jTextArea.addMouseListener(new MyCareMouseAction(jTextArea));
        jTextArea.addKeyListener(new CareMoveAction(jTextArea));
        jTextArea.addKeyListener(new AreaModeAction(jTextArea,jTextField,s));
        jTextArea.addKeyListener(new DeletionAndCopyAction(jTextArea));
        jTextField.addKeyListener(new FieldModeAction(jTextArea,jTextField,fileName));
        jTextArea.getCaret().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jTextArea.getCaret().setVisible(true);
            }
        });
    }
}
