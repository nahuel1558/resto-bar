package com.example.restobar.mappers;

import com.example.restobar.dtos.request.MesaRequest;
import com.example.restobar.dtos.response.MesaResponse;
import com.example.restobar.dtos.response.MesasResponse;
import com.example.restobar.models.Mesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MesaMapper {
    public Mesa mesaRequestToMesa(MesaRequest mesaRequest){
        Mesa mesa = Mesa.builder()
                .nombre(mesaRequest.getNombre())
                .build();
        return mesa;
    }
    public MesasResponse mesaListToResponse(List<Mesa> mesas) {
        List<MesaResponse> mesaResponseList = new ArrayList<>();

        for (Mesa mesa : mesas){
            MesaResponse mesaResponse = MesaResponse.builder()
                    .nombre(mesa.getNombre())
                    .build();
        }

        MesasResponse mesasResponse = MesasResponse.builder()
                .mesas(mesaResponseList)
                .build();
        return mesasResponse;
    }

}
