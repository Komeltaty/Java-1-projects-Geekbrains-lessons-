/*
5. Создать классы Собака и Кот с наследованием от класса Животное;

6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия
(для бега и плавания), или высоту (для прыжков);

7. У каждого животного есть ограничения на действия
(бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
плавание: кот не умеет плавать, собака – 10 м.);

8. При попытке животного выполнить одно из этих действий,
оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);

9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.

 */


public class MainClass {


    public static void main(String[] args) {
        int distans = 200;
        int swim = 5;
        double jump =1;
        Cat arsenii = new Cat("Арсений", 6, 8);
        Cat vasilii = new Cat("Василий", 2, 16);
        Dog bobic = new Dog("Бобик", 8, 9);
        Dog sharic =new Dog("Шарик", 3, 4);

        //вычисление максимальных возможностей
        arsenii.catRun();
       arsenii.catRunLengh(distans); //кот бежит указанную дистанцию
       arsenii.catSwimLengh(swim); //кот пытается плыть
       arsenii.catHight(jump);//кот прыгает

        //далее тожесамое со 2 котом
        System.out.println();
        vasilii.catRun();
        vasilii.catRunLengh(distans);
        vasilii.catSwimLengh(swim);
        vasilii.catHight(jump);
        System.out.println();

        //теперь тоже самое собаки
        bobic.dogRun();
        bobic.dogRunLengh(distans);
        bobic.dogSwimLengh(swim);
        bobic.dogHight(jump);

        //последний пес
        System.out.println();
        sharic.dogRun();
        sharic.dogRunLengh(distans);
        sharic.dogSwimLengh(swim);
        sharic.dogHight(jump);
   }
}
