
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
public class Validation {

    private final static Scanner scanner = new Scanner(System.in);

    // check employee exited by id
    public static boolean checkEmployeeExistedById(ArrayList<Employee> list, int id) {
        // traverse all elements of list to check obj exist with same id
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    // check a String is have all number
    public static boolean checkStringIsANumber(String string) {
        char[] allNumber = "0123456789".toCharArray();
        char[] stringToCharArray = string.toCharArray();
        boolean check = false;
        // traverse all character in stringToCharArray to check number
        for (int i = 0; i < stringToCharArray.length; i++) {
            check = false;
            char charOfString = stringToCharArray[i];
            // traverse all element of array allNumber to check a character 
            //of stringToCharArray is number
            for (int j = 0; j < allNumber.length; j++) {
                if (charOfString == allNumber[j]) {
                    check = true;
                    break;
                }
            }
            if (check == false) { // if a element of stringToCharArray is not a number
                return false;
            }
        }
        return true;
    }

    // check valid email with format <name>@<domain>
    public static boolean checkValidEmail(String email) {
        int count = 0;
        char[] arrayCharEmail = email.toCharArray();
        // traverse all elements of toCharArrayEmail to check valid email
        for (int i = 0; i < arrayCharEmail.length; i++) {
            if (arrayCharEmail[i] == '@') {
                count = count + 1;
            }
        }
        if (count != 1) {// not have only char '@'
            return false;
        }
        // check email have 2 parts <name> and <domain> not empty
        String[] emailSplitString = email.split("@");
        if (emailSplitString.length != 2) {
            return false;
        } else {
            // if 2 parts <name> or <domain> is empty string
            if (emailSplitString[0].isEmpty() || emailSplitString[1].isEmpty()) {
                return false;
            }
            return true;
        }
    }

    public static boolean checkStringValidFormatDate(String string, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date date = dateFormat.parse(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkDateExited(String string, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkDate_1EqualOrLessThanDate_2(String date_1, String date_2, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date firstDate;
        Date secondDate;
        try {
            firstDate = dateFormat.parse(date_1);
            secondDate = dateFormat.parse(date_2);
            if (firstDate.compareTo(secondDate) <= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
