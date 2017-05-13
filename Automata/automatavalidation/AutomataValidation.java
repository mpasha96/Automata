/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatavalidation;

import java.util.Scanner;

/**
 *
 * @author Pasha
 */
public class AutomataValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    
        
        System.out.println("Enter input to validate:");
        Scanner in = new Scanner(System.in);
        String input = in.next();

        int[][] id_tt = {{1,2,3,4},{1,1,2,4},{2,2,2,4},{1,1,2,4}};
        int[][] int_tt = {{1,3,4},{1,2,4},{2,2,4},{1,3,4},{4,4,4}};
        int[][] float_tt = {{1,3,2,4,9},{1,4,2,4,9},{5,4,4,4,9},{1,4,2,4,9},{4,4,4,4,9},{5,4,4,6,9},{8,7,4,4,9},{8,4,4,4,9},{8,4,4,4,9},{9,9,9,9,9,9}};
        int[][] char_tt = {{1,4,5},{4,2,5},{3,4,5},{4,4,5},{4,4,5}};
        int[][] string_tt = {{1,4,5},{4,2,5},{3,2,5},{4,4,5},{4,4,5}};
        
//        Automata o = new Automata(initial_state,final_state,regex_array,transitionTable)
        
//        ID Object
        Automata id_obj = new Automata(0,new int[]{1},new String[]{"^[a-zA-Z]$","^[0-9]$","^_$"},id_tt);
//        Int Object
        Automata int_obj = new Automata(0,new int[]{1},new String[]{"^[0-9]$","^[+-]$"},int_tt);
//        Float Object
        Automata float_obj = new Automata(0,new int[]{5,8},new String[]{"^[0-9]$","^[+-]$","^[.]$","^[e]$"},float_tt);
//        Char Object
        Automata char_obj = new Automata(0,new int[]{3},new String[]{"^[']$","^.$"},char_tt);
//        String Object
        Automata string_obj = new Automata(0,new int[]{3},new String[]{"^\"$","^.$"},string_tt);

        if(id_obj.validate(input))
            System.out.println("valid identifier");
        else if(int_obj.validate(input))
            System.out.println("Valid integer");
        else if(float_obj.validate(input))
            System.out.println("Valid float");
        else if(char_obj.validate(input))
            System.out.println("Valid character");
        else if(string_obj.validate(input))
            System.out.println("Valid string");
        else System.out.println("Invalid !!!");
        
    }
}