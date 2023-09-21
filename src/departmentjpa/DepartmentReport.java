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
public class DepartmentReport {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Employee> empList = EmployeeTable.findAllEmployee();
        List<Department> dpmList = DepartmentTable.findAllDepartment();
        
        System.out.println("All Employee by ID");
        System.out.println("-------------------");
        for (Employee emp : empList) {
           System.out.println("ID: " + emp.getEmployeeid());
           System.out.println("Name: " + emp.getName());
           System.out.println("Job: " + emp.getJob());
           System.out.println("Salary: " + emp.getSalary());
           System.out.println("Department: " + emp.getDepartmentid().getDepartmentid());
           System.out.println("-------------------");
        }
        
        System.out.println("All Employee by Department");
        System.out.println("-------------------");
        for (Department dpm : dpmList) {
           System.out.println("Department ID: " + dpm.getDepartmentid() + " Department Name: " + dpm.getName());
           System.out.println("-------------------");
           for (Employee emp : dpm.getEmployeeCollection()) {
              System.out.println("ID: " + emp.getEmployeeid());
              System.out.println("Name: " + emp.getName());
              System.out.println("Job: " + emp.getJob());
              System.out.println("Salary: " + emp.getSalary());
              System.out.println("-------------------");
           }
        }
    }
}
