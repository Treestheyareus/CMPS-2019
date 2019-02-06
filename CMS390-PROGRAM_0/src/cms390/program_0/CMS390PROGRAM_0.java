/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms390.program_0;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Glen
 */
public class CMS390PROGRAM_0 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        FindOutliers();
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
    
    public static void DegreeIterate(int cycles, double step){
        int cyclescomplete = 0;
        double currentvalue = 0;
        while(cyclescomplete < cycles){
            System.out.println(currentvalue);
            currentvalue += step;
            if(currentvalue > 360){
                currentvalue = 0;
                cyclescomplete += 1;
            }
        }
    }
    
    public static void RadianIterate(int cycles, double step) throws IOException{
        int cyclescomplete = 0;
        double currentvalue = 0;
        File thefile = new File("C:\\Users\\Glen\\Desktop\\SinOutput.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(thefile));
        while(cyclescomplete < cycles){
            String output = String.valueOf(DegreeToRadian(currentvalue));
            writer.write(output);
            writer.write("\n");
            currentvalue += step;
            if(currentvalue > 360){
                currentvalue = 0;
                cyclescomplete += 1;
            }
        }
        writer.close();
    }
    
    public static double DegreeToRadian(double input){
        double result = (input/180)*Math.PI;
        return(result);
    }
    
    public static void FindOutliers() throws FileNotFoundException{
        File thefile = new File("C:\\Users\\Glen\\Desktop\\SinOutput.txt");
        Scanner scanner = new Scanner(thefile);
        double[] valuearray = new double[361];
        int i = 0;
        while(scanner.hasNext()){
            valuearray[i] = Double.parseDouble(scanner.nextLine());
            i++;
        }
        //The array is now populated with the values from the text file
        double SD = findStandardDeviation(valuearray);
        //SD is calculated
        
        //Strategy One here
        System.out.println("Outliers, according to the first method:");
        double SD3 = SD*3;
        double avg = 0;
        double total = 0;
        for(i = 0;i < valuearray.length;i++){
            total += valuearray[i];
        }
        avg = total / 361;
        
        for(i = 0;i < valuearray.length;i++){
            if(Math.abs(valuearray[i] - avg ) > SD3){
                System.out.println("Line " + i + ": " + valuearray[i]);
            }
        }
        
        //Strategy Two here
        System.out.println("Outliers, according to the second method:");
        double previous = valuearray[0];
        for(i = 1;i < valuearray.length;i++){
            if(Math.abs(valuearray[i] - previous ) > SD3){
                System.out.println("Line " + i + ": " + valuearray[i]);
            }
            previous = valuearray[i];
        }
    }
    
    public static double findStandardDeviation(double[] arr){
        int i;
        double avg = 0;
        double total = 0;
        double result;
        double[] newarr = new double[361];
        for(i = 0;i < arr.length;i++){
            total += arr[i];
        }
        avg = total / 361;
        
        for(i = 0;i < arr.length;i++){
            newarr[i] = (arr[i]-avg) * (arr[i]-avg);
        }
        
        total = 0;
        avg = 0;
        for(i = 0;i < newarr.length;i++){
            total += newarr[i];
        }
        avg = total / 361;
        result = Math.sqrt(avg);
        return result;
    }
    
}
