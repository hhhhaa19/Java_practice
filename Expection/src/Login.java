/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-10
 * Time: 20:13
 */
public class Login {
    private String name ="admin";
    private String password="123456";
    public static void login (String name,String password) throws MyException{
        if(!name.equals(name)||!password.equals(password)){
            throw new MyException("错误");
        }
    }
}
