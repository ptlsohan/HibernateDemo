package com.config;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import com.dto.Address;
import com.dto.Department;
import com.dto.Student;

public class Main {
	
	static SessionFactory sf;
	static{
		Configuration cfg=new Configuration().addPackage("com.java.dto");
		cfg.setProperty(Environment.HBM2DDL_AUTO,"create");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Department.class);
		cfg.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
		cfg.setProperty("hibernate.connection.username","root");
		cfg.setProperty("hibernate.connection.password","Qwertyuiop1942");
		cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/myDB?autoReconnect=true&useSSL=false");
	//	cfg.setProperty("hibernate.cache.use_query_cache","true");
		cfg.setProperty(Environment.SHOW_SQL,"true");
			StandardServiceRegistryBuilder rb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		 sf = cfg.buildSessionFactory(rb.build());

		
		}
	
	public static void main(String[] args) {
		
		insertStudent();
		//getStudent();
		getAllStudents();
		sf.close();
	}
public static void insertStudent() {
		
		Session session = sf.openSession();
		Address a1= new Address();
		a1.setCity("ccc");
		Address a2= new Address();
		a2.setCity("dfdg");
		List<Address> li = new ArrayList<Address>();
		li.add(a1);
		li.add(a2);
		Transaction tx = session.beginTransaction();
	
		Department d = new Department();
		d.setDeptId(11);
		d.setName("cs");
		Student student = new Student(3,"sohan","ny",d);
		student.setDept(d);
		student.setList(li);
		//d.setStudent(student);
		session.save(d);
		session.save(student);
		
		tx.commit();
		session.close();
		
	}

public static void getAllStudents() {
Session s= sf.openSession();
CriteriaBuilder cb=s.getCriteriaBuilder();
CriteriaQuery<Student> cq=cb.createQuery(Student.class);

Root<Department> st=cq.from(Department.class);
cq.where(cb.equal(st.get("deptId"),11));
cq.multiselect(st.get("student"));
List<Student> list=s.createQuery(cq).list();
//List<Student> list=s.createQuery(cq).list();
System.out.println(list);
s.close();
}

public static void getStudent() {
	
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	//Student student = new Student(1,"sohan","ny");
	Student student = new Student(3,"sohan","ny",null);
	//Student student=session.get(Student.class, 3);
	session.delete(student);
	//student.setName("qwew");
//	Object st=(Student)session.createQuery("from Student where name='sohan'").getSingleResult();
	
//	Query<Student> query=session.createQuery("from student where id= 1");
//	query.setCacheable(true);
//	Student st=query.uniqueResult();
//	
//	Query<Student> query1=session.createQuery("from student where id= 1");
//	query.setCacheable(true);
//	Student st1=query1.uniqueResult();
//	
//	System.out.println(st);
	tx.commit();
	
	session.close();
	
	
	
	
}
	
	
}
