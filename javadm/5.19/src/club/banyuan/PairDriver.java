package club.banyuan;

public class PairDriver {

  /**
   * 创建几个体育场对，然后打印容量最大的体育场名称。
   */
  public static void main(String[] args) {

    Pair<String,Integer>[] stadiums = new Pair[3];
    stadiums[0] = new Pair<String,Integer>("五棵松", 25000);
    stadiums[1] = new Pair<String,Integer>("鸟巢", 109901);
    stadiums[2] = new Pair<String,Integer>("奥体中心", 66233);

    System.out.println(stadiums[0]);
  }

  /**
   * 返回容量最大的体育场的名称。
   *
   * @param stadiums ObjectPairs的数组，其中包含一个体育管名称，还有一个数字作为体育馆容量
   * @return 容量最大的体育馆的名称
   */
  public static String largestStadium(Pair<String,Integer>[] stadiums) {
    Pair<String,Integer> largestStadiumPair = stadiums[0];
    for(Pair<String,Integer> one : stadiums){
      if(one.getSecond().compareTo(largestStadiumPair.getSecond()) > 0)
      {
        largestStadiumPair = one;
      }
    }
    return largestStadiumPair.getFirst();
  }

}