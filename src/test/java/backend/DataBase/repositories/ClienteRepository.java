package backend.DataBase.repositories;

import backend.DataBase.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
    List<Cliente> findByNombreContaining(String nombre);
    
    Optional<Cliente> findByCorreo(String correo);
}
