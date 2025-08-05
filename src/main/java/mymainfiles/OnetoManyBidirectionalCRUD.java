package mymainfiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.CustomerBidirectionalPOJO;
import mypojos.VendorBidirectionalPOJO;

public class OnetoManyBidirectionalCRUD {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("wiprohibernate.cfg.xml");
        @SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        VendorBidirectionalPOJO v = new VendorBidirectionalPOJO();
        v.setVendorno(1001);
        v.setVendorName("Samsung");

        CustomerBidirectionalPOJO c1 = new CustomerBidirectionalPOJO();
        c1.setCustomerName("John");

        CustomerBidirectionalPOJO c2 = new CustomerBidirectionalPOJO();
        c2.setCustomerName("Alice");

        // Bidirectional linking
        v.addCustomer(c1);
        v.addCustomer(c2);

        session.save(v); // customers saved via cascade

        tx.commit();
        session.close();
        sf.close();

        System.out.println("Bidirectional OneToMany inserted successfully.");
    }
}
