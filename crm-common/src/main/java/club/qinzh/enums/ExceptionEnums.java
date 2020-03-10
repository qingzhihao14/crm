package club.qinzh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Atuhor: qin
 * @Create: 2020-03-09-17-28
 * @Time: 17:28
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnums {
    SUCCESS(200,"请求成功"),
    PARAM_IS_NULL(400,"参数为空");
    private int code;
    private String msg;
}
