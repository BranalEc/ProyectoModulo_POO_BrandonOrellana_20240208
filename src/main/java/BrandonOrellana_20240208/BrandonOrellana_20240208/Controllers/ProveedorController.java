package BrandonOrellana_20240208.BrandonOrellana_20240208.Controllers;

import BrandonOrellana_20240208.BrandonOrellana_20240208.Models.DTO.ProveedorDTO;
import BrandonOrellana_20240208.BrandonOrellana_20240208.Services.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    @Autowired
    private final ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<?>crear(@Valid @RequestBody ProveedorDTO dto){
        return ResponseEntity.ok(ProveedorService.crearProveedor(dto));
    }

    @GetMapping
    public List<ProveedorDTO>findAll(){
        return ProveedorService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO>actualizar(@PathVariable Long id, @RequestBody ProveedorDTO dto){
        return ProveedorService.actualizarProveedor(id, dto)
                .map(ResponseEntity.ok()
                        .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Long id){
        if (ProveedorService.eliminarProveedor(id)){
            return ResponseEntity.ok("Eliminado corectamente");
        }
        return ResponseEntity.status(404).body("no encontado");
    }


}
