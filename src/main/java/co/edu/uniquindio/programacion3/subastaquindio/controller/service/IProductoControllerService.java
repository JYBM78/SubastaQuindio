package co.edu.uniquindio.programacion3.subastaquindio.controller.service;

import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;

import java.util.List;

/**
 * Va tener los métodos que se llevan a la clase productoController y allí se pone la lógica
 */
public interface IProductoControllerService {

    List<ProductoDTO> obtenerProductos();

    boolean agregarProducto(ProductoDTO productoDTO);

    boolean eliminarProducto(String codigoUnico);

    boolean actualizarProducto(String codigoUnico, ProductoDTO productoDto );

    void registrarAcciones(String mensaje, int nivel, String accion);

}
