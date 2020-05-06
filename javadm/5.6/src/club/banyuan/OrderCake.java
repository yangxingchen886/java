package club.banyuan;

public class OrderCake extends Cake {
    private double weightlnKG;
    public OrderCake(double weightlnKG){
        this.weightlnKG = weightlnKG;
    }
    public double oPrice(double price){
        return price*weightlnKG;
    }

}
