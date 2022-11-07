package br.com.woz.wozlog.wozlog.services;

import br.com.woz.wozlog.wozlog.domain.models.Client;
import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import br.com.woz.wozlog.wozlog.domain.repositories.DeliveryRepository;
import br.com.woz.wozlog.wozlog.enums.StatusDelivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    @Transactional
    public Delivery request(Delivery delivery) {
        Client client = clientService.getById(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDENTE);
        delivery.setRequestDate(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
