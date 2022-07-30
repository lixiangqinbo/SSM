package org.ssm.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.ssm.entity.Room;
import org.ssm.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    @MapKey("stuId")
    public Map getAllStudents();

    /**
     * 采用resultMap级联的方式 映射多对一
     * 查询指定学生以及学生所在的班级信息
     * @param stuId
     * @return
     */
    public Student getStuAndClassById(@Param("stuId")int stuId);

    /**
     * association 映射多对一
     ** 第一步 先查询出学生的教室号
     * @param stuId
     * @return
     */
    public Student getStuAndRoomByStepOne(@Param("stuId") int stuId);

    /**
     * collecyion 一对多，一个班级对应多个学生
     * 查询指定班级号的学生信息;分步查询 步骤一
     * @param classId
     * @return
     */
    public Student getRoomAndStuByStepTwo(@Param("classId") int classId);

    /**
     * 多条件查询学生信息
     * @param student
     * @return
     */
    public List<Student> getStudenBySQL(@Param("student")Student student);

    /**
     * 批量保存
     * @param stus
     */
    public void saveStudents(@Param("stus")List<Student> stus);
    /**
     * 批量删除
     * @param ids
     */
    public void deleteStudents(@Param("ids")int[] ids);
}
