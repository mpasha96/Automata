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
public class NFA {

    int initial_state;
    ArrayList<Integer> final_state;
    char[] charArr = {'a', 'b'};
    ArrayList<ArrayList<TransitionObject>> transitionList;

    public int transition(int state, char ch, int i) {
        if (transitionList.get(state).get(i).ch == ch) {
            return transitionList.get(state).get(i).state;
        } else {
            return 99;
        }
    }

    public NFA(int initial_state, ArrayList<Integer> final_state, ArrayList<ArrayList<TransitionObject>> transitionList) {
        this.initial_state = initial_state;
        this.final_state = final_state;
        this.transitionList = transitionList;
    }
}
