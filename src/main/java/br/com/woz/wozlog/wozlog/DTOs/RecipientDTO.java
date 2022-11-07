package br.com.woz.wozlog.wozlog.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientDTO {
    private String name;
    private String address;
    private String number;
    private String complement;
    private String district;
}
