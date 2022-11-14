package calculadorswing.sergio.martinez.carrilero;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Sergio
 */
public class VistaSwing extends javax.swing.JFrame {
    
//    Variables
    private Modelo modelo;
    private char operador;
    boolean limpiar = true;
    boolean tienePunto = true;

    public VistaSwing() {
        initComponents();
        jTFResultado.setEditable(false);    
        jTFResultado.setText("");   
        modelo = new Modelo();
        generarKeyBindigs();
    }

    
//    Metodo para añadir un número a jTFResultado
    public void escribir(String num) {
        if (limpiar == true) {
            jTFResultado.setText("");
            limpiar = false;
            tienePunto = false;
        }
        jTFResultado.setText(jTFResultado.getText() + num);
        //System.out.println(jTFResultado.getText());
    }

//    Metodo que calcula la operación y muestra el resultado en el jTField
//    El StringFormat limita a 5 decimales en el resultado de las operaciones
    public void operar() {
        try {
            double numero = Double.parseDouble(jTFResultado.getText());

            switch (operador) {
                case '+':
                    limpiar = true;
                    tienePunto = true;
                    jTFResultado.setText(String.format("%.5f", modelo.sumar(numero)));

                    //System.out.println(jTFResultado.getText());
                    break;
                case '-':
                    limpiar = true;
                    tienePunto = true;
                    jTFResultado.setText(String.format("%.5f", modelo.restar(numero)));
                    //System.out.println(jTFResultado.getText());
                    break;
                case '*':
                    limpiar = true;
                    tienePunto = true;
                    jTFResultado.setText(String.format("%.5f", modelo.multiplicar(numero)));
                    //System.out.println(jTFResultado.getText());
                    break;
                case '/':
                    limpiar = true;
                    tienePunto = true;
                    jTFResultado.setText(String.format("%.5f", modelo.dividir(numero)));
                    //System.out.println(jTFResultado.getText());
                    break;
                default:
                    modelo.setResultado(numero);
                    limpiar = true;
                    tienePunto = true;

            }
//      Excepción para cuando ocurre un error durante el calculo, establece el
//      resultado a 0 y permite al usuario continuar si pulsa una tecla correcta
        } catch (NumberFormatException e) {
            jTFResultado.setText("Err");
            modelo.setResultado(0);
            limpiar = true;
            tienePunto = true;
        }
    }
    
    
//    Función con el código que necesario para generar un KeyBinding de esta
//    manera, no escribo el código todo el rato
    private void hacerKeyBindingParaBotones(JButton button,
            KeyStroke key, String mapKey) {
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(key, mapKey);
        button.getActionMap().put(mapKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                button.doClick();
            }
        });
    }
    
    //Metodo para generar los KeyBindings de los botones
    private void generarKeyBindigs() {
        hacerKeyBindingParaBotones(jB0,
                KeyStroke.getKeyStroke("0"), "1");
        hacerKeyBindingParaBotones(jB0,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD0, 0), "1");
        hacerKeyBindingParaBotones(jB1,
                KeyStroke.getKeyStroke("1"), "1");
        hacerKeyBindingParaBotones(jB1,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD1, 0), "1");
        hacerKeyBindingParaBotones(jB2,
                KeyStroke.getKeyStroke("2"), "2");
        hacerKeyBindingParaBotones(jB2,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD2, 0), "2");
        hacerKeyBindingParaBotones(jB3,
                KeyStroke.getKeyStroke("3"), "3");
        hacerKeyBindingParaBotones(jB3,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD3, 0), "3");
        hacerKeyBindingParaBotones(jB4,
                KeyStroke.getKeyStroke("4"), "4");
        hacerKeyBindingParaBotones(jB4,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD4, 0), "4");
        hacerKeyBindingParaBotones(jB5,
                KeyStroke.getKeyStroke("5"), "5");
        hacerKeyBindingParaBotones(jB5,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD5, 0), "5");
        hacerKeyBindingParaBotones(jB6,
                KeyStroke.getKeyStroke("6"), "6");
        hacerKeyBindingParaBotones(jB6,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD6, 0), "6");
        hacerKeyBindingParaBotones(jB7,
                KeyStroke.getKeyStroke("7"), "7");
        hacerKeyBindingParaBotones(jB7,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD7, 0), "7");
        hacerKeyBindingParaBotones(jB8,
                KeyStroke.getKeyStroke("8"), "8");
        hacerKeyBindingParaBotones(jB8,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD8, 0), "8");
        hacerKeyBindingParaBotones(jB9,
                KeyStroke.getKeyStroke("9"), "9");
        hacerKeyBindingParaBotones(jB9,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_NUMPAD9, 0), "9");
        hacerKeyBindingParaBotones(jBSumar,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_ADD, 0), "+");
        hacerKeyBindingParaBotones(jBSumar,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_PLUS, 0), "+");
        hacerKeyBindingParaBotones(jBRestar,
                KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "-");
        hacerKeyBindingParaBotones(jBRestar,
                KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "-");
        hacerKeyBindingParaBotones(jBMultiplicar,
                KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.SHIFT_DOWN_MASK), "*");
        hacerKeyBindingParaBotones(jBMultiplicar,
                KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "*");
        hacerKeyBindingParaBotones(jBMultiplicar,
                KeyStroke.getKeyStroke(KeyEvent.VK_ASTERISK, 0), "*");
        hacerKeyBindingParaBotones(jBDividir,
                KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.SHIFT_DOWN_MASK), "/");
        hacerKeyBindingParaBotones(jBDividir,
                KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "/");
        hacerKeyBindingParaBotones(jBMultiplicar,
                KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "/");
        hacerKeyBindingParaBotones(jBDecimal,
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_DECIMAL, 0), ",");
        hacerKeyBindingParaBotones(jBDecimal,
                KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0),
                ",");

    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTFResultado = new javax.swing.JTextField();
        jB7 = new javax.swing.JButton();
        jB8 = new javax.swing.JButton();
        jB9 = new javax.swing.JButton();
        jB4 = new javax.swing.JButton();
        jB5 = new javax.swing.JButton();
        jB6 = new javax.swing.JButton();
        jB1 = new javax.swing.JButton();
        jB2 = new javax.swing.JButton();
        jB3 = new javax.swing.JButton();
        jB0 = new javax.swing.JButton();
        jBDividir = new javax.swing.JButton();
        jBMultiplicar = new javax.swing.JButton();
        jBRestar = new javax.swing.JButton();
        jBDecimal = new javax.swing.JButton();
        jBSumar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTFResultado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTFResultado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFResultado.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 211;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 12);
        getContentPane().add(jTFResultado, gridBagConstraints);

        jB7.setText("7");
        jB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 6, 6);
        getContentPane().add(jB7, gridBagConstraints);

        jB8.setText("8");
        jB8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 6, 6);
        getContentPane().add(jB8, gridBagConstraints);

        jB9.setText("9");
        jB9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 6, 6);
        getContentPane().add(jB9, gridBagConstraints);

        jB4.setText("4");
        jB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 6, 6);
        getContentPane().add(jB4, gridBagConstraints);

        jB5.setText("5");
        jB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(jB5, gridBagConstraints);

        jB6.setText("6");
        jB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(jB6, gridBagConstraints);

        jB1.setText("1");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 6, 6);
        getContentPane().add(jB1, gridBagConstraints);

        jB2.setText("2");
        jB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(jB2, gridBagConstraints);

        jB3.setText("3");
        jB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(jB3, gridBagConstraints);

        jB0.setText("0");
        jB0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 12, 6);
        getContentPane().add(jB0, gridBagConstraints);

        jBDividir.setText("/");
        jBDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDividirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 6, 12);
        getContentPane().add(jBDividir, gridBagConstraints);

        jBMultiplicar.setText("*");
        jBMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMultiplicarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 12);
        getContentPane().add(jBMultiplicar, gridBagConstraints);

        jBRestar.setText("-");
        jBRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRestarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 12);
        getContentPane().add(jBRestar, gridBagConstraints);

        jBDecimal.setText(",");
        jBDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDecimalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 12, 6);
        getContentPane().add(jBDecimal, gridBagConstraints);

        jBSumar.setText("+");
        jBSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSumarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 12, 12);
        getContentPane().add(jBSumar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB8ActionPerformed
        // TODO add your handling code here:
        escribir("8");
    }//GEN-LAST:event_jB8ActionPerformed

    private void jB9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB9ActionPerformed
        // TODO add your handling code here:
        escribir("9");
    }//GEN-LAST:event_jB9ActionPerformed

    private void jBDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDividirActionPerformed
        // TODO add your handling code here:
        operar();
        operador = '/';
    }//GEN-LAST:event_jBDividirActionPerformed

    private void jBMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMultiplicarActionPerformed
        // TODO add your handling code here:
        operar();
        operador = '*';
    }//GEN-LAST:event_jBMultiplicarActionPerformed

    private void jBRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRestarActionPerformed
        // TODO add your handling code here:
        operar();
        operador = '-';
    }//GEN-LAST:event_jBRestarActionPerformed

    private void jBDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDecimalActionPerformed
        // TODO add your handling code here:
        if (tienePunto != true) {
            escribir(".");
            tienePunto = true;
        }
    }//GEN-LAST:event_jBDecimalActionPerformed

    private void jBSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSumarActionPerformed
        // TODO add your handling code here:
        operar();
        operador = '+';
    }//GEN-LAST:event_jBSumarActionPerformed

    private void jB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB7ActionPerformed
        // TODO add your handling code here:
        escribir("7");
    }//GEN-LAST:event_jB7ActionPerformed

    private void jB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4ActionPerformed
        // TODO add your handling code here:
        escribir("4");
    }//GEN-LAST:event_jB4ActionPerformed

    private void jB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5ActionPerformed
        // TODO add your handling code here:
        escribir("5");
    }//GEN-LAST:event_jB5ActionPerformed

    private void jB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3ActionPerformed
        // TODO add your handling code here:
        escribir("3");
    }//GEN-LAST:event_jB3ActionPerformed

    private void jB0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB0ActionPerformed
        // TODO add your handling code here:
        escribir("0");
    }//GEN-LAST:event_jB0ActionPerformed

    private void jB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6ActionPerformed
        // TODO add your handling code here:
        escribir("6");
    }//GEN-LAST:event_jB6ActionPerformed

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        // TODO add your handling code here:
        escribir("1");
    }//GEN-LAST:event_jB1ActionPerformed

    private void jB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2ActionPerformed
        // TODO add your handling code here:
        escribir("2");
    }//GEN-LAST:event_jB2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB0;
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JButton jB3;
    private javax.swing.JButton jB4;
    private javax.swing.JButton jB5;
    private javax.swing.JButton jB6;
    private javax.swing.JButton jB7;
    private javax.swing.JButton jB8;
    private javax.swing.JButton jB9;
    private javax.swing.JButton jBDecimal;
    private javax.swing.JButton jBDividir;
    private javax.swing.JButton jBMultiplicar;
    private javax.swing.JButton jBRestar;
    private javax.swing.JButton jBSumar;
    private javax.swing.JTextField jTFResultado;
    // End of variables declaration//GEN-END:variables
}
