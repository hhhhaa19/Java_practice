package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:在udp中有效信息都在报中，自己要多写几遍，request直接接受就行，response要设目标IP
 * 这里我们为方便所以request都是基于服务器的角度
 * User: Benjamin
 * Date: 2024-03-05
 * Time: 20:12
 */
public class UdpEchoServer {
    DatagramSocket socketServe = null;

    public UdpEchoServer(int port) throws SocketException {
        socketServe = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true) {
            //接受客户端request
            DatagramPacket request = new DatagramPacket(new byte[4096], 4096);
            socketServe.receive(request);
            //根据输入包，处理
            String strRequest = new String(request.getData(), 0, request.getLength());
            String strResponse = this.process(strRequest);
            //构造response数据包
            DatagramPacket response = new DatagramPacket(strResponse.getBytes(),0,strResponse.length());
            response.setAddress(request.getAddress());
            response.setPort(request.getPort());
            socketServe.send(response);
            //打印日志
            System.out.printf("[%s:%d]request:%s,response:%s",request.getAddress(),request.getPort(),strRequest,strResponse);
        }
    }

    private String process(String request) {
        //回响服务器
        return  request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
