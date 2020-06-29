public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    public Employee(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public void printEmployee() {
        System.out.println("сотрудник: " + this.FIO + ",");
        System.out.println("должность: " + this.position + ",");
        System.out.println("зарплата: " + this.salary + ",");
        System.out.println("возраст " + this.age + ",");
        System.out.println("КОНТАКТЫ:");
        System.out.println("e-mail: " + this.email + ",");
        System.out.println("телефон: " + this.phone + ",");
        System.out.println();
    }

    public int getAge() {
        return age;
    }



    }

