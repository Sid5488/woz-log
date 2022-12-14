package br.com.woz.wozlog.wozlog.domain.models;

import br.com.woz.wozlog.wozlog.enums.StatusDelivery;
import br.com.woz.wozlog.wozlog.validations.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotNull
    @ManyToOne
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    private Client client;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    @Valid
    @NotNull
    @Embedded
    private Recipient recipient;

    @NotNull
    private BigDecimal deliveryFee;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusDelivery status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime requestDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime finishedDate;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRegisterDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }
}
