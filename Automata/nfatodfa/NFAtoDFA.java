/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfatodfa;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NFAtoDFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<ArrayList<TransitionObject>> TTList = new ArrayList<ArrayList<TransitionObject>>();

        TTList.add(new ArrayList<TransitionObject>());
        TTList.get(0).add(new TransitionObject('a', 1));
        TTList.get(0).add(new TransitionObject('a', 2));

        TTList.add(new ArrayList<TransitionObject>());
        TTList.get(1).add(new TransitionObject('a', 4));

        TTList.add(new ArrayList<TransitionObject>());
        TTList.get(2).add(new TransitionObject('b', 1));
        TTList.get(2).add(new TransitionObject('b', 2));
        TTList.get(2).add(new TransitionObject('b', 3));

        TTList.add(new ArrayList<TransitionObject>());
        TTList.get(3).add(new TransitionObject('b', 4));

        TTList.add(new ArrayList<TransitionObject>());
        TTList.get(4).add(new TransitionObject('a', 3));

        ArrayList<Integer> final_states = new ArrayList<Integer>();
        final_states.add(3);
        final_states.add(4);
        final_states.add(0);

        NFA nfa = new NFA(0, final_states, TTList);
        conversion nfaobj = new conversion(nfa);
        FA dfa = nfaobj.convert();

        System.out.println("Transition Table:");
        dfa.printTT();
        System.out.println("Final States");
        dfa.printFinalStates();
        System.out.println("");

    }
}
