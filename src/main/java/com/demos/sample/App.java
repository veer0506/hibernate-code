package com.demos.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import com.demos.sample.entity.Author;

public class App {
	static App a = new App();

	public Session common() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Author.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		return session;
	}

	public void addData(Author author) {
		Session s = a.common();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.save(author);
			t.commit();
			System.out.println("susscessfully added");
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
		}

		finally {
			s.close();
		}
	}

	public void updateData(int id) {
		Session s = a.common();
		Transaction t = null;
		try {

			t = s.beginTransaction();
			Author auth = s.get(Author.class, id);
			Scanner ac = new Scanner(System.in);
			if (auth != null) {
				System.out.println("upate your data");
				System.out.println("update first name");
				auth.setFirstName(ac.next());
				System.out.println("update Book");
				auth.setBook(ac.next());
				System.out.println("update phone No.");
				auth.setPhoneNo(ac.nextLong());

				s.update(auth);
				t.commit();
			} else {
				System.out.println("Id is not avalaible");
			}
		} catch (HibernateException e) {
			System.out.println(e);
			if (t != null) {
				t.rollback();
			}
		} finally {
			s.close();
		}

	}

	public void deleteData(int id) {
		Session session = a.common();
		Transaction t = null;
		t = session.beginTransaction();
		Author auth = session.get(Author.class, id);
		try {
			if (auth != null) {

				session.remove(auth);
				System.out.println("sucessfully deleted");
				t.commit();
			} else {
				System.out.println("id not there");
			}
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
		} finally {
			session.close();
		}

	}

	
	  public void getData() {
		  Session s=a.common();
		  Transaction t=null;
		 t=s.beginTransaction();
		  try {
			  Query q= s.createQuery("from Author");
			  List<Author> list=q.getResultList();
			  for(Author auth:list) {
				  System.out.println(auth);
			  }
			  t.commit();
		  }
		  catch(HibernateException e){
			 System.out.println(e);
		  }
		  finally {
			  s.close();
		  }
	  
	  }
	  
		/*
		 * public Author getDataById() {
		 * 
		 * }
		 */
	 
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Author auth = new Author("shubham", "wrist", 768765L);

		// a.addData(auth);
		// a.updateData(1);
		//a.deleteData(50);
		a.getData();

		// Consider not setting the ID if using auto-generation

		/*
		 * Transaction t = null; try { t = session.beginTransaction(); Author a = new
		 * Author( "veer", "question", 768765L); session.persist(a); // Use save or
		 * persist based on your needs t.commit(); } catch (HibernateException e) { if
		 * (t != null) t.rollback(); // Rollback if there's an error
		 * e.printStackTrace(); } finally { session.close(); // Ensure session is closed
		 * }
		 */
	}
}
