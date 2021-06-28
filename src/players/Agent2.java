package players;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

public class Agent2 extends Agent {
    String content;
    protected void setup()
    {
        System.out.println("Agent2 started");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    JOptionPane.showMessageDialog(new JFrame(),"message 2 "+ message.getContent());
                }
            }
        });

    }
    protected void takeDown()
    {
        System.out.println("agent2 killed");
    }
}
