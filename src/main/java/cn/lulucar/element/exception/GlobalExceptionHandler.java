package cn.lulucar.element.exception;

import cn.lulucar.element.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wenxiaolan
 * @ClassName GlobalException
 * @date 2024/6/19 10:30
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{
    
}
