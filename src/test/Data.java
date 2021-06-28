/* java project ,their is 16 team and this project make each team play with anther team randomly and the first level will
   and 8 teams only will go to the next level and so on to get the winner of the 16 level and show the results in JOptionPane
   gui and using jade {agent , AclMessage } to sending and receiving the messages between the classes.

   to rin this project need to import jade to the project.
 */
package test;
import jade.core.AID;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import javax.swing.*;
import java.sql.Time;
import java.util.*;
import java.util.Random;

import static test.Main.*;

public class Data extends Agent {
    //////////////////////////
    static jade.core.Runtime r= jade.core.Runtime.instance();
    static Profile p=new ProfileImpl();
    static ContainerController main1=r.createMainContainer(p);
    /////////////////////////
    //main function tne begin function of application run the Agent of Data class;
    public static void main(String[] args) throws StaleProxyException
    {
        AgentController Data=main1.createNewAgent("Data","test.Data",null);
        Data.start();
    }
    // override function called when Agent of this class created, run 16 agent and the central agent test.Main;
    @Override
    protected void setup() {
        // exception handling for invoke the main2();
        try {
            main2();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // create central agent of the application
        try {
            AgentController Main = main1.createNewAgent("Main","test.Main",null);
            Main.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        try {
            showResualt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // function to declare all agents in the Application
    public void main2() throws StaleProxyException, InterruptedException
    {
        try
        {
            AgentController Agent1=main1.createNewAgent("Agent1","players.Agent1",null);
            Agent1.start();
            AgentController Agent2=main1.createNewAgent("Agent2","players.Agent2",null);
            Agent2.start();
            AgentController Agent3=main1.createNewAgent("Agent3","players.Agent3",null);
            Agent3.start();
            AgentController Agent4=main1.createNewAgent("Agent4","players.Agent4",null);
            Agent4.start();
            AgentController Agent5=main1.createNewAgent("Agent5","players.Agent5",null);
            Agent5.start();
            AgentController Agent6=main1.createNewAgent("Agent6","players.Agent6",null);
            Agent6.start();
            AgentController Agent7=main1.createNewAgent("Agent7","players.Agent7",null);
            Agent7.start();
            AgentController Agent8=main1.createNewAgent("Agent8","players.Agent8",null);
            Agent8.start();
            AgentController Agent9=main1.createNewAgent("Agent9","players.Agent9",null);
            Agent9.start();
            AgentController Agent10=main1.createNewAgent("Agent10","players.Agent10",null);
            Agent10.start();
            AgentController Agent11=main1.createNewAgent("Agent11","players.Agent11",null);
            Agent11.start();
            AgentController Agent12=main1.createNewAgent("Agent12","players.Agent12",null);
            Agent12.start();
            AgentController Agent13=main1.createNewAgent("Agent13","players.Agent13",null);
            Agent13.start();
            AgentController Agent14=main1.createNewAgent("Agent14","players.Agent14",null);
            Agent14.start();
            AgentController Agent15=main1.createNewAgent("Agent15","players.Agent15",null);
            Agent15.start();
            AgentController Agent16=main1.createNewAgent("Agent16","players.Agent16",null);
            Agent16.start();
           AgentController Main=main1.createNewAgent("Main","test.Main",null);
           Main.start();
        }
        catch (StaleProxyException e)
        {
            e.printStackTrace();
        }

        display();
        display();
        display();
        display();
        //showResualt();
    }
    // array of string , the names of the 16 agents;
    static String[] teams={"Agent1","Agent2","Agent3","Agent4","Agent5","Agent6","Agent7","Agent8","Agent9","Agent10","Agent11","Agent12","Agent13","Agent14","Agent15","Agent16"};
    // array of string , the referees of the champions league;
    static String[] referees={"vector","gomase","mosemany","gehad","ibrahim","irksen","nour","betso","jassama","marwan","sad eldin","magdy","samir esman","kanty","andres","bakary"};
    // array of string , the playgrounds of the champions league
    static String[] playgrounds={"wanda","metro","elentag","rades","wolves","elethad","ghazle elmhala","emarat","manshster","uitedStudium","anfeld","elslam","brgElarab","cairoStudium","bernabio","cambno"};
    // list to convert teams array to list to use collection.shuffle;
    static List<String> list=Arrays.asList(teams);
    // array of string to store the winners of matches;
    static String[] winers=new String[8];
    // array of string to store the name of agents and their message;
    static String[] agents=new String[15];
    // array of string to store the message of the agents;
    static String[] info=new String[15];
    // array to store the name of agents to sending a message;
    static String[] aga=new String[15];
    // array of integer to get the random score of matches from it;
    static Integer[] s={0,1,2,3,4,5,6};
    // array of string to store the score of all matches in the league;
    static String[] allScores=new String[15];
    // function to return random referee from referees[];
    static String getReferee()
    {
       int ind=random(referees.length);
       String refree=referees[ind];
       referees=removeTheElement(referees,ind);
       return refree;
    }
    // function to return random playground from playgrounds[];
    static String getPlayground()
    {
        int ind=random(playgrounds.length);
        String ground=playgrounds[ind];
        playgrounds=removeTheElement(playgrounds,ind);
        return ground;
    }
    // function to return random number of a specific range[0 - mod];
    static int random(int mod)
    {
        Random rand = new Random();
        int l= (rand.nextInt());
        if(l<0)
            l=l*-1;
        l=l%mod;
        return l;
    }
    // function to remove an element from array with index;
    static String[] removeTheElement(String[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    // function to remove an element from array with the element;
    static String[] removeElements(String[] input, String deleteMe)
    {
        List result = new LinkedList();

        for(String item : input)
            if(!deleteMe.equals(item))
                result.add(item);
        result.toArray(input);
        return input;
    }
    // in used as an index in the allScores[] in score function;
    static int in=0;
    // score function generate the score of the matches and return the winner;
    static String score(String agent1,String agent2)
    {
        int a1=random(s.length);
        int a2=random(s.length);
        if(a1==a2)
            a2++;
        if (a1 < a2)
        {
            allScores[in]=agent1+" lose from "+ agent2 + "  " + a2 +"-"+ a1;
            JOptionPane.showMessageDialog(new JFrame(),allScores[in]);
            in++;
            return agent2;
        }
        else
        {
            allScores[in]=agent2+" lose from "+ agent1 +"  " + a1 +"-"+ a2;
            JOptionPane.showMessageDialog(new JFrame(),allScores[in]);
            in++;
            return agent1;
        }

    }
    // function run the all function in this class and show the chart of matches and the winners and all data about the matches;
    static int j1=0;
    public static void display()
    {
        Collections.shuffle(list);
        list.toArray(teams);
        int j = 0;
        for (int i = 1; i < teams.length; i++) {
            String z=(teams[i - 1] + " vs " + teams[i] + ", the ground is " + getPlayground() + ", the referee : " + getReferee()+ ", begin now: " );
            System.out.println(z);
            agents[j1]=teams[i-1];
            info[j1]=z;
            aga[j1]=teams[i];
            String winer=score(teams[i - 1], teams[i]);
            System.out.println(winer);
            winers[j]=winer;
            j++;
            j1++;
            i++;
        }
        System.out.println("\n");
        teams=winers;
        int len =winers.length;
        if(len==1)
        {
            System.out.println("the champion is: " + winers[0]);
            JOptionPane.showMessageDialog(new JFrame(),"the champion is: " + winers[0]);
        }
        winers=new String[len/2];
    }
    // function used to show all matches resault after 10 seconds;
    public static void showResualt() throws InterruptedException
    {
        for (int i = 0; i < allScores.length; i++) {
            System.out.println(allScores[i]);
        }
        JOptionPane.showMessageDialog(new JFrame(), allScores, "Champions league Finished : " , JOptionPane.INFORMATION_MESSAGE);
    }

}
