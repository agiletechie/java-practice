import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String args[]){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());

        ArrayList<Accountant> accountants = new ArrayList<>();
        accountants.add(new Accountant());
//        employees = accountants;

        ArrayList<Object> employee1 = new ArrayList<>();
        ArrayList<Object> accountant1 = new ArrayList<>();
        employee1 = accountant1;

        List<?> employee2 = new ArrayList<>();
        ArrayList<Accountant> accountant2 = new ArrayList<>();
        employee2 = accountant2;
        // upper bound
        List<? extends Employee> employee3 = new ArrayList<>();
        List<Accountant> accountant3 = new ArrayList<>();
        employee3 = accountant3;
        // lower bound

        List<? super Employee> employee4 = new ArrayList<>();
        List<Accountant> accountant4 = new ArrayList<>();
//        employee4 = accountant4;

        employee1.add("Name");
        employee1.add(100);
        employee2.add(null);                            // doesn't allow anything else other than null as it cant confirm type safety
        new Application().call(employee1);

        makeEmployeeWork(accountants);
        makeEmployeeWork1(accountants);

    }
    public void call(List<?> list){
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

    public static void makeEmployeeWork(List<? extends Employee> employees){
        for(Employee emp : employees){
            emp.work();
        }
    }
    //for accessing Accountant class methods
    public static void makeEmployeeWork1(List<? extends Employee> employees){
        for(Accountant acc : (ArrayList<Accountant>)employees){
            acc.work();
        }
    }
}
