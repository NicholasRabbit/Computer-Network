package com.network.d_Socket03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer03 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket server = null;
        InputStream in = null;
        OutputStream out = null;  //本地存图片的输出流
        OutputStream msgOut = null;  //网络的输出流
        BufferedWriter bufferOut = null;
        try {
            //1,创建服务器，定义好端口
            serverSocket = new ServerSocket(8082);
            System.out.println("服务器已启动监听端口8082，等待连接……");
            //2,获取服务器端的Socket对象
            server = serverSocket.accept();
            //3,获取网络输入流
            in = server.getInputStream();
            //4,读取数据，并通过输出流写入到服务器本地磁盘
            //  使用相对路径注意在Edit Configurations里进行项目根路径的相关设置，否则报错
            //  这里设置根路径为src,也可手动更改为其它位置。
            out = new FileOutputStream("com\\network\\d_Socket03\\serverImages\\ThreeKingdoms.jpg");

            /*//上传一个大文件，测试并查看客户端的端口
            out = new FileOutputStream("com\\network\\d_Socket03\\serverImages\\借刀杀人.avi");*/

            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes,0,readCount);
            }
            out.flush();  //调用flush()方法，把缓存中的数据全部存进磁盘里

            //5,向客户端回复消息“已收到图片”,使用字符流
            msgOut = server.getOutputStream();
            bufferOut = new BufferedWriter(new OutputStreamWriter(msgOut));
            bufferOut.write("已收到图片！");
            bufferOut.flush();
            server.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (msgOut != null) {
                try {
                    msgOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferOut != null) {
                try {
                    bufferOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
