public class Cat extends Animals {
public int maxLenght = 200;
public double maxHight = 2;

      public Cat(String name, int age, int strength){
          super(name, age, strength);
            }

    //задание 9* добавлено индивидуальные параметры, в зависимости от характеристик кота, он может больше или меньше
    protected void catRun(){
        //изменяем начальные параметры под разных котов
        //если кот старый, или молодой - он может меньше
        //тоже самое с силой
        if (super.age>7 && super.age < 2){
            maxLenght=maxLenght-50;
            maxHight=maxHight-0.5;
        }

        if (super.strength>8){
            maxLenght=maxLenght+50;
            maxHight=maxHight+1;
        }
        else {maxLenght=maxLenght-50;
        maxHight=maxHight-1;}

         }

//проверка возможности выполнения действия, вызов действия. если выполнить нельзя, пишем что нельзя
protected int catRunLengh(int distance){
          if (maxLenght>=distance){
              run(distance);
          }
          else System.out.println("Бег. К сожалению, " + name + " не смог");

    return distance;
}

    protected int catSwimLengh(int swim) {

        if (swim>0) {
            System.out.println("Плавание. К сожалению, " + name + " не умеет плавать");
        }
            return swim;
    }


    protected double catHight(double jump) {

        if (maxHight>=jump){
            jump(jump);
        }
        else System.out.println("Прыжок. К сожалению, " + name + " не смог");
        return jump;
    }

}
