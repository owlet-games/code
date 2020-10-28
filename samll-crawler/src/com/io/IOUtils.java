package com.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

    public static void closeOutputStream(OutputStream outputStream){
        if (outputStream != null){
            try{
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void closeInputStream(InputStream inputStream){
        if (inputStream != null){
            try{
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void copy(InputStream inputStream,OutputStream outputStream,int buff) throws IOException{
        if (inputStream == null){
            throw new IllegalArgumentException("inputStream����Ϊ��"); //���Ϸ������쳣
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream����Ϊ��"); //���Ϸ������쳣
        }
        if (buff <= 0){
            throw new IllegalArgumentException("buff���벻С��0"); //���Ϸ������쳣
        }

        byte[] buffer = new byte[buff];
        int len;
        while ((len=inputStream.read(buffer)) > 0){
            outputStream.write(buffer,0,len);
        }
    }
}
