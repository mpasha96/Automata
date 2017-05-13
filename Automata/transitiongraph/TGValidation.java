/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitiongraph;

import java.util.List;

/**
 *
 * @author Admin
 */
public class TGValidation {
    int[] initial_state;
    String[] stringarr;
    int[] final_state;
    List<List<TransitionObject>> liist;
    int lastState;
    
    public boolean validate(String input)
    {
        for (int j = 0; j < 10; j++) {

        lastState= initial_state[j];
        
        for (int i = 0; i <input.length(); i++) {
            lastState = transition(lastState,input.charAt(i));
            if (lastState == -1)
            {
                return false;
            }
        }
        
        for (int i = 0; i <final_state.length; i++) {
            if(lastState==final_state[i])
                return true;
        }
        }
        return false;
    }
    
    private int transition(int state,char ch)
    {
        for (int i = 0; i <stringarr.length; i++) 
        {    
            if (true)
                return liist.get(i).indexOf(i);
        }
        return -1;
    }
    TGValidation(int[] initial_state, int[] final_state, List<List<TransitionObject>> liist)
    {
        this.initial_state = initial_state;
        this.final_state = final_state;
        this.liist = liist;    
    }
    
}
