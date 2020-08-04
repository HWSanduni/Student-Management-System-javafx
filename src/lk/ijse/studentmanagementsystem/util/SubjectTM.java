package lk.ijse.studentmanagementsystem.util;

public class SubjectTM {

    private String subId;
    private String courseId;
    private String name;
    private String type;


    public SubjectTM() {
    }

    public SubjectTM(String subId, String courseId, String name, String type) {
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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
        return "SubjectTM{" +
                "subId='" + subId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
