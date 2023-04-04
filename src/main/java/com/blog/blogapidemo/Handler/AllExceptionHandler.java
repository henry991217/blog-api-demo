package com.blog.blogapidemo.Handler;

import com.blog.blogapidemo.Vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//AOP实现
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception exception)
    {
        exception.printStackTrace();
        return  Result.fail(-999,"系统异常");
    }
}
