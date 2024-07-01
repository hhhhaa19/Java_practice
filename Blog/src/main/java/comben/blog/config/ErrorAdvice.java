package comben.blog.config;

import comben.blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 23:14
 */
@Slf4j
@RestControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.error("统一异常处理：Exception", e);
        return Result.fail("内部错误，请联系管理员");
    }
}
