package fr.istic.taa.jaxrs.dto;

import lombok.Data;

// Annotation Lombok pour générer automatiquement les méthodes getter, setter, toString, etc.
@Data
public class ClientDTO {
    private Long id;
    private String name;

}
