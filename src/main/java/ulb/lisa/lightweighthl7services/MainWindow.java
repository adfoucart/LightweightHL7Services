/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.lightweighthl7services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Adrien Foucart
 */
public class MainWindow extends javax.swing.JFrame {
    
    private final HL7Server listener = new HL7Server();
    private final ListenerLogs listenerLogs = new ListenerLogs();
    private final HL7Client client = new HL7Client();
    private final ClientLogs clientLogs = new ClientLogs();
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        openMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageExplorer = new javax.swing.JTextArea();
        startListenerButton = new javax.swing.JButton();
        localPortField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listenerLogsField = new javax.swing.JTextArea();
        sendMessageButton = new javax.swing.JButton();
        remotePortField = new javax.swing.JTextField();
        remoteHostField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        senderLogsField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lightweight HL7 Services");
        jLabel1.setOpaque(true);

        openMessageButton.setText("Open message");
        openMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMessageButtonActionPerformed(evt);
            }
        });

        messageExplorer.setColumns(20);
        messageExplorer.setRows(5);
        jScrollPane1.setViewportView(messageExplorer);

        startListenerButton.setText("Start Listener");
        startListenerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startListenerButtonActionPerformed(evt);
            }
        });

        localPortField.setText("65432");

        listenerLogsField.setColumns(20);
        listenerLogsField.setRows(5);
        jScrollPane2.setViewportView(listenerLogsField);

        sendMessageButton.setText("Send");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        remotePortField.setText("54321");

        remoteHostField.setText("localhost");

        senderLogsField.setColumns(20);
        senderLogsField.setRows(5);
        jScrollPane3.setViewportView(senderLogsField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(startListenerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remoteHostField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remotePortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMessageButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openMessageButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openMessageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startListenerButton)
                    .addComponent(localPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendMessageButton)
                    .addComponent(remotePortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remoteHostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMessageButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        
        if( fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
            File selectedFile = fc.getSelectedFile();
            try {
                String encoded = Files.readString(Path.of(selectedFile.toString()));
                messageExplorer.setText(encoded);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openMessageButtonActionPerformed

    private void startListenerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startListenerButtonActionPerformed
        if( listener.isListeningToHL7() ){
            listenerLogs.stop();
            listener.stopHL7Listener();
            startListenerButton.setText("Start Listener");
        }
        else{
            listener.startHL7Listener(Integer.valueOf(localPortField.getText()));
            startListenerButton.setText("Stop Listener");
            Thread t = new Thread(listenerLogs);
            t.start();
        }
    }//GEN-LAST:event_startListenerButtonActionPerformed

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        String msg = messageExplorer.getText();
        
        if( msg.length() == 0 ){
            senderLogsField.setText("Empty message field.");
            return;
        }
        
        if( !clientLogs.isRunning() ){
            Thread t = new Thread(clientLogs);
            t.start();
        }
        
        client.sendMessage(msg, remoteHostField.getText(), Integer.valueOf(remotePortField.getText()));
    }//GEN-LAST:event_sendMessageButtonActionPerformed
    
    private class ListenerLogs implements Runnable {
        
        private boolean running;
        
        @Override
        public void run() {
            running = true;
            
            while(running){
                try {
                    if( listener == null ){
                        listenerLogsField.setText("No listener running.");
                        return;
                    }
                    ArrayList<String> logs = listener.getLogs();
                    listenerLogsField.setText("");
                    if(logs.size() < 5) {
                        for(String logItem : logs) {
                            listenerLogsField.append(logItem + "\n");
                        }
                    } else {
                        for(String logItem : logs.subList(logs.size() - 5, logs.size())) {
                            listenerLogsField.append(logItem + "\n");
                        }
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    listenerLogsField.setText("Interrupted ListenerLogs");
                }
            }
        }
        
        public void stop(){
            listenerLogsField.setText("Stopping.");
            running = false;
            
            try {
                Thread.sleep(1000); // let current loop go through
            } catch (InterruptedException ex) {
                listenerLogsField.setText("Interrupted while stopping.");
            }
            listenerLogsField.setText("Stopped.");
        }
    
    }
    
    private class ClientLogs implements Runnable {
        
        private boolean running;
        
        @Override
        public void run() {
            running = true;
            
            while(running){
                try {
                    if( client == null ){
                        senderLogsField.setText("No client running.");
                        return;
                    }
                    ArrayList<String> logs = client.getLogs();
                    senderLogsField.setText("");
                    if (logs.size() < 5) {
                        for (String logItem : logs) {
                            senderLogsField.append(logItem + "\n");
                        }
                    } else {
                        for (String logItem : logs.subList(logs.size() - 5, logs.size())) {
                            senderLogsField.append(logItem + "\n");
                        }
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    senderLogsField.setText("Interrupted ClientLogs");
                }
            }
        }
        
        public void stop(){
            senderLogsField.setText("Stopping.");
            running = false;
            
            try {
                Thread.sleep(1000); // let current loop go through
            } catch (InterruptedException ex) {
                senderLogsField.setText("Interrupted while stopping.");
            }
            senderLogsField.setText("Stopped.");
        }
        
        public boolean isRunning(){
            return running;
        }
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea listenerLogsField;
    private javax.swing.JTextField localPortField;
    private javax.swing.JTextArea messageExplorer;
    private javax.swing.JButton openMessageButton;
    private javax.swing.JTextField remoteHostField;
    private javax.swing.JTextField remotePortField;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JTextArea senderLogsField;
    private javax.swing.JButton startListenerButton;
    // End of variables declaration//GEN-END:variables
}
