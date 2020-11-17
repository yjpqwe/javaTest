package com.java.test.try_with_resource;

import java.io.*;

/**
 * 解决使用try finally的资源泄露隐患
 */
public class Main {
    /**
     * 传统的方式实现对资源的关闭
     * @return
     * @throws IOException
     */
    private String traditionalTryCatch() throws IOException{
        //1.单一资源的关闭
//        String line = null;
//        BufferedReader br = new BufferedReader(new FileReader(""));
//        try {
//            line = br.readLine();
//        } finally {
//            br.close();
//        }
//        return line;

        //2.多个资源的关闭
        //输入流，第一个资源
        InputStream in = new FileInputStream("");
        try {
            //输出流，第二个资源
            OutputStream out = new FileOutputStream("");
            try {
                byte[] buf = new byte[100];
                int n;

                while ((n=in.read(buf))>=0)
                    out.write(buf,0,n);
            }finally {
                out.close();
            }
        }finally {
            in.close();
        }
        return null;
    }

    /**
     * java7引入的try with resources实现自动的资源关闭
     * @return
     * @throws IOException
     */
    private String newTryWithResources() throws IOException{
        //1.单个资源的使用与关闭
//        try(BufferedReader br = new BufferedReader(new FileReader(""))){
//            return br.readLine();
//        }

        //2.多个资源的使用与关闭
        try(FileInputStream in = new FileInputStream("");
        FileOutputStream out = new FileOutputStream("")
        ){
            byte[] buffer = new byte[100];
            int n = 0;
            while ((n=in.read(buffer))!=-1){
                out.write(buffer,0,n);
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
//        AutoClose autoClose = new AutoClose();
//        try {
//            autoClose.work();
//        }finally {
//            autoClose.close();
//        }
        try(AutoClose autoClose = new AutoClose()){
            autoClose.work();
        }
    }
}
