#### 1, 混合模式和普通模式的区别

普通模式只接受发送给本机的正确的数据包。

<img src="note-images/混杂模式和普通模式区别.jpg" style="zoom:50%;" />

#### 2，Wireshark命令

![1696241847597](note-images/1696241847597.png)

Source：表示发送方
Destination : 表示接受方

在搜索行输入以下命令

```txt
tcp.flags.ack==0   # ack: acknowdlege 确认请求
tcp.flags.ack==0 and tcp.flags.syn==1  : 组合多个条件查询，syn表示刚发的请求过去
and/or : 两个条件的逻辑关系
tcp.flags.fin==1 : 查询已发完的数据
udp/tcp/arp/dns :  查询指定类型协议，注意：udp协议的查询结果包括dns协议
ip.src_host==192.168.0.104 ： 查询指定发送方的请求
ip.dst_host==132.154.15.44 ： 查询指定接收放的请求
ip.src_host==192.168.0.104 or ip.dst_host==132.154.15.44 : 指定发送方或接收方
```

#### 3，多种协议

ARP协议： (Address Resolution Protocol) 根据IP地址获取物理地址的一种TCP/IP协议

