package springmain;

import daofiles.PersonDAO;
import pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SuppressWarnings("unused")
public class MainAppJDBC {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
        PersonDAO dao = ctx.getBean("personDAO", PersonDAO.class);

        System.out.println("→ All Persons:");
        for (Person p : dao.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\n→ Fetching ID 2:");
        System.out.println(dao.getPersonById(2));

        System.out.println("\n→ Inserting new person...");
        dao.insertPerson(new Person(4, 36, "Sergey", "Emets"));

        System.out.println("\n→ Updated List:");
        dao.getAllPersons().forEach(System.out::println);

        System.out.println("\n→ Deleting person with ID 2...");
        dao.deletePerson(2);

        System.out.println("\n→ Updating person with ID 1...");
        dao.updatePerson(new Person(4, 36, "Sergey", "CHANGED"));

        System.out.println("\n→ Final List:");
        dao.getAllPersons().forEach(System.out::println);
    }
}
