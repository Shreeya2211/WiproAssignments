package daofiles;

import pojo.Person;
import java.util.List;

public interface PersonDAO
{
    void insertPerson(Person p);
    Person getPersonById(int id);
    void updatePerson(Person p);
    void deletePerson(int id);
    List<Person> getAllPersons();
}
