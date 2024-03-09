package UDP;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-07
 * Time: 13:49
 */
public class UdpDictionaryServer extends UdpEchoServer {
    public UdpDictionaryServer(int port) throws SocketException {
        super(port);
    }

    @Override
    //private修饰的方法不能被重写
    public String process(String request) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("小猫", "cat");
        dictionary.put("小狗", "dag");
        dictionary.put("小猪", "pig");
        if (dictionary.containsKey(request)) {
            return dictionary.get(request);
        } else {
            return new String("No such word in dictionary");
        }
    }

    //这里还是要有main方法，不然就不会有dict对象
    public static void main(String[] args) throws IOException {
    UdpEchoServer server = new UdpDictionaryServer(9090);
    server.start();
    }
}
