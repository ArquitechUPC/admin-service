package org.Arquitech.Gymrat.admin.Admin.resource.trainer;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateTrainerResource {
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String specialization;
}
