package club.banyuan;

public class Main {

    public static void main(String[] args) {
	ElementaryStudent a1 = new ElementaryStudent();
    a1.EleStuName("张三");
    MiddleStudent a2 = new MiddleStudent();
    a2.middleName("李四");
    HighSchoolStudent a3 = new HighSchoolStudent();
    a3.highStuName("王五");
        System.out.println("小学学习方法："+a1.studymethod);
        System.out.println("小学学习方法："+a2.studymethod);
        System.out.println("小学学习方法："+a3.studymethod);
    }
}
