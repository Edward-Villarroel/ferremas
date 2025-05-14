package backend.DataBase.repositories;

import backend.DataBase.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    

    List<Producto> findByNombre_productoContaining(String nombre);
    

    List<Producto> findByCategoriaId_categoria(Integer categoriaId);
}
