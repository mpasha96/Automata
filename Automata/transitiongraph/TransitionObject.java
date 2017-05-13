/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transitiongraph;

/**
 *
 * @author Admin
 */
public class TransitionObject {
    public String character;
    public int state;
    
    TransitionObject(String character, int state)
    {
        this.character=character;
        this.state=state;
    }
}
