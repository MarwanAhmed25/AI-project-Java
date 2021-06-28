package players;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

public class Agent11 extends Agent {
    String content;
    protected void setup()
    {
        System.out.println("Agent11 started");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message=receive();
                if (message!=null)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"message 11 " +message.getContent());
                }

            }
        });
    }
    protected void takeDown()
    {
        System.out.println("agent11 killed");
    }
}
