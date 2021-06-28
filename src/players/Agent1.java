package players;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import test.Data;

import javax.swing.*;


public class Agent1 extends Agent {

    protected void setup()
    {
        System.out.println("Agent1 started");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message=receive();
                if (message!=null)
                {
                   JOptionPane.showMessageDialog(new JFrame(),"message 1 " + message.getContent());
                }
            }
        });

    }
    protected void takeDown()
    {
        System.out.println("agent1 killed");
    }

}

