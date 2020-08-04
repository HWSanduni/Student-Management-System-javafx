package lk.ijse.studentmanagementsystem.entity;

public class Subject {

    private String subId;
    private Course courseId;
    private String name;
    private String type;

    public Subject() {
    }

    public Subject(String subId, Course courseId, String name, String type) {
        this.subId = subId;
        this.courseId = courseId;
        this.name = name;
        this.type = type;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId='" + subId + '\'' +
                ", courseId=" + courseId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
