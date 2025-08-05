package mymainfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.CustomerPojo;
import mypojos.VendorPOJO;

/*
 * mysql> select * from wipro_hib_vendor;
+----------+-----------------+-----------------+
| vendorno | vendoremail     | vendorname      |
+----------+-----------------+-----------------+
|      100 | zoho@gmail.com  | ZOHOCORPORATION |
|      800 | wipro@gmail.com | WIPRO           |
+----------+-----------------+-----------------+
2 rows in set (0.00 sec)

mysql> select * from wipro_hib_customers;
+------------+--------------+--------------+
| customerid | customername | vendorfor_id |
+------------+--------------+--------------+
|         10 | Devika       |          100 |
|         11 | Abinaya      |          100 |
|         12 | Thanu        |          100 |
|        100 | Kanishka     |          800 |
|        103 | Sai          |          800 |
+------------+--------------+--------------+
5 rows in set (0.00 sec)

AFTER DELETE:

mysql> select * from wipro_hib_vendor;
+----------+-----------------+------------+
| vendorno | vendoremail     | vendorname |
+----------+-----------------+------------+
|      800 | wipro@gmail.com | WIPRO      |
+----------+-----------------+------------+
1 row in set (0.00 sec)

mysql> select * from wipro_hib_customers;
+------------+--------------+--------------+
| customerid | customername | vendorfor_id |
+------------+--------------+--------------+
|        100 | Kanishka     |          800 |
|        103 | Sai          |          800 |
+------------+--------------+--------------+
2 rows in set (0.00 sec)
 */
