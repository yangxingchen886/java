package club.banyuan;

public class DataSet {
  // TODO: 定义private 实例变量
  private double sum;
  private int count;
  private Object maximum;
  private Measurer measurer;//RectangleMeasurer,StringMeasurer的接口



  public DataSet(Measurer aMeasurer) {//构造方法
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  public DataSet(){//无参构造方法
    sum = 0;
    count = 0;
    maximum = null;
  };

  // TODO： 重载方法，使得Contry统计 DataSetTester 运行成功

  public void add(Country x){
    sum = sum + x.getMeasure();
    if (count == 0 || ((Country)maximum).getMeasure() < x.getMeasure()) {
      maximum = x;
    }
    count++;
  }

  public void add(Rectangle x) {
    sum = sum + measurer.measure(x);//sum此时为面积和
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;//maximum为最大面积的长方形
    }
    count++;
  }

  public void add(String x) {
    sum = sum + measurer.measure(x);//sum此时为字符串长度和
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;//maximum为最大长度的字符串
    }
    count++;
  }

  public double getAverage() {
    // TODO: Check divide by zero. Compute the average value.
    if(count == 0){
      return 0;
    }
    else {
      return sum / count;
    }
  }

  public Object getMaximum() {
    return maximum;
  }



}