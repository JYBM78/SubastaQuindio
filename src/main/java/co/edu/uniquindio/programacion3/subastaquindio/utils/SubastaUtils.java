package co.edu.uniquindio.programacion3.subastaquindio.utils;

import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;
import co.edu.uniquindio.programacion3.subastaquindio.model.SubastaQuindio;

public class SubastaUtils {
    public static SubastaQuindio inicializarDatos(){

        SubastaQuindio subasta= new SubastaQuindio();

            Producto producto = new Producto();
            producto.setCodigoUnico("1234");
            producto.setNombreProducto("Lavadora HAcebeee");
            producto.setDescripcion("Lavadora casi nueva");
            producto.setAnunciante("Carlos Montes");
            producto.setTipoProducto("HOGAR");
            producto.setFechaPublicacion("29-09-2023");
            producto.setFechaFinPublicacion("29-09-2023");
            producto.setValorInicial(45200);
            subasta.getListaProducto().add(producto);

            return subasta;

    }
}
