/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finiteautomata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author faiq
 */
public class FA {
    int tt[][];
    int is;
    int fs;
    String pattern[];
   
    public FA(int tt[][],int is,int fs,String inputPattern[])
    {
        this.tt=tt;
        this.is=is;
        this.fs=fs;
        this.pattern=inputPattern;
        
    }
    public boolean validate(String str)
    {
        int st=is;
        
        for (int j = 0; j < str.length(); j++) {
            st=transition(st,str.charAt(j));
           }
        if(st==fs)
         return  true;
        
          else return false;
    }
    private int transition(int st,char ch)
    {

//        for (int i = 0; i < chars.length; i++) {
        for (int i = 0; i < pattern.length; i++)

        {
            String re=pattern[i];
            Pattern r = Pattern.compile(re);

      // Now create matcher object.
      Matcher m = r.matcher(String.valueOf(ch));
      
      if(m.matches())
      {
          return tt[st][i];
      }
        
        
    }
        return 99;

    }
}