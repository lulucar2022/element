package cn.lulucar.element.model.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wenxiaolan
 * @ClassName Result
 * @date 2024/6/20 9:07
 * @description
 */
@Getter
@Setter
public class Result<T> {
    private static final Integer DEFAULT_CODE = 200;
    private static final String DEFAULT_MESSAGE = "success";
    
    private Integer code; // 响应码  
    private String message; // 响应信息  
    private T data; // 响应数据  
    
    // 构造函数
    public Result(Builder<T> builder) {
        this.code = builder.code != -1 ? builder.code : DEFAULT_CODE;
        this.message = builder.message != null? builder.message : DEFAULT_MESSAGE;
        this.data = builder.data;   
    }
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
    public static final class Builder<T> {
        private Integer code; // 响应码  
        private String message; // 响应信息  
        private T data; // 响应数据      
        
        private Builder() {
        }
        public Builder<T> code(int code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Result<T> build() {
            return new Result<>(this);
        }

        // 失败情况的默认方法
        public Builder<T> failure(int errorCode, String errorMessage) {
            this.code(errorCode); // 调用已存在的code()方法
            this.message(errorMessage); // 调用已存在的message()方法
            this.data(null); // 假设失败时没有数据
            return this;
        }
    }
}
