public class Animals {
    protected String name;
   protected int age;
   protected int strength;



    public Animals(String name, int age, int strength){
        this.name=name;
        this.age=age;
        this.strength=strength;
            }

   protected void run(int runLenght){
System.out.println("Забег: " + name + " пробежал " + runLenght + " метров");
    }

    protected void swim(int swimLenght){
        System.out.println("Заплыв: " + name +" проплыл "+ swimLenght + " метров");
    }

    protected void jump(double hight){
        System.out.println("Прыжок: " + name + " прыгнул на " + hight + " метров");
    }

}
