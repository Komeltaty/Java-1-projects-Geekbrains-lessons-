public abstract class Animal {
    protected String name;
    protected int age;
    protected int strength;
    protected int runLimit=0;
    protected double jumpLimit=0;
    protected int swimLimit=0;

    public Animal() { this.name = "Безымянный";}

    public Animal(String name) {
        this.name=name;
        }

    public Animal(String name, int age, int strength) {
        this.name=name;
        this.age=age;
        this.strength=strength;
    }

    public void run(int distance){
        if (runLimit>0 && distance <= runLimit){
            System.out.println(this.name +" пробежал " + distance + " метров");
        }
        else System.out.println(this.name +" не смог пробежать" );
    }

    public void swim(int distance){
        if (swimLimit>0 && distance <= swimLimit){
            System.out.println(this.name +" проплыл " + distance + " метров");
        }
        else System.out.println(this.name +" не смог проплыть" );
    }

    public void jump(int height){
        if (jumpLimit>0 && height <= jumpLimit){
            System.out.println(this.name +" прыгнул на " + height + " метров");
        }
        else System.out.println(this.name +" не смог прыгнуть" );

    }
}
