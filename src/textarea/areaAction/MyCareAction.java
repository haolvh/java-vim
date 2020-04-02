package textarea.areaAction;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class MyCareAction implements CaretListener {
    private JTextArea jTextArea;
    private JTextField jTextField;

    public MyCareAction(JTextArea jTextArea, JTextField jTextField){
        this.jTextArea = jTextArea;
        this.jTextField = jTextField;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        try {
           /* //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            //计算行数，比较奇芭，能用，有待搞懂
            Rectangle rec = jTextArea.modelToView(posi);
            int rows = rec.y / rec.height + 1;
            //计算列数用上面的方法就不行了，先获取所在行r,但是如果设置了自动换行的话，这个r目测不好用，
            int r = jTextArea.getLineOfOffset(posi);
            //用光标偏移量减去行首偏移量就是列数了，
            int columns = posi - jTextArea.getLineStartOffset(r) + 1;*/

            //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            //计算行数，比较奇芭，能用，有待搞懂
            int rows = jTextArea.getLineOfOffset(posi) + 1;
            //用光标偏移量减去行首偏移量就是列数了，
            int columns = posi - jTextArea.getLineStartOffset(rows-1) + 1;
            jTextField.setText(rows+","+columns);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
