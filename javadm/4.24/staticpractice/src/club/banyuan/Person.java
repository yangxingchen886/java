package club.banyuan;

public class Person {
  private static int count = 0;
  private static int counttwo = 0;
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    count++;
    counttwo++;
  }

  public Person(String name) {
    this.name = name;
    count++;
  }

  public Person() {
    count++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  public static int getcount(){
    return count;
  }
  public static int getcounttwo(){
    return counttwo;
  }
}