package club.banyuan;

public class Main {

    public static void printBehavior(Weekday weekday){
        if(weekday.isWeekDay()){
            System.out.println(weekday);//打印枚举类对象时会自动加载枚举类对象的toString()方法，可以不加toString()
        }else{
            System.out.println(weekday);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[10];
        for (Weekday one : Weekday.values()) {
            printBehavior(one);
        }

        Weekday sat = Weekday.SATURDAY;
        for (Weekday day : Weekday.values()) {
            System.out.println(day.compareTo(sat));
        }
    }
}