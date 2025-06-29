package com.budgetpartner.APP.service;

import com.budgetpartner.APP.dto.miembro.MiembroDtoPostRequest;
import com.budgetpartner.APP.dto.miembro.MiembroDtoResponse;
import com.budgetpartner.APP.dto.miembro.MiembroDtoUpdateRequest;
import com.budgetpartner.APP.entity.Miembro;
import com.budgetpartner.APP.entity.Organizacion;
import com.budgetpartner.APP.entity.Rol;
import com.budgetpartner.APP.exceptions.NotFoundException;
import com.budgetpartner.APP.mapper.MiembroMapper;
import com.budgetpartner.APP.repository.MiembroRepository;
import com.budgetpartner.APP.repository.OrganizacionRepository;
import com.budgetpartner.APP.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;
    @Autowired
    private OrganizacionRepository organizacionRepository;
    @Autowired
    private RolRepository rolRepository;

    //ENDPOINTS

    //Llamada para Endpoint
    //Crea una Entidad usando el DTO recibido por el usuario
    public Miembro postMiembro(MiembroDtoPostRequest dto){

        Organizacion organizacion = organizacionRepository.findById(dto.getOrganizacionId())
                .orElseThrow(() -> new NotFoundException("Organización no encontrada con id: " + (dto.getOrganizacionId())));

        System.out.println(dto.getRolId());

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new NotFoundException("Rol no encontrada con id: " + (dto.getRolId())));

        Miembro miembro = MiembroMapper.toEntity(dto, organizacion, rol);
        miembroRepository.save(miembro);
        return miembro;
    }

    //Llamada para Endpoint
    //Obtiene una Entidad usando el id recibido por el usuario
        /*DEVUELVE AL USUARIO:
    */
    public MiembroDtoResponse getMiembroDtoById(Long id){
        //Obtener ususario usando el id pasado en la llamada
        Miembro miembro = miembroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado con id: " + id));

        MiembroDtoResponse dto = MiembroMapper.toDtoResponse(miembro);
        return dto;
    }

    //Llamada para Endpoint
    //Elimina una Entidad usando el id recibido por el usuario
    public Miembro deleteMiembroById(Long id){
        //Obtener ususario usando el id pasado en la llamada
        Miembro miembro = miembroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado con id: " + id));

        //Elimina miembro. Quita los valores de sus claves ajenas
        miembroRepository.delete(miembro);

        return miembro;
    }

    //Llamada para Endpoint
    //Actualiza una Entidad usando el id recibido por el usuario
    public Miembro patchMiembro(MiembroDtoUpdateRequest dto, Long id) {

        // Obtener miembro usando el id pasado en la llamada
        Miembro miembro = miembroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Miembro no encontrado con id: " + id));

        Rol rol = null;
        if (dto.getRolId() != null) {
            rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new NotFoundException("Rol no encontrada con id: " + (dto.getRolId())));
        }

        MiembroMapper.updateEntityFromDtoRes(dto, miembro, rol);
        miembroRepository.save(miembro);
        return miembro;
    }

    //OTROS MÉTODOS

}
