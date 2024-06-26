package cn.lulucar.element.exception;

import cn.lulucar.element.model.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleException(IllegalArgumentException e){
        Result<String> result = Result.<String>builder()
                .failure(HttpStatus.BAD_REQUEST.value(), "非法参数："+e.getMessage())
                .data(null)
                .build();
        return new  ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
