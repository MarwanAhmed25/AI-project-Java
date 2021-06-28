/* java project ,their is 16 team and this project make each team play with anther team randomly and the first level will
   and 8 teams only will go to the next level and so on to get the winner of the 16 level and show the results in JOptionPane
   gui and using jade {agent , AclMessage } to sending and receiving the messages between the classes.

   to rin this project need to import jade to the project.
 */
package test;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main extends Agent {
    String[] agents=Data.agents;
    String[] aga=Data.aga;
    String[] info=Data.info;
    @Override
    protected void setup() {
        System.out.println("Main start");
        for (int i=0;i<agents.length;i++)
        {
            ACLMessage acl = new ACLMessage(ACLMessage.INFORM);
            acl.addReceiver(new AID(agents[i], false));
            acl.setContent(info[i]);
            send(acl);
            ACLMessage acl2 = new ACLMessage(ACLMessage.INFORM);
            acl2.addReceiver(new AID(aga[i], false));
            acl2.setContent(info[i]);
            send(acl2);
        }

    }

}
