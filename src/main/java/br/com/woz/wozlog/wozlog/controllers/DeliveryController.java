package br.com.woz.wozlog.wozlog.controllers;

import br.com.woz.wozlog.wozlog.DTOs.DeliveryDTO;
import br.com.woz.wozlog.wozlog.DTOs.RecipientDTO;
import br.com.woz.wozlog.wozlog.assembler.DeliveryAssembler;
import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import br.com.woz.wozlog.wozlog.domain.repositories.DeliveryRepository;
import br.com.woz.wozlog.wozlog.services.DeliveryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/deliveries")
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryAssembler deliveryAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO request(@Valid @RequestBody Delivery delivery) {
        return deliveryAssembler.toModel(deliveryService.request(delivery));
    }

    @GetMapping
    public List<DeliveryDTO> getAll() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }
}
