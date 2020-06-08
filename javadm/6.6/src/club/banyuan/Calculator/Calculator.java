import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  public static void main(String[] args) {
    while (true){
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入：");
      String s = sc.nextLine();

      if("quit".equals(s)){
        System.exit(0);
      }

      String[] calculatorElements = s.split("\\s+");

      if(calculatorElements.length != 3){
        System.out.println("非法输入，请重新输入");
        continue;
      }

      BigDecimal bigDecimal1 = new BigDecimal(calculatorElements[0]);
      BigDecimal bigDecimal2 = new BigDecimal(calculatorElements[2]);

      Pattern pattern1 = Pattern.compile("\\+");
      Matcher matcher1 = pattern1.matcher(s);
      if(matcher1.find()){
        System.out.println(bigDecimal1.add(bigDecimal2));
      }

      Pattern pattern2 = Pattern.compile("-");
      Matcher matcher2 = pattern2.matcher(s);
      if(matcher2.find()){
        System.out.println(bigDecimal1.subtract(bigDecimal2));
      }

      Pattern pattern3 = Pattern.compile("\\*");
      Matcher matcher3 = pattern3.matcher(s);
      if(matcher3.find()){
        System.out.println(bigDecimal1.multiply(bigDecimal2));
      }

      Pattern pattern4 = Pattern.compile("/");
      Matcher matcher4 = pattern4.matcher(s);
      if(matcher4.find()){
        System.out.println(bigDecimal1.divide(bigDecimal2,3, RoundingMode.HALF_UP));
      }

      Pattern pattern5 = Pattern.compile("%");
      Matcher matcher5 = pattern5.matcher(s);
      if(matcher5.find()){
        BigDecimal[] bigDecimals = bigDecimal1.divideAndRemainder(bigDecimal2);
        System.out.println(bigDecimals[1]);
      }
    }


  }

}

