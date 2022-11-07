package br.com.woz.wozlog.wozlog.services;

import br.com.woz.wozlog.wozlog.DTOs.OccurrenceDTO;
import br.com.woz.wozlog.wozlog.assembler.OccurrenceAssembler;
import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import br.com.woz.wozlog.wozlog.domain.models.Occurrence;
import br.com.woz.wozlog.wozlog.domain.repositories.DeliveryRepository;
import br.com.woz.wozlog.wozlog.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OccurrenceService {
    private DeliveryRepository deliveryRepository;
    private OccurrenceAssembler occurrenceAssembler;

    public Delivery search(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
    }

    @Transactional
    public OccurrenceDTO register(Long deliveryId, String description) {
        Delivery delivery = search(deliveryId);

        Occurrence register = delivery.addOccurrence(description);

        return occurrenceAssembler.toModel(register);
    }
}
