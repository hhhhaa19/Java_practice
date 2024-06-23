package org.example.booksmanagementsystem.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.booksmanagementsystem.Enum.LoginStatus;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 13:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnType<T, V> {
    private T value;//实际返回
    private V parameter;//附加参数


    public ReturnType(T value, V parameter) {
        this.value = value;
        this.parameter = parameter;
    }

    public ReturnType(T value) {
        this.value = value;
    }

    public static <T> ReturnType success(T value) {
        ReturnType returnType = new ReturnType(value);
        returnType.setLoginStatus(LoginStatus.SUCCESS);
        return returnType;
    }

    public static <T> ReturnType error(T value) {
        ReturnType returnType = new ReturnType(value);
        returnType.setLoginStatus(LoginStatus.ERROR);
        return returnType;
    }

    public static <T> ReturnType notLog(T value) {
        ReturnType returnType = new ReturnType(value);
        returnType.setLoginStatus(LoginStatus.NOT_LOG);
        return returnType;
    }

    private LoginStatus loginStatus;//状态码
}
