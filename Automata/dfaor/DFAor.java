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

public class DFAor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        DFAaddition a= new DFAaddition();
//        a.combinations();
//        a.createFinalTT();
//        System.out.println("TT of Final DFA:");
//        a.printfinalTT();
//        System.out.println("final states:");
//        a.finalStatesOfFinalFA();
//        System.out.print("reuslt: ");
//        a.validate("aba");


        compliment x= new compliment();
        int[][] tt1 = {{1,0},{2,0},{2,2}};
        DFA a= x.DFAcompliment(new DFA(0,new int[]{0},tt1));    
        for (int i = 0; i <a.final_state.length; i++) {
            System.out.println(a.final_state[i]);
        }
        

    }
    
}
