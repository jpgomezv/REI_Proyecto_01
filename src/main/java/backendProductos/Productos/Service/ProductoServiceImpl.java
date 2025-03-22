package backendProductos.Productos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backendProductos.Productos.Model.ProductModel;
import backendProductos.Productos.Repository.ProductoIRepository;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoIRepository productoRepository;

    @Override
    public String guardarProduct(ProductModel product) {
        productoRepository.save(product);
        return "Producto guardado correctamente.";
    }

    @Override
    public ProductModel buscarProductPorId(Long idProduct) {
        return productoRepository.findById(idProduct).orElse(null);
    }

    @Override
    public String eliminarProductPorId(Long idProduct) {
        if (productoRepository.existsById(idProduct)) {
            productoRepository.deleteById(idProduct);
            return "Producto eliminado correctamente.";
        }
        return "Producto no encontrado.";
    }

    @Override
    public String actualizarProduct(Long idProduct, ProductModel productNuevo) {
        return productoRepository.findById(idProduct).map(producto -> {
            producto.setProduct_name(productNuevo.getProduct_name());
            producto.setCategory(productNuevo.getCategory());
            producto.setSub_category(productNuevo.getSub_category());
            producto.setDescription(productNuevo.getDescription());
            producto.setStock(productNuevo.getStock());
            productoRepository.save(producto);
            return "Producto actualizado correctamente.";
        }).orElse("Producto no encontrado.");
    }

    @Override
    public List<ProductModel> listarProduct() {
        return productoRepository.findAll();
    }
}
