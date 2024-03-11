package TCP;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-09
 * Time: 16:14
 */
public class TcpDictionaryServer extends TcpEchoServer{
    public TcpDictionaryServer(int port) throws IOException {
        super(port);
    }

    @Override
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

    public static void main(String[] args) throws IOException {
        TcpDictionaryServer server = new TcpDictionaryServer(9090);
        server.start();
    }
}
