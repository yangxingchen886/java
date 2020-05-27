package club.banyuan.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class cmd {

  private static void delete(File file) {
    if (file.isFile()) {
      file.delete();
    }
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (File file1 : files) {
        if (file1.isFile()) {
          file1.delete();
        } else {
          delete(file1);
        }
        file.delete();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    if ("ls".equals(args[0])) {
      if (args.length == 1) {
        File file = new File("./");
        String[] fileName = file.list();
        if (fileName == null) {
          System.out.println("当前为空目录");
        } else {
          for (String s : fileName) {
            System.out.println(s);
          }
        }
      }
      if (args.length == 2) {
        File file = new File(args[1]);
        String[] fileName = file.list();
        if (fileName == null) {
          System.out.println("当前为空目录");
        } else {
          for (String s : fileName) {
            System.out.println(s);
          }
        }
      }
      if (args.length == 3 && "-l".equals(args[2])) {
        File file = new File(args[1]);
        File[] fileArray = file.listFiles();
        String[] detailFile = new String[4];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (File one : fileArray) {
          detailFile[0] = (one.isDirectory()) ? "d" : "-";
          detailFile[1] =
              (one.isFile()) ? String.format("%5d", one.length()) : String.format("%5d", 0);
          detailFile[2] = dateFormat.format(new Date(one.lastModified())) + "";
          detailFile[3] = one.getName();
          for (String str : detailFile) {
            System.out.print(str + "     ");
          }
          System.out.println();
        }
      }
    }
    if ("rm".equals(args[0])) {
      File file = new File(args[1]);
      delete(file);
    }
    if ("cp".equals(args[0])) {
      File file1 = new File(args[1]);
      try {
        if (!file1.isFile()) {
          throw new IOException();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      File file2 = new File(args[2], file1.getName());
      file2.createNewFile();
      InputStream inputStream = null;
      OutputStream outputStream = null;
      try {
        inputStream = new FileInputStream(file1);
        byte[] bytes = inputStream.readAllBytes();
        outputStream = new FileOutputStream(file2);
        outputStream.write(bytes);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (outputStream != null) {
            outputStream.close();
          }
          if (inputStream != null) {
            inputStream.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    if ("cat".equals(args[0])) {
      File file = new File(args[1]);
      try {
        if (!file.isFile()) {
          throw new IOException();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try (InputStream inputStream = new FileInputStream(file)) {
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

