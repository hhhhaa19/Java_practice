package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-07
 * Time: 13:03
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serveIp, int Port) throws IOException {
        socket = new Socket(serveIp, Port);//与服务器建立链接
    }

    public void start() {
        System.out.println("客户端启动！");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(System.in);
            Scanner inputScanner = new Scanner(inputStream);
            PrintWriter outputWriter = new PrintWriter(outputStream);
            while (true) {
                //构造request
                System.out.print("请输入请求->");
                if (!scanner.hasNext()) {
                    break;
                }
                String request = scanner.next();
                //发送request
                outputWriter.println(request);
                //要刷新缓存
                outputWriter.flush();
                //接受response
                String response = inputScanner.next();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
