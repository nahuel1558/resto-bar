package com.example.restobar.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class MesasResponse {
    private List<MesaResponse> mesas;
}
