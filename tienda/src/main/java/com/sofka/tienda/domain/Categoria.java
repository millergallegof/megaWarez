package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Column(name = "cat_nombre", nullable = false, length = 80)
    private String catNombre;

    @Column(name = "cat_created_at", nullable = false)
    private Instant catCreatedAt;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Subcategoria.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "scatCategoria"
    )
    private Set<Subcategoria> subcategorias = new LinkedHashSet<>();


}