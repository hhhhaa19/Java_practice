package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:在UDP中，服务器与客户端都只有一个socket->对应的网卡的端卡，
 * 但每个socket各有一个send与receive,对应一个报，所以有四个报，要想清楚每个报在服务器还是客户端上，是request 还是 response
 * User: Benjamin
 * Date: 2024-03-05
 * Time: 20:46
 */
public class UdpEchoClient {
    public DatagramSocket clientDatagramSocket = null;
    private String serveIp;
    private int servePort;

    public UdpEchoClient(String serveIp, int servePort) throws SocketException {
        //给一个随机端口就行
        clientDatagramSocket = new DatagramSocket();
        //把服务器的IP与port存起来
        this.serveIp = serveIp;
        this.servePort = servePort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //构造请求
            System.out.print("请输入内容"+"->");
            if (!scanner.hasNext()) {
                break;//??
            }
            String str = scanner.next();
            DatagramPacket request = new DatagramPacket(str.getBytes(), 0, str.getBytes().length);
            request.setAddress(InetAddress.getByName(serveIp));
            request.setPort(servePort);
            //发送请求，还是一样，关键信息都在报中,注意这里只有destination,要发出去后才有source的信息
            clientDatagramSocket.send(request);
            //构造收取response
            DatagramPacket response = new DatagramPacket(new byte[1024],1024);
            clientDatagramSocket.receive(response);
            //打印response,这里收到的client的response应该与serve的request相同
            System.out.println(new String(response.getData(),0,response.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
