package com.network.a_InetAddressTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest001 {
    /**InetAddress类常用方法范例*/
    public static void main(String[] args) {

        try {
            //1,getLocalHost(..)获取代表本机的InetAddress对象。静态方法。
            InetAddress localhost = InetAddress.getLocalHost();  //输出：DESKTOP-FNRT4BQ/192.168.139.1
            System.out.println("localhost==>" + localhost);

            //2,(1) getByName(..)根据指定主机名，获取它的InetAddress对象。静态方法。
            InetAddress inetAddress = InetAddress.getByName("DESKTOP-FNRT4BQ");
            System.out.println("inetAddress==>" + inetAddress);

            //2,(2) getByName(..)也可根据域名，获取InetAddress对象。静态方法。
            InetAddress inetAddress02 = InetAddress.getByName("www.163.com");
            System.out.println("inetAddress02==>" + inetAddress02);

            //3, getHostAddress(), 获取InetAddress对象的IP地址
            String ipAdd = localhost.getHostAddress();
            System.out.println("ipAdd==>" + ipAdd);

            //4, getHostName(),通过InetAddress对象获取主机名或域名
            String hostName01 = localhost.getHostName();
            String hostName02 = inetAddress02.getHostName();
            System.out.printf("hostName01==>%s\nhostName02==>%s",hostName01,hostName02);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }




    }

}
