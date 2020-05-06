package club.banyuan;

public class Main {

    public static void main(String[] args) {
        Cake a1 = new Cake();
        a1.setPrice(100);
        Cake a2 = new Cake();
        a2.setPrice(100);
        Cake a3 = new Cake();
        a3.setPrice(100);
        Cake a4 = new Cake();
        a4.setPrice(100);
        Cake a5 = new Cake();
        a5.setPrice(100);
        Cake a6 = new Cake();
        a6.setPrice(100);
        Cake a7 = new Cake();
        a7.setPrice(100);
        Cake a8 = new Cake();
        a8.setPrice(100);
        Cake a9 = new Cake();
        a9.setPrice(100);
        Cake a10 = new Cake();
        a10.setPrice(100);

        Cake[] cake = new Cake[]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10};

        double sum=0;
        for (int i = 0 ;i<10;i++){
        sum += cake[i].price;
        }
        System.out.println(sum);
    }
}
