package springbootassi10.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class Customer {
    
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String gender;

    @NotNull
    private LocalDate birthday;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
    private String phone;

 // Getters and setters
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

    public String getGender() 
    { 
    	return gender;
    	}
    public void setGender(String gender)
    { 
    	this.gender = gender;
    	}

    public LocalDate getBirthday()
    { 
    	return birthday; 
    	}
    public void setBirthday(LocalDate birthday) 
    { 
    	this.birthday = birthday;
    	}

    public String getPhone() 
    { 
    	return phone;
    	}
    public void setPhone(String phone)
    { 
    	this.phone = phone;
    	}
}
