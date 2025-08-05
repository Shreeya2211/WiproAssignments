package myservletdemos;

//MODEL CLASS OR JAVA BEAN CLASS OR POJO CLASS

/*
 * mysql> create table students(id int auto_increment primary key,name varchar(20),email varchar(20));
Query OK, 0 rows affected (0.04 sec)

mysql> select * from students
    -> ;
+----+--------+---------------+
| id | name   | email         |
+----+--------+---------------+
|  2 | Harini | hhh@gmail.com |
+----+--------+---------------+
1 row in set (0.01 sec)

mysql> select * from students;
+----+----------+---------------+
| id | name     | email         |
+----+----------+---------------+
|  4 | Thananya | ggg@gmail.com |
|  6 | Sai      | sai@gmail.com |
|  7 | Yamini   | xxx@gmail.com |
+----+----------+---------------+
3 rows in set (0.01 sec)

mysql> desc students;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| id    | int(11)     | NO   | PRI | NULL    | auto_increment |
| name  | varchar(20) | YES  |     | NULL    |                |
| email | varchar(20) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

 */
public class Student {
	 private int id;
	    private String name;
	    private String email;

	    // Constructors
	    public Student() {}
	    public Student(int id, String name, String email) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	    }

	    // Getters & Setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

}
