package org.mybatis.pojo;

public class Room {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    private Integer classId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.class_name
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    private String className;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.class_id
     *
     * @return the value of room.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.class_id
     *
     * @param classId the value for room.class_id
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.class_name
     *
     * @return the value of room.class_name
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.class_name
     *
     * @param className the value for room.class_name
     *
     * @mbggenerated Wed Jul 27 22:36:52 CST 2022
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}