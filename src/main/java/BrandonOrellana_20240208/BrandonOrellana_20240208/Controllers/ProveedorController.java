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
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProveedorController {
    //Aqui estamos inyectando el ProveedorService en controller
    @Autowired
    private final ProveedorService proveedorService;

    //Aqui estariamos mandando a llamar el crear de Service pero como me daba erro obviamente da error aca
    /*@PostMapping
    public ResponseEntity<?>crear(@Valid @RequestBody ProveedorDTO dto){
        return ResponseEntity.ok(proveedorService.crearProveedor(dto));
    }*/
    //Aqui estamos llamando el findAll del Service
    @GetMapping("/proveedores")
    public List<ProveedorDTO>findAll(){
        return proveedorService.findAll();
    }
    //Aqui estamos llamando al metodo del Service actualizarProveedor
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO>actualizar(@PathVariable Long id, @RequestBody ProveedorDTO dto){
        return proveedorService.actualizarProveedor(id, dto)
                .map(ResponseEntity::ok)
                        .orElseGet(()->ResponseEntity.notFound().build());
    }
    //Y aqui llamando al metodo del service eliminarProveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Long id){
        if (ProveedorService.eliminarProveedor(id)){
            return ResponseEntity.ok("Eliminado corectamente");
        }
        return ResponseEntity.status(404).body("no encontado");
    }


}
