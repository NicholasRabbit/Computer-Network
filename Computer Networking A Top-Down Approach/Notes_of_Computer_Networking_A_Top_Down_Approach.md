## Chapter 1 Computer Networks and the Internet

### 1.3 The Network Core

#### **1.3.1 Packet Switching**

There are two predominant types of switching packets:  they are routers and link-layer switches.

##### Routing and Forwarding

What the difference between routing and forwarding?

> Forwarding is the local action of moving arriving packets from router's input to an appropriate router's output link, while routing the global action of determining paths from a source end to a destination end taken by packets.



**Figure 1.11**

![1759286304532](note-images/1759286304532.png)

*There are 2 links and 1 router in this figure.* 

Regardless of propagation delay, the delay of transmitting L bytes from "Source" to "Destination" is $2L/R$ when the switch uses "Store-and-forward Transmission". Whereas, if the switch transmit the first bit it receives without waiting the whole packet, the delay is $L/R$, because it is literally like the switch doesn't exist. 

##### Forwarding Tables and Routing Protocols

How does a router determine which link it should forward the packet onto?

First of all, there is a IP address in each packet. If a packet is sent to a hamlet B in another province from a village where you live, it is transfer to the nearest router of your home; the router doesn't know how to exactly send the packet to the hamlet, but it knows how to send the province in the IP address. So it sends the packet to a router or link-layer switch in the nearest city and the a switch in the city will send the packet to a switch in a provincial switch. All the switches know the fastest way to a provincial switch. 

Secondly, a switch in the provincial centre reads the IP address and send to another provincial switch. Then it is sent to a switch in a city near the destination, a county and finally the hamlet B. 

#### 1.3.2 Circuit Switching

##### Packet Switching Versus Circuit Switching

Why does it need 10 seconds to transmit all the data for a user under TDM(Time-division Multiplexing)?

A link with bandwidth of 1 Mbps is shared by 10 users in a circuit-switched TDM. 1 second is divided into 10 slots so each user can use 0.1 second(100 ms) and transmit 100 kbps data(1Mbps/10); a user can transmit 100k bits per second. As a result, $1Mbps\div 100k=10 s$.

### 1.4 Delay, Loss, and Throughput in Packet-Switched Networks

#### 1.4.1 Overview of Delay in Packet-Switched Networks

##### Types of Delay

(1) Bottleneck link is always at network edge, which means that it is the bandwidth of links at the edge of the Network that always causes delay or congestion. 

##### Comparing Transmission and Propagation Delay

Let me draw an analogy between a tollbooth on a high way and a router. 

Suppose there are 10 cars as a group driving through the tollbooth A, each car needs 12 seconds to pass. It needs 10*12=120 seconds in total. This is transmission delay. 

Also suppose tollbooth B is 100 kilometres from tollbooth A, the caravan accelerate instantaneously to 100 km/h. The time from A to B is 1 hour. This is propagation delay.

#### 1.4.4 Throughput in Computer Networks

Since the rate of the core of network is over-provisioned and tremendous, the constraining factor for throughput of today's Internet is normally at the access network.

### 1.5 Protocol Layers and Their Service Models 

Messages exchanged by higher layer protocols such as HTTP, FTP, TCP, UDP, DNS, or IP are all eventually encapsulated in link-layer frames that are transmitted by physical media such as an Ethernet cable. Thus, a packet sniffer such as Wireshark can receive the copy of every link-layer frame to be analysed. 