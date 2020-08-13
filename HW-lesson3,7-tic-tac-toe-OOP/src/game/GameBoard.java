package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame{
    static int dimenision = 3;
    static int cellSize = 150;
    private char [][] gameField;//матрица поля
    private GameButton[] gameButtons;//матрица кнопок

    private Game game;

    static int level = 0;//переменная будет отвечать за сложность

    static  char nullSymbol = '\u0000';


    public GameBoard (Game currntGame){
        this.game = currntGame;
        initField();
    }
//создаем поле
    private void initField() {
        setBounds(cellSize * dimenision, cellSize * dimenision, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
// панель меню
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая легкая игра");
        //вешаем слушателя, который обнуляет поле
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
                level=0;
                getGame().setPlayersTurn(0);//здесь мы при очестке поле присваиваем игроку значение 0
                getGame().initGame(0);
            }
        });

//добавляем кнопку сложного поля

        JButton newGameButton2 = new JButton("Новая сложная игра");
        //вешаем слушателя, который обнуляет поле
        newGameButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
                level=1;
                getGame().setPlayersTurn(0);//здесь мы при очестке поле присваиваем игроку значение 0
                getGame().initGame(0);
            }
        });

//настройки панели:
        //менеджер размещения
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        //добавляем кнопку
        controlPanel.add(newGameButton);
        controlPanel.add(newGameButton2);
        //размер кнопки
        controlPanel.setSize(cellSize * dimenision, 150);

//панель игового поля
        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimenision, dimenision));
        gameFieldPanel.setSize(cellSize * dimenision, cellSize * dimenision);

        gameField = new char[dimenision][dimenision];
        gameButtons = new GameButton[dimenision * dimenision];

        //инициализация игрового поля
        for (int i = 0; i < (dimenision * dimenision); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    //очищаем поле
        void emptyField() {
            for (int i = 0; i< (dimenision * dimenision); i++){
                gameButtons[i].setText("");

                int x = i / GameBoard.dimenision;
                int y = i % GameBoard.dimenision;

                gameField[x][y] = nullSymbol;
            }
            getGame().setPlayersTurn(0);//здесь мы при очитке поля присваиваем игроку значение 0
            getGame().initGame(0);

        }


        Game getGame(){
        return game;
        }

        public char getGameField(int x, int y) {
        char v = gameField[x][y];
        return v;
    }


        //проверка на наличие символа
        boolean isTurnable(int x, int y){
        boolean result = false;

        if(gameField[y][x]==nullSymbol)
            result = true;

        return result;
        }

        //обновляем инфо о поле: из класса гейм запрашиваем инфо о текущем игроке
        void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSigh();

        }

        boolean checkWin(){
boolean result = false;

char playerSymbol = getGame().getCurrentPlayer().getPlayerSigh();
if(checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)){
    result = true;
}
return result;
        }


    private boolean checkWinDiagonals(char playerSymbol) {
        boolean result = false;
        boolean diag1 = true;
        boolean diag2 = true;

        for (int i = 0; i < dimenision; i++) {
            diag1 &= (gameField[i][i] == playerSymbol);
            diag2 &= (gameField[dimenision - 1 - i][i] == playerSymbol);
        }
        if (diag1 || diag2)
            result = true;
        return result;
    }

    private boolean checkWinLines(char playerSymbol) {
        boolean result = false;
        boolean hor;
        boolean ver;
        //проверка по строкам,столбцам и диагоналям
        ver = true;
        for (int i = 0; i<dimenision; i++) {
            hor = true;
            ver = true;
            for (int j = 0; j < dimenision; j++) {

                hor &= (gameField[i][j] == playerSymbol);
                ver &= (gameField[j][i] == playerSymbol) ;
            }
            if (hor||ver){
                result =true;
                break;
            }
            if (result)
                break;
        }
        return result;

    }

    boolean isFull(){
        boolean result = true;

        for(int i = 0; i<dimenision; i++){
            for(int j=0; j<dimenision; j++){
                if (gameField[i][j] == nullSymbol)
                    result = false;
            }
        }
        return result;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }
    }




