package backendProductos.Productos.Service;

import java.util.List;

import backendProductos.Productos.Model.ProductModel;

public interface IProductoService {
    
    String guardarProduct(ProductModel Product);
    ProductModel buscarProductPorId(Long IdProduct);
    String eliminarProductPorId(Long IdProduct);
    String actualizarProduct(Long IdProduct, ProductModel ProductNuevo);
    List<ProductModel> listarProduct ();
    
    
}
