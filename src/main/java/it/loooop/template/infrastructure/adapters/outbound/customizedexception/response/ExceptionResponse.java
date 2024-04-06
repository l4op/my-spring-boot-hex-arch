package it.loooop.template.infrastructure.adapters.outbound.customizedexception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime date;

    private String message;

    private List<String> details;

}
