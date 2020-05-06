package club.banyuan;

public class ReadyMadeCake extends Cake {
    private int quantity;

    public ReadyMadeCake(int quantity) {
        this.quantity = quantity;
    }

    public double rPrice(double price) {
        return price * quantity;
    }
}
