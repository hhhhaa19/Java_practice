package org.example.booksmanagementsystem.component;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 13:11
 */
@Data
@AllArgsConstructor
public class ReturnType <T,V>{
    private T value;
    private  V parameter;

}
