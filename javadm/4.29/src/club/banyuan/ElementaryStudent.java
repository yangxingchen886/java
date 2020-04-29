package club.banyuan;

public class ElementaryStudent extends student{

    public void EleStuName(String name){
        super.setStudentName(name);
        System.out.println("小学生："+getStudentName());
    }

    String studymethod = "看书";

//    public void EleStuStudy(String stuMethod){
//        super.setStudymethod(stuMethod);
//        System.out.println("小学生学习方法："+getStudymethod());
//    }


}
