package textarea.areaAction;

import javax.swing.*;

public class DefaultTextArea {
    private JTextArea jTextArea;
    private JTextField jTextField;
    private String fileName;
    private Integer fileSign;

    public DefaultTextArea(JTextArea jTextArea,String ss,String fileName,Integer fileSign,JTextField jTextField){
        this.jTextArea = jTextArea;
        this.jTextField = jTextField;
        this.fileName = fileName;
        this.fileSign = fileSign;
        setTextArea(ss);
    }

    public void setTextArea(String ss){
        String s = "\n"+
                "~\n"+
                "~\n"+
                "~\n"+
                "~\n"+
                "~\n"+
                "~\n"+
                "~                                        MyVim\n"+
                "~\n"+
                "~                                      版本：１.0\n"+
                "~\n"+
                "~                                     作者：Lv Hao\n"+
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
        String sss = "";
        if(ss!=null&&fileSign==1){
            jTextArea.setText(ss);
            jTextField.setText("\""+fileName+"\"");
        }else if((ss==null||ss.equals(""))&&fileSign==0&&fileName!=null){
            if(fileName.startsWith("/")){
                jTextField.setText("\""+fileName+"\""+"    [新目录]");
            }else
                jTextField.setText("\""+fileName+"\""+"    [新文件]");
            jTextArea.setText(sss);
        }else if(ss.equals("")&&fileSign==1){
            jTextArea.setText(ss);
            jTextField.setText("\""+fileName+"\"");
        }else {
            jTextArea.setText(s);
        }
        jTextArea.setEditable(false);
        /*jTextArea.setCaretPosition(0);*/
    }
}
