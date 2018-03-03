package cn.com.zs.permissions.code.exception;

import cn.com.zs.permissions.exception.ApiException;
import cn.com.zs.permissions.exception.GenericBusinessException;
import cn.com.zs.permissions.exception.SqlException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 标题: 全局异常处理器
 * <p>
 * 描述: 全局异常处理器
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/3-22:52
 */
@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerResolver {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity handlerApiException(ApiException e){
        logError("apiException",e.getMessage(),e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GenericBusinessException.class)
    public ResponseEntity handlerGenericBussionssException(GenericBusinessException e){
        logError("genericBusinessException",e.getMessage(),e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SqlException.class)
    public ResponseEntity handlerSqlException(SqlException e){
        logError("sqlException",e.getMessage(),e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handlerRunTimeException(RuntimeException e){
        logError("runtimeException",e.getMessage(),e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handlerThrowable(Throwable e){
        logError("throwable",e.getMessage(),e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static void logError(String name,String msg,Throwable t){
        log.error("error name is {},msg is {}",name,msg,t);
    }
}
