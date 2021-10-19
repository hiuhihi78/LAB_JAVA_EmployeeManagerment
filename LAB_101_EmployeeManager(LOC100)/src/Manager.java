
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hiuhihi78
 */
public class Manager {

    // menu
    public static void displayMenu() {
        System.out.println("      Employee Manager");
        System.out.println("-----------------------------");
        System.out.println("1.  Add employees ");
        System.out.println("2.  Update employees");
        System.out.println("3.  Remove employees");
        System.out.println("4.  Search employees");
        System.out.println("5.  Sort employees by salary");
        System.out.println("6.  Exit");
    }

    // allow user add employees
    public static void addEmployees(ArrayList<Employee> list) {
        System.out.println("---------Add Employee-----------");
        int id = GetValue.getId(list);
        String firstName = GetValue.getInputString("first name");
        String lastName = GetValue.getInputString("last name");
        String phone = GetValue.getPhone();
        String email = GetValue.getEmail();
        String address = GetValue.getInputString("address");
        String dob = GetValue.getDob();
        String sex = GetValue.getSex();
        double salary = GetValue.getSalary();
        String egency = GetValue.getInputString("egency");
        Employee employee = new Employee(id, firstName, lastName, phone, email,
                address, dob, sex, salary, egency);
        list.add(employee);// add new employee
        System.out.println("Successfully!\n");

    }

    // allow user update employees by id
    public static void updateEmployeesById(ArrayList<Employee> list) {
        System.out.println("---------Update Employee---------");
        // input id
        int id = GetValue.getInputPositiveInt("ID");
        //check employee with id existed in list 
        boolean employeeExisted = Validation.checkEmployeeExistedById(list, id);
        //update employee
        if (employeeExisted == false) {
            System.out.println("This ID not contain in System!\n");
        } else {
            System.out.println("Input new information of employee: ");
            //traverse all element of list until get obj have same id to update
            for (int i = 0; i < list.size(); i++) {
//                if (id == list.get(i).getId()) {
//                    list.remove(i);
//                    int newId = GetValue.getId(list);
//                    String firstName = GetValue.getInputString("first name");
//                    String lastName = GetValue.getInputString("last name");
//                    String phone = GetValue.getPhone();
//                    String email = GetValue.getEmail();
//                    String address = GetValue.getInputString("address");
//                    String dob = GetValue.getDob();
//                    String sex = GetValue.getSex();
//                    double salary = GetValue.getSalary();
//                    String egency = GetValue.getInputString("egency");
//                    Employee employee = new Employee(newId, firstName, lastName,
//                            phone, email, address, dob, sex, salary, egency);
//                    list.add(employee);
//                    break;
//                }
                if (id == list.get(i).getId()) {
                    int newId = GetValue.getIdUpdate(list, id);
                    String firstName = GetValue.getInputString("first name");
                    String lastName = GetValue.getInputString("last name");
                    String phone = GetValue.getPhone();
                    String email = GetValue.getEmail();
                    String address = GetValue.getInputString("address");
                    String dob = GetValue.getDob();
                    String sex = GetValue.getSex();
                    double salary = GetValue.getSalary();
                    String egency = GetValue.getInputString("egency");
                    Employee employee = new Employee(newId, firstName, lastName,
                            phone, email, address, dob, sex, salary, egency);
                    list.set(i, employee);
                    break;
                }
            }
            System.out.println("Successfully!\n");
        }
    }

    // allow user remove employee by id 
    public static void removeEmployeeById(ArrayList<Employee> list) {
        System.out.println("---------Remove Employee---------");
        // input id
        int id = GetValue.getInputPositiveInt("ID");
        //check employee with id is exited  
        boolean empolyeeExited = Validation.checkEmployeeExistedById(list, id);
        //remove employee
        if (empolyeeExited == false) {
            System.out.println("This ID not contain in System!\n");
        } else {
            //traverse to all element until get obj have same id to remove
            for (int i = 0; i < list.size(); i++) {
                if (id == list.get(i).getId()) {
                    list.remove(i);
                    break;
                }
            }
            System.out.println("Successfully!\n");
        }
    }

    // allow user to search employees by part of name
    public static void searchEmployeesByPartName(ArrayList<Employee> list) {
        ArrayList<Employee> listSearch = new ArrayList<>();
        System.out.println("---------Search Employee---------");
        // input part of name
        String partOfName = GetValue.getInputString("part of name");
        // search
        // traverse all element of list to find obj contain partOfName to add obj to listSearch
        for (int i = 0; i < list.size(); i++) {
            String firstName = list.get(i).getFirstName();
            String lastName = list.get(i).getLastName();
            if (firstName.contains(partOfName) || lastName.contains(partOfName)) {
                listSearch.add(list.get(i));
            }
        }
        // display results of search a part of name
        if (listSearch.size() == 0) {
            System.out.println("This name is not contain in system!\n");
        } else {
            String format = String.format("%-5s%-10s%-10s%-15s%-25s%-10s%-13s%-7s%-10s%-7s",
                    "ID", "FirstName", "LastName", "Phone", "Email", "Address",
                    "DOB", "Sex", "Salary", "Egency");
            System.out.println(format);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.println(listSearch.get(i));
            }
            System.out.println("");
        }
    }

    // allow user to sort employee by salary
    public static void sortEmployeesBySalary(ArrayList<Employee> list) {
        if (list.size() == 0) {
            System.out.println("System is empty!\n");
            return;
        }
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee t, Employee t1) {
                double salary1 = t.getSalary();
                double salary2 = t1.getSalary();
                if (salary1 < salary2) {
                    return -1;
                } else if (salary1 == salary2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        // display result
        String format = String.format("%-5s%-10s%-10s%-15s%-25s%-10s%-13s%-7s%-10s%-7s",
                "ID", "FirstName", "LastName", "Phone", "Email", "Address",
                "DOB", "Sex", "Salary", "Egency");
        System.out.println(format);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");
    }
}
