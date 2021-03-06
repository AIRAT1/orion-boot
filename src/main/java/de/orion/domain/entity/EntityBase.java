package de.orion.domain.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class EntityBase {
    @Id
    private UUID id = UUID.randomUUID();
}
