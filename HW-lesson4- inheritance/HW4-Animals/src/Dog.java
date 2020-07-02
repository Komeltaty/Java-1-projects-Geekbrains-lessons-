public class Dog extends Animals {
    int maxLenght = 500  ;
    double maxHight = 0.5 ;
    int maxSwim = 10;

    public Dog(String name, int age, int strength){
        super(name, age, strength);
    }

    //задание 9* добавлено индивидуальные параметры, в зависимости от характеристик кота, он может больше или меньше
    protected void dogRun(){
       //изменяем начальные параметры под разных собак
        //если собака старая, или молодая - она может меньше
        //если собака сильная - она может больше, и наоборот

        if (super.age>7 && super.age<2) {
            maxLenght = maxLenght - 200;
            maxHight = maxHight - 0.2;
            maxSwim = maxSwim - 3;
        }
        if (super.strength>8){
            maxLenght=maxLenght+200;
            maxHight=maxHight+0.6;
            maxSwim=maxSwim+3;
        }
        else if (super.strength<3) {
            maxLenght=maxLenght-100;
          maxHight=maxHight-0.1;
        maxSwim=maxSwim-2;}

    }
    //проверка возможности выполнения действия, вызов действия. если выполнить нельзя, пишем что нельзя
    protected int dogRunLengh(int distance){


        if (maxLenght>=distance){
            run(distance);
        }
        else System.out.println("Бег. К сожалению, " + name + " не смог");

        return distance;
    }

    protected int dogSwimLengh(int swim) {

        if (maxSwim>=swim) {
            swim(swim);
            }
        else System.out.println("Плавание. К сожалению, " + name + " не смог");
        return swim;
    }


    protected double dogHight(double jump) {

        if (maxHight>=jump){
            jump(jump);
        }
        else System.out.println("Прыжок. К сожалению, " + name + " не смог");
        return jump;
    }
}
