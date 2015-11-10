package lukesandbox.json;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Lucas on 10/28/2015.
 */
public class CourseBean implements Serializable {
    private String courseName;
    private String teacher;
    private int section;

    public CourseBean(){

    }

    public CourseBean(HashMap courseHashMap) {
        this.courseName = (String) courseHashMap.get("courseName");
        this.teacher = (String) courseHashMap.get("teacher");
        this.section = Integer.parseInt(String.valueOf(courseHashMap.get("section")));
    }

    public CourseBean(String courseName, String teacher, int section){
        this.courseName = courseName;
        this.teacher = teacher;
        this.section = section;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }



}
