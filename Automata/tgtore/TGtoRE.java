/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TGtoRE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ArrayList<TransitionObject>> alist = new ArrayList<ArrayList<TransitionObject>>(); 
        
        alist.add(new ArrayList<TransitionObject>());
        alist.get(0).add(new TransitionObject("a",1));
        alist.get(0).add(new TransitionObject("b",2));
        
        alist.add(new ArrayList<TransitionObject>());
        alist.get(1).add(new TransitionObject("aa",3));
        
        alist.add(new ArrayList<TransitionObject>());
        alist.get(1).add(new TransitionObject("bb",3));
        
        alist.add(new ArrayList<TransitionObject>());
        alist.get(1).add(new TransitionObject("",5));
        
        alist.add(new ArrayList<TransitionObject>());
        alist.get(1).add(new TransitionObject("",0));
        
        alist.add(new ArrayList<TransitionObject>());
        
        TG graph = new TG(alist);
        System.out.println(graph.convertToRE());
        
        
    }
    
}
