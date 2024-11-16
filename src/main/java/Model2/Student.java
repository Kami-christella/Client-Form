package Model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")

public class Student {

	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
	    protected int id;
	 
	    @Column(name="name")
	    protected String name;
	 
	    @Column(name="country")
	    protected String country;
	 
	   
	 
	    public Student() {
	    }
	 
	    public Student(String name,String country) {
	        super();
	        this.name = name;
	        this.country = country;
	    }

	    public Student(int id, String name, String country) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.country = country;
	    }

//		public static void updateStudent(Student user) {
//			// TODO Auto-generated method stub
//			
//		}
}
