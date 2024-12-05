import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Teacher>teachers = new ArrayList<>();
        List<Student>students = new ArrayList<>();


        Teacher Amar = new Teacher(1,"Amar",5000);
        teachers.add(Amar);
        Teacher Ajay = new Teacher(2,"Ajay",2000);
        teachers.add(Ajay);
        Teacher Chandrika = new Teacher(3,"Chandrika",7000);
        teachers.add(Chandrika);


        Student Tamanna = new Student(1,"Tamanna",5);
        students.add(Tamanna);
        Student Tushar = new Student(2,"Tushar",4);
        students.add(Tushar);
        Student Ravi = new Student(3,"Ravi",7);
        students.add(Ravi);

        School RiverSide_High_School = new School(teachers,students);
        Tamanna.payFees(10000);
        Ravi.payFees(12000);
        System.out.println("River-Side High School has earned:  "+RiverSide_High_School.getTotalMoneyEarned());
        System.out.println("Paying Salaries of Teachers");
        Amar.receiveSalary(Amar.getSalary());
        Chandrika.receiveSalary((Chandrika.getSalary()));
        System.out.println("Paid salary, left money: "+ RiverSide_High_School.getTotalMoneyEarned());

    }
}
