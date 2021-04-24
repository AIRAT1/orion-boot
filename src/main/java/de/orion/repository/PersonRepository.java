package de.orion.repository;

import de.orion.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person>, PersonCustomRepository {
    Person findByEmailAndName(String email, String name);

    @Query("SELECT person FROM Person person WHERE person.email=:email AND person.name=:name")
    Person findByEmailAndNameCustom(String email, String name);

    @Modifying
    @Query("DELETE FROM BillingDetails WHERE personId=: personId")
    void deleteBy(UUID personId);
}
