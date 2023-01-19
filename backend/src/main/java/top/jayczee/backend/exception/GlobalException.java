package top.jayczee.backend.exception;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.jayczee.backend.pojo.R;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 全局异常统一处理类 通过AOP捕捉各种异常，然后向前端返回信息
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    /**
     * 最大异常Exception，除了下面特别处理的异常，其他异常都通过这个方法向前端返回信息
     *
     * @param e
     * @return 全局异常统一信息
     */
    @ExceptionHandler(Exception.class)
    public R<?> exceptionHandler(Exception e) {
        //500代表服务器内部代码错误
        log.info(e.getMessage());
        e.printStackTrace();
        return R.ng("系统出错,请联系管理员！", 500);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return R.ng(message, 500);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public R<?> BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return R.ng(message, 500);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R<?> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return R.ng(message, 500);
    }

    /**
     * 参数格式异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<?> HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.info("HTTP请求参数转换异常:" + e.getMessage());
        return R.ng("参数格式异常", 500);
    }

    /**
     * 未登录异常处理
     *
     * @param e
     * @return 401错误
     */
    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<?> loginExceptionHandler(NotLoginException e) {
        //401代表未认证错误
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(R.ng("需要登录"));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public R<?> illegalException(IllegalArgumentException e){
        String message= e.getMessage();
        return R.ng(message);
    }
}
