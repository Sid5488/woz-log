package br.com.woz.wozlog.wozlog.controllers;


import br.com.woz.wozlog.wozlog.DTOs.Input.OccurrenceInputDTO;
import br.com.woz.wozlog.wozlog.DTOs.OccurrenceDTO;
import br.com.woz.wozlog.wozlog.assembler.OccurrenceAssembler;
import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import br.com.woz.wozlog.wozlog.domain.repositories.DeliveryRepository;
import br.com.woz.wozlog.wozlog.domain.models.Occurrence;
import br.com.woz.wozlog.wozlog.exceptions.EntityNotFoundException;
import br.com.woz.wozlog.wozlog.services.OccurrenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {
    private OccurrenceService occurrenceService;
    private OccurrenceAssembler occurrenceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceDTO register(
            @PathVariable Long deliveryId,
            @Valid @RequestBody OccurrenceInputDTO occurrenceInput
    ) {
        OccurrenceDTO register = occurrenceService.register(deliveryId, occurrenceInput.getDescription());

        return register;
    }

    @GetMapping
    public List<OccurrenceDTO> getAll(@PathVariable Long deliveryId) {
        Delivery delivery = occurrenceService.search(deliveryId);

        return occurrenceAssembler.toCollectionModel(delivery.getOccurrences());
    }
}
