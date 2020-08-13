package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
   private int row;
   private int cell;
   private GameButton button;

   public GameActionListener(int row, int cell, GameButton gButton){
       this.row = row;
       this.cell = cell;
       this.button = gButton;
   }


    @Override
    public void actionPerformed(ActionEvent e) {
GameBoard board = button.getBoard();

if (board.isTurnable(row, cell)){
     updateByPlayersData(board);

     if(board.isFull()){
         board.getGame().showMassage("Ничья");
         board.emptyField();
         board.getGame().passTurn();


     }
     else{//разделение на сложную/простую игру
             if (GameBoard.level==0) {
             updateByAiData(board);
             if(board.isFull()){
                 board.getGame().showMassage("Ничья");
                 board.emptyField();

             }
         }
         else {
             updateByHardAiData(board, board.getGame().getCurrentPlayer().getPlayerSigh());
             if(board.isFull()){
                 board.getGame().showMassage("Ничья");
                 board.emptyField();
                 board.getGame().passTurn();

             }
         }
     }
}
else{
    board.getGame().showMassage("Некорректный ход!");
}
    }

    private void updateByPlayersData(GameBoard board){
       //обновляем матрицу игры
        board.updateGameField(row, cell);

        //обновляем содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSigh()));

        if(board.checkWin()) {
           // board.getGame().showMassage("Вы выйграли!");
           button.getBoard().getGame().showMassage("You are win!");
            board.emptyField();
            board.getGame().passTurn();

        }
        else{

            board.getGame().passTurn();

        }
    }

    //ход компьютера
    private void updateByAiData(GameBoard board){
          int x, y;
           Random rnd = new Random();

           do {
               x = rnd.nextInt(GameBoard.dimenision);
               y = rnd.nextInt(GameBoard.dimenision);
           }
           while (!board.isTurnable(x, y));

           //update game

           board.updateGameField(x, y);

           //update button
           int cellIndex = GameBoard.dimenision * x + y;
           board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSigh()));

           //ifwin
           if (board.checkWin()) {
               button.getBoard().getGame().showMassage("Computer win!");
               board.emptyField();
              // board.getGame().passTurn();

           } else {

               board.getGame().passTurn();

           }
   }

    private void updateByHardAiData(GameBoard board, char playerSigh) {
        int x=-1;
        int y=-1;
        int help1;
        int help2;

        boolean help = false;

       for (int i = 0; i < 9; i++) {

                 help1 = i / GameBoard.dimenision;//номер строки
                 help2 = i % GameBoard.dimenision;
          // System.out.println(help1+","+ help2);

           if (board.isTurnable(help1, help2)){


                //проверяем все левые элементы
                if (help2 - 1 >= 0 && board.getGameField(help1, (help2 - 1))== playerSigh) {

                 x=help1;
                 y = help2;
                    help = true;
                }
                //проверяем все правые элементы
                else if (help2 + 1 <= board.dimenision-1 && board.getGameField(help1, help2 + 1)==playerSigh) {

                    x=help1;
                    y = help2;
                    help = true;
                }
                    //проверяем верх
                    else if (help1 - 1 >= 0 && board.getGameField(help1 - 1,help2) == playerSigh) {

                    x=help1;
                    y = help2;
                        help = true;
                    }
                  //если число в последней строке
                    else if (help1 + 1 <= board.dimenision - 1 && board.getGameField(help1 + 1, help2) == playerSigh) {

                    x=help1;
                    y = help2;
                    help = true;
                    }
                    //угол1
                    else if (help1 - 1 >= 0 && help2 - 1 >= 0 && board.getGameField(help1 - 1, help2 - 1) == playerSigh) {

                        x=help1;
                    y = help2;
                    help = true;

                    }
                    // угол 2
                    else if (help1 + 1 <= board.dimenision - 1 && help2 + 1 <= board.dimenision - 1 && board.getGameField(help1 + 1,help2 + 1) == playerSigh) {

                        x=help1;
                    y = help2;
                    help = true;
                    }
                   // угол 3
                    else if (help1 - 1 >= 0 && help2 + 1 <= board.dimenision - 1 && board.getGameField(help1 - 1, help2 + 1) == playerSigh) {

                        x=help1;
                    y = help2;
                    help = true;
                    }
                    // угол 4
                    else if (help1 + 1 <= board.dimenision - 1 && help2 - 1 >= 0 && board.getGameField(help1 + 1,help2 - 1)==playerSigh) {

                        x=help1;
                    y = help2;
                    help = true;
                    }


            }if (help && board.isTurnable(x, y)){
               /*System.out.println("2й брэйк");
               System.out.println(x+","+y);*/
               break;}
       }
            if (!help){
                Random rnd = new Random();

                do {
                    x = rnd.nextInt(GameBoard.dimenision);
                    y = rnd.nextInt(GameBoard.dimenision);
                }

                while (!board.isTurnable(x, y));
                //System.out.println("random"+x+","+y);
            }
            //update game

            board.updateGameField(x, y);

            //update button
            int cellIndex = GameBoard.dimenision * x + y;
            board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSigh()));

            //ifwin
            if (board.checkWin()) {
                button.getBoard().getGame().showMassage("Computer win!");
                board.emptyField();
                //board.getGame().passTurn();

            } else {
                board.getGame().passTurn();
            }}


    }


