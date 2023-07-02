package studentinventoryconsoleapp;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author MURITALA Muideen Agunbiade
 */

@Entity
public class Student implements Serializable {
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String course;  
    
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    } 
    
    public void saveStudent() {
        Configuration cfg = new Configuration()
                            .configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder()
                            .applySettings(cfg.getProperties())
                            .build();
        SessionFactory sf = cfg.buildSessionFactory(sr);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Student std = new Student();
        std.setId(2023002);
        std.setFirst_name("Nuhu");
        std.setLast_name("AbdulAzeez");
        std.setCourse("MMS");
        
        tx.commit();
        
        session.close();
        sf.close();
        System.out.println("I was here.");
    }
}
