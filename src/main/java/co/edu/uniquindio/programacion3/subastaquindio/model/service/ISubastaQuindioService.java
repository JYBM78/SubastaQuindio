package co.edu.uniquindio.programacion3.subastaquindio.model.service;

import co.edu.uniquindio.programacion3.subastaquindio.exceptions.ProductoException;
import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;

import java.util.ArrayList;

public interface ISubastaQuindioService {

    Producto crearProducto(String codigoUnico, String nombreProducto, String descripcion, String tipoProducto,
                           String foto, String nombreAnunciante, String fechaPublicacion, String fechaFinPublicacion,
                           Double valorInicial) throws ProductoException;

    boolean verificarProductoExistente(String codigoUnico) throws ProductoException;

    ArrayList<Producto> obtenerProducto();

    Producto obtenerProducto(String codigoUnico);

    Boolean eliminarProducto(String codigoUnico) throws ProductoException;


    boolean actualizarProducto(String codigoUnico, Producto producto) throws ProductoException;
}
