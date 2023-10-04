package com.network.e_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//UDP接收端
public class UDPReceiver {

    public static void main(String[] args) {
        DatagramSocket receiver = null;
        try {
            //1，创建DatagramSocket接收端对象
            receiver = new DatagramSocket(8081);
            //2，创建DatagramPacket对象接受数据
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
            //3，调用方法接收数据，有数据发送到8081端口就接收，否则一直等待
            System.out.println("接收端等待中……");
            receiver.receive(packet);   //把接收到的数据封装进packet对象里
            //4，把接收的数据包拆解
            int length = packet.getLength();  //接收到数据的长度
            byte[] receiveData = packet.getData();  //把接受的数据存到byte[]数组
            String message = new String(receiveData,0,length);
            System.out.println("receive message ==>" + message);

            //5，回复信息给发送端，写法和发送端发送信息写法一样
            byte[] data = "Hi this is a message from Recevier!".getBytes();
            DatagramPacket packetReceive = new DatagramPacket(data,data.length, InetAddress.getByName("127.0.0.1"),9090);  //发送端的端口：9090
            receiver.send(packetReceive);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            receiver.close();
        }
    }
}
