import game.Game;
/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать;
2. Реализовать логику более умного компьютера, который определяет свой ход на основании соседних клеток;
3. Найти в коде неоптимальные места и улучшить их;
4. *Усилить логику алгоритмом с подсчётом очков для каждой клетки.
1. Найти неоптимальные и плохие места в коде игры;
2. Оптимизировать их;
3. Портировать методы AI и определения победы в ООП-реализацию.

 */
public class MainClass {
    public static void main(String[] args) {
     Game gameInstance = new Game();
gameInstance.initGame(0);

    }
}


//после окончания игры ничей, поле обновляется всегда
//добавила проверку на ничью после хода компьютера
//сделала чтобы новая игра игралась снова крестиками