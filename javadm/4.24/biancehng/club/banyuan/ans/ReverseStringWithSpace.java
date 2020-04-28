  package club.banyuan.ans;

public class ReverseStringWithSpace {

  public static int randomInt(int from, int to) {
    return (int) (Math.random() * (to + 1 - from) + from);

  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println(randomInt(-3, 6));
    }
  }
}