package org.example.booksmanagementsystem.cofig;

import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.ReturnType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-23
 * Time: 21:57
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler
    public ReturnType handleException(Exception e) {
        log.error(e.getMessage());
        return ReturnType.error("内部错误，请联系管理员");
    }

}
