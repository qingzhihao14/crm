package club.qinzh.mapper.extend;

import club.qinzh.bean.User;
import club.qinzh.bean.extend.UserExtend;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-13-13-35
 * @Time: 13:35
 * @Description:
 */
public interface UserExtendMapper {
    List<UserExtend> selectAllWithOther();
}
