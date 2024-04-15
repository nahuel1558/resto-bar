package com.example.restobar.models;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "producto")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Producto extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costo")
    private Float costo;
    @Column(name = "precio")
    private Float precio;
}
