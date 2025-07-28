package BrandonOrellana_20240208.BrandonOrellana_20240208.Services;

import BrandonOrellana_20240208.BrandonOrellana_20240208.Entities.ProveedorEntity;
import BrandonOrellana_20240208.BrandonOrellana_20240208.Models.DTO.ProveedorDTO;
import BrandonOrellana_20240208.BrandonOrellana_20240208.Repositories.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.*;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
@RequiredArgsConstructor
@Builder
public class ProveedorService {

    @Autowired
    private static ProveedorRepository acceso;

    public List<ProveedorDTO> findAll(){
        return acceso.findAll()
                .stream()
                .map(this::convertDto)
                .toList();
    }

    /*public ProveedorDTO crearProveedor(ProveedorDTO dto){
        ProveedorEntity proveedor = ProveedorEntity.builder()
                .providerName(dto.getProviderName())
                .providerPhone(dto.getProviderPhone())
                .providerAddress(dto.getProviderAddress())
                .providerEmail(dto.getProviderEmail())
                .providerCode(dto.getProviderCode())
                .providerStatus(dto.getProviderStatus())
                .providerComments(dto.getProviderComments())
                .build();

        ProveedorEntity guardado = acceso.save(proveedor);
        return convertDto(guardado);
    }*/

    public Optional <ProveedorDTO>actualizarProveedor(Long id, ProveedorDTO dto){
        return acceso.findById(id).map(proveedor -> {
            proveedor.setProviderName(dto.getProviderName());
            proveedor.setProviderPhone(dto.getProviderPhone());
            proveedor.setProviderAddress(dto.getProviderAddress());
            proveedor.setProviderEmail(dto.getProviderEmail());
            proveedor.setProviderCode(dto.getProviderCode());
            proveedor.setProviderStatus(dto.getProviderStatus());
            proveedor.setProviderComments(dto.getProviderComments());
            return convertDto(acceso.save(proveedor));
        });
    }

    public static boolean eliminarProveedor(Long id){
        if (acceso.existsById(id)){
            acceso.deleteById(id);
            return true;
        }
        return false;
    }

    private ProveedorDTO convertDto(ProveedorEntity proveedor){
        return ProveedorDTO.builder()
                .providerID(proveedor.getProviderID())
                .providerName(proveedor.getProviderName())
                .providerPhone(proveedor.getProviderPhone())
                .providerAddress(proveedor.getProviderAddress())
                .providerEmail(proveedor.getProviderEmail())
                .providerCode(proveedor.getProviderCode())
                .providerStatus(proveedor.getProviderStatus())
                .providerComments(proveedor.getProviderComments())
                .build();
    }
}
