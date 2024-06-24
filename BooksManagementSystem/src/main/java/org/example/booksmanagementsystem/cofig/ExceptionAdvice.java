package org.example.booksmanagementsystem.cofig;

import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.ReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

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
        log.error("发生异常", e);
        return ReturnType.error("内部错误，请联系管理员");
    }
}
