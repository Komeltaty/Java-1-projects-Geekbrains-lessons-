package game;

import javax.swing.*;

public class Game {
    private GameBoard board;
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    private int playersTurn = 0;


    //it's new game board
    public Game(){
        this.board = new GameBoard(this);
    }

    //массив, содержащий игроков.
    public void initGame(int playersTurn){
        gamePlayers[0]=new GamePlayer(true, 'X');
        gamePlayers[1]=new GamePlayer(false, 'O');

    }



    //переход хода.
    void passTurn(){
        if(playersTurn==0){
            playersTurn = 1;
        }
        else{
            playersTurn = 0;
        }
    }
//передает информацию о текущем игроке (передаем значени о текузем игроке в матрицу инициации игры и возвращаем это значение)
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }
//окно с сообщением
    void showMassage (String massageText){
        JOptionPane.showMessageDialog(board,massageText);
    }
//сеттер для установки значения игрока
    public void setPlayersTurn (int playersTurn){
        this.playersTurn=playersTurn;
    }
}

