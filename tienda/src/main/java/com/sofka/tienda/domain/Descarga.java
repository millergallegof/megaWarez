package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.time.Instant;

@Data
@Entity
@Table(name = "descarga")
public class Descarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dwn_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Descarga.class,
            optional = false
    )
    @JoinColumn(name = "dwn_usuario_id", nullable = false)
    private Usuario dwnUsuario;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Item.class,
            optional = false)
    @JoinColumn(name = "dwn_item_id", nullable = false)
    private Item dwnItem;

    @Column(name = "dwn_created_at", nullable = false)
    private Instant dwnCreatedAt;

}