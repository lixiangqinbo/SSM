import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.mapper.StudentMapper;
import org.mybatis.pojo.Student;
import org.mybatis.pojo.StudentExample;
import org.mybatis.pojo.StudentKey;
import org.mybatis.util.SqlSessionUtil;

import java.util.List;

public class Test {

    @org.junit.Test
    public void Generation(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuId(2);
        student.setClassId(2);
        student.setStuGender("GAY");
        student.setStuName("GAI");
//        StudentExample studentExample = new StudentExample();
//        studentExample.createCriteria();
//        List<Student> list = studentMapper.selectByExample(studentExample);
//        list.forEach(System.out::println);
//        studentMapper.insertSelective(student);
//        StudentKey studentKey = new StudentKey();
//        studentKey.setStuId(2);
//        studentMapper.deleteByPrimaryKey(studentKey);
//        studentMapper.updateByPrimaryKeySelective(student);
//        StudentExample studentExample = new StudentExample();
//        studentExample.createCriteria();
        //查询前开启分页拦截器 会自动拦截limit请求
        Page<Object> page = PageHelper.startPage(1, 2);
        List<Student> list = studentMapper.selectByExample(null);
        PageInfo<Student> pageInfo = new PageInfo(list,4);
        list.forEach(System.out::println);
        //System.out.println(page);
        System.out.println(pageInfo);
    }
}
