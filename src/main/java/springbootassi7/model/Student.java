package springbootassi7.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    @NotBlank(message = "{firstName.required}")
    @Size(min = 3, max = 30, message = "{firstName.required}")
    private String firstName;

    @NotBlank(message = "{lastName.required}")
    @Size(min = 3, max = 30, message = "{lastName.required}")
    private String lastName;

    @NotBlank(message = "{sex.required}")
    private String sex;

    @NotNull(message = "{dob.required}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dob;

    @NotBlank(message = "{email.required}")
    @Email
    private String email;

    @NotBlank(message = "{section.required}")
    private String section;

    @NotBlank(message = "{country.required}")
    private String country;

    private boolean firstAttempt;

    @NotEmpty(message = "{subjects.required}")
    private List<String> subjects;

    // Getters and setters
    public String getFirstName()
    { 
    	return firstName; 
    	}
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public boolean isFirstAttempt() { return firstAttempt; }
    public void setFirstAttempt(boolean firstAttempt) { this.firstAttempt = firstAttempt; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }
}
