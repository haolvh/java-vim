package window;

import textarea.AreaControl;
import util.FilePath;
import util.OpenFile;
import window.action.MyWindowAction;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.util.List;

public class VimFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 800;

    private static final int TEXTAREA_ROWS = 100;
    private static final int TEXTAREA_COLUMNS = 200;

    private String s = "";
    private String fileName = null;
    private Integer fileSign = 0;

    public VimFrame(){

        setTitle("MyVim");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));
        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        jTextField.setPreferredSize(new Dimension(20,30));
        jPanel.add(jTextField);
        JTextField jTextField1 = new JTextField(1);
        jTextField1.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        jTextField1.setPreferredSize(new Dimension(5,30));
        jTextField1.setText("1,1");
        jTextField1.setHorizontalAlignment(JTextField.RIGHT);
        jTextField1.setEditable(false);
        jPanel.add(jTextField1);
        add(jPanel,BorderLayout.SOUTH);


        JTextArea jTextArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
        jTextArea.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        new AreaControl(jTextArea,jTextField,jTextField1,s,fileName,fileSign);
        add(jTextArea, BorderLayout.CENTER);

        addWindowListener(new MyWindowAction());
    }

    public VimFrame(String filePath){
        this.fileName = filePath;
        if(FilePath.isFilePath(filePath)==1){
            this.fileSign = 1;
            this.s = OpenFile.readFile(filePath);
            /*System.out.println(s);*/
            setTitle(new File(filePath).getName());
        }else{
            this.fileSign = 0;
            setTitle(filePath);
        }
        /*String s= OpenFile.readFile(filePath);
        System.out.println(s);
        setTitle(new File(filePath).getName());*/
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));
        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        jTextField.setPreferredSize(new Dimension(20,30));
        jPanel.add(jTextField);
        JTextField jTextField1 = new JTextField(1);
        jTextField1.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        jTextField1.setPreferredSize(new Dimension(5,30));
        jTextField1.setText("1,1");
        jTextField1.setHorizontalAlignment(JTextField.RIGHT);
        jTextField1.setEditable(false);
        jPanel.add(jTextField1);
        add(jPanel,BorderLayout.SOUTH);


        JTextArea jTextArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
        jTextArea.setFont(new Font("SansSerif",Font.BOLD,20).deriveFont(20.0f));
        new AreaControl(jTextArea,jTextField,jTextField1,s,fileName,fileSign);
        add(jTextArea, BorderLayout.CENTER);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane);
        addWindowListener(new MyWindowAction());
    }
}
