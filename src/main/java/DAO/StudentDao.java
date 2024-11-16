package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import Model2.Student;
import Hutil.HibernateUtilConf;

public class StudentDao {

	
	public void saveStudent(Student student) {
		   Transaction transaction = null;
	        try (Session session = HibernateUtilConf.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(student);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
    }

    /**
     * Update Student
     * @param Student
     */
    public void updateStudent(Student student) {
    	  Transaction transaction = null;
          try (Session session = HibernateUtilConf.getSessionFactory().openSession()) {
              // start a transaction
              transaction = session.beginTransaction();
              // save the student object
              session.update(student);
              // commit transaction
              transaction.commit();
          } catch (Exception e) {
              if (transaction != null) {
                  transaction.rollback();
              }
              e.printStackTrace();
          }
    }

    /**
     * Delete Student
     * @param id
     */
    public void deleteStudent(int id) {

    	 Transaction transaction = null;
         try (Session session = HibernateUtilConf.getSessionFactory().openSession()) {
             // start a transaction
             transaction = session.beginTransaction();

             // Delete a user object
             Student student = session.get(Student.class, id);
             if (student != null) {
                 session.delete(student);
                 System.out.println("Student is deleted");
             }

             // commit transaction
             transaction.commit();
         } catch (Exception e) {
             if (transaction != null) {
                 transaction.rollback();
             }
             e.printStackTrace();
         }
    }

    /**
     * Get Student By ID
     * @param id
     * @return
     */
    public Student getStudent(int id) {

    	 Transaction transaction = null;
         Student student = null;
         try (Session session = HibernateUtilConf.getSessionFactory().openSession()) {
             // start a transaction
             transaction = session.beginTransaction();
             // get an user object
             student = session.get(Student.class, id);
             // commit transaction
             transaction.commit();
         } catch (Exception e) {
             if (transaction != null) {
                 transaction.rollback();
             }
             e.printStackTrace();
         }
         return student;
    }
    public List < Student > getAllStudents() {

    	 Transaction transaction = null;
         List < Student > listOfUser = null;
         try (Session session = HibernateUtilConf.getSessionFactory().openSession()) {
             // start a transaction
             transaction = session.beginTransaction();
             // get an user object

             listOfUser = session.createQuery("from student").getResultList();

             // commit transaction
             transaction.commit();
         } catch (Exception e) {
             if (transaction != null) {
                 transaction.rollback();
             }
             e.printStackTrace();
         }
         return listOfUser;
    }
}
