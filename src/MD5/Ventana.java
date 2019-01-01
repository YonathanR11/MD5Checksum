/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD5;

import java.awt.Color;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import me.marnic.jiconextract.extractor.IconSize;
import me.marnic.jiconextract.extractor.JIconExtractor;

/**
 *
 * @author Yonathan
 */




public class Ventana extends javax.swing.JFrame implements DropTargetListener{

    
    DropTarget dt,dt2;
    
    int fileSelect = 0;
    public static String f1,f2;
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.dt = new DropTarget(file1, this);
        dt2 = new DropTarget(file2, this);
        info.setVisible(false);
    }
    
    
    public void dragEnter(DropTargetDragEvent dtde) {
//        System.out.println("Drag Enter");
    }

    public void dragExit(DropTargetEvent dte) {
//        System.out.println("Drag Exit");
    }

    public void dragOver(DropTargetDragEvent dtde) {
//        System.out.println("Drag sobre");
    }

    public void dropActionChanged(DropTargetDragEvent dtde) {
//        System.out.println("Drop Acción cambiada");
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        if (fileSelect==0) {
        try {
            Transferable tr = dtde.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (int i = 0; i < flavors.length; i++) {
                if (flavors[i].isFlavorJavaFileListType()) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    java.util.List list = (java.util.List) tr.getTransferData(flavors[i]);
                    for (int j = 0; j < list.size(); j++) {
                        f1 = list.get(j).toString();
                        File name = new File(list.get(j).toString());
                        String Filename = name.getName();
                        nameFile1.setText(Filename);
                        BufferedImage image = JIconExtractor.getJIconExtractor().extractIconFromFile((File) list.get(j), IconSize.EXTRALARGE);
                        Icon icono = new ImageIcon(image);
                        file1.setIcon(icono);
                    }
                    dtde.dropComplete(true);
                    return;
                }
            }
            dtde.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
        }else{
           try {
            Transferable tr = dtde.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (int i = 0; i < flavors.length; i++) {
                if (flavors[i].isFlavorJavaFileListType()) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    java.util.List list = (java.util.List) tr.getTransferData(flavors[i]);
                    for (int j = 0; j < list.size(); j++) {
                        f2 = list.get(j).toString();
                        File name = new File(list.get(j).toString());
                        String Filename = name.getName();
                        long a = name.length();
                        System.err.println(a);
                        nameFile2.setText(Filename);
                        BufferedImage image = JIconExtractor.getJIconExtractor().extractIconFromFile((File) list.get(j), IconSize.EXTRALARGE);
                        Icon icono = new ImageIcon(image);
                        file2.setIcon(icono);
                    }
                    dtde.dropComplete(true);
                    return;
                }
            }
            dtde.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        } 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fondo = new javax.swing.JPanel();
        file1 = new javax.swing.JLabel();
        file2 = new javax.swing.JLabel();
        nameFile1 = new javax.swing.JLabel();
        nameFile2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        info = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MD5 Chechsum");
        setBackground(new java.awt.Color(255, 255, 255));

        fondo.setBackground(new java.awt.Color(255, 255, 255));

        file1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        file1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        file1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/archivo (1).png"))); // NOI18N
        file1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        file1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                file1MouseEntered(evt);
            }
        });

        file2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        file2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/archivo (1).png"))); // NOI18N
        file2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        file2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                file2MouseEntered(evt);
            }
        });

        nameFile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        nameFile2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Arrastra y suelta los archivos a verificar");

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Verificar");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        estado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Mas información");
        info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(file1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameFile1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(file2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameFile2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(info)
                .addGap(96, 96, 96))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(file1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(file2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameFile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameFile2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_file1MouseEntered
        fileSelect = 0;
    }//GEN-LAST:event_file1MouseEntered

    private void file2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_file2MouseEntered
        fileSelect = 1;
    }//GEN-LAST:event_file2MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (f1!=null && f2!=null) {
            
        Boolean isEquals = checksum(f1, f2);
        System.out.println("Equals? " + isEquals);
        if (isEquals) {
            estado.setBackground(Color.green);
            estado.setText("Son iguales");
        }else{
            estado.setBackground(Color.red);
            estado.setText("Son diferentes");
        }
        info.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "¡Debes seleccionar los 2 archivos primero!", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseClicked
        informacion abrir = new informacion(null, true);
        abrir.setLocationRelativeTo(fondo);
        abrir.setVisible(true);
    }//GEN-LAST:event_infoMouseClicked

    private FileInputStream openFile(String fileName) throws FileNotFoundException {
        return (new FileInputStream(fileName));
    }

    public Boolean checksum(String filePath1, String filePath2) {
        FileInputStream file1 = null, file2 = null;
        MessageDigest md = null;

        try {
            file1 = openFile(filePath1);
            file2 = openFile(filePath2);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        String hash1 = generateHashForFile(file1, md);
        String hash2 = generateHashForFile(file2, md);
        return (hash1.equals(hash2));
    }

    private String generateHashForFile(FileInputStream file, MessageDigest md) {
        DigestInputStream fileDigest = new DigestInputStream(file, md);

        try {
            while (fileDigest.read() != -1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        byte[] digested1 = md.digest();
        String hash = byteToHex(digested1);
        return hash;
    }

    private String byteToHex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String hash = formatter.toString();
        formatter.close();
        return hash;
    }

    
    
    
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estado;
    private javax.swing.JLabel file1;
    private javax.swing.JLabel file2;
    public javax.swing.JPanel fondo;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nameFile1;
    private javax.swing.JLabel nameFile2;
    // End of variables declaration//GEN-END:variables

    
}
