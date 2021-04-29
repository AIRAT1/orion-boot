package de.orion.repository;

import de.orion.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Component
@Transactional
@RequiredArgsConstructor
public class CustomPersonRepository implements PersonCustomRepository{
    private final EntityManager entityManager;

    public Person get(UUID id) {
        return entityManager.find(Person.class, id);
    }

    public Person create(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(person);
    }

    public void deleteById(UUID id) {
        entityManager.remove(get(id));
    }

    public List<Person> getByFirstNameAndLastNameNative(String firstName, String lastName) {
        return entityManager.createNativeQuery(
                "SELECT * FROM user " +
                        "WHERE first_name= ?1 " +
                        "AND last_name= ?2;"
        )
                .setParameter(1, firstName)
                .setParameter(2, lastName)
                .getResultList();
    }

    public List<Person> getByFirstNameAndLastName(String firstName, String lastName) {
        return entityManager.createQuery(
                "SELECT person FROM Person person " +
                        "WHERE person.firstName= :firstName " +
                        "AND person.lastName=:lastName"
        )
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<Person> getByFirstNameAndLastNameCriteria (String firstName, String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.where(criteriaBuilder.and(
//                criteriaBuilder.equal(root.get(Person_.firstName), firstName),
                criteriaBuilder.equal(root.get("firstName"), firstName),
                criteriaBuilder.equal(root.get("lastName"), lastName)
                ));
        return entityManager.createQuery(query).getResultList();
    }
}
