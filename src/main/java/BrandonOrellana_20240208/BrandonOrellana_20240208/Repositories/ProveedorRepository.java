package BrandonOrellana_20240208.BrandonOrellana_20240208.Repositories;

import BrandonOrellana_20240208.BrandonOrellana_20240208.Entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

}
