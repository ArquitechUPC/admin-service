package org.Arquitech.Gymrat.admin.Admin.resource.trainer;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TrainerResource {
    private Integer id;

    private String name;

    private String phone;

    private String email;

    private String specialization;
}
