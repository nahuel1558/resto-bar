package com.example.restobar.models;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "producto")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Pedido extends Base{

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @JsonFormat(pattern = "yyyy-MM-dd") //formato para utilizar json
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "precio_total")
    private Float precioTotal;

    @OneToMany(mappedBy = "pedido")
    @JoinColumn(name = "item_id")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;
}
