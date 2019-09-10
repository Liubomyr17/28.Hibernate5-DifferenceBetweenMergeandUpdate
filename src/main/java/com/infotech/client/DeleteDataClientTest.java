package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DeleteDataClientTest {
    public static void main(String[] args) {
        deleteEmployeeById();

    }

    private static void deleteEmployeeById() {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 2);
            if(employee!= null){
                session.beginTransaction();
                session.delete(employee);
                session.getTransaction().commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

}