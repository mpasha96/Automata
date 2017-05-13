/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfatodfa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class conversion {

    NFA nfa;

    public conversion(NFA nfa) {
        this.nfa = nfa;
    }

    public FA convert() {
        int curr_state = nfa.initial_state;

        ArrayList<int[]> ttArray = new ArrayList<int[]>();
        ArrayList<ArrayList<Integer>> comb_list = new ArrayList<ArrayList<Integer>>();
        comb_list.add(new ArrayList<Integer>());
        ArrayList<Integer> final_states = new ArrayList<Integer>();

        comb_list.get(0).add(nfa.initial_state);

        int u = 0;
        int x = 0;

        while (u < comb_list.size()) {
            int[] tempArr = new int[nfa.charArr.length];

            for (int j = 0; j < tempArr.length; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();

                for (int i = 0; i < comb_list.get(x).size(); i++) {
                    if (curr_state == 99) {
                        temp.add(99);
                        break;
                    }

                    for (int k = 0; k < nfa.transitionList.get(curr_state).size(); k++) {
                        curr_state = comb_list.get(x).get(i);
                        int st1 = nfa.transition(curr_state, nfa.charArr[j], k);
                        temp.add(st1);
                    }
                }

                temp.sort(null);
                temp = removedupes(temp);

                if (temp.size() > 1 && has(temp, 99)) {
                    temp.removeAll(Arrays.asList(99));
                }

                if (notcontain(comb_list, temp)) {
                    comb_list.add(temp);
                    u++;
                }

                int index = findindex(comb_list, temp);
                tempArr[j] = index;
            }
            x++;

            ttArray.add(tempArr);
            if (x < comb_list.size()) {
                curr_state = comb_list.get(x).get(0);
            } else {
                break;
            }
        }

        int[][] finalTT = new int[ttArray.size()][nfa.charArr.length];
        setFinalTT(ttArray, finalTT);
        setFinalStates(comb_list, final_states);
        FA finalObj = new FA(finalTT, 0, final_states, nfa.charArr);
        return finalObj;
    }

    public void setFinalStates(ArrayList<ArrayList<Integer>> comb_list, ArrayList<Integer> final_states) {
        for (int i = 1; i < comb_list.size(); i++) {
            for (int j = 0; j < comb_list.get(i).size(); j++) {
                if (nfa.final_state.contains(comb_list.get(i).get(j)) && !final_states.contains(i)) {
                    final_states.add(i);
                }
            }
        }
    }

    public boolean has(ArrayList<Integer> temp, int x) {
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> removedupes(ArrayList<Integer> temparr) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        ArrayList<Integer> found = new ArrayList<Integer>();

        for (int c : temparr) {
            if (found.contains(c)) {
                continue;
            }

            newList.add(c);
            found.add(c);
        }

        return newList;
    }

    public boolean notcontain(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size() && j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == b.get(j)) {
                    count++;
                }
            }
            if (count == b.size() && b.size() == a.get(i).size()) {
                return false;
            }
        }
        return true;
    }

    public int findindex(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size() && j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == b.get(j)) {
                    count++;
                }
            }

            if (count == b.size() && b.size() == a.get(i).size()) {
                return i;
            }
        }
        return -1;
    }

    public void setFinalTT(ArrayList<int[]> ttArray, int[][] finalTT) {
        for (int i = 0; i < ttArray.size(); i++) {
            int[] t = ttArray.get(i);
            for (int j = 0; j < nfa.charArr.length; j++) {
                finalTT[i][j] = t[j];
            }
        }
    }
}
