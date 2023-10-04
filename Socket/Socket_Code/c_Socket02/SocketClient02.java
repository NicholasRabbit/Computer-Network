package com.network.c_Socket02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient02 {

    public static void main(String[] args) {
        Socket client = null;
        OutputStream out = null;
        BufferedWriter writer = null;
        InputStream in = null;
        BufferedReader clientReader = null;
        try {
            //1,创建客户端对象
            client = new Socket(InetAddress.getLocalHost(),8082);
            //2,获取输出字节流, 这一步跟IO流中创建读取文件的输入流同理：
            //  例：BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("bufferReadFile002.txt")));
            out = client.getOutputStream();
            //3,把输出流转换为字符流
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write("Hello Server! I'm a client buffer.");
            writer.flush();     //write()方法写完要刷新流
            //4,调用shutdownOutput(),告诉服务器后面不再发送消息了，否则服务器会一直等待
            client.shutdownOutput();
            //5,获取服务端传来的字节流数据
            in = client.getInputStream();
            //6,把字节流转换为字符流
            clientReader = new BufferedReader(new InputStreamReader(in));
            String msg = null;
            while( (msg = clientReader.readLine()) != null ){
                System.out.println("client==>" + msg);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (client != null) {
                try {
                    client.close();
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
            if (writer != null) {
                try {
                    writer.close();
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
            if (clientReader != null) {
                try {
                    clientReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
