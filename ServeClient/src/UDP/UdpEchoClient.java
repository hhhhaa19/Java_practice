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
    DatagramSocket socketClient = null;
    private String requestIP = null;
    private int requestPort;

    public UdpEchoClient(String requestIP,int requestPort) throws SocketException {
        //这里要传入目标服务器，暂存，后续使用
        socketClient = new DatagramSocket();
        this.requestIP = requestIP;
        this.requestPort = requestPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动！");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("请输入内容->");
            if(!scanner.hasNext()){
                break;
            }
            //从客户端终端得到命令
            String str = scanner.next();
            //构造request
            DatagramPacket request = new DatagramPacket(str.getBytes(),0,str.getBytes().length);
            request.setAddress(InetAddress.getByName(requestIP));
            request.setPort(requestPort);
            //发送
            socketClient.send(request);
            //接受
            DatagramPacket response = new DatagramPacket(new byte[4096],4096);
            socketClient.receive(response);
            System.out.println(new String(response.getData(),0,response.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }

}
