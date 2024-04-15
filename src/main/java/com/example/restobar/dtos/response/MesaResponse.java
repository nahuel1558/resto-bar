package com.example.restobar.dtos.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Data;

@Getter
@Builder
@Data
public class MesaResponse {
    private String nombre;
}
