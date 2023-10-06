package co.edu.uniquindio.programacion3.subastaquindio.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Anunciante extends Persona implements Serializable {

    private static final long serialVersioUID = 1L;

    Usuario usuarioAsociado;

    ArrayList<Producto> listProductos = new ArrayList<>();

    public  Anunciante(){

    }

    public Anunciante(Usuario usuarioAsociado, ArrayList<Producto> listProductos) {
        this.usuarioAsociado = usuarioAsociado;
        this.listProductos = listProductos;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public ArrayList<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
    }
}
