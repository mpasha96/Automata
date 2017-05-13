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
public class concatenation {
    
        FA dfa1;
        FA dfa2;
        
        public concatenation(FA dfa1, FA dfa2)
        {
            this.dfa1 = dfa1;
            this.dfa2 = dfa2;
        }

        public FA dfaconcatination()
        {
            int curr_state = dfa1.initial_state;
            
            ArrayList<int[]> ttArray = new ArrayList<int[]>();
            ArrayList<ArrayList<Integer>> comb_list = new ArrayList<ArrayList<Integer>>();
            comb_list.add(new ArrayList<Integer>());
            ArrayList<Integer> final_states = new ArrayList<Integer>();

            
            comb_list.get(0).add(dfa1.initial_state);           
            if (dfa1.final_states.contains(dfa1.initial_state))
            {
                comb_list.get(0).add(dfa2.initial_state);
            }
            
            for (int u = 0; ; u++)
            {
                
                int[] tempArr = new int[dfa1.charArr.length];

                for (int j = 0; j < tempArr.length; j++)
                {
                    ArrayList<Integer> temp1 = new ArrayList<Integer>();
                    ArrayList<Integer> temp2 = new ArrayList<Integer>();
                    
                    //transition of dfa1
                    int st1 = dfa1.transition(curr_state, dfa1.charArr[j]);
                    temp1.add(st1);
                    if (dfa1.final_states.contains(st1))
                    {
                        temp2.add(dfa2.initial_state);
                    }

                    //transition of dfa2 list
                    for (int i = 0; i < comb_list.get(u).size() - 1; i++)
                    {
                        int currst2 = comb_list.get(u).get(i + 1);
                        int st2 = dfa2.transition(currst2, dfa2.charArr[j]);
                        if (!temp2.contains(st2))
                        {
                            temp2.add(st2);
                        }
                    }
                    temp2.sort(null);
                    
                    //adding dfa2equations(temp2) in tem1
                    for (int i = 0; i < temp2.size(); i++)
                    {
                        temp1.add(temp2.get(i));
                    }
                    
                    if (contain(comb_list, temp1))
                    {
                        comb_list.add(temp1);
                    }
                    
                    int index = findindex(comb_list, temp1);
                    tempArr[j] = index;

                }

                ttArray.add(tempArr);
                

                if (u + 1 < comb_list.size())
                {
                    curr_state = comb_list.get(u + 1).get(0);
                }
                else
                {
                    break;
                }
            }

            int[][] finalTT = new int[ttArray.size()][dfa2.charArr.length];
            setFinalTT(ttArray,finalTT);
            setFinalStates(comb_list,final_states);         
            
            FA finalObj = new FA(finalTT, 0, final_states, dfa2.charArr);
            return finalObj;

        }
        
        public void setFinalStates(ArrayList<ArrayList<Integer>> comb_list,ArrayList<Integer> final_states)
        {
           for (int i = 1; i < comb_list.size(); i++)
            {
                for (int j = 0; j < comb_list.get(i).size(); j++)
                {
                    if (dfa2.final_states.contains(comb_list.get(i).get(j)) && !final_states.contains(i))
                    {
                        final_states.add(i);
                    }
                }
            }   
        }
        
        public void setFinalTT(ArrayList<int[]> ttArray,int[][] finalTT)
        {
            for (int i = 0; i < ttArray.size(); i++)
            {
                int[] t = ttArray.get(i);
                for (int j = 0; j < dfa2.charArr.length; j++)
                {
                    finalTT[i][j] = t[j];
                }
            }
        }
        
        public boolean contain(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> b)
        {
            for (int i = 0; i < a.size(); i++)
            {
                int count = 0;
                for (int j = 0; j < b.size() && j < a.get(i).size(); j++)
                {
                    if (a.get(i).get(j) == b.get(j))
                    {
                        count++;
                    }
                }
                if (count == b.size() && b.size()==a.get(i).size())
                {
                    return false;
                }
            }
            return true;
        }
  
        public int findindex(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> b)
        {
            for (int i = 0; i < a.size(); i++)
            {
                int count = 0;
                for (int j = 0; j < b.size() && j < a.get(i).size(); j++)
                {
                    if (a.get(i).get(j) == b.get(j))
                    {
                        count++;
                    }
                }
                if (count == b.size() && b.size()==a.get(i).size())
                {
                    return i;
                }
            }
            return -1;
        }
    }