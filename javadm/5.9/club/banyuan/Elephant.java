package club.banyuan;

import club.banyuan.util.Comparable;
import java.util.Objects;

public class Elephant implements Comparable {

  public int heightInCM;

  public Elephant() {
  }

  public Elephant(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  private static final Elephant[] cache = new Elephant[10];
  private static int cacheSize = 0;

  public static Elephant valueOf(int heightInCM) {
    for (Elephant elephant : cache) {
      if (elephant == null) {
        break;
      }
      if (elephant.heightInCM == heightInCM) {
        return elephant;
      }
    }
    Elephant elephant = new Elephant(heightInCM);
    cache[cacheSize++] = elephant;
    return elephant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {//先直接比较地址，如果地址相同，则肯定相同
      return true;
    }
    //若传入参数为null，因为调用该方法的对象肯定不是null，要不会是空指针异常，此时为false
    //getClass()返回引用运行时的类型
    //若传入参数类型和引用的类型不同，则肯定也是false
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    //走到这一步说明参数不是null，且类型和引用类型一致，此时比较两个引用类型中的内容
    Elephant elephant = (Elephant) o;
    return heightInCM == elephant.heightInCM;
  }

  @Override
  public int hashCode() {
    return Objects.hash(heightInCM);
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    Elephant elephant1 = new Elephant();

    System.out.println(elephant == elephant1);

    Elephant elephant2 = Elephant.valueOf(200);
    Elephant elephant3 = Elephant.valueOf(200);
    System.out.println(elephant2 == elephant3);

  }

  @Override
  public int compareTo(Comparable c) {//此方法只能比较参数类型和引用类型相同时的内容大小
    if (c instanceof Elephant) {
      Elephant elephant = (Elephant) c;
      return Integer.compare(this.heightInCM, elephant.heightInCM);
    } else {
      System.out.println("类型不匹配");
      return 0;
    }
  }

  @Override
  public String toString() {
    return "Elephant{" +
        "heightInCM=" + heightInCM +
        '}';
  }
}