import java.util.*;
import java.io.*;
//import java.io.PrintWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.IOException; 


//Student code from a prior semester - used to demo Checkstyle
public class RefactoringDemoFBB {

        public static void main(String args[]) throws FileNotFoundException, IOException {
                
                String count = "0";
                String argument = "";
                double test = 0;
                
                if (args.length == 0) {
                        argument = "console";
                }
                
                else {
                        argument = args[0];
                }
                
                
                if (argument == "batch") {
                        //Path filepath = Paths.get("\\src\\resources\\fbb-input.txt");
                        File filepath = new File(".\\src\\fbb-input.txt");
                        Scanner scanFile = new Scanner(filepath);
                        PrintWriter outFile = new PrintWriter("fbb-actual-output.txt");
                        
                        while(scanFile.hasNext()) {
                                count = scanFile.nextLine();
                                count.trim();
                            
                                try {
                                        test = Double.parseDouble(count);
                                }
                                catch (NumberFormatException e) {
                                    outFile.println(count + " = Invalid Input");
                                    continue;
                                }
                 
                                
                                if(test < 0) {
                                outFile.println(count + " = Invalid Input");
                                continue;
                            }
                                          
                            if(test > 2147483647) {
                                outFile.println(count + " = Invalid Input");
                                continue;
                            }
                                          
                        if(test%1 != 0) {
                                outFile.println(count + " = Invalid Input");
                                continue;
                        }
                              
                            if (test%3 == 0) {
                                outFile.print("Foo");
                            }
                                        
                                if (test%5 == 0) {
                                        outFile.print("Bar");
                            }
                                        
                                if (test%7 == 0) {
                                        outFile.print("Baz");
                                }
                                        
                            if (test%7 != 0 && test%5 != 0 && test%3 != 0) {
                                         int printValue = (int)test;
                                         outFile.print(printValue);
                            }
                                            
                            outFile.println("");
                                
                        } //End of While Loop
                        outFile.close();
                }
                
                if (argument == "console") {
                  Scanner scan = new Scanner(System.in);
                  String answer = "";
 
                  while(!answer.equals("Stop")) {
                        
                          System.out.println("Please Enter a Value: ");
                          count = scan.nextLine();
                          count.trim();
                
                          try {
                                  test = Double.parseDouble(count);
                          }
                          catch (NumberFormatException e) {
                              System.out.println(count + " = Invalid Input");
                              continue;
                          }
         
                        
                          if(test < 0) {
                          System.out.println(count + " = Invalid Input");
                          continue;
                      }
                                  
                      if(test > 2147483647) {
                          System.out.println(count + " = Invalid Input");
                          continue;
                      }
                                  
                  if(test%1 != 0) {
                      System.out.println(count + " = Invalid Input");
                          continue;
                  }
                      
                      if (test%3 == 0) {
                                  System.out.print("Foo");
                      }
                                
                          if (test%5 == 0) {
                             System.out.print("Bar");
                      }
                                
                          if (test%7 == 0) {
                                   System.out.print("Baz");
                          }
                                
                      if (test%7 != 0 && test%5 != 0 && test%3 != 0) {
                                   int printValue = (int)test;
                                   System.out.print(printValue);
                      }
                                    
                      System.out.println("");
                      System.out.println("Would you like to End Program? (Type \"Stop\" to End) ");
                          answer = scan.nextLine();
                        
                  } //End of While Loop
                } 
                
        }
}