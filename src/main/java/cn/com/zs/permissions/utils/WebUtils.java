package cn.com.zs.permissions.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 标题: web工具类
 * <p>
 * 描述: web工具类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/12-13:02
 */
public class WebUtils {

    public static void writeJson(HttpServletResponse response,byte[] byteArray) throws IOException {
        response.setHeader("Content-Type","tegxt/html;charset=utf-8");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(byteArray,0,byteArray.length);
        outputStream.flush();
        outputStream.close();
    }
}
