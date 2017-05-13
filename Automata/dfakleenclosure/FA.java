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

class FA
    {
        public char[] charArr;
        public int[][] tt;
        public int initial_state;
        public ArrayList<Integer> final_states;

        public FA(int[][] tt, int initial_state, ArrayList<Integer> final_states, char[] charArr)
        {
            this.tt = tt;
            this.initial_state = initial_state;
            this.final_states = final_states;
            this.charArr = charArr;
        }

        public int transition(int st, char c)
        {
            if (c=='a')
                return tt[st][0];
            else if (c=='b')
                return tt[st][1];
            else return 99;           
        }
        
        public void printFinalStates()
        {
            for (int i = 0; i < final_states.size(); i++)
            {
                System.out.print(final_states.get(i) + "\t");
            }
        }
        
        public void printTT()
        {
            for (int i = 0; i < tt.length; i++)
            {
                for (int j = 0; j < charArr.length; j++)
                {
                    System.out.print(tt[i][j] + "\t");
                }
                System.out.println("");
            }
        }
    }
    