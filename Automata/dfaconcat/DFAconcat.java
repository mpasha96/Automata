/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaconcat;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class DFAconcat {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] tt1 = { { 1, 0 }, { 1, 0 } };
        int[][] tt2 = { { 1, 2 }, { 3, 2 }, { 1, 3 }, { 3, 3 } };
        
        ArrayList<Integer> final_states1 = new ArrayList<Integer>();
        final_states1.add(0);
        final_states1.add(1);

        ArrayList<Integer> final_states2 = new ArrayList<Integer>();
        final_states2.add(3);
        
        char[] charArr = { 'a', 'b' };
        FA dfa1 = new FA(tt1, 0, final_states1, charArr);
        FA dfa2 = new FA(tt2, 0, final_states2, charArr);         
           
        concatenation a = new concatenation(dfa1,dfa2);
        FA dfaFinal = a.dfaconcatination();
        
        System.out.println("Concatenated DFA's Transition Table:");
        dfaFinal.printTT();
        System.out.println("Concatenated DFA's Final States");
        dfaFinal.printFinalStates();
        System.out.println("");
        
    } 
}
