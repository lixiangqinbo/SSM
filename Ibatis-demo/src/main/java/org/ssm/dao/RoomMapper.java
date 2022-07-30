package org.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.ssm.entity.Room;

public interface RoomMapper {
    /**
     * association 映射多对一
     ** 第一步 先查询出学生的教室号
     * @param classId
     * @return
     */
    public Room getStuAndRoomByStepTwo(@Param("classId") int classId);

    /**
     * collecyion 一对多，一个班级对应多个学生
     * 查询指定班级号的学生信息
     * @param classId
     * @return
     */
    public Room getRoomAndStuByCollection(@Param("classId") int classId);

    /**
     * collecyion 一对多，一个班级对应多个学生
     * 查询指定班级号的学生信息;分步查询 步骤一
     * @param classId
     * @return
     */
    public Room getRoomAndStuByStepOne(@Param("classId") int classId);
}
