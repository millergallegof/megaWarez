package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scat_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Descarga.class,
            optional = false)
    @JoinColumn(name = "scat_categoria_id", nullable = false)
    private Categoria scatCategoria;

    @Column(name = "scat_nombre", nullable = false, length = 80)
    private String scatNombre;

    @Column(name = "scat_created_at", nullable = false)
    private Instant scatCreatedAt;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Item.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "itmSubcategoria"
    )
    private Set<Item> items = new LinkedHashSet<>();

}