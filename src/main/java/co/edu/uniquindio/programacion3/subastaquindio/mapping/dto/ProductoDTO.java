package co.edu.uniquindio.programacion3.subastaquindio.mapping.dto;

public record ProductoDTO(

        String codigoUnico,
        String nombreProducto,
        String descripcion,
        String tipoProducto,
        String foto,
        String nombreAnunciante,
        String fechaPublicacion,
        String fechaFinPublicacion,
        Double valorInicial) {
}
