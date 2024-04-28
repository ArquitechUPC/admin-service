package org.Arquitech.Gymrat.admin.Admin.resource.trainer;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTrainerResource {

    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String specialization;

}
