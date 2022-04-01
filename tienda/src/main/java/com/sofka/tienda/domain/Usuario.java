package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data //etiqueta para utilizar getter y setter de a libreria lombook
@Entity
@Table(name = "usuario")
public class Usuario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @Column(name = "usu_username", nullable = false, length = 80)
    private String usuUsername;

    @Column(name = "usu_password", nullable = false, length = 32)
    private String usuPassword;

    @Column(name = "usu_created_at", nullable = false)
    private Instant usuCreatedAt;

    @Column(name = "usu_updated_at")
    private Instant usuUpdatedAt;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Descarga.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "dwnUsuario"
    )
    private Set<Descarga> descargas = new LinkedHashSet<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Session.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "sesUsuario"
    )
    private Set<Session> sessions = new LinkedHashSet<>();


}