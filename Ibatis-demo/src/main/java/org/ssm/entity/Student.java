package org.ssm.entity;

public class Student {
    private String stuName;
    private String stuGender;
    private  int stuId;
    private int classId;
    private Room room;

    public Student(String stuName, String stuGender, int stuId, int classId, Room room) {
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuId = stuId;
        this.classId = classId;
        this.room = room;
    }

    public Student() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuId=" + stuId +
                ", classId=" + classId +
                ", room=" + room +
                '}';
    }
}
