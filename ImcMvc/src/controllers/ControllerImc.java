
package controllers;

import java.awt.Image;
import models.ModelImc;
import views.ViewImc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Norberto
 */
public class ControllerImc implements ActionListener
{
    ModelImc modelImc;
    ViewImc viewImc;

    public ControllerImc(ModelImc modelImc, ViewImc viewImc) 
    {
        this.modelImc = modelImc;
        this.viewImc = viewImc;
        this.viewImc.jbCalcular.addActionListener(this);
        this.viewImc.jbBorrar.addActionListener(this);
        initViewImc();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == viewImc.jbCalcular)
        {
            btnCalcular();
        }
        else if (e.getSource() == viewImc.jbBorrar)
        {
            btnBorrar();
        }
    }
    
    public void btnCalcular()
    {
        try {
            
            modelImc.setPeso(Double.parseDouble(viewImc.jtfPeso.getText()));
            modelImc.setAltura(Double.parseDouble(viewImc.jtfAltura.getText()));
            modelImc.setSexo(viewImc.jcbSexo.getSelectedItem().toString());
            
            Double peso = modelImc.getPeso();
            Double altura = modelImc.getAltura();
            String sexo = modelImc.getSexo();
            System.out.println(peso);
            System.out.println(altura);
            double alturaMetros;
            String imcr = null;
            String estado = null;
            
            
            

            if (peso == 0 || altura == 0) 
            {
                JOptionPane.showMessageDialog(null, "Error: No se puede dividir entre 0");
            } else if (peso < 0 || altura < 0) 
            {
                JOptionPane.showMessageDialog(null, "Error: Solo se aceptan numeros positivos");
            } else if ((altura > 0 && altura < 50) || (altura > 280) || (peso > 0 && peso < 20) || (peso > 700)) 
            {
                JOptionPane.showMessageDialog(null, "Error: Ingresa las medidas correctas \nAltura en centimetros\n Peso en Kilogramos\n ");
            } else {
                alturaMetros = altura / 100;
                double imcUno = peso / Math.pow(alturaMetros, 2);
                double imc = Math.round(imcUno);
                

                if(sexo == "Femenino")
                {
                        if (imc < 19) {
                            imcr = "Desnutricion";
                        } else if (imc >= 19 && imc < 24) {
                            imcr = "Normal";
                        } else if (imc >= 24 && imc < 27) {
                            imcr = "Sobrepeso";
                        } else if (imc >= 27 && imc < 32) {
                            imcr = "Obesidad";
                        } else if (imc >= 32) {
                            imcr = "Obesidad Grave";
                        }
                }
                else if (sexo == "Masculino")
                {
                        if (imc < 20) {
                            imcr = "Desnutricion";
                        } else if (imc >= 20 && imc < 25) {
                            imcr = "Normal";
                        } else if (imc >= 25 && imc < 30) {
                            imcr = "Sobrepeso";
                        } else if (imc >= 30 && imc < 40) {
                            imcr = "Obesidad";
                        } else if (imc >= 40) {
                            imcr = "Obesidad Grave";
                        }
                }
                estado = "\nEstado de IMC: " + imcr + "\n\nIndice de Masa Corporal: " + (String.format("%.2f", imc)) + "\n\nSexo: " + sexo;
                modelImc.setResultado(estado);
                System.out.println(estado);
                viewImc.jtaResultado.setText(modelImc.getResultado());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Solo se pueden ingresar valores numericos\n " + e);
        }

        
    }
    
    public void btnBorrar()
    {
        viewImc.jtaResultado.setText("");
        viewImc.jtfAltura.setText("");
        viewImc.jtfPeso.setText("");
        viewImc.jcbSexo.setSelectedItem("Femenino");
    }
    
    public void lbImagenTabla()
    {
        ImageIcon imagenLogin = new ImageIcon(getClass().getResource("/Images/tabla.jpg"));
        Image fondoLogin = imagenLogin.getImage().getScaledInstance(viewImc.jlImagen.getWidth(), viewImc.jlImagen.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoLogin = new ImageIcon(fondoLogin);
        viewImc.jlImagen.setIcon(iconoEscaladoLogin);
    }

    private void initViewImc() 
    {
        viewImc.setTitle("Imc con MVC");
        viewImc.setResizable(false);
        viewImc.setLocationRelativeTo(null);
        viewImc.setVisible(true);
        lbImagenTabla();
        
    }
    
}
