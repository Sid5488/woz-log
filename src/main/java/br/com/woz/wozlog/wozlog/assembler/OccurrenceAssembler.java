package br.com.woz.wozlog.wozlog.assembler;

import br.com.woz.wozlog.wozlog.DTOs.OccurrenceDTO;
import br.com.woz.wozlog.wozlog.domain.models.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OccurrenceAssembler {
    private ModelMapper modelMapper;

    public OccurrenceDTO toModel(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionModel(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
