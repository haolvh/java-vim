package textarea.areaAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyCareMouseAction extends MouseAdapter {
    private JTextArea jTextArea;

    public MyCareMouseAction(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        jTextArea.setCursor(new Cursor(Cursor.TEXT_CURSOR)); //鼠标进入Text区后变为文本输入指针
    }
    public void mouseExited(MouseEvent mouseEvent) {
        jTextArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //鼠标离开Text区后恢复默认形态
    }
}
