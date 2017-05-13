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

public class cfgValidation {

//        <S>->A<X>A
//        <X>->A<X>A
//        <X>->B<T>
//        <T>->B<T>
//        <T>->C
    
    static int index = 0;
    char[] input;

    public boolean Validate(String Sinput) {
        input = Sinput.toCharArray();
//        for (int i = 0; i < input.length; i++) {
//            System.out.println(input[i]);
//        }
        if (S()) {
            if (input[index] == '$') {
                return true;
            }
        }
        return false;
    }

    public boolean S() {
        if (input[index] == 'a') {
            index++;
            if (X()) {
                if (input[index] == 'a') {
                    index++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean X() {
        if (input[index] == 'a') {
            index++;
            if (X()) {
                if (input[index] == 'a') {
                    index++;
                    return true;
                }
            }
        } else {
            if (input[index] == 'b') {
                index++;
                if (T()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean T() {
        if (input[index] == 'b') {
            index++;
            if (T()) {
                return true;
            }
        } else {
            if (input[index] == 'c') {
                index++;
                return true;
            }
        }
        return false;
    }
}
