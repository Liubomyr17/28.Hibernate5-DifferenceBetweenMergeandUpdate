package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MergeDataClientTest {

    public static void main(String[] args) {
        Employee employee1 = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee1 = session.get(Employee.class, 1);
            System.out.println(employee1);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        employee1.setSalary(75000.00);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Employee employee2 = session.get(Employee.class, 1);
            session.merge(employee1);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}


