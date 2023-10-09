/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 18:24
 */
public class AddString {
    public String addstring(String s1,String s2){
        StringToInt st =new StringToInt();
        int a =st.StrToInt(s1);
        int b =st.StrToInt(s2);
        int sum =a+b;
        int length = 0;
        int temp =sum;
        StringBuffer sb =new StringBuffer();
        while(sum!=0){
            sb.append(sum%10);
            sum /=10;
        }
        sb.reverse();
        return sb.toString();
    }
}
