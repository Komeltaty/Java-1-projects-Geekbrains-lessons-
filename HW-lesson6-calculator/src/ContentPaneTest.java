import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

public class ContentPaneTest
{
    public JFrame window = new JFrame("Calc");
    public JTextField input = new JTextField();

    public ContentPaneTest()
    {
        window.setSize(170, 220); // размер окна
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white); // цвет окна
        window.setLayout(null);
        window.setResizable(false); // не даём изменять размер
        window.setLocationRelativeTo(null);
        inputField(); // процедура, устанавливающая атрибуты поля для ввода
        buttonConstruct(); // создаёт кнопки
        window.setVisible(true);
    }

    private void inputField()
    {
        input.setBounds(10, 5, 120, 20);
        window.add(input);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyDispatcher());
    }

    class KeyDispatcher implements KeyEventDispatcher
    {
        public boolean dispatchKeyEvent(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                result();
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                input.setText("");
            }
            return false;
        }
    }
    private void buttonConstruct()
    {
        int nums = 0;
// у каждой кнопки множество параметров, которые нужно задать
// Делаем массив имён, чтобы можно было в цикле назначить и имена сразу
// ** - возведение в степень
        String[] arr = new String[]{"1", "2", "3", "С", "4", "5", "6", "*", "7", "8", "9", "-", "0", "**", "+", "/", "(", ")", "="};
        JButton[] button = new JButton[arr.length];
        for (int i=0; i<5; i++)
        {
            for (int j=0; j<4; j++)
            {
                button[nums] = new JButton();
                button[nums].setFont(new Font("Calibri", Font.BOLD, 20));
                button[nums].setText(arr[nums]);
                button[nums].setMargin(new Insets(0,0,0,0));
                button[nums].setBounds(10+j*30, 25+i*30, 30, 30);
                button[nums].setFocusable(false);
                window.add(button[nums]);
                ActionListener numsButton = new NumsListener();
                button[nums].addActionListener(numsButton);
                if (nums < arr.length - 1)
                {
                    nums++;
                }
                else
                {
                    break;
                }
            }
        }
    }
    public class NumsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name = ((JButton)e.getSource()).getText();
            switch (name) {
                case "=":
                case "С":
                    break;
                default:
                    input.setText(input.getText() + name);
                    break;
            }
            if (name.equals("="))
                result();
            if (name.equals("С"))
                input.setText("");
            window.repaint();
        }
    }
    private void result()
    {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try
        {
            input.setText("" + engine.eval(input.getText()));
        }
        catch (ScriptException ignored)
        {
            String str = input.getText();
            int g = str.length();
            char[] chArray = str.toCharArray();
            for(int i = 0; i<chArray.length; i++){
                if(chArray[i] == '*'){
                    int a = Integer.parseInt(str.substring(0,i));
                    int b = Integer.parseInt(str.substring(i+2, g));
                    input.setText("" + power(a,b));
                    break;
                }
            }
        }
    }
    static int power(int a, int b){
        int result = 1;
        for (int i=1; i<=b; i++){
            result = result*a;
        }
        return result;
    }
    public static void main(String[] args)
    {
        new ContentPaneTest();
    }
}
