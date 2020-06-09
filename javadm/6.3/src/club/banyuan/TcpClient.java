package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class TcpClient {

  public static void main(String[] args) {
    try (Socket socket = new Socket("127.0.0.1", 10000)) {
      System.out.println("客户端启动");
      BufferedReader bufferedReader = new BufferedReader(
          new FileReader("src/club/banyuan/alice.code"));
      OutputStream outputStream = socket.getOutputStream();
      PrintWriter pw = new PrintWriter(outputStream, true);
      String str = null;
      while ((str = bufferedReader.readLine()) != null) {
        pw.println(str);
      }
//      socket.shutdownOutput();
      bufferedReader.close();
//      Scanner scanner = new Scanner(System.in);
//      System.out.println("请输入要加密的字符：");
//      String s = scanner.nextLine();
//      outputStream.write(s.getBytes());
      System.out.println("发送成功");

      InputStream inputStream = socket.getInputStream();
      byte[] bytes = inputStream.readAllBytes();
      System.out.println("来自服务器的消息:" + new String(bytes));
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("客户端退出");
  }
}
