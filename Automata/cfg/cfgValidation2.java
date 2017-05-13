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
public class cfgValidation2 {
    static int index = 0;
    char[] input;
    
        public boolean Validate(String Sinput) {
        input = Sinput.toCharArray();
        if (E()) {
            if (input[index] == '$') {
                return true;
            }
        }
        return false;
    }
        public boolean E(){
            if(T()){
                if(E1())
                {
                    return true;
                }
            }
            return false;
        }
        
        public boolean E1(){
            if(PM()){
                if(T()){
                    if(E1()){
                        return true;
                    }
                }
            }
            else return true;
            return false;
        }
        
        public boolean T(){
            if(F()){
                if(T1()){
                    return true;
                }
            }
            return false;
        }
        
        public boolean T1(){
            if(MDM()){
                if(F()){
                    if(T1()){
                        return true;
                    }
                }
            }
            else return true;
            return false;
        }
        
        public boolean F(){
            if(input[index]>='a' && input[index]<='z'){
                index++;
                return true;
            }
            else if(input[index]>='0' && input[index]<='9')
            {
                index++;
                return true;
            }
            else {
                if(input[index]=='('){
                    index++;
                    if(E()){
                        if(input[index]==')'){
                            index++;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        
        public boolean PM(){
            if(input[index]=='+'){
                index++;
                return true;
            }
            else if(input[index]=='-'){
                index++;
                return true;
            }
            return false;
        }
        
        public boolean MDM(){
            if(input[index]=='*'){
                index++;
                return true;
            }
            else if(input[index]=='/'){
                index++;
                return true;
            }
            else if(input[index]=='%'){
                index++;
                return true;
            }
            return false;
        }
        
}
