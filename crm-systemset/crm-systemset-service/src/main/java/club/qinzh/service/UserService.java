package club.qinzh.service;


import club.qinzh.bean.User;
import club.qinzh.bean.extend.UserExtend;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-27
 * @Time: 9:27
 * @Description:
 */
public interface UserService {

    User findByNameAndPassword(String username,String password);

    User findById(Long id);

    List<User> findAllUser();
    List<UserExtend> findAllUserwithRole();
    void saveOrUpadte(User user);

    void deleteById(Long id);
}
