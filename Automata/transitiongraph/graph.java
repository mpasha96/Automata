/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitiongraph;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Admin
 */
public class graph {
    public int is;
    public int[] fs;
    List<List<TransitionObject>> wrongpaths = new ArrayList<List<TransitionObject>>(); 
    
    public graph(int is, int[] fs)
    {
        int first;
        this.is = is;
        this.fs = fs;
    }
    
}
