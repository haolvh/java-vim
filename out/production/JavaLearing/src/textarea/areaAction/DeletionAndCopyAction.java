package textarea.areaAction;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class DeletionAndCopyAction implements KeyListener {

    private JTextArea jTextArea;
    private Date DTime1;
    private Date DTime2;
    private Date CTime1;
    private Date CTime2;
    private Integer deletionSign = 0;
    private Integer copySign = 0;
    private Integer copySth1 = 0;
    private Integer copySth2 = 0;
    private String copyString;
    public DeletionAndCopyAction(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_D){
            deletionSign+=1;
        }

        if(e.getKeyCode()==KeyEvent.VK_Y){
            copySign+=1;
        }

        if(e.getKeyCode()==KeyEvent.VK_P){
            copySth2 = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_D&&deletionSign==1){
            DTime1 = new Date();
        }

        if(e.getKeyCode()==KeyEvent.VK_D&&deletionSign>2){
            deletionSign = 0;
            DTime1 = new Date();
        }

        if(e.getKeyCode()==KeyEvent.VK_D&&deletionSign==2){
            DTime2 = new Date();
            if(DTime2.getTime()-DTime1.getTime()<30*10){
                try {
                    int row = jTextArea.getLineOfOffset(jTextArea.getCaretPosition());
                    int start = jTextArea.getLineStartOffset(row);
                    int end = jTextArea.getLineEndOffset(row);
                    jTextArea.replaceRange(null,start,end);
                    deletionSign = 0;
                    jTextArea.select(jTextArea.getCaretPosition(),jTextArea.getCaretPosition()+1);
                    jTextArea.setSelectionColor(Color.GRAY);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }else
                deletionSign = 0;
        }

        if(e.getKeyCode()==KeyEvent.VK_Y&&copySign==1){
            CTime1 = new Date();
        }

        if(e.getKeyCode()==KeyEvent.VK_Y&&copySign>2){
            copySign = 0;
            CTime1 = new Date();
        }

        if(e.getKeyCode()==KeyEvent.VK_Y&&copySign==2){
            CTime2 = new Date();
            if(CTime2.getTime()-CTime1.getTime()<30*10){
                try {
                    int row = jTextArea.getLineOfOffset(jTextArea.getCaretPosition());
                    int start = jTextArea.getLineStartOffset(row);
                    int end = jTextArea.getLineEndOffset(row);
                    jTextArea.select(start,end-1);
                    jTextArea.setSelectionColor(Color.GRAY);
                    copyString = jTextArea.getSelectedText();
                    System.out.println(copyString);
                    copySign = 0;
                    copySth1 = 1;
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }else{
                copySign = 0;
                copySth1 = 0;
            }
        }

        if(copySth1==1&&copySth2==1&&e.getKeyCode()==KeyEvent.VK_P){
            jTextArea.insert(copyString,jTextArea.getCaretPosition());
            copySth2 = 0;
        }
    }
}
