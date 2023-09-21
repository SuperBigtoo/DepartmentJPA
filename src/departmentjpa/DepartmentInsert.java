/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentjpa;

import java.util.List;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Jason
 */
public class DepartmentInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department dpm1 = new Department("IT");
        Department dpm2 = new Department("HR");
        Employee emp1 = new Employee("John", "Network Admin", 56000, dpm1);
        Employee emp2 = new Employee("Mary", "HR Manager", 46000, dpm2);
        Employee emp3 = new Employee("Henry", "Programer", 67000, dpm1);
        Employee emp4 = new Employee("Clark", "HR recruiter", 36000, dpm2);
        
        // Insert Departments
        DepartmentTable.insertDepartment(dpm1);
        DepartmentTable.insertDepartment(dpm2);
        
        // Insert Employees
        EmployeeTable.insertEmployee(emp1);
        EmployeeTable.insertEmployee(emp2);
        EmployeeTable.insertEmployee(emp3);
        EmployeeTable.insertEmployee(emp4);
    }
}
