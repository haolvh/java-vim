package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void writeFile(String fileName,String fileText){
        String filePath;
        if(fileName.startsWith("/")){
            File fileReWrite = new File(fileName);
            if(fileReWrite.exists()&&fileReWrite.isFile()){
                fileReWrite.delete();
            }
            filePath = fileName;
        }else{
            filePath = "/home/l/IdeaProjects/test/"+fileName;
        }
        try {
            File file1 = new File(filePath);
            File fileDir = file1.getParentFile();
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }
            file1.createNewFile();
        }catch (IOException e){
            System.out.println("创建文件失败！");
            e.printStackTrace();
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(fileText.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
