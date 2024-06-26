package cn.lulucar.element.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author wenxiaolan
 * @ClassName TimeUtils
 * @date 2024/6/22 10:54
 * @description
 */
@Slf4j
public class TimeUtils {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    public static LocalDateTime stringToLocalDateTime(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            // handle exception
            log.error("时间格式转换失败：{}", e.getMessage());
            return null;
        }
    }

    public static LocalDateTime stringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            // handle exception
            log.error("时间格式转换失败：{}", e.getMessage());
            return null;
        }
    }
}
