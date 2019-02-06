/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms390.program_0;

/**
 *
 * @author Glen
 */
public class CMS390PROGRAM_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sum10for());
        System.out.println(sum10while());
        System.out.println(avg10());
    }
    
    public static int sum10for(){
        int i;
        int sum = 0;
        for(i = 1; i < 11;i++){
            sum += i;
        }
        return sum;
    }
    
    public static int sum10while(){
        int i = 1;
        int sum = 0;
        while(i < 11){
            sum += i;
            i++;
        }
        return sum;
    }
    
    public static int avg10(){
        return sum10for()/10;
    }
    
    public static void DegreeIterate(int cycles, int step){
    
    }
    
}
