
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.okruss.CNC.classes;
import java.sql.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import jxl.write.*;
import jxl.*;
/**
 *
 * @author tecnico2
 */
public class conex
{
    Connection con;
    Statement stm=null;
    public String user="";
    public String passwd="";
    public String server="";

    private File file;
    private JTable table;
    private String nombreTab;

    public Statement conexion()
    {
     String cad="";
     ArrayList<String> lineas = new ArrayList<String>(); 
     try
        {
            FileReader fr = new FileReader("conf\\conInf.dat");
            BufferedReader bf = new BufferedReader(fr);
            while((cad=bf.readLine())!=null)
                {              
                    lineas.add(cad);
                }
            user=lineas.get(1);passwd=lineas.get(2);server=lineas.get(3);
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            con=DriverManager.getConnection(
                    "jdbc:mysql://"+server+":3306/credito?user="+user+"&password="+passwd+"&zeroDateTimeBehavior=convertToNull");
            stm=con.createStatement();
            stm.getConnection();
            stm.executeUpdate("use credito");
            //System.out.println(lineas.get(1)+"   "+lineas.get(2));
        }
     catch(Exception e)
        {
         JOptionPane.showMessageDialog(null,""+e.getCause());
        }
     return stm;
    }

    public void setDatos(JTable table,File file,String nombreTab)
    {
    //this.file=file;
    this.table=table;
    this.nombreTab=nombreTab;
    }
    public boolean export()
    {
    try
        {
        //Nuestro flujo de salida para apuntar a donde vamos a escribir
        DataOutputStream out=new DataOutputStream(new FileOutputStream("c:\\export\\export.xls"));

        //Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
        WritableWorkbook w = Workbook.createWorkbook(out);


        //Como excel tiene muchas hojas esta crea o toma la hoja
        //Coloca el nombre del "tab" y el indice del tab
        WritableSheet s = w.createSheet(nombreTab, 0);
        for(int i=0;i< table.getColumnCount();i++)
        {
            for(int j=0;j<1;j++)
            {
                Object objeto=table.getColumnName(i);
                s.addCell(new Label(i, j, String.valueOf(objeto)));
            }
        }

        for(int i=0;i< table.getColumnCount();i++)
        {
            for(int j=0;j<table.getRowCount();j++)
            {
                Object objeto=table.getValueAt(j,i);
                s.addCell(new Label(i, j+1, String.valueOf(objeto)));
            }
        }
        w.write();
        //Cerramos el WritableWorkbook y DataOutputStream
        w.close();
        out.close();

        

        //si todo sale bien salimos de aqui con un true :D
        return true;


    }
    catch(IOException ex){ex.printStackTrace();}
    catch(WriteException ex){ex.printStackTrace();}

    //Si llegamos hasta aqui algo salio mal
    return false;

    }

    public ArrayList<String> DatosConex()
    {
        String cad="";
     ArrayList<String> lineas = new ArrayList<String>(); 
     try
        {
            FileReader fr = new FileReader("conf\\conInf.dat");
            BufferedReader bf = new BufferedReader(fr);
            while((cad=bf.readLine())!=null)
                {              
                    lineas.add(cad);
                }
            user=lineas.get(1);passwd=lineas.get(2);server=lineas.get(3);
        }
     catch(Exception e)
        {
         JOptionPane.showMessageDialog(null,""+e.getCause());
        }
     return lineas;
    }
}
