package Model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Courses")

public class Courses {

	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
	    protected int id;
	 
	    @Column(name="cname")
	    protected String cname;
	 
	    @Column(name="lecturer")
	    protected String lecturer;
	 
	   
	 
	    public Courses() {
	    }
	 
	    public Courses(String cname,String lecturer) {
	        super();
	        this.lecturer = lecturer;
	        this.cname = cname;
	    }

	    public Courses(int id, String cname, String lecturer) {
	        super();
	        this.id = id;
	        this.cname = cname;
	        this.lecturer = lecturer;
	    }
}
