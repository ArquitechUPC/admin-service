package org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotNull
    @Column(length = 50, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Column(length = 9, nullable = false)
    private String phone;

    @NotBlank
    @NotNull
    @Column(length = 80, nullable = false)
    private String email;

    @NotBlank
    @NotNull
    @Column(length = 80, nullable = false)
    private String specialization;

}
