package util;

import java.io.File;

public class FilePath {
    private static Integer isFileSign;
    public static Integer isFilePath(String filePath){
        File file = new File(filePath);
        if(file.exists()&&file.isFile()){
            isFileSign = 1;
        }else
            isFileSign = 0;
        /*System.out.println(isFileSign);*/
        return isFileSign;
    }
}
