/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaor;

/**
 *
 * @author Admin
 */
public class DFA {
        int initial_state;
        int[] final_state;
        int[][] transitionTable;

        public int transition(int state, char ch)
        {
            if (ch == 'a')
                return transitionTable[state][0];
            if (ch == 'b')
                return transitionTable[state][1];
            return 999;
        }

        public DFA(int initial_state, int[] final_state, int[][] transitionTable)
        {
            this.initial_state = initial_state;
            this.final_state = final_state;
            this.transitionTable = transitionTable;
        }
        

}
