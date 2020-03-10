package club.qinzh.handler;

import club.qinzh.exception.CrmException;
import club.qinzh.utils.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-17-48
 * @Time: 17:48
 * @Description:
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(CrmException.class)
    public ResponseEntity handler(CrmException e){
       /* return ResponseEntity.status(e.getExceptionEnums().getCode())
                                .body(e.getExceptionEnums().getMsg());*/
        return ResponseEntity.status(e.getExceptionEnums().getCode())
                .body(new ResponseResult(e.getExceptionEnums()));
    }
}
