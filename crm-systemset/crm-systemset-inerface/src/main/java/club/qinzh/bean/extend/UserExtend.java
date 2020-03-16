package club.qinzh.bean.extend;

import club.qinzh.bean.Role;
import club.qinzh.bean.User;
import lombok.Data;

/**
 * @Atuhor: qin
 * @Create: 2020-03-13-13-33
 * @Time: 13:33
 * @Description:
 */
@Data
public class UserExtend extends User {
    private Role role;
}
