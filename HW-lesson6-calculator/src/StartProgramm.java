//сделать сброс переменных для ввода новых значений
//разделить полный сброс и сброс последнего значения
//сделать возможным ввод дробей и числе(через если, если переменная
//содержащая символ действия пуста, то дописываем число
//сделать сброс всех значений при выполнении операции равно

/*
1. Разработать оконное приложение «Калькулятор»;
1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
1.2. Калькулятор должен иметь одно окно вывода результатов.
1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartProgramm {
double nomber1=0;//2 вспомогательных числа для ввода данных с кнопок
double nomber2=0;
boolean znak=false;//вспомогательное поле для ввода знака числа
    //при нажатии на кнопку знака будет менять на тру
String GO=null;//вспомогательное поле для определение производимого действия
    //при нажатии на знак действия, ей будет присвоено значение, которое мы используем при нажатии на кнопку равно
boolean go1=false;
    boolean zapyataya = false;


 public  void start(){

     //создаем окно
     JFrame frame = new JFrame("Калькулятор");
     //кнопка выкл
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //тут убрала размер окна, потмоу что он съедает кнопки
   frame.setPreferredSize(new Dimension(400,600));

     //создаем вертикальное построение
    //JPanel contents = new JPanel(new VerticalLayout());
    //создаем панель, в оторую вложим кнопки
     JPanel calculate = new JPanel();
    calculate.setSize(500,500);
    //текстовое поле
     JPanel buttonText = new JPanel();
     Button buttonText1 = new Button("Ввести параметры");
     JTextField field = new JTextField(30);
     //это нужно, чтоб заработало вертикальное распложение
    // frame.getContentPane().add(contents);
     frame.getContentPane().add(calculate);
     //вот тут мы добаляем текстовое поле и будущие кнопки в соответсвующие
     //"контейнеры"
    // contents.add(buttonText);
     //buttonText.add(buttonText1);//кнопка для диалогового окна
     //contents.add(calculate);



//создаем и сразу добавляем кнопки

     GridLayout layout= new GridLayout(6, 4, 5, 5);
//первые 4 кнопки отвечают за вычисление и ввод
     calculate.setLayout(layout);
     Button buttonmultiplication = new Button("умножение");
     calculate.add(buttonmultiplication);
     Button buttondivision = new Button("деление");
     calculate.add(buttondivision);
     Button buttonsum = new Button("сумма");
     calculate.add(buttonsum);
     Button buttonsubtraction = new Button("вычитание");
     calculate.add(buttonsubtraction);
//сразу вводим 4 слушателя

     //слушатель для диалогового окна умножение
     ActionListener listenermultiplication = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             String result = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите первую цифру:</h2>"

             );
             double x =0;
             x=Double.parseDouble(result);

             String result1 = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите вторую цифру:</h2>"

             );
             //2е число
             double y=0;
             y = Double.parseDouble(result1);
             double t = x*y;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Результат умножения</h2>"
                             + x + " * " + y + " = "+t

             );
         }
     };
     //подключение кнопки
     buttonmultiplication.addActionListener(listenermultiplication);

     //слушатель для диалогового окна деления
     ActionListener listenerdivision = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             String result = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите первую цифру:</h2>"

             );
             double x =0;
             x=Double.parseDouble(result);

             String result1 = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите вторую цифру:</h2>"

             );
             //2е число
             double y=0;
             y = Double.parseDouble(result1);
             if (y==0){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Ошибка! На ноль делить нельзя!</h2>");
             }
             else {
                 double t = x/y;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Результат деления</h2>"
                             + x + " / " + y + " = "+t); }
         }
     };
     //подключение кнопки
     buttondivision.addActionListener(listenerdivision);

     //слушатель для диалогового окна сложения
     ActionListener listenersum = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             String result = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите первую цифру:</h2>"

             );
             double x =0;
             x=Double.parseDouble(result);

             String result1 = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите вторую цифру:</h2>"

             );
             //2е число
             double y=0;
             y = Double.parseDouble(result1);


                 double t = x+y;
                 //вывод результата
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Результат сложения</h2>"
                                 + x + " + " + y + " = "+t); }

     };
     //подключение кнопки
     buttonsum.addActionListener(listenersum);

     //слушатель для диалогового окна вычитания
     ActionListener listenersubtraction = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             String result = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите первую цифру:</h2>"

             );
             double x =0;
             x=Double.parseDouble(result);

             String result1 = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите вторую цифру:</h2>"

             );
             //2е число
             double y=0;
             y = Double.parseDouble(result1);


             double t = x-y;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Результат вычитания</h2>"
                             + x + " - " + y + " = "+t); }

     };
     //подключение кнопки
     buttonsubtraction.addActionListener(listenersubtraction);

     //2й ряд кнопок
     Button buttonX2 = new Button("квадрат числа");
     calculate.add(buttonX2);
     Button buttonC = new Button("очистить поле");
     calculate.add(buttonC);
     Button buttonDEL = new Button("DEL");
     calculate.add(buttonDEL);
     Button buttonMultiplication = new Button(" * ");
     calculate.add(buttonMultiplication);

     //слушатели кнопок
     ActionListener listenerX2 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             String result = JOptionPane.showInputDialog(
                     calculate,
                     "<html><h2>Введите число, возводимое в квадрат:</h2>"
             );
             double x =0;
             x=Double.parseDouble(result);

            double t = x*x;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Результат возведения в квадрат числа </h2>"
                             + x +" * "+x+ " = "+t
             );
         }
     };
     //подключение кнопки
     buttonX2.addActionListener(listenerX2);

     ActionListener listenerDellAll = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             GO=null;
             go1=false;
             zapyataya=false;
             znak=false;
             nomber1=0;
             nomber2=0;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Все поля очищены</h2>"
             );
         }
     };
     //подключение кнопки
     buttonC.addActionListener(listenerDellAll);

     ActionListener listenerDellLast = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             if(nomber2!=0 ){
                 nomber2=0;
                 zapyataya=false;
                 znak=false;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Поле очищено, введите число 2 заново</h2>"
                 );

             }
             else if (go1==true){
                 go1=false;
                 GO=null;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Действие удалено, введите заново</h2>"
                 );
             }
             else if (nomber1!=0){
                 nomber1=0;
                 zapyataya=false;
                 znak=false;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Поле очищено, введите число 1 заново</h2>"
                 );
             }
             }
     };
     //подключение кнопки
     buttonDEL.addActionListener(listenerDellLast);

     ActionListener listenerMult = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             GO = "Умножение";
             go1=true;
             zapyataya=false;
             znak=false;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                             nomber1+" * " ); }
     };
     //подключение кнопки
     buttonMultiplication.addActionListener(listenerMult);


     // 3й ряд кнопок:
     Button button7 = new Button("  "+7+ "  ");
     calculate.add(button7);
     Button button8 = new Button("  "+8+ "  ");
     calculate.add(button8);
     Button button9 = new Button("  "+9+ "  ");
     calculate.add(button9);
     Button buttonDivision = new Button(" / ");
     calculate.add(buttonDivision);

     //listener
     ActionListener listener7 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(7);
             //вывод результата
             if (go1==false){
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                              nomber1 ); }
              else {
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                             nomber2 ); }}
     };

     //подключение кнопки
     button7.addActionListener(listener7);

     ActionListener listener8 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(8);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button8.addActionListener(listener8);

     ActionListener listener9 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
            enterNomber(9);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button9.addActionListener(listener9);

     ActionListener listener91 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             GO = "Деление";
             go1=true;
             zapyataya=false;
             znak=false;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                             nomber1+" / " );
         }
     };
     //подключение кнопки
     buttonDivision.addActionListener(listener91);

    // 4й ряд кнопок
     Button button4 = new Button("  "+4+ "  ");
     calculate.add(button4);
     Button button5 = new Button("  "+5+ "  ");
     calculate.add(button5);
     Button button6 = new Button("  "+6+ "  ");
     calculate.add(button6);
     Button buttonSum = new Button(" + ");
     calculate.add(buttonSum);
//слушатели
     ActionListener listener4 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
            enterNomber(4);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button4.addActionListener(listener4);

     ActionListener listener5 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(5);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button5.addActionListener(listener5);

     ActionListener listener6 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(6);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button6.addActionListener(listener6);

     ActionListener listenerSumL = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             GO = "Сумма";
             go1=true;
             zapyataya=false;
             znak=false;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                             nomber1+" + " ); }
     };
     //подключение кнопки
     buttonSum.addActionListener(listenerSumL);


     //5й ряд кнопок
     Button button1 = new Button("  "+1+ "  ");
     calculate.add(button1);
     Button button2 = new Button("  "+2+ "  ");
     calculate.add(button2);
     Button button3 = new Button("  "+3+ "  ");
     calculate.add(button3);
     Button buttonSub = new Button(" - ");
     calculate.add(buttonSub);
     //слушатели на 5й ряд
     ActionListener listener1 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(1);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button1.addActionListener(listener1);

     ActionListener listener2 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             enterNomber(2);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button2.addActionListener(listener2);

     ActionListener listener3 = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
            enterNomber(3);
             //вывод результата
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };
     //подключение кнопки
     button3.addActionListener(listener3);

     ActionListener listenerSub = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //первое число
             GO = "Вычитание";
             go1=true;
             zapyataya=false;
             znak=false;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Вы ввели: </h2>"+
                             nomber1+" - " ); }
     };
     //подключение кнопки
     buttonSub.addActionListener(listenerSub);

     //6й ряд кнопок
     Button buttonZnak = new Button("  +/-  ");
     calculate.add(buttonZnak);
     Button button0 = new Button("  "+0+ "  ");
     calculate.add(button0);
     Button buttonZapyataya = new Button("  ,  ");
     calculate.add(buttonZapyataya);
     Button enter = new Button("  =  ");
     calculate.add(enter);

     ActionListener ListenerZnak = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             znak=true;
             //вывод результата
             JOptionPane.showMessageDialog(
                     calculate,
                     "<html><h2>Будет введено отрицательное число </h2>"
                              );
         }
     };

     buttonZnak.addActionListener(ListenerZnak);

     ActionListener ListenerZero = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            enterNomber(0);
             if (go1==false){
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber1 ); }
             else {
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Вы ввели: </h2>"+
                                 nomber2 ); }}
     };

     button0.addActionListener(ListenerZero);

     ActionListener ListenerZap = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             zapyataya = true;

                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Далее нужно ввести дробную часть </h2>"
                 );
         }
     };

     buttonZapyataya.addActionListener(ListenerZap);


     ActionListener ListenerEnter = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             double result=0;
             if (go1==true){

             if (GO.equals("Деление")){
                 if (nomber2==0){
                     JOptionPane.showMessageDialog(
                             calculate,
                             "<html><h2>Ошибка! На ноль делить нельзя!</h2>");
                 }
                 else {
                 result=nomber1/nomber2;
                     JOptionPane.showMessageDialog(
                             calculate,
                             "<html><h2>Результат деления </h2>"+
                                     nomber1 +"/" + nomber2 +" = "+ result );
             }}
             if (GO.equals("Умножение")){
                 result = nomber1*nomber2;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Результат умножения </h2>"+
                                 nomber1 +"*" + nomber2 +" = "+ result );
             }
             if (GO.equals("Сумма")){
                 result=nomber1+nomber2;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Результат суммирования </h2>"+
                                 nomber1 +"+" + nomber2 +" = "+ result );
             }

             if (GO.equals("Вычитание")){
                 result=nomber1-nomber2;
                 JOptionPane.showMessageDialog(
                         calculate,
                         "<html><h2>Результат вычитания </h2>"+
                                 nomber1 +"-" + nomber2 +" = "+ result );
             }

             GO=null;
             go1=false;
             zapyataya=false;
             znak=false;
             nomber1=0;
             nomber2=0;

         }}
     };

     enter.addActionListener(ListenerEnter);


     frame.pack();
     frame.setVisible(true);
 }

 private void enterNomber(double nomber){

     //если мы еще не нажали на кнопку вычислительной операции(т.е. вводим 1 число), или запятую
     if (go1==false&&zapyataya==false){
         if (nomber1==0){
             if (znak==true){
                 nomber1=-nomber;//если вводим отрицательное число
             }
             else nomber1=nomber;
             }
         else {nomber1=nomber1*10+nomber;
             }
          }
         //если вводим 1 число, но после запятой
         if (go1==false&&zapyataya==true){
             for (int i=10; i<10000000; i=i*10){
                 if(nomber1*(i/10)%1==0){
                     nomber=nomber/i;
                     nomber1=nomber1+nomber;
                     break;
                 }
             }
         }



         if (go1==true&&zapyataya==false){
             if (nomber2==0){
                 if (znak=true){
                     nomber2=-nomber;
                 }
                 nomber2=nomber;
                 }
             else nomber2=nomber2*10+nomber;}
             //если вводим 1 число, но после запятой
             if (go1==true&&zapyataya==true){
                 for (int i=10; i<10000000; i=i*10){
                     if(nomber2*(i/10)%1==0){
                         nomber=nomber/i;
                         nomber2=nomber2+nomber;
                         break;
                     }
                 }
             }}

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
new StartProgramm().start();
            }
        });

    }
}
