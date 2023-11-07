/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-05
 * Time: 20:17
 */
import java.util.Stack;

public class transform {
    public static void main(String[] args) {
        Stack<String> stack_value = new Stack<>();
        Stack<String> stack_symbol = new Stack<>();
        String expression = "( 3 + 4 ) * 5 - 8 / 2";
        String [] str = expression.split(" ");
        for (String s:str
        ) {
            if (isValue(s)) {
                stack_value.push(s);
            } else {
                if (s.equals(")")) {
                    Intermediate_results(stack_value, stack_symbol);
                    stack_symbol.pop();
                } else if (s.equals("(")) {
                    stack_symbol.push(s);
                } else {
                    if (!stack_symbol.isEmpty()) {
                        if (priority(s) <= priority(stack_symbol.peek())) {
                            Intermediate_results(stack_value, stack_symbol);
                        }
                    }
                    stack_symbol.push(s);
                }
            }
        }
        while (!stack_symbol.isEmpty()) {
            Intermediate_results(stack_value, stack_symbol);
        }
        System.out.println(stack_value.peek());
    }

    // 判断是否为数值，返回true为数值
    public static Boolean isValue (String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("(") && !s.equals(")");
    }

    // 计算各运算符的优先级
    public static int priority(String s) {
        int p = 0;
        switch (s) {
            case "+":
            case "-": {
                p = 1;
                break;
            }

            case "*":
            case "/": {
                p = 2;
                break;
            }
            case "(": {
                p = -1;
                break;
            }
        }
        return p;
    }

    // 对中间结果进行拼接、入栈等操作
    public static void Intermediate_results(Stack<String> stack_value, Stack<String> stack_symbol) {
        String res = "";
        String s2 = stack_value.pop();
        String s1 = stack_value.pop();
        res += s1 + " " + s2;
        res += " " + stack_symbol.pop();
        stack_value.push(res);
    }
}
