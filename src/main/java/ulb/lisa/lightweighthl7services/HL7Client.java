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
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.parser.Parser;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrien Foucart
 */
public class HL7Client {
    
    private ArrayList<String> logs = new ArrayList();
    
    public ACK sendMessage(String msg, String host, int port){
        HapiContext ctxt = new DefaultHapiContext();
        Parser parser = ctxt.getPipeParser();

        Connection conn;
        try {
            conn = ctxt.newClient(host, port, false);
        } catch (HL7Exception ex) {
            logs.add("Failed to connect to host.");
            return null;
        }
        
        Initiator init = conn.getInitiator();
        Message response;
        try {
            response = init.sendAndReceive(parser.parse(msg));
        } catch (LLPException | HL7Exception | IOException ex) {
            logs.add("Failed to send message.");
            return null;
        }
        
        logs.add("Sending message: " + msg);

        String encodedResponse;
        try {
            encodedResponse = parser.encode(response);
            logs.add("Response:" + encodedResponse);
        } catch (HL7Exception ex) {
            logs.add("Failed to parse response.");
        }

        if( response instanceof ACK ){
            return (ACK) response;
        }
        
        return null;
    }
    
    public ArrayList<String> getLogs(){
        return logs;
    }
}
