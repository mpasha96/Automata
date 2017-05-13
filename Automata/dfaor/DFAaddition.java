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

public class DFAaddition {
    
    int[][] tt1 = {{1,0},{2,0},{2,2}};
    DFA dfa1 = new DFA(0,new int[]{2},tt1);
    int[][] tt2 = {{2,1},{3,0},{0,3},{1,2}};
    DFA dfa2 = new DFA(0,new int[]{0},tt2);

    ArrayList<Combinations> state_comb = new ArrayList<Combinations>();
    ArrayList ttvar1 = new ArrayList();
    ArrayList ttvar2 = new ArrayList();
   
    char[] ch = {'a','b'};
    Combinations temp;
    int counter=0;
    
    int[][] finalTT;
    ArrayList<Integer> FSofFinalFA = new ArrayList<Integer>();
    int ISofFinalFA=0;
    
    public void combinations()
    {
        state_comb.add(new Combinations(dfa1.initial_state,dfa2.initial_state));

        while (counter<state_comb.size())
        {
            
            for(char c : ch)
            {
                int x = dfa1.transition(state_comb.get(counter).x, c);
                int y = dfa2.transition(state_comb.get(counter).y, c);
                
                temp = new Combinations(x,y);
                int value= checkCombinationXY(x,y);
                
                if (value==-1)
                {
                    state_comb.add(temp);  
                    
                    if (c == 'a')
                        ttvar1.add(state_comb.size() - 1);
                    if (c == 'b')
                        ttvar2.add(state_comb.size() - 1);
                }
                else
                {
                    
                    if (c == 'a')
                        ttvar1.add(value);
                    if (c == 'b')
                        ttvar2.add(value);
                }      
            }
            counter++;
        }
    }
    
    public int checkCombinationXY(int x, int y) {
        for (int i = 0; i < state_comb.size(); i++) {
            Combinations temps = (Combinations) state_comb.get(i);
            if (temps.x == x && temps.y == y) {
                return i;
            }
        }
        return -1;
    }
        
    public void createFinalTT() {        
        finalTT = new int[this.state_comb.size()][2];
        
        for (int x = 0; x < finalTT.length; x++) {
            int a = (int) ttvar1.get(x);
            int b = (int) ttvar2.get(x);
            for (int y = 0; y < finalTT[x].length - 1; y++) {
                finalTT[x][y] = a;
                finalTT[x][y + 1] = b;
            }
        }
    }
    
    public void printfinalTT() {
        for (int x = 0; x < finalTT.length; x++) {
            for (int y = 0; y < finalTT[x].length; y++) {
                System.out.print(finalTT[x][y] + " ");
            }
            System.out.println();
        }
    }
    
    public void validate(String input) {        
        int currentState = ISofFinalFA;
        
        for(int i =0; i < input.length(); i++) {
            currentState = transition(currentState, input.charAt(i));
        }
        
        if(isFinalState(currentState)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
    
    public int transition(int state, char ch)
        {
            if (ch == 'a')
                return finalTT[state][0];
            if (ch == 'b')
                return finalTT[state][1];
            return 999;
    }
    
    
    public void finalStatesOfFinalFA()
    {
        int a =0;

        for (int i = 0; i <state_comb.size(); i++) {
            if(state_comb.get(i).x == 2 || state_comb.get(i).y == 0)
                FSofFinalFA.add(i);
            
        }
        
//        for(int x=0;x<state_comb.size();x++) {
//            Combinations CC = (Combinations) state_comb.get(x);
//            if(checkFAFinalStates(CC.x) || checkFAFinalStates(CC.y)) {
//                FSofFinalFA[a]= x;
//                a++;
//            }
//        }
        
        for (int i = 0; i <FSofFinalFA.size(); i++) {
            System.out.println(FSofFinalFA.get(i));
        }
    }
    
    public boolean isFinalState(int state)
    {
        for (int i = 0; i <FSofFinalFA.size(); i++) {
            if (state==FSofFinalFA.get(i))
                return true;
        }
        return false;
    }
    
//    public boolean checkFAFinalStates(int state) {
//        
//        for(int x = 0 ; x < max(dfa1.final_state.length,dfa2.final_state.length) ; x++) {
//            if(state == dfa1.final_state[x] || state == dfa2.final_state[x]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    int max(int a, int b)
//    {
//        if(a>b)
//            return a;
//        else return b;
//    }
    
//    public int countOfFinalStates()
//    {
//        int c = 0;
//
//        for(int x=0;x<state_comb.size();x++) 
//        {
//            Combinations CC = (Combinations) state_comb.get(x);
//            if(checkFAFinalStates(CC.x) || checkFAFinalStates(CC.y)) {
//                c++;
//            }
//        }
//        return c;   
//    }

}