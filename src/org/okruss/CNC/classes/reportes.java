/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.okruss.CNC.classes;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author JavierObeth
 */

public class reportes 
{
    
    public void contrato (String car, String prod, String mont, String has,
            String ubca, String montT, String letra, String uprod, String cve,
            String fecha)

    {
         try
        {
            

            Map parameter = new HashMap();
            parameter.put("TITULO","Contrado Crédito Simple "+prod+ "");
            parameter.put("cartera",car);
            parameter.put("prod",prod);
            parameter.put("mont",mont);
            parameter.put("has",has);
            parameter.put("ubcana",ubca);
            parameter.put("montTot",montT);
            parameter.put("letra",letra);
            parameter.put("ubprod",uprod);
            parameter.put("fecha",fecha);
            parameter.put("cve",cve);
            JasperReport report=JasperCompileManager.compileReport("reportes\\contrato.jrxml");
            JasperPrint print=JasperFillManager.fillReport(report, parameter,new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print,"library\\contrato_"+car+"_"+prod+".pdf");
            //JasperViewer.viewReport(print,false);
            JasperViewer visor= new JasperViewer(print,false);
                         visor.setTitle("Contrado Crédito Simple "+prod);
                         visor.setVisible(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ocurrio un error al generar el "
                    + "reporte.");
            JOptionPane.showMessageDialog(null,""+e.getMessage());
        }
    }
    
    
    public void PAGARE (String folioPag, String monto, String letra, String prod,
            String domprod, String fecha, String cve, String por,String ms, String ls)

    {
         try
        {
            

            Map parameter = new HashMap();
            parameter.put("TITULO","Pagaré por "+monto+ "");
            parameter.put("folioPag",folioPag);
            parameter.put("prod",prod);
            parameter.put("monto",monto);
            parameter.put("letra",letra);
            parameter.put("domprod",domprod);
            parameter.put("fecha",fecha);
            parameter.put("cve",cve);
            parameter.put("por", por);
            parameter.put("montoSeg", ms);
            parameter.put("letraSeg", ls);

            parameter.put("letra",letra);
            JasperReport report=JasperCompileManager.compileReport("reportes\\pagare.jrxml");
            JasperPrint print=JasperFillManager.fillReport(report, parameter,new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print,"library\\pagare_"+folioPag+"_"+prod+".pdf");
            //JasperViewer.viewReport(print,false);
            JasperViewer visor= new JasperViewer(print,false);
                         visor.setTitle("Pagare "+prod);
                         visor.setVisible(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ocurrio un error al generar el "
                    + "reporte.");
            JOptionPane.showMessageDialog(null,""+e.getMessage());
        }
    }
    
}
