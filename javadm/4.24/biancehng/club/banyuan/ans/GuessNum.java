package club.banyuan.ans;

import java.util.Scanner;

class GuessNum {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5};
        int trueNum = 0;
        int trueRoad = 0;
        System.out.println("猜一猜4个不重复的数字，请输入4个数字：");
        Scanner sc = new Scanner(System.in);
        String sr = sc.nextLine();

        for (int i = 0; i < 4; i++) {
            if (arr[i] == (sr.charAt(i)-48)){
                trueRoad++;
            }

        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((sr.charAt(i)-48) == arr[j]) {
                    trueNum++;
                }
            }
        }
        if (trueRoad == 4) {
            System.out.println("输入正确！");
        } else {
            System.out.println("输入错误，包含了" + trueNum + "个正确数字," + trueRoad + "个正确位数");
        }
    }
}