package club.banyuan;

public class Pair<T> {

    private T first;
    private T second;

    public Pair(T firstElement, T secondElement) {
        first = (T) firstElement;
        second = (T) secondElement;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void swap() {
        System.out.println(first);
        System.out.println(second);
        T third = first;
        first = second;
        second = third;
        System.out.println(first);
        System.out.println(second);
    }

}
 class PairUtil  {
//    public static <T extends Pair> T swap(T Pair){
//        T a,b,c;
//        a= (T) Pair.getFirst();
//        b=(T)Pair.getSecond();
//        c=a;
//        a=b;
//        b=c
//        return Pair;
//    }

}
