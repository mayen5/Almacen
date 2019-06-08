package com.cmayen.almacen.core.reporte;

import com.cmayen.almacen.core.db.Conexion;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GenerarReporte {

    private static GenerarReporte instancia = null;
    public static GenerarReporte getInstancia(){
        if (instancia == null) {
            instancia = new GenerarReporte();
        }
        return instancia;
    }
    public void mostrarReporte(String titulo, String nombre, Map parametros){
        
        InputStream reporte = GenerarReporte.class.getResourceAsStream(nombre);
        
        try {
            JasperReport jasperReport = null;
            jasperReport = (JasperReport)JRLoader.loadObject(reporte);
            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(jasperReport, parametros, Conexion.getInstancia().getConnection());
            JasperViewer jasperView = new JasperViewer(jasperPrint, false);
            jasperView.setTitle(titulo);
            jasperView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
