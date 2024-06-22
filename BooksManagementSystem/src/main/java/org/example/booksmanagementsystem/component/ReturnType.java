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
public class ReturnType <T,V>{
    private T value;
    private  V parameter;

    public ReturnType(T value, V parameter) {
        this.value = value;
        this.parameter = parameter;
    }

    private LoginStatus loginStatus;//状态码
}
