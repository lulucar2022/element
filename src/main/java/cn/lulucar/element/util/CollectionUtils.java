package cn.lulucar.element.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author wenxiaolan
 * @ClassName CollectionUtils
 * @date 2024/6/19 9:51
 * @description
 */
public class CollectionUtils {
    public static final List<Integer> sexList = Arrays.asList(0,1);
    public static boolean isAnyIn(List<Integer> list, int ...values) {
        if (list == null) {
            list = sexList;
        }
        return list.stream()
                .anyMatch(i -> Arrays.stream(values).anyMatch(value -> i == value));
    }
}
