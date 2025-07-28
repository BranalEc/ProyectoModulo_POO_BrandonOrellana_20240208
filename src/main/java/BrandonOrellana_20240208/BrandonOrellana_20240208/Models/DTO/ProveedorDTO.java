package BrandonOrellana_20240208.BrandonOrellana_20240208.Models.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Builder
@ToString
@EqualsAndHashCode
@Getter @Setter
public class ProveedorDTO {
    private Long id;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    private String providerName;

    private String providerPhone;

    private String providerAddress;

    @Email(message = "Debe ser un correo valido")
    private String providerEmail;

    @NotBlank(message = "El codigo es obligatorio")
    private String providerCode;

    private Integer providerStatus;

    private String providerComments;
}
