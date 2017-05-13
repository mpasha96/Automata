/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CFG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter string to validate:");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        input = input + '$';
        cfgValidation2 cfgObject = new cfgValidation2();
        System.out.println(cfgObject.Validate(input));

    }
}
