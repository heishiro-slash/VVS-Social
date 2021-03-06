/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.GUI;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import joinme.controlador.ControladorPerfil;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class Perfil extends javax.swing.JFrame {
    private static Usuario usuario;
    private static Usuario usuarioConsultado;
    
    private ControladorPerfil controlador;
    
    /**
     * Creates new form Perfil
     */
    public Perfil(Usuario usuario, Usuario usuarioConsultado) {
        this.usuario = usuario;
        this.usuarioConsultado = usuarioConsultado;
        controlador= new ControladorPerfil();
        initComponents();
        init();
    }
    
    private void init() {        
        jLabelNombre.setText(controlador.getNombre(usuarioConsultado));
        jLabelAp1.setText(controlador.getApellido1(usuarioConsultado));
        jLabelAp2.setText(controlador.getApellido2(usuarioConsultado));
        jLabelAlias.setText(controlador.getAlias(usuarioConsultado));
        jLabelCumple.setText(controlador.getFechaNac(usuarioConsultado));

        if (controlador.esAmigo(usuario, usuarioConsultado) || usuario.equals(usuarioConsultado))
            jBotonEnviarPeticion.setEnabled(false);
        
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
        //Entradas en el muro
        List<String> lista=null;
        lista = controlador.getEventos(usuario, usuarioConsultado);
        for (int i=0;i<lista.size();i++)
            modelo1.addElement(lista.get(i));
        jList1.setModel(modelo1);
        
        //Lista de no amigos
        List<String> listaNoAmigos=null;
        listaNoAmigos = controlador.getListaNoAmigos(usuario);
        for (int i=0;i<listaNoAmigos.size();i++)
            modelo2.addElement(listaNoAmigos.get(i));
        jListNoAmigos.setModel(modelo2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAp1 = new javax.swing.JLabel();
        jLabelAlias = new javax.swing.JLabel();
        jLabelCumple = new javax.swing.JLabel();
        jButtonDesconectar = new javax.swing.JButton();
        jLabelAp2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBotonVerAmigos = new javax.swing.JButton();
        jButtonPagPrincipal = new javax.swing.JButton();
        jBotonPublicar = new javax.swing.JButton();
        jBotonEnviarPeticion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListNoAmigos = new javax.swing.JList();
        jVerUsuario = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil");

        jLabel1.setText("jLabelFoto");

        jLabelNombre.setText("jLabelNombre");

        jLabelAp1.setText("jLabelApellido");

        jLabelAlias.setText("jLabelUbic");

        jLabelCumple.setText("jLabelCumple");

        jButtonDesconectar.setText("Desconectar");
        jButtonDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesconectarActionPerformed(evt);
            }
        });

        jLabelAp2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAp1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAp2))
                            .addComponent(jLabelAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                        .addComponent(jButtonDesconectar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCumple, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDesconectar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAp1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNombre)
                        .addComponent(jLabelAp2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAlias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCumple)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jBotonVerAmigos.setText("Lista de amigos");
        jBotonVerAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonVerAmigosActionPerformed(evt);
            }
        });

        jButtonPagPrincipal.setText("Mi Pagina Principal");
        jButtonPagPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagPrincipalActionPerformed(evt);
            }
        });

        jBotonPublicar.setText("Publicar");
        jBotonPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonPublicarActionPerformed(evt);
            }
        });

        jBotonEnviarPeticion.setText("Peticion de amistad");
        jBotonEnviarPeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonEnviarPeticionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBotonEnviarPeticion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonPublicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonVerAmigos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPagPrincipal))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBotonEnviarPeticion, jBotonPublicar, jBotonVerAmigos, jButtonPagPrincipal});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBotonVerAmigos)
                .addComponent(jButtonPagPrincipal)
                .addComponent(jBotonPublicar)
                .addComponent(jBotonEnviarPeticion))
        );

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jScrollPane1);

        jListNoAmigos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListNoAmigos);

        jVerUsuario.setText("Ver Perfil");
        jVerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerUsuarioActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jLabel2.setText("Lista de no amigos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jVerUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jVerUsuario))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonPublicarActionPerformed
        controlador.publicarEntrada(usuario, this);
    }//GEN-LAST:event_jBotonPublicarActionPerformed

    private void jButtonPagPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagPrincipalActionPerformed
        controlador.pagPrincipal(usuario, this);
    }//GEN-LAST:event_jButtonPagPrincipalActionPerformed

    private void jButtonDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesconectarActionPerformed
        controlador.desconectar(this);
        
    }//GEN-LAST:event_jButtonDesconectarActionPerformed

    private void jBotonVerAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonVerAmigosActionPerformed
        controlador.verAmigosActionPerformed(usuario, usuarioConsultado, this);
    }//GEN-LAST:event_jBotonVerAmigosActionPerformed

    private void jBotonEnviarPeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonEnviarPeticionActionPerformed
        controlador.enviarSolicitud(usuario, usuarioConsultado, this);
    }//GEN-LAST:event_jBotonEnviarPeticionActionPerformed

    private void jVerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerUsuarioActionPerformed
        if(!jListNoAmigos.isSelectionEmpty()){
            String alias = (String) jListNoAmigos.getSelectedValue();
            controlador.getPerfil(alias, usuario, this);
        }
    }//GEN-LAST:event_jVerUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil(usuario,usuarioConsultado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonEnviarPeticion;
    private javax.swing.JButton jBotonPublicar;
    private javax.swing.JButton jBotonVerAmigos;
    private javax.swing.JButton jButtonDesconectar;
    private javax.swing.JButton jButtonPagPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAlias;
    private javax.swing.JLabel jLabelAp1;
    private javax.swing.JLabel jLabelAp2;
    private javax.swing.JLabel jLabelCumple;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JList jList1;
    private javax.swing.JList jListNoAmigos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jVerUsuario;
    // End of variables declaration//GEN-END:variables
}
