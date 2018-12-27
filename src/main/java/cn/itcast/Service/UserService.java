package cn.itcast.Service;

import cn.itcast.Mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by netman on 2018/12/27.
 */

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(long id)
    {
        //return null;
    return userMapper.selectByPrimaryKey(id);
    }
    public void deleteById( long id)
    {
      //  userMapper.deleteByPrimaryKey(id);
    }

}
