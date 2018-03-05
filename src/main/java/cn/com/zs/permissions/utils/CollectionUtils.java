package cn.com.zs.permissions.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 标题: 集合处理工具类
 * <p>
 * 描述: 集合处理工具类
 * <p>
 * 版权: Copyright (c) 2017
 * <p>
 * 公司: 广州点睿信息科技有限公司
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2017/11/11-1:30
 */
public class CollectionUtils {


    /**
     * 判断集合为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    /**
     * 不为空集合
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    public static <T>List<T> emptyList(){
        return Collections.emptyList();
    }


}
