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
@Table(name = "mesa")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Mesa extends Base {

    @Column(name = "nombre")
    private String nombre;

}
