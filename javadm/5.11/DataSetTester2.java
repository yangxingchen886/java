package club.banyuan;

public class DataSetTester2 {

  public static void main(String[] args) {
    Measurer m = new RectangleMeasurer();//m是新的RectangleMeasurer类的对象
    DataSet data = new DataSet(m);//data中的measurer初始化为m
    data.add(new Rectangle(15, 10));
    data.add(new Rectangle(40, 20));
    data.add(new Rectangle(20, 10));
    System.out.println("平均面积: " + data.getAverage());
    System.out.println("输出值: 410.0");
    Rectangle max = (Rectangle) data.getMaximum();  // data.getMaximum()返回的是最大面积的长方形
    System.out.println("最大面积矩形: " + max);
    System.out.println("期待输出值: Rectangle{width=40,height=20}");
  }
}
