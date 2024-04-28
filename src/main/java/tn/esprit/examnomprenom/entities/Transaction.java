package tn.esprit.examnomprenom.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.examnomprenom.entities.enums.TypeTransaction;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTransaction;
    double montant;
    TypeTransaction type;
    LocalDate dateTransaction;

    @ManyToOne
    Compte expediteur;
    @ManyToOne
    Compte destinataire;
}
