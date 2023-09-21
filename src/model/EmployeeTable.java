/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jason
 */
public class EmployeeTable {
    
    public static void insertEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Employee fromDb = em.find(Employee.class, emp.getEmployeeid());
        fromDb.setEmployeeid(emp.getEmployeeid());
        fromDb.setName(emp.getName());
        fromDb.setJob(emp.getJob());
        fromDb.setSalary(emp.getSalary());
        fromDb.setDepartmentid(emp.getDepartmentid());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void removeEmployee(Employee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Employee fromDb = em.find(Employee.class, emp.getEmployeeid());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }    
    }
    
    public static List<Employee> findAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> empList = (List<Employee>)em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        return empList;
    }
    
    public static List<Employee> findEmployeeById(Integer employeeid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Employee.findByEmployeeid");
        query.setParameter("employeeid", employeeid);
        List<Employee> empList = (List<Employee>) query.getResultList();
        em.close();
        return empList;
    }
    
    public static List<Employee> findEmployeeByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Employee.findByName");
        query.setParameter("name", name);
        List<Employee> empList = (List<Employee>) query.getResultList();
        em.close();
        return empList;
    }
}
