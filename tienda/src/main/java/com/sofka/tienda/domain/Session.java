package com.sofka.tienda.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.time.Instant;

@Data
@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Usuario.class,
            optional = false)
    @JoinColumn(name = "ses_usuario_id", nullable = false)
    private Usuario sesUsuario;

    @Column(name = "ses_token", nullable = false, length = 32)
    private String sesToken;

    @Column(name = "ses_created_at", nullable = false)
    private Instant sesCreatedAt;

}