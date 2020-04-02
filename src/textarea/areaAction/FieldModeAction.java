package textarea.areaAction;

import util.HighLightUtil;
import util.OpenFile;
import util.WriteFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class FieldModeAction implements KeyListener {


    private JTextArea jTextArea;
    private JTextField jTextField;
    private Integer editSign;
    private Integer orderSign;
    /*private Integer firstCareOffset;*/
    private String text;
    private String latestText;
    private String fileName;
    public FieldModeAction(JTextArea jTextArea, JTextField jTextField,String fileName){
        this.jTextArea = jTextArea;
        this.jTextField = jTextField;
        this.editSign = 0;
        this.orderSign = 0;
        /*this.firstCareOffset = this.jTextArea.getText().length();*/
        this.text = jTextArea.getText();
        this.fileName = fileName;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_Q){
            orderSign = 1;
        }

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            orderSign = 1;
        }

        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            orderSign = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_ENTER&&
                (jTextField.getText().equals(":q!")||jTextField.getText().equals(":q！")
                        ||jTextField.getText().equals(":ｑ！")||jTextField.getText().equals(":ｑ!"))){
            System.out.println("我退出了！");
            System.exit(0);
        }

        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_ENTER&&
                (jTextField.getText().indexOf("/")!=jTextField.getText().lastIndexOf("/"))){
            String text = jTextField.getText();
            String s1 = text.substring(1,text.lastIndexOf("/"));
            String s2 = text.substring(text.lastIndexOf("/")+1,text.length());
            new HighLightUtil(jTextArea,s1,s2).replace();
            jTextField.setText("已修改！");
            jTextField.setBackground(Color.RED);
            new HighLightUtil(jTextArea,s2,"").find();
            Robot robot = null;
            try{
                robot = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            /*jTextArea.setCaretPosition(jTextArea.getText().length()-firstCareOffset);*/
            jTextArea.setCaretPosition(jTextArea.getCaretPosition());
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            jTextArea.select(jTextArea.getCaretPosition()-1,jTextArea.getCaretPosition());
            jTextArea.setSelectionColor(Color.GRAY);
        }

        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_ENTER&&
                (jTextField.getText().equals(":w")||jTextField.getText().equals(":ｗ"))){
            String text = jTextArea.getText();
            this.latestText = text;
            WriteFile.writeFile(fileName,text);
            jTextField.setText("\""+new File(fileName).getName()+"\""+"        已写入");

            Robot robot = null;
            try{
                robot = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            jTextArea.setCaretPosition(jTextArea.getCaretPosition());

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_ENTER&&
                (jTextField.getText().equals(":q")||jTextField.getText().equals(":ｑ"))){
            if(jTextArea.getText().equals(text)||jTextArea.getText().equals(latestText)){
                System.out.println("我退出了！");
                System.exit(0);
            }else{
                jTextField.setText("文件已修改不能退出！");
                jTextField.setBackground(Color.RED);

                Robot robot = null;
                try{
                    robot = new Robot();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

                jTextArea.setCaretPosition(jTextArea.getCaretPosition());

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
        }

        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_ENTER&&
                (jTextField.getText().equals(":x")||jTextField.getText().equals(":ｘ"))){
            String text = jTextArea.getText();
            this.latestText = text;
            WriteFile.writeFile(fileName,text);
            System.out.println("已保存！　　我退出了！");
            System.exit(0);
        }

        if(orderSign==1&&e.getKeyCode()==KeyEvent.VK_BACK_SPACE&&
                (jTextField.getText().equals(null)||jTextField.getText().equals(""))){
            Robot robot = null;
            try{
                robot = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            /*jTextArea.setCaretPosition(jTextArea.getText().length()-firstCareOffset);*/
            jTextArea.setCaretPosition(jTextArea.getCaretPosition());
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            jTextArea.select(jTextArea.getCaretPosition()-1,jTextArea.getCaretPosition());
            jTextArea.setSelectionColor(Color.GRAY);
        }
        orderSign = 0;
        editSign = 0;
    }
}
