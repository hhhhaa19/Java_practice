package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-07
 * Time: 12:35
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        //创建服务器端口
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            //先与client服务器建立联系
            Socket clientsocket = serverSocket.accept();
            System.out.printf("客户端[%s:%d]上线\n",clientsocket.getInetAddress(),clientsocket.getPort());
            //长连接
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientsocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    private void processConnection(Socket clientsocket) throws IOException {
        //在这个任务中处理链接
        try (InputStream inputStream = clientsocket.getInputStream();
             OutputStream outputStream = clientsocket.getOutputStream()) {
            //利用Scanner来处理输入流
            Scanner scanner = new Scanner(inputStream);
            //构造输出,利用PrintWriter(处理字符流)来转化字节流,Scanner与PrintWriter则可以进一步封装，直接产生字符串
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                if (!scanner.hasNext()) {
                    break;
                }
                //读取输入
                String request = scanner.next();
                String response = process(request);
                //此处outputStream为输出对象
                //向输出流输出内容
                printWriter.println(response);
                printWriter.flush();
                //打印日志
                System.out.printf("[%s:%d] request:%s response:%s\n",clientsocket.getInetAddress(),clientsocket.getPort(),request,response);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            //在当前链接结束时，关闭
            clientsocket.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
