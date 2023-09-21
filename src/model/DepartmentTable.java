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
public class DepartmentTable {
    
    public static void insertDepartment(Department dpm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(dpm);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateDepartment(Department dpm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dpm.getDepartmentid());
        fromDb.setDepartmentid(dpm.getDepartmentid());
        fromDb.setName(dpm.getName());
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
    
    public static void removeDepartment(Department dpm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dpm.getDepartmentid());
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
    
    public static List<Department> findAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Department> dpmList = (List<Department>)em.createNamedQuery("Department.findAll").getResultList();
        em.close();
        return dpmList;
    }
    
    public static List<Department> findDepartmentById(Integer departmentid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByDepartmentid");
        query.setParameter("departmentid", departmentid);
        List<Department> dpmList = (List<Department>) query.getResultList();
        em.close();
        return dpmList;
    }
    
    public static List<Department> findDepartmentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> dpmList = (List<Department>) query.getResultList();
        em.close();
        return dpmList;
    }
}
