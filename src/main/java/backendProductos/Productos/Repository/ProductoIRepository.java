package backendProductos.Productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backendProductos.Productos.Model.ProductModel;



public interface ProductoIRepository extends JpaRepository<ProductModel, Long> {
    
}
