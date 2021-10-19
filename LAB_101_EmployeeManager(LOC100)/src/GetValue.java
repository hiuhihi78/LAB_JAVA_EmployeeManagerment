
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hiuhihi78
 */
public class GetValue {

    private final static Scanner scanner = new Scanner(System.in);

    // get a number in a range
    public static int getNumberInRange(int from, int to, String msg) {
        int result = 0;
        // loop until user input correct
        while (true) {
            result = getInputPositiveInt(msg);
            if (result < from || result > to) {
                System.err.println("Invalid of " + msg + "!Please enter a number from "
                        + from + " to " + to + "!");
                continue;
            } else {
                return result;
            }
        }
    }

    // get input by user return String value
    public static String getInputString(String msg) {
        String result = null;
        // loop until user input correct
        while (true) {
            System.out.print("Enter " + msg + ": ");
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Invalid of " + msg + ", " + msg + " must not be empty!");
            } else {
                return result;
            }
        }
    }

    // get input by user return positive int 
    public static int getInputPositiveInt(String msg) {
        int result = 0;
        // loop until user input correct
        while (true) {
            try {
                String input = getInputString(msg);
                result = Integer.parseInt(input);
                if (result < 0) {
                    System.err.println("Invalid of " + msg + ", " + msg
                            + " must be positive number!");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.err.println("Invalid of " + msg + ", " + msg
                        + " must be a number!");
            }
        }
    }

    // get ID is unique in list
    public static int getId(ArrayList<Employee> list) {
        int id = 0;
        // loop until get valid id
        while (true) {
            id = getInputPositiveInt("ID");
            boolean idExited = Validation.checkEmployeeExistedById(list, id);
            if (idExited == true) {
                System.err.println("This ID was exited!");
                continue;
            } else if (id <= 0) {
                System.err.println("Invalid of ID! ID must be positive number!");
            } else {
                return id;
            }
        }
    }

    // get Phone number by user
    public static String getPhone() {
        String phone = null;
        boolean validPhone = false;
        // loop until user input correct
        while (true) {
            phone = getInputString("phone");
            validPhone = Validation.checkStringIsANumber(phone);// check phone is a number
            if (validPhone == true) {
                if (phone.length() != 10) {
                    System.err.println("Invalid of Phone! Phone number must be a 10 digits!");
                    continue;
                } else {
                    return phone;
                }
            } else {
                System.err.println("Invalid of Phone! Phone must be a number!");
                continue;
            }
        }
    }

    // get email by user
    public static String getEmail() {
        String email = null;
        // loop until get correct email
        while (true) {
            email = getInputString("Email");
            boolean validEmail = Validation.checkValidEmail(email);// check valid email
            if (validEmail == false) {
                System.err.println("Invalid of email! Email must be format <name>@<domain>!");
                continue;
            } else {
                return email;
            }
        }
    }

    // get dob by user
//    public static String getDob() {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String currentDate = formatter.format(date);
//        boolean isDate = false;
//        boolean inputDateLessThanCurrentDate = false;
//        // loop until user input correct
//        while (true) {
//            String result = getInputString("DOB");
//            isDate = Validation.checkStringDate(result);
//            // check input is valid date with format dd/MM/yyyy and less than current date
//            if (isDate == true) {
//                // check date less than current date
//                inputDateLessThanCurrentDate
//                        = Validation.checkDate_1LessThanDate_2(result, currentDate);
//                if (inputDateLessThanCurrentDate == false) {
//                    System.err.println("Date of birth must less than or equal to current date "
//                            + currentDate + "!");
//                    continue;
//                }
//                return result;
//            } else {
//                System.err.println("Invalid of date!Date must be format dd/MM/yyyy!");
//            }
//        }
//    }
    // get dob by user
    public static String getDob() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(date);
        // loop until user input correct
        while (true) {
            String dob = getInputString("DOB");
            // check valid format
            boolean validFormat = Validation.checkStringValidFormatDate(dob, "dd/MM/yyyy");
            // check date exited
            boolean dateExited = Validation.checkDateExited(dob, "dd/MM/yyyy");
            // check date lessthan current date
            boolean dateEqualOrLessThanCurrentDate = Validation.checkDate_1EqualOrLessThanDate_2(dob, currentDate, "dd/MM/yyyy");
            if (validFormat == true && dateExited == true && dateEqualOrLessThanCurrentDate == true) {
                return dob;
            } else if (validFormat == false) {
                System.err.println("Invalid of DOB, DOB must be follow format dd/MM/yyyy");
                continue;
            } else if (dateExited == false) {
                System.err.println("Invalid of DOB, DOB must be a date exited!");
                continue;
            } else if (dateEqualOrLessThanCurrentDate == false) {
                System.err.println("Invalid of DOB, DOB must be equal or less than "
                        + "current date " + currentDate + "!");
                continue;
            }
        }
    }

    // get Sex by user
    public static String getSex() {
        String sex = null;
        // loop until user input correct
        while (true) {
            sex = getInputString("Sex");
            if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")) {
                return sex;
            } else {
                System.err.println("Invalid of Sex! Please enter male or female!");
                continue;
            }
        }
    }

    // get salary by user
    public static double getSalary() {
        double result = 0;
        // loop until get valid salary
        while (true) {
            try {
                String input = getInputString("Salary");
                result = Double.parseDouble(input);
                if (result < 0) {
                    System.err.println("Invalid of salary, salary must be equal or greater than 0!");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Invalid of salary! salary must be a number!");
            }
        }
    }


    public static int getIdUpdate(ArrayList<Employee> list, int id) {
        // loop until user input correct
        while (true) {
            int idUpdate = getInputPositiveInt("ID");
            if (idUpdate == id) {  // input old id
                return idUpdate;
            }
            //  input new id
            boolean employeeExisted = Validation.checkEmployeeExistedById(list, idUpdate);
            if(employeeExisted == true){  
                System.err.println("Invalid of ID, ID was existed!");
                continue;
            }else{
                return idUpdate;
            }
        }
    }
}
