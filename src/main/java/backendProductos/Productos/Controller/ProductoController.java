package backendProductos.Productos.Controller;

import backendProductos.Productos.Model.ProductModel;
import backendProductos.Productos.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping
    public String crearProducto(@RequestBody ProductModel producto) {
        return productoService.guardarProduct(producto);
    }

    @GetMapping("/GetBy/{id}")
    public ProductModel obtenerProductoPorId(@PathVariable Long id) {
        return productoService.buscarProductPorId(id);
    }

    @GetMapping
    public List<ProductModel> listarProductos() {
        return productoService.listarProduct();
    }

    @PutMapping("/Put/{id}")
    public String actualizarProducto(@PathVariable Long id, @RequestBody ProductModel producto) {
        return productoService.actualizarProduct(id, producto);
    }

    @DeleteMapping("/Delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProductPorId(id);
    }
}

