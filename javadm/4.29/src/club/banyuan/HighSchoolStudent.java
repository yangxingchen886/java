package club.banyuan;

public class HighSchoolStudent extends student {
    public void highStuName(String name) {
        super.setStudentName(name);
        System.out.println("大学生：" + getStudentName());
    }

    String studymethod = "自学";

}
