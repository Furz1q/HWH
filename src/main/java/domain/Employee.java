package domain;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private String department;

    public Employee(String firstName, String lastName, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }


    public String getDepartment() {
        return department;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName==null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName==null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            return other.lastName == null;
        }else return lastName.equals(other.lastName);
    }
    @Override
    public String toString(){
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
