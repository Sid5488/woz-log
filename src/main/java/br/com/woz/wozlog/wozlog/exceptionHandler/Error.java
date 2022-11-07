package br.com.woz.wozlog.wozlog.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Field> fields;

    @Getter
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }
}
