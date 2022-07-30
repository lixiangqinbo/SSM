package org.ssm.entity;

import java.util.List;

public class Room {
    private int classId;
    private String className;
    private List<Student> students;

    public Room(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Room() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Room{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", students=" + students +
                '}';
    }
}
