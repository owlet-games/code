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
            throw new IllegalArgumentException("inputStream不能为空"); //不合法参数异常
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream不能为空"); //不合法参数异常
        }
        if (buff <= 0){
            throw new IllegalArgumentException("buff必须不小于0"); //不合法参数异常
        }

        byte[] buffer = new byte[buff];
        int len;
        while ((len=inputStream.read(buffer)) > 0){
            outputStream.write(buffer,0,len);
        }
    }
}
