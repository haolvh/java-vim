package textarea.areaAction;

import util.CareMoveUtil;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CareMoveAction implements KeyListener {


    private JTextArea jTextArea;
    public CareMoveAction(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()=='H'){
            CareMoveUtil.setLeftCare(jTextArea);
        }

        if(e.getKeyCode()=='L'){
            CareMoveUtil.setRight(jTextArea);
        }

        if(e.getKeyCode()=='J')
            CareMoveUtil.setUp(jTextArea);

        if(e.getKeyCode()=='K')
            CareMoveUtil.setDown(jTextArea);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
