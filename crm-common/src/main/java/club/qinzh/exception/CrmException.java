package club.qinzh.exception;

import club.qinzh.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-17-11
 * @Time: 17:11
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmException extends RuntimeException {
    /*
    * 发生异常状态码
    * */
    //private int code;

    /*
    * 异常信息
    * */
    //private String msg;
    //为了方便，变成枚举
    private ExceptionEnums exceptionEnums;



}
