package club.qinzh.service;

import club.qinzh.bean.User;
import club.qinzh.bean.UserExample;
import club.qinzh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2020-03-12-09-27
 * @Time: 9:27
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByNameAndPassword(String username,String password){
        UserExample example = new UserExample();
        example.createCriteria().andUsrNameEqualTo(username)
                                .andUsrPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users != null && users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
