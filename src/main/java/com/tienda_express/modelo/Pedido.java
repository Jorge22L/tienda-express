package com.tienda_express.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_cliente", nullable = false, length = 150)
    private String nombreCliente;

    @Column(name = "correo", nullable = false, length = 150)
    private String correo;

    @Column(name = "comentario", length = Integer.MAX_VALUE)
    private String comentario;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_pedido", nullable = false)
    private Instant fechaPedido;

    @ColumnDefault("0")
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;


}