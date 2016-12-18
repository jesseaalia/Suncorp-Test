//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// * Test class to test sorting of Employee object on different parameters.
// * each test method will test each Comparator implementation.
// * @author http://javarevisited.blogpot.com
// */
//public class EmployeeTestmAIN {
//   
//   public static void main(String[] args) {
//	
//	    Employee e1 = new Employee(1, "A", 1000, 32, new Date(2011, 10, 1));
//        Employee e2 = new Employee(2, "AB", 1300, 22, new Date(2012, 10, 1));
//        Employee e3 = new Employee(3, "B", 10, 42, new Date(2010, 11, 3));
//        Employee e4 = new Employee(4, "CD", 100, 23, new Date(2011, 10, 1));
//        Employee e5 = new Employee(5, "AAA", 1200, 26, new Date(2011, 10, 1));
//     
//       
//        List<Employee> listOfEmployees = new ArrayList<Employee>();
//        listOfEmployees.add(e1);
//        listOfEmployees.add(e2);
//        listOfEmployees.add(e3);
//        listOfEmployees.add(e4);
//        listOfEmployees.add(e5);
//        System.out.println("Unsorted List : " + listOfEmployees);
//       
//        
//        Collections.sort(listOfEmployees, Employee.NameComparator);
//        
//        Collections.sort(listOfEmployees, Employee.AgeComparator);
//        
//          }
//}
//
//
