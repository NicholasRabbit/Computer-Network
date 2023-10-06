package com.network.c_Socket02;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1,本例示范使用字符流进行网络传输数据，字符流只能传输纯文本
 * 2,跟IO流一样，字符流需要转换为字节流才可传输
 * 3,字符流用于传输纯文本的话，效率比字节流高，调用的方法也多
 * 4,客户端，或服务端不再输出时，别忘记调用shutdownOutput()方法，否则会一直等待*/
public class SocketServer02 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket server = null;
        InputStream in = null;
        BufferedReader reader = null;
        OutputStream out = null;
        BufferedWriter serverWriter = null;
        try {
            serverSocket = new ServerSocket(8082);
            System.out.println("服务器等待连接……");
            server = serverSocket.accept();
            //1,接收客户端传来的字节输入流
            in = server.getInputStream();
            //2,把输入流转换为字符流
            reader = new BufferedReader(new InputStreamReader(in));  //使用InputStreamReader把字节流转换为字符流，注意如果包装流关闭，其内部节点流也会关闭
            String str = null;
            if((str = reader.readLine()) != null){
                System.out.println("server==>" + str);
            }
            //3,回传信息给客户端
            out = server.getOutputStream();
            serverWriter = new BufferedWriter(new OutputStreamWriter(out));  //字节流转换为字符流
            serverWriter.write("Hello client! I'm a server buffer,too.");
            //write(..)方法写完要刷新
            serverWriter.flush();
            //4,关闭发送消息，否则客户端一直等待
            server.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
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
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverWriter != null) {
                try {
                    serverWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
