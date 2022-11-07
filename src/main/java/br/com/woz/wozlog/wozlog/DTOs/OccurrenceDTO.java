package br.com.woz.wozlog.wozlog.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceDTO {
    private Long id;
    private String description;
    private OffsetDateTime registerDate;
}
