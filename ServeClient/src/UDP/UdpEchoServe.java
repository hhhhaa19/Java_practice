package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:在udp中有效信息都在报中，自己要多写几遍，request直接接受就行，response要设目标IP
 * 这里我们为方便所以request都是基于服务器的角度
 * User: Benjamin
 * Date: 2024-03-05
 * Time: 20:12
 */
public class UdpEchoServe {
    private DatagramSocket datagramSocket = null;
    public UdpEchoServe(int port) throws SocketException {
        //程序提供一个socket去链接一个硬件的网口
        datagramSocket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){

            //利用网卡的接口，接受客户端请求,这里以输入型参数来传入
            DatagramPacket request = new DatagramPacket(new byte[1024],1024);
            //注意这里datagramPacket不是流，而是一个报
            datagramSocket.receive(request);
            //处理请求,注意是我们构建的服务器进程来处理
            DatagramPacket response = this.process(request);
            //打印日志
            System.out.printf("[%s:%d] request\n",request.getAddress(),request.getPort());
            //利用网卡的接口response响应
            datagramSocket.send(response);
        }
    }

    private DatagramPacket process(DatagramPacket request) {
        //处理数据报,注意用报中数据的有效部分,而不是直接数组长度
        String stringResponse = new String(request.getData(),0,request.getLength());
        //业务逻辑，这里无
        //构造一个数据报，返回回去,注意request报本身包含source的IP与地址,但有意思的是作为request应该也要有destination的IP与端口，
        // 那我们怎么知道得到的是哪个，用于发送的报的sourceIP是send出去才用的
        //->我们通过封装，使得datagramPacket的source只能被得到，不能被修改，destination只能修改，不能修改
        DatagramPacket response = new DatagramPacket(stringResponse.getBytes(),0,stringResponse.getBytes().length);
        response.setAddress(request.getAddress());
        response.setPort(request.getPort());
        return response;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServe udpEchoServe = new UdpEchoServe(9090);
        udpEchoServe.start();
    }
}
