package org.ssm.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.ssm.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 保存
     * @return
     */
    public int saveUser();
    /**
     * 更新
     * @return
     */
    public int updateUser();
    /**
     * 删除
     * @return
     */
    public int deleteUser();
    /**
     * 更具id查询
     * @return
     */
    public User getUserById();
    /**
     * 查询所有
     * @return
     */
    public List<User> getAllUser();

    /**
     * mybatis获取参数的方式一：当mapper接口参数为单个时，则直接 #{*} 或者 '${*}'
     */
    public User checkLogin1(String userNam);
    /**
     * mybatis获取参数的方式二：当mapper接口参数为多个时 mybatis会把参数放在map集合中 -->#{arg0} 或者 '${arg0}'
     */
    public User checkLogin2(String userName,String password);
    /**
     * mybatis获取参数的方式三：当mapper接口参数为map集合参数，则直接#{键}或者 '${键}'
     */
    public User checkLogin3(Map<String,Object> map);
    /**
     * mybatis获取参数的方式四：当mapper接口中参数是实体类型，则直接#{属性名} 或者 '${属性名}'
     */
    public User checkLogin4(User user);
    /**
     * mybatis获取参数的方式五：当mapper接口中形参加了@Param("XX")注解，则直接 #{XX} 或者 '${XX}'
     */
    public User checkLogin5(@Param("userName") String userName, @Param("password")String password);

    /**
     * 查找指定用户 并返回以Map形式返回
     * @param userName
     * @param password
     * @return
     */
  public Map<String,Object> getUserMap(@Param("userName") String userName, @Param("password")String password);

    /**
     * 返回全部记录 并且以Map形式
     * @return
     */
    public List<Map<String,Object>> getAllUserListMap();

    /**
     * 返回全部记录 并且以Map形式
     * @return
     */
    @MapKey("id")
    public Map<String,Object> getAllUserMap();

    /**
     * 通过输入字符串模糊查询
     * @return
     */
    @MapKey("id")
    public Map getUserByLike(@Param("portionStr") String portionStr);

    /**
     * 批量处理
     * @param ids
     * @return
     */
    public int pachDeleteUser(@Param("ids") String ids);
    /**
     * 保存并返回主键
     * @return
     */
    public int saveUserReturnKey(User user);
}
