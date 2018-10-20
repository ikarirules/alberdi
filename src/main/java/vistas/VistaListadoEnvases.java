package vistas;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VistaListadoEnvases extends VistaListadoPadre {

    private TableView miTabla;

    public VistaListadoEnvases(List envases) {
        super();
        ObservableList miLista = FXCollections.observableArrayList(envases);
        TableColumn column1 = crearColumnas("nombre");//Se envía el nombre del atributo.
        TableColumn column2 = crearColumnas("tipo");
        TableColumn column3 = crearColumnas("volumen");
        TableColumn column4 = crearColumnas("descripcion");
        miTabla = new TableView(miLista);
        miTabla.getColumns().addAll(column1,column2,column3,column4);
        contenido.getChildren().add(miTabla);
    }
    

}
