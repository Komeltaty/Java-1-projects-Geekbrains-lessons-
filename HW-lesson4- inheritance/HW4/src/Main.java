/*
1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;

2. Конструктор класса должен заполнять эти поля при создании объекта;

3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;

4. Создать массив из 5 сотрудников:
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000,
30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */


public class Main {
    public static void main(String[] args) {
        Employee[] array = new Employee[5];
        array[0] = new Employee("Пупкин Василий Иванович", "директор", "Pupkin@mail.ru", "89998889999", 100000, 41);
        array[1] = new Employee("Берушин Алексей Николаевич", "инженер", "abrakadabra@dmail.com", "8-678-373-33-33", 35000, 50);
        array[2] = new Employee("Подберезовик Селена", "инженер", "podber@pochta.ru", "654-345-765", 33333, 25);
        array[3] = new Employee("Вверхнадуйка Александра Семётовна", "слесарь", "sredniiklass@pochta.ru", "888888888", 17000, 66);
        array[4] = new Employee("Весенняя Валерия Петровна", "тех.персонал", "343434@mail.ru", "898989898", 65000, 45);

            for (int i = 0; i < 5; i++) {
                if (array[i].getAge() >= 40)
                    array[i].printEmployee();
            }
    }
}