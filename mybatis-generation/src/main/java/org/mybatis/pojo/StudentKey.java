package org.mybatis.pojo;

public class StudentKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    private Integer stuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    private Integer classId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_id
     *
     * @return the value of student.stu_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public Integer getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_id
     *
     * @param stuId the value for student.stu_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.class_id
     *
     * @return the value of student.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.class_id
     *
     * @param classId the value for student.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}