package co.istad.springwebmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductEditRequest(
        @NotBlank
        @Size(max = 40)
        String name,
        Double price
) {
}
