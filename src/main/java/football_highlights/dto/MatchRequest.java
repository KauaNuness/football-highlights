package football_highlights.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MatchRequest(

        @NotBlank(message = "Descrição da partida é obrigatória")
        String description,

        @NotNull(message = "ID do campo é obrigatório")
        Long fieldId
) {
}