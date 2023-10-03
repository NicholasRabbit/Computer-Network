### 1, ARP协议

参考：https://blog.csdn.net/m0_45406092/article/details/118548617
			https://zhuanlan.zhihu.com/p/370507243

ARP协议： (Address Resolution Protocol) 根据IP地址获取物理地址的一种TCP/IP协议

ARP协议流程：

1，假设本地电脑主机IP地址：192.168.0.104，MAC地址：00-D8-61-11-1C-44(MAC地址由6组数字组成每位是一个Byte=两个16进制)，想要找网关192.168.0.1的MAC地址，本主机会以Broadcast广播的形式发送消息。消息中包含本机的IP地址和MAC地址，以及请求的IP地址和用00-00-00-00-00-00表示的MAC地址。

2，如果192.168.0.1收到广播，则会存储主机的IP和MAC地址，然后把自己的MAC地址发送给请求主机。

Wireshark搜索框里输入arp进行过滤后，可用ping  www.baidu.com 来查看本地主机和网关使用ARP交互的过程。

