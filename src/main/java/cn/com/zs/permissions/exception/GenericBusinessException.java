package cn.com.zs.permissions.exception;

/**
 * 标题: 通用业务异常
 * <p>
 * 描述: service层抛此异常
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/3/3-14:38
 */
public class GenericBusinessException extends BaseException{

    public GenericBusinessException() {
        super();
    }

    public GenericBusinessException(String message) {
        super(message);
    }

    public GenericBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericBusinessException(Throwable cause) {
        super(cause);
    }

    public GenericBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
