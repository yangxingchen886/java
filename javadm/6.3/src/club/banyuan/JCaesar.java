package club.banyuan;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 凯撒加密
 *
 * @author jianggujin
 *
 */
public class JCaesar {

  /**
   * 加密
   *
   * @param str
   * @param k
   * @return
   */
  public static String encrypt(String str, int k) {
    StringBuilder result = new StringBuilder();
    for (char c : str.toCharArray()) {
      result.append(encrypt(c, k));
    }
    return result.toString();
  }

  /**
   * 解密
   *
   * @param str
   * @param k
   * @return
   */
  public static String decrypt(String str, int k) {
    // 取相反数
    k = 0 - k;
    return encrypt(str, k);
  }

  /**
   * 包裹输入流，原输入流为加密数据输入流
   *
   * @param in
   * @param k
   * @return
   */
  public static InputStream wrap(InputStream in, int k) {
    return new DecInputStream(in, k);
  }

  /**
   * 包裹输出流，包裹后的输出流为加密输出流
   *
   * @param out
   * @param k
   * @return
   */
  public static OutputStream wrap(OutputStream out, int k) {
    return new EncOutputStream(out, k);
  }

  /**
   * 加密输出流
   *
   * @author jianggujin
   *
   */
  private static class EncOutputStream extends OutputStream {
    private final OutputStream out;
    private final int k;

    EncOutputStream(OutputStream out, int k) {
      this.out = out;
      this.k = k;
    }

    @Override
    public void write(int b) throws IOException {
      out.write(encrypt((char) b, k));
    }
  }

  /**
   * 解密输入流
   *
   * @author jianggujin
   *
   */
  private static class DecInputStream extends InputStream {

    private final InputStream in;
    private final int k;

    DecInputStream(InputStream in, int k) {
      this.in = in;
      this.k = 0 - k;
    }

    @Override
    public int read() throws IOException {
      int i = in.read();
      if (i == -1) {
        return i;
      }
      return encrypt((char) i, k);
    }

  }

  /**
   * 加密
   *
   * @param c
   * @param k
   * @return
   */
  private static char encrypt(char c, int k) {
    // 如果字符串中的某个字符是小写字母
    if (c >= 'a' && c <= 'z') {
      c += k % 26; // 移动key%26位
      if (c < 'a') {
        c += 26; // 向左超界
      } else if (c > 'z') {
        c -= 26; // 向右超界
      }
    }
    // 如果字符串中的某个字符是大写字母
    else if (c >= 'A' && c <= 'Z') {
      c += k % 26; // 移动key%26位
      if (c < 'A') {
        c += 26;// 同上
      } else if (c > 'Z') {
        c -= 26;// 同上
      }
    }
    return c;
  }
}