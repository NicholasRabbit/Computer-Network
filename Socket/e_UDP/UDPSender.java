package com.network.e_UDP;


import java.io.IOException;
import java.net.*;

/*
* 使用UDP协议的形式进行网络编程
* 1,UDP在网络开发中使用较少；
* 2,在Socket网络编程中，UDP接发两端都是把数据封装到DatagramPacket对象里的；
*   注意UDP两端的对象是DatagramSocket，注意区分
* 3,UDP是以数据包的形式发送数据的，每个数据包限制64kb,因此不适宜发送大文件；
* 4,UDP两端都要规定好端口，与TCP不同，TCP的客户端系统会默认给个端口。
* */

//发送端
public class UDPSender {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            //1,创建DatagramSocket对象，用来封装数据，同时规定好端口
            socket = new DatagramSocket(9090);  //是DatagramSocket, 不是DatagramPacket

            byte[] data = "Hi this is a message from Sender!".getBytes();

            //2,创建DatagramPacket对象，存放数据
            DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName("127.0.0.1"),8081);
            //3,发送数据
            socket.send(packet);

            //5，接收从接收端返回的信息
            byte[] bytes = new byte[1024];
            DatagramPacket packet02 = new DatagramPacket(bytes,bytes.length);
            socket.receive(packet02);
            int length = packet02.getLength();   //接收到数据的长度
            byte[] data02 = packet02.getData();  //把接受的数据存到byte[]数组
            String message = new String(data02,0,length);
            System.out.println("message ==>" + message);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4,最后记得关闭传输，不要占用网络资源
            socket.close();
        }
    }
}
