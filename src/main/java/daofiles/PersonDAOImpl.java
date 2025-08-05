package daofiles;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Person;

public class PersonDAOImpl implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    // For Spring injection of DataSource
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertPerson(Person p)
    {
        String sql = "INSERT INTO person (id, name, email, age, first_name, last_name) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, p.getId(), p.getName(), p.getEmail(), p.getAge(), p.getFirstName(), p.getLastName());
    }

    @Override
    public Person getPersonById(int id)
    {
        String sql = "SELECT * FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setEmail(rs.getString("email"));
            person.setAge(rs.getInt("age"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            return person;
        });
    }

    @Override
    public void updatePerson(Person p)
    {
        String sql = "UPDATE person SET name = ?, email = ?, age = ?, first_name = ?, last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, p.getName(), p.getEmail(), p.getAge(), p.getFirstName(), p.getLastName(), p.getId());
    }

    @Override
    public void deletePerson(int id)
    {
        String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Person> getAllPersons()
    {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setEmail(rs.getString("email"));
            person.setAge(rs.getInt("age"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            return person;
        });
    }
}
