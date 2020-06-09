package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket();
    Scanner s = new Scanner(System.in);
    while (true) {
      System.out.println("请输入字符串");
      String word = s.nextLine();
      byte[] bytes = word.getBytes();
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
          InetAddress.getByName("127.0.0.1"),
          10086);
      ds.send(dp);
      ds.close();
    }
  }
}
