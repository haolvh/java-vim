package textarea.areaAction;

import util.CarePosition;

import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AreaModeAction implements KeyListener {

    private JTextArea jTextArea;
    private JTextField jTextField;
    private Integer editSign;
    private Integer orderSign;
    private String s;
    private Integer caretPosition;
    public AreaModeAction(JTextArea jTextArea, JTextField jTextField, String s){
        this.jTextArea = jTextArea;
        this.jTextField = jTextField;
        this.editSign = 0;
        this.orderSign = 0;
        this.s = s;
        this.caretPosition = jTextArea.getCaretPosition();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_I){
            editSign = 1;
        }

        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            editSign = 0;
        }

        if(e.getKeyCode()==KeyEvent.VK_SHIFT){
            orderSign = 2;
            editSign = 0;
            //System.out.println(orderSign);
        }

        if(e.getKeyCode()==KeyEvent.VK_SEMICOLON){
            orderSign ++;
            //System.out.println(orderSign);
        }

        if(e.getKeyCode()==KeyEvent.VK_D){
            orderSign = 1;
            editSign = 0;
        }

        if(e.getKeyCode()==KeyEvent.VK_SLASH){
            orderSign = 1;
            editSign = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_SLASH){
            jTextField.setText("/");
            Robot robot = null;
            try{
                robot = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }


            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            /*jTextArea.setEditable(false);
            jTextField.setBackground(Color.WHITE);
            jTextField.setText(":");*/
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        if(editSign==1&&e.getKeyCode()==KeyEvent.VK_I){
            jTextField.setBackground(Color.WHITE);
            jTextField.setText("-- insert --");
            if(jTextArea.getText()==null){
                jTextArea.setText("");
                jTextArea.setCaretPosition(caretPosition);
            }
            /*jTextArea.setText("");*/
            jTextArea.setCaretPosition(jTextArea.getCaretPosition());
            jTextArea.setEditable(true);
            jTextArea.setLineWrap(true);        //激活自动换行功能
            jTextArea.setWrapStyleWord(false);            // 激活断行不断字功能</strong>
            /*System.out.println(jTextArea.getLineWrap());*/
        }

        if(editSign==0&&e.getKeyCode()==KeyEvent.VK_ESCAPE){
            jTextArea.setEditable(false);
            jTextField.setBackground(Color.WHITE);
            jTextField.setText(null);
            this.caretPosition = CarePosition.carePosition(jTextArea);
            jTextArea.select(jTextArea.getCaretPosition()-1,jTextArea.getCaretPosition());
            jTextArea.setSelectionColor(Color.GRAY);
            Highlighter highlighter = jTextArea.getHighlighter();
            highlighter.removeAllHighlights();
        }

        if(editSign==0&&orderSign==3&&e.getKeyCode()==KeyEvent.VK_SHIFT){
            jTextArea.setEditable(false);
            jTextField.setBackground(Color.WHITE);
            jTextField.setText(":");
            Robot robot = null;
            try{
                robot = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }


            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            jTextArea.setEditable(false);
            jTextField.setBackground(Color.WHITE);
            jTextField.setText(":");
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }
}
