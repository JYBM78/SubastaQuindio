package co.edu.uniquindio.programacion3.subastaquindio.model;

import co.edu.uniquindio.programacion3.subastaquindio.exceptions.ProductoException;
import co.edu.uniquindio.programacion3.subastaquindio.model.service.ISubastaQuindioService;

import java.util.ArrayList;

public class SubastaQuindio implements ISubastaQuindioService {

    private ArrayList<Producto> listaProducto = new ArrayList<>();

    public ArrayList<Producto> getListaProducto() {

        return listaProducto;
    }

    @Override
    public Producto crearProducto(String codigoUnico, String nombreProducto, String descripcion, String tipoProducto,
                                  String foto, String nombreAnunciante, String fechaPublicacion, String fechaFinPublicacion,
                                  Double valorInicial) throws ProductoException{
        Producto nuevoProducto = null;
        boolean productoExiste = verificarProductoExistente(codigoUnico);
        if(productoExiste){
            throw new ProductoException("El producto con código único: "+codigoUnico+" ya existe");
        }else{
            nuevoProducto = new Producto();
            nuevoProducto.setCodigoUnico(codigoUnico);
            nuevoProducto.setNombreProducto(nombreProducto);
            nuevoProducto.setDescripcion(descripcion);
            nuevoProducto.setTipoProducto(tipoProducto);
            nuevoProducto.setFoto(foto);
            nuevoProducto.setAnunciante(nombreAnunciante);
            nuevoProducto.setFechaPublicacion(fechaPublicacion);
            nuevoProducto.setFechaPublicacion(fechaFinPublicacion);
            nuevoProducto.setValorInicial(valorInicial);
            getListaProducto().add(nuevoProducto);
        }
        return nuevoProducto;
    }

    public void agregarProducto(Producto nuevoProducto) throws ProductoException{
        getListaProducto().add(nuevoProducto);
    }

    @Override
    public boolean actualizarProducto(String codigoActual, Producto producto) throws ProductoException {
        Producto productoActual = obtenerProducto(codigoActual);
        if(productoActual == null)
            throw new ProductoException("El producto a actualizar no existe");
        else{
            productoActual.setNombreProducto(producto.getNombreProducto());
            productoActual.setCodigoUnico(producto.getCodigoUnico());
            productoActual.setTipoProducto(producto.getTipoProducto());
            productoActual.setAnunciante(producto.getAnunciante());
            productoActual.setDescripcion(producto.getDescripcion());
            productoActual.setFoto(producto.getFoto());
            productoActual.setFechaFinPublicacion(producto.getFechaPublicacion());
            productoActual.setFechaFinPublicacion(producto.getFechaFinPublicacion());
            return true;
        }
    }

    @Override
    public Boolean eliminarProducto(String codigoUnico) throws ProductoException {
        Producto producto = null;
        boolean flagExiste = false;
        producto = obtenerProducto(codigoUnico);
        if(producto == null)
            throw new ProductoException("El empleado a eliminar no existe");
        else{
            getListaProducto().remove(producto);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarProductoExistente(String codigoUnico) throws ProductoException{
        if(productoExiste(codigoUnico)){
            throw new ProductoException("El producto con el código único: "+ codigoUnico + "ya existe");
        }else{
            return false;
        }
    }

    public boolean productoExiste(String codigoUnico){
        boolean productoEncontrado = false;
        for (Producto producto : getListaProducto()){
            if(producto.getCodigoUnico().equalsIgnoreCase(codigoUnico)){
                productoEncontrado = true;
                break;
            }
        }
        return productoEncontrado;
    }

    @Override
    public Producto obtenerProducto(String codigoUnico) {
        Producto productoEncontrado = null;
        for (Producto empleado : getListaProducto()) {
            if(empleado.getCodigoUnico().equalsIgnoreCase(codigoUnico)){
                productoEncontrado = empleado;
                break;
            }
        }
        return productoEncontrado;
    }

    @Override
    public ArrayList<Producto> obtenerProducto() {
        return getListaProducto();
    }
}