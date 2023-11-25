package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.Professionnel;
import lombok.Data;

@Data
public class RDVDTO {
    private Long id;
    private String date;
    private Professionnel professionnel;
    private Client client;
    private String sujet;

}
