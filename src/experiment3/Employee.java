package experiment3;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }

    void calculateSalary() {
        System.out.println("Salary: " + salary);
    }

    void calculateSalary(double bonus) {
        System.out.println("Salary with Bonus: " + (salary + bonus));
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

class employeems {   // corrected class name spelling
    public static void main(String[] args) {

        Employee emp = new Employee("Aditya", 15, 45000);
        Manager mgr = new Manager("Jivan", 11, 65000, "IT");

        System.out.println("Employee Details:");
        emp.display();
        emp.calculateSalary();
        emp.calculateSalary(2000);

        System.out.println("\nManager Details:");
        mgr.display();
        mgr.calculateSalary(5000);
    }
}