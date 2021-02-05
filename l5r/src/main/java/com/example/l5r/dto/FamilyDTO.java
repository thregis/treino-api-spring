package com.example.l5r.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FamilyDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    private String description;

    private Long clanId;
    private String clanName;

    private Boolean active;
}
