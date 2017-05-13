/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegexAssignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
//        System.out.print("Input:");
//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//
//        String id = "^([A-Za-z]([A-Za-z0-9])*)|(_([A-Za-z0-9]*))$";
//        String inter= "^(([+-])?([0-9])+)$";
//        String flt = "^([+-]?)[0-9]*\\.[0-9]+(e[+-]?[0-9]+)?$";
//        String ch = "^(\'.\')|(\'\\\\[nrt]+\')$";
//        String str = "(^\".*\"$)";
//        String email = "^[A-Za-z0-9]+[._A-Za-z0-9-+]*@[A-Za-z0-9-]+[.A-Za-z0-9]*[.A-Za-z]{2,}$";
//        String url = "^(http:\\/\\/|https:\\/\\/)?(www.)?[a-zA-Z0-9]+\\.[a-z]{3}(\\.([a-z]+))?$";
//
//        Pattern pattern_id = Pattern.compile(id);
//        Pattern pattern_integer = Pattern.compile(inter);
//        Pattern pattern_float = Pattern.compile(flt);
//        Pattern pattern_char = Pattern.compile(ch);
//        Pattern pattern_string = Pattern.compile(str);  
//        Pattern pattern_email = Pattern.compile(email);        
//        Pattern pattern_url = Pattern.compile(url);        
//
//
//        
//        Matcher matcher_id = pattern_id.matcher(input);
//        Matcher matcher_integer = pattern_integer.matcher(input);
//        Matcher matcher_float = pattern_float.matcher(input);
//        Matcher matcher_char = pattern_char.matcher(input);
//        Matcher matcher_string = pattern_string.matcher(input);
//        Matcher matcher_email = pattern_email.matcher(input);
//        Matcher matcher_url = pattern_url.matcher(input);
//
//        if(matcher_id.matches())
//            System.out.println("input is an Identifier");
//        else if(matcher_integer.matches())
//            System.out.println("Input is an Integer");
//        else if(matcher_float.matches())
//            System.out.println("Input is a Float");
//        else if(matcher_char.matches())
//            System.out.println("Input is a Character");
//        else if(matcher_string.matches())
//            System.out.println("Input is a String");
//        else if(matcher_email.matches())
//            System.out.println("Input is an E-mail");
//        else if(matcher_url.matches())
//            System.out.println("Input is a URL");
//        else System.out.println("Invalid input");
//        
        //Folder Validation Regex Code
        System.out.print("Enter folder name to validate:");
        Scanner in = new Scanner(System.in);
        String input =in.next();

        String regex= "^[^:*?<>/\\\\|\"]*$";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        
        if(m.matches())
             System.out.println("Success! Valid folder name");
        else System.out.println("Failed! Invalid folder name");
//        \/:*?<>"|

    }

}
