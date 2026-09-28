package football_highlights.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HighlightRequest(

        @NotNull(message = "ID da partida é obrigatório")
        Long matchId,

        @NotBlank(message = "Descrição do lance é obrigatória")
        String description,

        @NotBlank(message = "Nome do arquivo é obrigatório")
        String fileName,

        @NotNull(message = "Duração é obrigatória")
        Integer durationSeconds
) {
}