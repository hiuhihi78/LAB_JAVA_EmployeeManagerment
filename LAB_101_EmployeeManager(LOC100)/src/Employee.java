/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dob; //date of birth
    private String sex;
    private double salary;
    private String egency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, 
            String email, String address, String dob, String sex, double salary,
            String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }


//    String format = String.format("%-%-5s%-10s%-10s%-15s%-25s%-10s%-13s%-7s%-10s%-7s",
//                "ID","FirstName","LastName","Phone","Email","Address","DOB","Salary","Egency");
    @Override
    public String toString() {
        String format = String.format("%-5d%-10s%-10s%-15s%-25s%-10s%-13s%-7s%-10.1f%-7s",
                id, firstName, lastName, phone, email, address, dob, sex, salary, egency);
        return format;
    }
}
