package org.example.booksmanagementsystem.cofig;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-23
 * Time: 19:59
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ResponseAdvice implements ResponseBodyAdvice {


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ReturnType) {
            return body;
        }
        if (body instanceof String) {
            return objectMapper.writeValueAsString(ReturnType.success(body));
        }
        return ReturnType.success(body);
    }
}
