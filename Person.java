package geekbrains;

public class Person {
    private String Name;
    private String Position;
    private String Email;
    private long Phone;
    private int Salary;
    public int Age;

    public Person(String name, String position, String email, long phone, int salary, int age) {
        Name = name;
        Position = position;
        Email = email;
        Phone = phone;
        Salary = salary;
        Age = age;
    }
    public void GetInformation(){
        System.out.println(String.format("Worker name: %s, Position: %s, Contact info: %s,%s, Salary: %s, Age: %s", Name, Position, Email, Phone, Salary, Age));
    }
}

