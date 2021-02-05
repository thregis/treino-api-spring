package com.example.l5r.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clan_id")
    private Long id;

    @Column(name = "clan_name")
    private String name;

    @Column(name = "clan_founder")
    private String founder;

    @Column(name = "clan_major")
    private Boolean major;

    @Column(name = "clan_description")
    private String description;

    @Column(name = "clan_active")
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_clan")
    private List<Family> families;

    }
