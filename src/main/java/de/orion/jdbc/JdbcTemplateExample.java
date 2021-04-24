package de.orion.jdbc;

import de.orion.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JdbcTemplateExample {
    private final JdbcTemplate jdbcTemplate;

    public List<Person> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql, Person.class);
    }

    public Person getById(UUID id) {
        String sql = "SELECT * FROM users WHERE id=?1";
        return jdbcTemplate.queryForObject(sql, Person.class, id);
    }
}
