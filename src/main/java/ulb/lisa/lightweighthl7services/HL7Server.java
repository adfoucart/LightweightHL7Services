/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.lightweighthl7services;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionListener;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Adrien Foucart
 */
public class HL7Server {
    private HL7Service listener;
    private ArrayList<String> logs;
    private boolean validate = true;
    
    public HL7Server(){
        logs = new ArrayList();
    }
    
    public void startHL7Listener(int port){
        logs.add("Starting HL7 Listener on port " + port + ".");
        if( listener == null ){
            HapiContext ctxt = new DefaultHapiContext();
            listener = ctxt.newServer(port, false);
        }
        
        if( isListeningToHL7() ){
            logs.add("HL7 Server is already running.");
            return;
        }
        
        ReceivingApplication<Message> handler = new ReceiverApplication();
        listener.registerApplication(handler);
        listener.registerConnectionListener(new MyConnectionListener());
        try {
            listener.startAndWait();
        } catch (InterruptedException ex) {
            logs.add("Interrupted HL7 Listener");
        }
        
        logs.add("HL7 Server is started.");
    }
    
    public void stopHL7Listener(){
        listener.stop();
        logs.add("HL7 Server is stopped.");
    }
    
    public boolean isListeningToHL7(){        
        return ( listener != null && listener.isRunning() );
    }

    public ArrayList<String> getLogs() {
        return logs;
    }

    void setValidating(boolean selected) {
        validate = selected;
    }
    
    private class ReceiverApplication implements ReceivingApplication<Message> {
        @Override
        public Message processMessage(Message t, Map<String, Object> map) throws ReceivingApplicationException, HL7Exception {
            HapiContext ctxt = new DefaultHapiContext();
            ctxt.getParserConfiguration().setValidating(validate);
            String encodedMessage = ctxt.getPipeParser().encode(t);
            logs.add("Received message:\n" + encodedMessage + "\n");
            
            try {
                return t.generateACK();
            } catch (IOException ex) {
                return null;
            }
        }

        @Override
        public boolean canProcess(Message t) {
            return true;
        }
        
    }
    
    private class MyConnectionListener implements ConnectionListener {

        @Override
        public void connectionReceived(Connection conn) {
            logs.add("New connection: " + conn.getRemoteAddress().toString());
        }

        @Override
        public void connectionDiscarded(Connection conn) {
            logs.add("Disconnected: " + conn.getRemoteAddress().toString());
        }
        
    }
}
