package com.network.b_Socket01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) {

        OutputStream out = null;
        InputStream in = null;
        Socket client = null;
        try {
            //1,创建客户端的Socket对象，连接本地ServerSocket监听的端口，如果成功则返回Socket对象。实际开发中通常是两台机器，这里仅作练习。
            client = new Socket(InetAddress.getLocalHost(),8082);
            System.out.println("Client's Socket==>" + client);
            //2,获取IO流进行传输数据, 这里使用字节流,写法和普通的IO流传输写法一样；
            out = client.getOutputStream();
            out.write("Hi server!".getBytes());
            //3,这里也调用shutdownOutput()方法，表示客户端也不再发消息了
            client.shutdownOutput();
            //4,接收服务器传来的数据
            in = client.getInputStream();
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ( (readCount = in.read(bytes)) != -1 ){
                System.out.println(new String(bytes,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5, 传输完毕要关闭IO流和网络连接，不要占用资源
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}
