/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinventoryconsoleapp;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Administrator
 */
public class StudentInventoryConsoleApp {

    /**
     * 
     * @param args the command line arguments
     */
    
    
    Configuration cfg;
    ServiceRegistry sr;
    
   SessionFactory sf;
    Session session;
    Student std;
    Scanner input;

    public StudentInventoryConsoleApp() {
        cfg = new Configuration()
              .configure();
        sr = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties())
                        .build();
        sf = cfg.buildSessionFactory(sr);
        input = new Scanner(System.in);  
        std = new Student();
    }
    
    public static void main(String[] args) {
        StudentInventoryConsoleApp sica = new StudentInventoryConsoleApp();
        sica.displayMenu();
    }
   
    public void displayMenu() {
        int option;
        while(true) {
            System.out.println("\nStudent Inventory");
            System.out.println("=================");
            System.out.println("1. Register a new student");
            System.out.println("2. View a Student record");
            System.out.print("What do you want to do? (1/2): ");

            option = input.nextInt();

            switch(option) {
                case 1:
                    saveStudent();
                    break;
                case 2:
                    
                    break; 
                default:
                    System.out.println("Invalid Entry!");
            }
            
            System.out.print("More operations? (y/n): ");
            if( !input.next().contains("y") ) 
                break;
        }
    } 
    
    public void saveStudent() {
        System.out.println("\nEnter the student's details");
        System.out.print("Student ID: ");
        std.setId( input.nextInt() );
        System.out.print("First Name: ");
        std.setFirst_name( input.next() );
        System.out.print("Last Name: ");
        std.setLast_name( input.next() );
        System.out.print("Course: ");
        std.setCourse( input.next() );
        
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(std);
        tx.commit();
        
        System.out.println("Record saved successfully.");         
        
        session.close();
    }
}
