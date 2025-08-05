package pojo;

public class Person {
    private int id;
    private String name;
    private String email;
    private int age;
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(int id, int age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId()
    { 
    	return id; 
    }
    public void setId(int id)
    { 
    	this.id = id;
    }

    public String getName()
    { 
    	return name;
    }
    public void setName(String name)
    { 
    	this.name = name;
    }

    public String getEmail()
    { 
    	return email;
    }
    public void setEmail(String email)
    { 
    	this.email = email;
    }

    public int getAge()
    { 
    	return age;
    }
    public void setAge(int age)
    { 
    	this.age = age;
    }

    public String getFirstName()
    { 
    	return firstName;
    }
    public void setFirstName(String firstName)
    { 
    	this.firstName = firstName;
    }

    public String getLastName()
    { 
    	return lastName;
    }
    public void setLastName(String lastName)
    { 
    	this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Person{id=" + id + ", name='" + name + '\'' +
                ", email='" + email + '\'' + ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + '}';
    }
}
