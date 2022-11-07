package br.com.woz.wozlog.wozlog.assembler;

import br.com.woz.wozlog.wozlog.DTOs.DeliveryDTO;
import br.com.woz.wozlog.wozlog.domain.models.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DeliveryAssembler {
    private ModelMapper modelMapper;

    public DeliveryDTO toModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionModel(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
