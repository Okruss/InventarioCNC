/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.okruss.CNC.classes;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author administrador
 */
public class file_browser 
{
    public String selecciona_archivo()
        {
            JFileChooser explorer = new JFileChooser();
            int resp;
            String path="";
            resp=explorer.showSaveDialog(explorer);//JFileChoo
            if (resp==JFileChooser.APPROVE_OPTION) 
            {//Si el usuario presiona aceptar; le damos el path del archivo.
                try
                {   
                    path=String.valueOf(explorer.getSelectedFile().toString());
                }
                catch(Exception e)
                {
                JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            return path;
        }
}
