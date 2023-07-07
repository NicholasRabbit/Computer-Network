package com.network.d_Socket03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1,使用Socket从客户端向服务器传送文件范例；
 * */
public class SocketClient03 {

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        Socket client = null;
        BufferedReader reader = null;
        InputStream msgIn = null; //服务器消息输入流
        try {
            //1,创建客户端Socket对象
            client = new Socket(InetAddress.getLocalHost(),8082);
            //2,要想向服务器传文件，首先从本地获取文件的输入流, 这里idea相对路径报异常FileNotFoundException，绝对路径管用可复制成功，后期待研究
            String filePath = "F:\\Learning\\Computer\\Socket网络编程\\Network_Code\\Network\\src\\com\\network\\d_Socket03\\images\\三国.jpg";

            /*//上传一个大文件，好有时间在DOS窗口输入“netstat”,并查看客户端的端口
            String filePath = "D:\\Moives-D\\MichaelMann\\Collateral.借刀杀人.双语字幕.HR-HDTV.AC3.960X528.x264-人人影视制作.avi";*/

            in = new FileInputStream(filePath);
            //3,获取输出流，向网络中输出字节流到服务器
            out = client.getOutputStream();
            //4,从本地读到程序内，再从程序传送到网络输出流中
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while( (readCount = in.read(bytes)) != -1){
                out.write(bytes,0,readCount);
            }
            out.flush();  //调用flush()方法，把缓存总剩余数据全部传送到磁盘中
            //5,传输完毕调用shutdownOutput()方法，告诉服务器后面不再传输数据
            client.shutdownOutput();

            //6,接收服务器的消息
            msgIn = client.getInputStream();
            reader = new BufferedReader(new InputStreamReader(msgIn));
            String message = null;
            while ((message = reader.readLine()) != null) {
                System.out.println("message form server: " + message);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
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
            if (msgIn != null) {
                try {
                    msgIn.close();
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
            }

        }
    }
}
