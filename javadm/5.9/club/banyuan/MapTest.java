package club.banyuan;

public class MapTest {

  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("12","b");
    map.put("34","c");
    map.put("56","d");
    map.put("12","e");
    System.out.println(map.size());//3
    System.out.println(map.get("12"));//e
    System.out.println(map.get("34"));//c
    System.out.println(map.containsKey("56"));//true
    System.out.println(map.containsValue("d"));//true
    map.remove("56");
    System.out.println(map.size());//2
    map.remove("34");
    map.remove("12");
    System.out.println(map.size());//0
    System.out.println(map.isEmpty());//true
  }
}
