import window.VimFrame;

import java.util.Scanner;

public class MyVim {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();

        if(order.equals("myvim")){
            VimFrame vimFrame = new VimFrame();
            vimFrame.setVisible(true);
        }

        if(order.startsWith("vim")){
            String filePath;
            if(order.contains("/")){
                int index1 = order.indexOf("/");
                int index2 = order.length();
                filePath = order.substring(index1,index2);
                /*System.out.println(filePath);*/
            }else{
                int index1 = order.indexOf(" ");
                int index2 = order.length();
                filePath = order.substring(index1+1,index2);
                /*System.out.println(filePath);*/
            }
            VimFrame vimFrame = new VimFrame(filePath);
            vimFrame.setVisible(true);

        }

        /*VimFrame vimFrame = new VimFrame("vim /home/l/IdeaProjects/test/test1.txt");
        vimFrame.setVisible(true);*/
    }
}
