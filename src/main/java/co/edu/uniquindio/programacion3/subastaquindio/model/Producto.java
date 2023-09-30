package co.edu.uniquindio.programacion3.subastaquindio.model;


import java.time.LocalDate;


public class Producto {

    private String codigoUnico;

    private String nombreProducto;

    private String tipoProducto;

    private String descripcion;

    private String foto;

    private String anunciante;

    private String fechaPublicacion;

    private String fechaFinPublicacion;

    private double valorInicial;

    public Producto (){

    }

    public Producto(String codigoUnico, String nombreProducto, String tipoProducto,
                    String descripcion, String foto, String anunciante, String fechaPublicacion,
                    String fechaFinPublicacion, double valorInicial) {
        this.codigoUnico = codigoUnico;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.foto = foto;
        this.anunciante = anunciante;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaFinPublicacion = fechaFinPublicacion;
        this.valorInicial = valorInicial;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFechaFinPublicacion() {
        return fechaFinPublicacion;
    }

    public void setFechaFinPublicacion(String fechaFinPublicacion) {
        this.fechaFinPublicacion = fechaFinPublicacion;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }
}
