
public class Cat extends Animal{



    int hunger; //это количество еды, которую кот может съесть за раз(уровень голода)
    boolean fill = false; //по умолчанию сытость фолс(кот создается голодным)

         public Cat (String name){
        super("Кот " + name);
        this.hunger=5; //задаем уровень голода кота, стандартный
        this.runLimit=200;
        this.jumpLimit=2;
    }
    public Cat (String name, int hunger){
        super("Кот " + name);
        this.hunger=hunger; //тут зададим индивидуальный голод
        this.runLimit=200;
        this.jumpLimit=2;
    }
//делаем перегрузку потому что быть может у нас будет индивидульный голод,
    //и мы зададим спортивные параметры
    public Cat (String name, int hunger, int runLimit, double jumpLimit){
        super("Кот " + name);
        this.hunger=hunger;//тут тоже индивидуальный голод
        this.runLimit=runLimit;
        this.jumpLimit=jumpLimit;
    }


        public void swim (int distance){
        System.out.println( name+" не умеет плавать.");
    }
     //здесь кот должен есть из миски.
    //если его уровень голода меньше уровня еды в миске

    public int catEat(int volumeFood){

       if (hunger <= volumeFood){
        volumeFood=volumeFood-hunger;
        hunger=0; //cat eat
        System.out.println(name + " поел");
       fill=true;
        }
       else {
           hunger=hunger-volumeFood;
           volumeFood=0;
                   }

        return volumeFood;
        }

       }
