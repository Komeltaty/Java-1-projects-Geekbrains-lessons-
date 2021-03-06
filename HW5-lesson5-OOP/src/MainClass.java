
/*
1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;
2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;
7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
 */
public class MainClass {
    public static void main(String[] args) {

        //создаем массив котов
        Cat[] catsArray = new Cat[4];
        catsArray[0] = new Cat("Васька", 4);
        catsArray[1] = new Cat ("Персик", 15);
        catsArray[2] = new Cat ("Снужинка", 4);
        catsArray[3] = new Cat ("Люся", 6);
        //создаем миску
        Bowl bowl = new Bowl(10,0);

        //вводим вспомогательную переменую для сеттера
        int a;

        //цикл
        for (Cat cat: catsArray){

         while (!cat.fill) { // оборачиваем в бесконечный цикл, чтобы кот мог поесть, даже если миска пустая

                bowl.full(bowl.getVolumeFood());//мы берем миску, в качестве аргумента передаем объем еды

               System.out.println("Голод " + cat.name + ": " + cat.hunger + ". Кот сыт? " + cat.fill);

                //вот тут мы проверим условие, не больше ли желудок кота, чем объем миски, и если да, то выйдем из цикла
             //введено исклчительно ради условия 5, если убрать, то кот поест в несколько приемов
                if (cat.hunger > bowl.volume){
                    System.out.println( cat.name +", тебе нужна миска побольше, приходи в другой раз.");
                    System.out.println();
                    break;
                }
                 a = cat.catEat(bowl.getVolumeFood()); // тут котик ест

                 bowl.setVolumeFood(a);//тут мы заносим новое значение объема еды в соответствующую переменную через сеттер

                System.out.println("Голод " + cat.name + ": " + cat.hunger + ". Кот сыт? " + cat.fill);
                System.out.println();
            }
        }
    }
}
