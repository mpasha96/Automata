/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitiongraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TransitionGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter input to validate:");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        
        List<List<TransitionObject>> liist = new ArrayList<List<TransitionObject>>(); 
        
        liist.add(new ArrayList<TransitionObject>());
        liist.get(0).add(new TransitionObject("ab",1));
        liist.get(0).add(new TransitionObject("b",1));
        
        liist.add(new ArrayList<TransitionObject>());
        liist.get(1).add(new TransitionObject("abb",1));
        liist.get(1).add(new TransitionObject("b",1));   
        liist.get(1).add(new TransitionObject("b",2));        
        
        TGValidation tg = new TGValidation(new int[]{1},new int[]{2},liist);
        
        
                        
    }
    
}
