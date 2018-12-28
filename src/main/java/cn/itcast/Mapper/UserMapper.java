package cn.itcast.Mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by netman on 2018/12/27.
 */

public interface UserMapper extends Mapper<User> {

    @Select("select * from tb_user where id = #{id}")
    public User getUserByID(long id);


    public User queryUserByXMlId(int id);

}
