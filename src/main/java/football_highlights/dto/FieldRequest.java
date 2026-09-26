package football_highlights.dto;

import jakarta.validation.constraints.NotBlank;

public record FieldRequest(
        @NotBlank(message = "Nome do campo é onrigatório")
        String name,

        String address
) {
}
