/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

/**
 *
 * @author Admin
 */
public class TransitionObject {
     private String str;
        private int state;
        public TransitionObject(String str, int state)
        {
            this.str = str;
            this.state = state;
        }
        public void setString(String s)
        {
            this.str = s;
        }
        public String getString()
        {
            return this.str;
        }
        public void setState(int st)
        {
            this.state = st;
        }
        public int getState()
        {
            return this.state;
        }    
}
