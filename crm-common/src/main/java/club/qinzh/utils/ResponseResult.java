package club.qinzh.utils;

import club.qinzh.enums.ExceptionEnums;
import lombok.Data;

import java.util.Date;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-18-18
 * @Time: 18:18
 * @Description:
 */
@Data
public class ResponseResult {
    private int code;
    private String msg;
    private Long time;

    public ResponseResult(ExceptionEnums exceptionEnums){
        this.code = exceptionEnums.getCode();
        this.msg = exceptionEnums.getMsg();
        this.time = new Date().getTime();
    }
}
