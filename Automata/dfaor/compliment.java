/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaor;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class compliment {
    
   public DFA DFAcompliment(DFA dfa)
   {
        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();
        int c=0;
        
        for (int i = 0; i < dfa.transitionTable.length; i++)
        {
            for (int j = 0; j < dfa.final_state.length; j++)
            {
                if (i == dfa.final_state[j])
                {
                    x.add(i);
                }
            }
        }
        
        for (int i = 0; i <dfa.transitionTable.length; i++) {
           
            if(!x.contains(i))
            { 
               y.add(i);
               
            }
        }
       
        int[] newFS = new int[y.size()];

        for (int i = 0; i <y.size(); i++) {
            newFS[c]=(int)y.get(i);
            
            c++;
        }
       
//printing new arr
//        System.out.println("");
//        for (int i = 0; i <arr.length; i++) {
//            System.out.println(arr[i]);
//        }
       
        DFA newdfa = new DFA(dfa.initial_state,newFS,dfa.transitionTable);
        return newdfa;
   }
}
