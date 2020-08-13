
package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {
    private enum Action{
        PLUS, MINUS, MULTIPLY, DIVIDE, NONE
    }

    private class Data{
        private Integer number;
        private Action whichButton = Action.NONE;
        public Action getWhichButton() {
            return whichButton;
        }
        public void setWhichButton(Action whichButton) {
            this.whichButton = whichButton;
        }
        public Integer getNumber() {
            return number;
        }
        public void setNumber(Integer number) {
            this.number = number;
        }
    }
    public  void createGUI(){



        final Data buffer = new Data();
        final int[] сount = {0};
        // создание окна программы
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200,200));
        frame.pack();
        frame.setVisible(true);

        // создание кнопок
        JButton addition = new JButton("+");
        JButton substraction = new JButton("-");
        JButton multiplication = new JButton("*");
        JButton division = new JButton("/");
        JButton equal = new JButton("=");

        // добавление кнопок в окно программы
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // объявления метода расположения содержимого внутри окна
        panel.add(addition);
        panel.add(substraction);
        panel.add(division);
        panel.add(multiplication);
        panel.add(equal);

        frame.setContentPane(panel); // добавление содержимого в саму программу

        // создание поля ввода
        JTextField field = new JTextField(5); //в параметре указывается кол-во символов, которое можно ввести
        frame.add(field); // добавление поля ввода в программу

        ActionListener fieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        };
        field.addActionListener(fieldListener);



        ActionListener buttonPlus = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer a = new Integer(field.getText());
                if(buffer.getNumber() == null) {
                    buffer.setNumber(a);
                }

                buffer.setWhichButton(Action.PLUS);

            }
        };

        addition.addActionListener(buttonPlus);

        ActionListener buttonMinus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer a = new Integer(field.getText());
                if(buffer.getNumber() == null) {
                    buffer.setNumber(a);
                }

                buffer.setWhichButton(Action.MINUS);
            }
        };

        substraction.addActionListener(buttonMinus);

        ActionListener buttonDivide = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer a = new Integer(field.getText());
                if(buffer.getNumber() == null) {
                    buffer.setNumber(a);
                }

                buffer.setWhichButton(Action.DIVIDE);
            }
        };

        division.addActionListener(buttonDivide);

        ActionListener buttonMultiply = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer a = new Integer(field.getText());
                if(buffer.getNumber() == null) {
                    buffer.setNumber(a);
                }

                buffer.setWhichButton(Action.MULTIPLY);
            }
        };

        multiplication.addActionListener(buttonMultiply);

        ActionListener buttonEqaul = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer b = new Integer(field.getText());
                if(buffer.getNumber() != null){
                    if(buffer.getWhichButton() == Action.PLUS){
                        Integer result = b + buffer.getNumber();
                        field.setText(result.toString());
                    }
                    if(buffer.getWhichButton() == Action.MINUS){
                        Integer result = buffer.getNumber() - b;
                        field.setText(result.toString());
                    }
                    if(buffer.getWhichButton() == Action.DIVIDE){
                        Integer result = buffer.getNumber() / b;
                        Integer remainder = buffer.number % b;
                        if(remainder != 0) {
                            field.setText(result.toString() + "," + remainder.toString());
                        } else {
                            field.setText(result.toString());
                        }
                    }
                    if(buffer.getWhichButton() == Action.MULTIPLY){
                        Integer result = buffer.getNumber() * b;
                        field.setText(result.toString());
                    }
                }


            }
        };
        equal.addActionListener(buttonEqaul);

    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculator main = new Calculator();
                main.createGUI();

            }
        });
    }
}

