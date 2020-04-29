package club.banyuan;

public class MiddleStudent extends student {
    public void middleName(String name){
        super.setStudentName(name);
        System.out.println("中学生："+getStudentName());
    }

    String studymethod = "网课";
//    public void middleStudy(){
//        super.setStudymethod("网课");
//    }
}
