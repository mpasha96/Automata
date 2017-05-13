/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg;

/**
 *
 * @author Admin
 */
public class cfgValidation1 {

//    S -> A
//    A -> aX | bx | null
//    X -> aA | bA
    
    static int index = 0;
    char[] input;

    public boolean Validate(String Sinput) {
        input = Sinput.toCharArray();
        if (S()) {
             if (input[index] == '$'){
                return true;
             }
        }
        return false;
    }

    public boolean S() {

        if (A()) {
            return true;
        }
        return false;
    }

    public boolean A() {

        if (input[index] == 'a') {
            index++;
            if (X()) {
                return true;
            }
        } else if (input[index] == 'b') {
            index++;
            if (X()) {
                return true;
            }
        } else {
            return true;
        }

        return false;

    }

    public boolean X() {
        if (input[index] == 'a') {
            index++;
            if (A()) {
                return true;
            }
        } else if (input[index] == 'b') {
            index++;
            if (A()) {
                return true;
            }
        }
        return false;
    }
}
