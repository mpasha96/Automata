/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfakleenclosure;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DFAKleenClosure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] tt = {{1, 0}, {1, 2}, {2, 2}};
//        int[][] tt = { { 1, 3 }, { 3, 2 },{ 3, 3},{3,3} };

        ArrayList<Integer> final_states = new ArrayList<Integer>();
        final_states.add(0);
        char[] charArr = {'a', 'b'};

        FA dfa = new FA(tt, 0, final_states, charArr);
        kleen a = new kleen(dfa);
        FA dfaFinal = a.kleenclosure();

        System.out.println("Transition Table:");
        dfaFinal.printTT();
        System.out.println("Final States");
        dfaFinal.printFinalStates();
        System.out.println("");

    }

}
