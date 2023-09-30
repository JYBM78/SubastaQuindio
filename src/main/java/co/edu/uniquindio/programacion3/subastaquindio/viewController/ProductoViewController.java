package co.edu.uniquindio.programacion3.subastaquindio.viewController;

import co.edu.uniquindio.programacion3.subastaquindio.controller.ProductoController;
import co.edu.uniquindio.programacion3.subastaquindio.controller.service.IProductoControllerService;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ProductoViewController {

    ProductoController productoControllerService;

    /**
     * Un arrraylist no es observable en una tabla de jFX
     * ObservableList<>, permite visualizarlo
     */

    ObservableList<ProductoDTO> listaProductoDto = FXCollections.observableArrayList();

    ProductoDTO productoSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<ProductoDTO, String> colAnunciante;

    @FXML
    private TableColumn<ProductoDTO, String> colCodigoUnico;

    @FXML
    private TableColumn<ProductoDTO, String> colDescripcion;

    @FXML
    private TableColumn<ProductoDTO, String> colFechaFinPublicacion;

    @FXML
    private TableColumn<ProductoDTO, String> colFechaPublicacion;

    @FXML
    private TableColumn<ProductoDTO, String> colNombreProducto;

    @FXML
    private TableColumn<ProductoDTO, String> colTipoProducto;

    @FXML
    private TableColumn<ProductoDTO, String> colValorInicial;

    @FXML
    private TableView<ProductoDTO> tableProductos;

    @FXML
    private TextArea txaDescripcion;

    @FXML
    private TextField txfAnunciante;

    @FXML
    private TextField txfCodigoUnico;

    @FXML
    private TextField txfFechaFinPublicacion;

    @FXML
    private TextField txfFechaPublicacion;

    @FXML
    private TextField txfNombreProducto;

    @FXML
    private TextField txfTipoProducto;

    @FXML
    private TextField txfValorInicial;

    @FXML
    void actualizarProducto(ActionEvent event) {

    }

    @FXML
    void agregarProducto(ActionEvent event) {

        crearProducto();
    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    }

    private void crearProducto(){


        // Capturar los datos
        ProductoDTO productoDTO = construirProductoDto();

        // Validar la información
        if(datosValidos(productoDTO)){
            if(productoControllerService.agregarProducto(productoDTO)){
                listaProductoDto.add(productoDTO);
                mostrarMensaje("notificación productos", "Producto creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposProductos();
            }else{
                mostrarMensaje("notificación productos", "Producto NO creado", "El empleado NO se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("notificación productos", "Producto NO creado", "Los datos ingresados son inválidos", Alert.AlertType.ERROR);
        }

    }

    private ProductoDTO construirProductoDto(){
        return new ProductoDTO(
                txfCodigoUnico.getText(), // captura lo que se escribe en la tabla
                txfNombreProducto.getText(),
                txaDescripcion.getText(),
                txfTipoProducto.getText(),
                "",
                txfAnunciante.getText(),
                txfFechaPublicacion.getText(),
                txfFechaFinPublicacion.getText(),
                Double.valueOf(txfValorInicial.getText())
        );

    }

    private void limpiarCamposProductos(){
        txfCodigoUnico.setText("");
        txfNombreProducto.setText("");
        txfAnunciante.setText("");
        txfValorInicial.setText("");
        txaDescripcion.setText("");
        txfFechaPublicacion.setText("");
        txfFechaFinPublicacion.setText("");
        txfTipoProducto.setText("");
    }

    private boolean datosValidos(ProductoDTO productoDto){
        String mensaje = "";
        if(productoDto.nombreProducto() == null || productoDto.nombreProducto().equals(""))
            mensaje += "El nombre del Producto es inválido \n" ;
        if(productoDto.nombreAnunciante() == null || productoDto.nombreAnunciante().equals(""))
            mensaje += "El nombre del anunciante es inválido \n" ;
        if(productoDto.codigoUnico() == null || productoDto.codigoUnico().equals(""))
            mensaje += "El código único del anunciate es inválido \n" ;
        if(productoDto.valorInicial() == null)
            mensaje += "El valor inicial de la puja es inválido \n" ;
        if(productoDto.descripcion() == null || productoDto.descripcion().equals(""))
            mensaje += "La descripción de la puja es inválida \n" ;
        if(productoDto.fechaPublicacion() == null || productoDto.fechaPublicacion().equals(""))
            mensaje += "La fecha de publicación es inválida \n" ;
        if(productoDto.fechaFinPublicacion() == null || productoDto.fechaFinPublicacion().equals(""))
            mensaje += "La fecha de fin publicación es inválida \n" ;
        if(productoDto.tipoProducto() == null || productoDto.tipoProducto().equals(""))
            mensaje += "El tipo de producto es inválido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente", "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }

    }

    /**
     * Enlaza la columna con el dato, crea una especie de método .codigoUnico etc.
     * método anónimo
     */

    private void initDataBinding() {
        colCodigoUnico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigoUnico()));
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreProducto()));
        colAnunciante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreAnunciante()));
        colValorInicial.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().valorInicial())));
        colDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        colFechaPublicacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaPublicacion()));
        colFechaFinPublicacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaFinPublicacion()));
        colTipoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().tipoProducto())));

    }

    /**
     * Método que identifica dónde se da click, se marca como elemento observable
     * oldselection, pone en azul la línea selecionada.
     */

    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });
    }


    /**
     * Al dar click en la tabla, el elemento seleccionado se resalta en el campo de texto
     * el método listenerSelection llama al método empleadoSeleccionado
     * @param empleadoSeleccionado
     */

    private void mostrarInformacionProducto(ProductoDTO empleadoSeleccionado) {
        if(empleadoSeleccionado != null){
            txfCodigoUnico.setText(productoSeleccionado.codigoUnico());
            txfNombreProducto.setText(productoSeleccionado.nombreProducto());
            txfAnunciante.setText(productoSeleccionado.nombreAnunciante());
            txaDescripcion.setText(productoSeleccionado.descripcion());
            txfValorInicial.setText(String.valueOf(productoSeleccionado.valorInicial()));
            txfFechaPublicacion.setText(productoSeleccionado.fechaPublicacion());
            txfFechaFinPublicacion.setText(String.valueOf(productoSeleccionado.fechaFinPublicacion()));
            txfTipoProducto.setText(productoSeleccionado.tipoProducto());
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}


