package br.com.woz.wozlog.wozlog.DTOs;

import br.com.woz.wozlog.wozlog.enums.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {
    private Long id;
    private String clientName;
    private RecipientDTO recipient;
    private BigDecimal deliveryFee;
    private StatusDelivery deliveryStatus;
    private OffsetDateTime requestDate;
    private OffsetDateTime finishedDate;
}
