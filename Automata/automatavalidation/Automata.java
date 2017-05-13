/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatavalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pasha
 */
public class Automata {
       
    int initial_state;
    String[] stringarr;
    int[] final_state;
    int[][] transitionTable;
            
    public boolean validate(String input)
    {
        int lastState= initial_state;
        
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
        return false;
    }
    
    private int transition(int state,char ch)
    {
        for (int i = 0; i <stringarr.length; i++) 
        {
            Pattern p = Pattern.compile(stringarr[i]);
            Matcher m = p.matcher(String.valueOf(ch));
            
            if (m.matches())
                return transitionTable[state][i];
        }
        return -1;
    }
    
    Automata(int initial_state, int[] final_state, String[] stringarr, int[][] transitionTable)
    {
        this.initial_state = initial_state;
        this.stringarr = stringarr;
        this.final_state = final_state;
        this.transitionTable = transitionTable;            
    }
}
