package com.budgetpartner.APP.mapper;

import com.budgetpartner.APP.dto.request.RolDtoRequest;
import com.budgetpartner.APP.entity.Rol;
import com.budgetpartner.APP.dto.response.RolDtoResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolMapper {

    // Convierte Rol en RolDtoResponse
    public static RolDtoResponse toDtoResponse(Rol rol) {
        if (rol == null) return null;

        return new RolDtoResponse(
                rol.getId(),
                rol.getNombre(),
                rol.getPermisos()
        );
    }

    // Convierte RolDtoRequest en Rol
    public static Rol toEntity(RolDtoRequest dto) {
        if (dto == null) return null;

        return new Rol(
                dto.getNombre(),
                dto.getPermisos()
        );
    }

    // Actualiza entidad existente con los valores del DTO
    public static void updateEntityFromDtoRes(RolDtoRequest dto, Rol rol) {
        if (dto == null || rol == null) return;

        if (dto.getNombre() != null) rol.setNombre(dto.getNombre());
        if (dto.getPermisos() != null) rol.setPermisos(dto.getPermisos());
    }

    public static List<RolDtoResponse> toDtoResponseListRol(List<Rol> roles) {
        List<RolDtoResponse> listaRolesDtoResp = new ArrayList<>();
        if (roles == null || roles.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (Rol rol : roles) {
                RolDtoResponse rolDtoResp = RolMapper.toDtoResponse(rol);
                listaRolesDtoResp.add(rolDtoResp);
            }
            return listaRolesDtoResp;
        }
    }
}