public class OnetoManyRelationShipCRUD {
	static Scanner sc = new Scanner(System.in);
    @SuppressWarnings("deprecation")
	static SessionFactory factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- VENDOR-CUSTOMER MENU ---");
            System.out.println("1. Add Vendor with Customers");
            System.out.println("2. View All Vendors");
            System.out.println("3. Update Vendor");
            System.out.println("4. Delete Vendor");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
            case 1 : addVendor();break;
            case 2 : viewAll();break;
            case 3 : updateVendor();break;
            case 4 : deleteVendor();break;
            case 0 : System.out.println("Exiting...");break;
            default :System.out.println("Invalid choice.");
        }
    } while (choice != 0);
    factory.close();
}
    public static void addVendor() 
    {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        VendorPOJO vendor = new VendorPOJO();
        System.out.print("Enter vendor ID: ");
        vendor.setVid1(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter vendor name: ");
        vendor.setVname1(sc.nextLine());
        sc.nextLine();        
        System.out.print("Enter vendor email: ");
        vendor.setVemail(sc.nextLine());

        List<CustomerPojo> list = new ArrayList<>();
        System.out.print("How many customers? ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) 
        {
        	CustomerPojo c = new CustomerPojo();
            System.out.print("Enter customer ID: ");
            c.setCustid(sc.nextInt());
            sc.nextLine();        
            System.out.print("Enter customer name: ");
            c.setCustname(sc.nextLine());
            list.add(c);//customers to be added in arraylist
        }
            vendor.setCustomers(list);//One to many:: One vendor many customers!
            session.persist(vendor);//Iam persisting vendor object, but customer object will also be persisted by default!
            //session.save(vendor);//Iam saving vendor object, but customer object will also be persisted by default!

            tx.commit();
            session.close();
            System.out.println("Vendor and customers saved successfully.");
        }

        @SuppressWarnings("unchecked")
		public static void viewAll() {
            Session session = factory.openSession();
            session.clear();
            List<VendorPOJO> list = session.createQuery("from VendorPOJO").list();//HQL COMMAND
            for (VendorPOJO v : list) {
                System.out.println("\nVendor ID: " +v.getVid1());
                System.out.println("Vendor Name: " + v.getVname1());
                System.out.println("Vendor Email: " + v.getVemail());
                
                System.out.println("Customers:");
                for (CustomerPojo c : v.getCustomers()) {
                    System.out.println("  - " + c.getCustid()+ " : " + c.getCustname());
                }
            }

            session.close();
        }
        
        public static void updateVendor() {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            System.out.print("Enter vendor ID to update: ");
            int id = sc.nextInt();

            VendorPOJO v =(VendorPOJO) session.get(VendorPOJO.class, id);//select * from tablename where eno=?
            if (v != null) 
            {
                System.out.print("Enter new vendor name: ");
                v.setVname1(sc.next());

                // Optionally update customer names
                for (CustomerPojo c : v.getCustomers()) {
                    System.out.print("Update name for customer ID " + c.getCustid() + " (current: " + c.getCustname() + "): ");
                    c.setCustname(sc.next());
                }

                session.update(v);//update operation
                tx.commit();
                System.out.println("Vendor updated.");
            } else {
                System.out.println("Vendor ID not found.");
            }

            session.close();
        }

        public static void deleteVendor() {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            System.out.print("Enter vendor ID to delete: ");
            int id = sc.nextInt();
            VendorPOJO v =(VendorPOJO) session.get(VendorPOJO.class, id);

            if (v != null) {
                session.delete(v); // Will also delete all customers (cascade)
                tx.commit();
                System.out.println("Vendor and associated customers deleted.");
            } else {
                System.out.println("Vendor not found.");
            }

            session.close();
        }

    }
	


/*
Jul 30, 2025 10:47:16 AM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {4.0.4.Final}
Jul 30, 2025 10:47:17 AM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate Core {4.3.5.Final}
Jul 30, 2025 10:47:17 AM org.hibernate.cfg.Environment <clinit>
INFO: HHH000206: hibernate.properties not found
Jul 30, 2025 10:47:17 AM org.hibernate.cfg.Environment buildBytecodeProvider
INFO: HHH000021: Bytecode provider name : javassist
Jul 30, 2025 10:47:17 AM org.hibernate.cfg.Configuration configure
INFO: HHH000043: Configuring from resource: wiprohibernate.cfg.xml
Jul 30, 2025 10:47:17 AM org.hibernate.cfg.Configuration getConfigurationInputStream
INFO: HHH000040: Configuration resource: wiprohibernate.cfg.xml
Jul 30, 2025 10:47:17 AM org.hibernate.cfg.Configuration doConfigure
INFO: HHH000041: Configured SessionFactory: null
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH000402: Using Hibernate built-in connection pool (not for production use!)
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000401: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/wipro2025]
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000046: Connection properties: {user=root, password=****, autocommit=true}
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH000006: Autocommit mode: true
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Jul 30, 2025 10:47:17 AM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
Jul 30, 2025 10:47:17 AM org.hibernate.engine.jdbc.internal.LobCreatorBuilder useContextualLobCreation
INFO: HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
Jul 30, 2025 10:47:18 AM org.hibernate.engine.transaction.internal.TransactionFactoryInitiator initiateService
INFO: HHH000399: Using default transaction strategy (direct JDBC transactions)
Jul 30, 2025 10:47:18 AM org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory <init>
INFO: HHH000397: Using ASTQueryTranslatorFactory
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000228: Running hbm2ddl schema update
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000102: Fetching database metadata
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000396: Updating schema
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_customers
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_vendor
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.TableMetadata <init>
INFO: HHH000261: Table found: wipro2025.wipro_hibernate_students
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.TableMetadata <init>
INFO: HHH000037: Columns: [stud_name, id, email]
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.TableMetadata <init>
INFO: HHH000108: Foreign keys: []
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.TableMetadata <init>
INFO: HHH000126: Indexes: [primary]
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_customers
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_vendor
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_customers
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: wipro_hib_vendor
Jul 30, 2025 10:47:21 AM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000232: Schema update complete

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 1
Enter vendor ID: 100
Enter vendor name: ZOHO

Enter vendor email: zoho@gmail.com
How many customers? 3
Enter customer ID: 10
Enter customer name: Devi
Enter customer ID: 11
Enter customer name: Abi
Enter customer ID: 12
Enter customer name: Thananya
Hibernate: insert into wipro_hib_vendor (vendoremail, vendorname, vendorno) values (?, ?, ?)
Hibernate: insert into wipro_hib_customers (customername, customerid) values (?, ?)
Hibernate: insert into wipro_hib_customers (customername, customerid) values (?, ?)
Hibernate: insert into wipro_hib_customers (customername, customerid) values (?, ?)
Hibernate: update wipro_hib_customers set vendorfor_id=? where customerid=?
Hibernate: update wipro_hib_customers set vendorfor_id=? where customerid=?
Hibernate: update wipro_hib_customers set vendorfor_id=? where customerid=?
Vendor and customers saved successfully.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

Vendor ID: 100
Vendor Name: ZOHO
Vendor Email: zoho@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 10 : Devi
  - 11 : Abi
  - 12 : Thananya

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 3
Enter vendor ID to update: 100
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_0_, vendorpojo0_.vendoremail as vendorem2_1_0_, vendorpojo0_.vendorname as vendorna3_1_0_ from wipro_hib_vendor vendorpojo0_ where vendorpojo0_.vendorno=?
Enter new vendor name: ZOHOCORPORATION
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
Update name for customer ID 10 (current: Devi): Devika
Update name for customer ID 11 (current: Abi): Abinaya
Update name for customer ID 12 (current: Thananya): Thanu
Hibernate: update wipro_hib_vendor set vendoremail=?, vendorname=? where vendorno=?
Hibernate: update wipro_hib_customers set customername=? where customerid=?
Hibernate: update wipro_hib_customers set customername=? where customerid=?
Hibernate: update wipro_hib_customers set customername=? where customerid=?
Vendor updated.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 3
Enter vendor ID to update: 2329
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_0_, vendorpojo0_.vendoremail as vendorem2_1_0_, vendorpojo0_.vendorname as vendorna3_1_0_ from wipro_hib_vendor vendorpojo0_ where vendorpojo0_.vendorno=?
Vendor ID not found.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 4
Enter vendor ID to delete: 888
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_0_, vendorpojo0_.vendoremail as vendorem2_1_0_, vendorpojo0_.vendorname as vendorna3_1_0_ from wipro_hib_vendor vendorpojo0_ where vendorpojo0_.vendorno=?
Vendor not found.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 1
Enter vendor ID: 800
Enter vendor name: WIPRO

Enter vendor email: wipro@gmail.com
How many customers? 2
Enter customer ID: 100
Enter customer name: Kanishka
Enter customer ID: 103
Enter customer name: Sai
Hibernate: insert into wipro_hib_vendor (vendoremail, vendorname, vendorno) values (?, ?, ?)
Hibernate: insert into wipro_hib_customers (customername, customerid) values (?, ?)
Hibernate: insert into wipro_hib_customers (customername, customerid) values (?, ?)
Hibernate: update wipro_hib_customers set vendorfor_id=? where customerid=?
Hibernate: update wipro_hib_customers set vendorfor_id=? where customerid=?
Vendor and customers saved successfully.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

Vendor ID: 100
Vendor Name: ZOHOCORPORATION
Vendor Email: zoho@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 10 : Devika
  - 11 : Abinaya
  - 12 : Thanu

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

Vendor ID: 100
Vendor Name: ZOHOCORPORATION
Vendor Email: zoho@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 10 : Devika
  - 11 : Abinaya
  - 12 : Thanu

Vendor ID: 800
Vendor Name: WIPRO
Vendor Email: wipro@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 100 : Kanishka
  - 103 : Sai

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 4
Enter vendor ID to delete: 100
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_0_, vendorpojo0_.vendoremail as vendorem2_1_0_, vendorpojo0_.vendorname as vendorna3_1_0_ from wipro_hib_vendor vendorpojo0_ where vendorpojo0_.vendorno=?
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
Hibernate: update wipro_hib_customers set vendorfor_id=null where vendorfor_id=?
Hibernate: delete from wipro_hib_customers where customerid=?
Hibernate: delete from wipro_hib_customers where customerid=?
Hibernate: delete from wipro_hib_customers where customerid=?
Hibernate: delete from wipro_hib_vendor where vendorno=?
Vendor and associated customers deleted.

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

Vendor ID: 100
Vendor Name: ZOHOCORPORATION
Vendor Email: zoho@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 10 : Devika
  - 11 : Abinaya
  - 12 : Thanu

Vendor ID: 800
Vendor Name: WIPRO
Vendor Email: wipro@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 100 : Kanishka
  - 103 : Sai

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 2
Hibernate: select vendorpojo0_.vendorno as vendorno1_1_, vendorpojo0_.vendoremail as vendorem2_1_, vendorpojo0_.vendorname as vendorna3_1_ from wipro_hib_vendor vendorpojo0_

Vendor ID: 800
Vendor Name: WIPRO
Vendor Email: wipro@gmail.com
Customers:
Hibernate: select customers0_.vendorfor_id as vendorfo3_1_0_, customers0_.customerid as customer1_0_0_, customers0_.customerid as customer1_0_1_, customers0_.customername as customer2_0_1_ from wipro_hib_customers customers0_ where customers0_.vendorfor_id=?
  - 100 : Kanishka
  - 103 : Sai

--- VENDOR-CUSTOMER MENU ---
1. Add Vendor with Customers
2. View All Vendors
3. Update Vendor
4. Delete Vendor
0. Exit
Enter choice: 0
Exiting...
Jul 30, 2025 11:03:32 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
INFO: HHH000030: Cleaning up connection pool [jdbc:mysql://localhost:3306/wipro2025]
*/