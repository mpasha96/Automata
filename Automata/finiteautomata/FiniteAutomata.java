/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finiteautomata;

/**
 *
 * @author faiq
 */
public class FiniteAutomata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String patternInput[]={"^[a-zA-Z]$","^[0-9]$","^_$"};
        
        int TT[][]={{1,2,3},{1,1,2},{2,2,2},{1,1,2}};
       
        int is=0;
        int fs=1;
        
        FA fa=new FA(TT,is,fs,patternInput);
        System.out.println(fa.validate("7gy"));
    }
    
}
