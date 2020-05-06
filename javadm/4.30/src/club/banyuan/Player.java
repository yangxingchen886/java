package club.banyuan;

import java.util.Scanner;

public class Player {

    public static final String[] FINGER_TOTAL = {"石头", "剪刀", "布"};
    public static final String ROLE_HUMAN = "人";

    private int id;

    private int finger;

    private boolean isOut;

    private String role;


    static Player[] initPlayers(int playerCount) {
        Player[] players = new Player[playerCount];

        Player human = new Player();
        human.setRole("人");
        players[0] = human;
        for (int i = 1; i < playerCount; i++) {
            Player computer = new Player();
            computer.setRole("电脑");
            computer.setId(i);
            players[i] = computer;
        }
        return players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getFinger() {
        return finger;
    }

    public void setFinger(int finger) {
        this.finger = finger;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }



    public void showFinger() {
        if (ROLE_HUMAN.equals(role)) {
            System.out.println("请出拳 1.石头  2.剪刀  3.布: \n输入0返回上一级");
            Scanner scanner = new Scanner(System.in);
            int order = scanner.nextInt();
            if(order == 0){
                Rules.willBackToMenu = true;
                return;
            }
            setFinger(order);
        } else {
            int randomFinger = (int) (Math.random() * 3) + 1;
            setFinger(randomFinger);
        }
    }

    public String toString() {
        if (ROLE_HUMAN.equals(role)) {
            return "玩家" + "出了" + FINGER_TOTAL[finger - 1];
        } else {
            return "电脑" + id + "出了" + FINGER_TOTAL[finger - 1];
        }
    }
}

