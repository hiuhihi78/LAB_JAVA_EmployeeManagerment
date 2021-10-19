
import java.util.ArrayList;
import static java.util.Collections.list;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hiuhihi78
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();;
        int choice = 0;
        //loop until user input number  6
        while (true) {
            // show menu and choice option
            Manager.displayMenu();
            choice = GetValue.getNumberInRange(1, 6, "choice");
            switch (choice) {
                case 1:
                    Manager.addEmployees(list);
                    break;
                case 2:
                    Manager.updateEmployeesById(list);
                    break;
                case 3:
                    Manager.removeEmployeeById(list);
                    break;
                case 4:
                    Manager.searchEmployeesByPartName(list);
                    break;
                case 5:
                    Manager.sortEmployeesBySalary(list);
                    break;
                case 6:
                    //System.exit(0);
                    break;

            }
        }
    }

}
