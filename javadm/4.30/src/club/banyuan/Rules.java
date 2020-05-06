package club.banyuan;

import java.util.Scanner;

public class Rules {
    static boolean willBackToMenu;

    private static int countPlaysLeft;

    public static int getCountPlaysLeft() { return countPlaysLeft; }

    public static void setCountPlaysLeft(int count) { countPlaysLeft = count; }


    private static int getWinnerFinger(String rlt) {
        if ("12".equals(rlt) || "21".equals(rlt)) {
            return 1;
        } else if ("13".equals(rlt) || "31".equals(rlt)) {
            return 3;
        } else {
            return 2;
        }
    }

    static boolean isDraw(String rlt) {
        return rlt.length() == 3 || rlt.length() == 1;
    }

    static void outPlayer(Player[] players, String rlt) {
        int winnerFinger = getWinnerFinger(rlt);
        for (Player player : players) {
            if (!player.isOut() && player.getFinger() != winnerFinger) {
                player.setOut(true);
                int countLeft = getCountPlaysLeft();
                setCountPlaysLeft(countLeft - 1);
                System.out.println(player.toString() + "输掉了");
            } else if (!player.isOut()) {
                System.out.println(player.toString() + "胜利");
            }
        }
        System.out.println();
    }

    static void showFingers(Player[] players) {
        System.out.printf("当前游戏%d人参与猜拳\n", Rules.getCountPlaysLeft());
        for (Player player : players) {
            if (player.isOut()) {
                continue;
            }
            player.showFinger();
        }
    }

    static String competeResult(Player[] players) {
        StringBuilder rlt = new StringBuilder();
        for (Player player : players) {
            if (player.isOut()) {
                continue;
            }
            String oneFinger = player.getFinger() + "";
            if (!rlt.toString().contains(oneFinger)) {
                rlt.append(oneFinger);
            }
        }
        return rlt.toString();
    }

    static boolean isFinalWinner(Player[] players) {
        int winnerCount = 0;
        for (Player player : players) {
            if (!player.isOut()) {
                winnerCount++;
            }
        }
        return winnerCount == 1;
    }

    static void printWinner(Player[] players) {
        for (Player player : players) {
            if (!player.isOut()) {
                if(Player.ROLE_HUMAN.equals(player.getRole())){
                    System.out.println("获胜方是" + player.getRole() );
                }else {
                    System.out.println("获胜方是" + player.getRole() + player.getId());
                }
            }
        }
    }

    public static int playersCountInit() {
        int playerCount;
        while(true){
            System.out.println("用户输入多少人参与猜拳（2~5人）。输入0退出程序");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            scanner.nextLine();
            if(a == 0){
                System.exit(0);
            }else if(a < 2 || a > 5){
                System.out.println("非法输入");
            }else{
                playerCount = a;
                break;
            }
        }
        return playerCount;
    }
}
