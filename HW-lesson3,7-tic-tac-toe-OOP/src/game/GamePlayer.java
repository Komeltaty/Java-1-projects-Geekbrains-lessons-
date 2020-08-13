package game;

public class GamePlayer {
    private char playerSigh;
    private boolean realPlayer = true;

    //в конструкторе мы определяем, что текущий игрок и текузий символ - те, что передали при вызове метода
    public GamePlayer(boolean isRealPlayer, char playerSign){
        this.realPlayer = isRealPlayer;
        this.playerSigh = playerSign;
    }

    public boolean isRealPlayer(){
        return realPlayer;
    }

    public  char getPlayerSigh(){
        return playerSigh;
    }
}
