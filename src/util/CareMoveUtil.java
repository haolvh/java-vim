package util;

import javax.swing.*;
import java.awt.*;

public class CareMoveUtil {
    public static void setLeftCare(JTextArea jTextArea){
        try {
            //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            if(posi<1)
                posi = 1;
            jTextArea.setCaretPosition(posi-1);
            jTextArea.select(posi-2,posi-1);
            jTextArea.setSelectionColor(Color.GRAY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setRight(JTextArea jTextArea){
        try {
            //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            if(posi>jTextArea.getText().length()-1)
                posi = jTextArea.getText().length()-1;
            jTextArea.setCaretPosition(posi+1);
            jTextArea.select(posi,posi+1);
            jTextArea.setSelectionColor(Color.GRAY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setUp(JTextArea jTextArea){
        try {
            //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            //计算行数，比较奇芭，能用，有待搞懂
            int rows = jTextArea.getLineOfOffset(posi) + 1;
            //用光标偏移量减去行首偏移量就是列数了，
            int columns = posi - jTextArea.getLineStartOffset(rows-1) + 1;
            /*System.out.println("posi="+posi);
            System.out.println("rows="+rows);
            System.out.println("columns="+columns);*/
            if(rows==1){
                jTextArea.setCaretPosition(posi);
                jTextArea.select(posi-1,posi);
                jTextArea.setSelectionColor(Color.GRAY);
            }else {
                int upRowsCount = jTextArea.getLineEndOffset(rows-2) - jTextArea.getLineStartOffset(rows-2);
                if(columns>upRowsCount){
                    jTextArea.setCaretPosition(jTextArea.getLineEndOffset(rows-2)-1);
                    jTextArea.select(jTextArea.getLineEndOffset(rows-2)-1-1,jTextArea.getLineEndOffset(rows-2)-1);
                    jTextArea.setSelectionColor(Color.GRAY);
                }else{
                    jTextArea.setCaretPosition(jTextArea.getLineStartOffset(rows-2)+columns-1);
                    jTextArea.select(jTextArea.getLineStartOffset(rows-2)+columns-1-1,jTextArea.getLineStartOffset(rows-2)+columns-1);
                    jTextArea.setSelectionColor(Color.GRAY);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setDown(JTextArea jTextArea){
        try {
            //获取光标位置，距离起始位置的偏移量
            int posi = jTextArea.getCaretPosition();
            //计算行数，比较奇芭，能用，有待搞懂
            int rows = jTextArea.getLineOfOffset(posi) + 1;
            //用光标偏移量减去行首偏移量就是列数了，
            int columns = posi - jTextArea.getLineStartOffset(rows-1) + 1;
            int rows2;
            int sign = 0;
            int textLength = jTextArea.getText().length();
            int lastRows = jTextArea.getLineOfOffset(textLength) + 1;
            if(rows==lastRows-1){
                rows2 = rows;
                sign = 0;
            }else if(rows==lastRows){
                sign = 1;
                rows2 = rows;
            }else {
                rows2 = rows + 1;
                sign = 0;
            }
            if(sign==0){
                if(rows2==lastRows){
                    jTextArea.setCaretPosition(posi);
                    if(posi==textLength){
                        int posi1 = textLength - 1;
                        jTextArea.select(posi1,posi1+1);
                        jTextArea.setSelectionColor(Color.GRAY);
                    }else{
                        jTextArea.select(posi,posi+1);
                        jTextArea.setSelectionColor(Color.GRAY);
                    }
                }else {
                    int upRowsCount = jTextArea.getLineEndOffset(rows) - jTextArea.getLineStartOffset(rows);
                    if(columns>upRowsCount){
                        jTextArea.setCaretPosition(jTextArea.getLineEndOffset(rows)-1);
                        jTextArea.select(jTextArea.getLineEndOffset(rows)-1-1,jTextArea.getLineEndOffset(rows)-1);
                        jTextArea.setSelectionColor(Color.GRAY);
                    }else{
                        jTextArea.setCaretPosition(jTextArea.getLineStartOffset(rows)+columns-1);
                        jTextArea.select(jTextArea.getLineStartOffset(rows)+columns-1-1,jTextArea.getLineStartOffset(rows)+columns-1);
                        jTextArea.setSelectionColor(Color.GRAY);
                    }
                }
            }else {
                jTextArea.setCaretPosition(posi);
                jTextArea.select(posi-1,posi);
                jTextArea.setSelectionColor(Color.GRAY);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
