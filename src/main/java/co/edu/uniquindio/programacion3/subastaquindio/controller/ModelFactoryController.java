package co.edu.uniquindio.programacion3.subastaquindio.controller;

import co.edu.uniquindio.programacion3.subastaquindio.controller.service.IModelFactoryController;
import co.edu.uniquindio.programacion3.subastaquindio.exceptions.ProductoException;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;
import co.edu.uniquindio.programacion3.subastaquindio.model.SubastaQuindio;

import java.util.List;

public class ModelFactoryController implements IModelFactoryController {

    SubastaQuindio subasta;
    SubastaMapper mapper = SubastaMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estática oculta. Tan solo se instanciara el singleton una vez

    /**
     * Se centraliza la comunicación de la app, para dar un orden en la ejecución de operaciones
     * por parte de los usuarios, asignado turnos en el orden que que la persona ingresa a la app
     */
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public SubastaQuindio getSubasta() {
        return subasta;
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        return mapper.getProductoDto(subasta.getListaProducto());
    }

    @Override
    public boolean agregarProducto(ProductoDTO productoDTO) {
        try{
            if(!subasta.verificarProductoExistente(productoDTO.codigoUnico())){
                Producto producto = mapper.productoDtoToProducto(productoDTO);
                getSubasta().agregarProducto(producto);
            }
            return true;
        }catch (ProductoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String codigoUnico) {
        return false;
    }

    @Override
    public boolean actualizarProducto(String codigoUnico, ProductoDTO productoDto) {
        return false;
    }
}
