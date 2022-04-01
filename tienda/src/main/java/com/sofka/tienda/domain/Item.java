package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itm_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Subcategoria.class,
            optional = false)
    @JoinColumn(name = "itm_subcategoria_id", nullable = false)
    private Subcategoria itmSubcategoria;

    @Column(name = "itm_nombre", nullable = false, length = 80)
    private String itmNombre;

    @Column(name = "itm_created_at", nullable = false)
    private Instant itmCreatedAt;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Descarga.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "dwnItem"
    )
    private Set<Descarga> descargas = new LinkedHashSet<>();

}