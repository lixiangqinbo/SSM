import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ssm.dao.RoomMapper;
import org.ssm.dao.StudentMapper;
import org.ssm.dao.UserMapper;
import org.ssm.entity.Room;
import org.ssm.entity.Student;
import org.ssm.entity.User;
import org.ssm.util.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void  testSaveUser() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("ibatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(inputStream);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession session = sessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.saveUser();
        //session.commit();
        session.close();
        System.out.println("受影响行数："+result);

    }

    @org.junit.Test
    public void updateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.updateUser();
        sqlSession.close();
        System.out.println("受影响行数："+result);
    }
    @org.junit.Test
    public void deleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.deleteUser();
        sqlSession.close();
        System.out.println("受影响行数："+result);
    }
    @org.junit.Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById();
        sqlSession.close();
        System.out.println("受影响行数："+user.toString());
    }
    @org.junit.Test
    public void getAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getAllUser();
        sqlSession.close();
        list.forEach(System.out::println);
    }

    /**
     * mybatis获取参数的方式一：当mapper接口参数为单个时，则直接 #{*} 或者 '${*}'
     */
    @org.junit.Test
    public void checkLogin1(){
        String userName = "admin1";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin1(userName);
        sqlSession.close();
        System.out.println("受影响行数："+user.toString());

    }
    /**
     * mybatis获取参数的方式二：当mapper接口参数为多个时 mybatis会把参数放在map集合中 -->#{arg0} 或者 '${arg0}'
     */
    @org.junit.Test
    public void checkLogin2(){
        String userName = "admin1";
        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin2(userName,password);
        sqlSession.close();
        System.out.println("受影响行数："+user.toString());
    }
    /**
     * mybatis获取参数的方式三：当mapper接口参数为map集合参数，则直接#{键}或者 '${键}'
     */
    @org.junit.Test
    public void checkLogin3(){
        Map<String,Object> map = new HashMap<>();
        map.put("userName","admin1");
        map.put("password","123456");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin3(map);
        sqlSession.close();
        System.out.println("受影响行数："+user.toString());
    }
    /**
     * mybatis获取参数的方式四：当mapper接口中参数是实体类型，则直接#{属性名} 或者 '${属性名}'
     */
    @org.junit.Test
    public void checkLogin4(){
        User user = new User();
        user.setUserName("admin1");
        user.setPassword("123456");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.checkLogin4(user);
        sqlSession.close();
        System.out.println("受影响行数："+user1.toString());
    }
    /**
     * mybatis获取参数的方式五：当mapper接口中形参加了@Param("XX")注解，则直接 #{XX} 或者 '${XX}'
     */
    @org.junit.Test
    public void checkLogin5(){
        String userName = "admin1";
        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin5(userName,password);
        sqlSession.close();
        System.out.println("受影响行数："+user.toString());
    }

    /**
     * 查找指定用户 并返回以Map形式返回
     */
    @org.junit.Test
    public void getUserMap(){
        String userName = "admin1";
        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map map = userMapper.getUserMap(userName,password);
        sqlSession.close();
        System.out.println("受影响行数："+map.toString());
        //{password=123456, gender=男, id=2, userName=admin1, email=12345@qq.com}

    }

    /**
     * 返回全部记录 并且以Map形式
     */
    @org.junit.Test
    public void getAllUserListMap(){
        String userName = "admin1";
        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List list = userMapper.getAllUserListMap();
        sqlSession.close();
        list.forEach(System.out::println);
        /*{password=123456, gender=男, id=2, userName=admin1, email=12345@qq.com}
        {password=123456, gender=男, id=3, userName=admin, email=12345@qq.com}
        {password=123456, gender=男, id=4, userName=admin, email=12345@qq.com}
        {password=123456, gender=男, id=5, userName=admin, email=12345@qq.com}
        {password=123456, gender=男, id=6, userName=admin, email=12345@qq.com}
*/
    }

    /**
     * 返回全部记录 并且以Map形式
     */
    @org.junit.Test
    public void getAllUserMap(){
        String userName = "admin1";
        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map map = userMapper.getAllUserMap();
        sqlSession.close();
        System.out.println("受影响行数："+map.toString());
    //受影响行数：{2={password=123456, gender=男, id=2, userName=admin1, email=12345@qq.com}, 3={password=123456, gender=男, id=3, userName=admin, email=12345@qq.com}, 4={password=123456, gender=男, id=4, userName=admin, email=12345@qq.com}, 5={password=123456, gender=男, id=5, userName=admin, email=12345@qq.com}, 6={password=123456, gender=男, id=6, userName=admin, email=12345@qq.com}}
    }

    /**
     * 根据名字模糊查询
     */
    @org.junit.Test
    public void getUserByLike(){
        String userName = "admin1";
//        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map map = userMapper.getUserByLike(userName);
        sqlSession.close();
        System.out.println("受影响行数："+map.toString());
    }

    /**
     * 批量删除
     */
    @org.junit.Test
    public void pachDeleteUser(){
        String ids = "2,3";
//        String password = "123456";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.pachDeleteUser(ids);
        sqlSession.close();
        System.out.println("受影响行数："+result);
    }

    /**
     * 添加记录并返回主键值
     * useGeneratedKey = "true" ：表示当前添加功能使用自增主键
     * KeyProperty = "id"  ：将返回的自增主键值放进形参的id属性
     */
    @org.junit.Test
    public void saveUserReturnKey(){
        User user  = new User();
        user.setUserName("migration");
        user.setPassword("1234567");
        user.setEmail("migration@qq.com");
        user.setGender("女");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.saveUserReturnKey(user);
        sqlSession.close();
        System.out.println("受影响行数："+user.getId());
    }

    /**
     * 自定义映射测试
     */
    @org.junit.Test
    public  void getAllStudents(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map result = studentMapper.getAllStudents();
        sqlSession.close();
        System.out.println("受影响行数："+result.toString());
    }

    @org.junit.Test
    public void getStuAndClassById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.getStuAndClassById(1);
        sqlSession.close();
        System.out.println("受影响行数："+student.toString());
    }

    @org.junit.Test
    public void getStuAndRoomByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student =  studentMapper.getStuAndRoomByStepOne(2);
        System.out.println(student.getStuName());
//        System.out.println(student.getClassId());
//        System.out.println(student.toString());
    }

    @org.junit.Test
    public void getRoomAndStuByCollection(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        Room room = mapper.getRoomAndStuByCollection(2);
        System.out.println(room.toString());
    }

    @org.junit.Test
    public void getRoomAndStuByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        Room room = mapper.getRoomAndStuByStepOne(1);
        System.out.println(room.toString());
    }
    @org.junit.Test
    public void getStudenBySQL(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuGender("");
        student.setStuName("");
        List<Student> list = studentMapper.getStudenBySQL(student);
        list.forEach(System.out::println);
    }
    @org.junit.Test
    public void saveStudents(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student("张三1", "男", 0, 1, null);
        Student student1 = new Student("张三2", "男", 0, 1, null);
        Student student2 = new Student("张三3", "男", 0, 1, null);
        List<Student> students = Arrays.asList(student, student1, student2);
        studentMapper.saveStudents(students);
    }

    @org.junit.Test
    public void deleteStudents(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int[] ids ={6,7,8};
        studentMapper.deleteStudents(ids);
    }
}
