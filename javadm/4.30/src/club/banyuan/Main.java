package club.banyuan;

public class Main {
    public static void main(String[] args) {
        while (true){
            Rules.willBackToMenu = false;
            int playerCount = Rules.playersCountInit();
            Rules.setCountPlaysLeft(playerCount);
            Player[] players = Player.initPlayers(playerCount);

            while (true) {
                Rules.showFingers(players);
                if(Rules.willBackToMenu){
                    break;
                }else{
                    String rlt = Rules.competeResult(players);

                    if (Rules.isDraw(rlt)) {
                        System.out.println("平局");
                        continue;
                    } else {
                        Rules.outPlayer(players, rlt);
                    }
                    if (Rules.isFinalWinner(players)) {
                        break;
                    }
                }

            }
            if(Rules.willBackToMenu){
                continue;
            }
            Rules.printWinner(players);
            break;
        }
    }
}
