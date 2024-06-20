package cn.lulucar.element.util;

import lombok.Data;

/**
 * @author wenxiaolan
 * @ClassName Result
 * @date 2024/6/20 9:07
 * @description
 */
@Data
public class Result<T> {
    private int code; // 响应码  
    private String message; // 响应信息  
    private T data; // 响应数据  
    
    // 示例：成功响应的静态方法  
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    
    // 示例：失败响应的静态方法（带异常信息）  
    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}
