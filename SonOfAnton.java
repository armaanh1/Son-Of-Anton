import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SonOfAnton 
{

    private File codeFile;
    private Queue<String> instructions;
    private Scanner scanFile;
    private Scanner scanInput;
    private HashMap<String, String> declaredStrings;
    private HashMap<String, Integer> declardInts;
    private HashMap<String, Double> declardDecimals;
    private HashMap<String, Boolean> declaredBns;
    private String currentInstruction;
    private ArrayList<String> variableNames;


    public SonOfAnton(String codePath) throws FileNotFoundException
    {

        this.codeFile = new File(codePath);
        this.scanFile = new Scanner(codeFile);
        this.scanInput = new Scanner(System.in);
        this.instructions = new LinkedList<String>();
        this.declaredStrings = new HashMap<String,String>();
        this.declardInts = new HashMap<String,Integer>();
        this.declardDecimals = new HashMap<String,Double>();
        this.declaredBns = new HashMap<String,Boolean>();
        this.variableNames = new ArrayList<String>();

    }

    public void start() 
    {
    
        formInstructions();

        while(!this.instructions.isEmpty())
        {

            currentInstruction = instructions.remove();
            System.out.println();

            if(currentInstruction.substring(0,6).equals("create"))
            {

                // System.out.println("CREATE COMMAND DETECTED & EXECUTED IN LINE: " + currentInstruction);

                if(currentInstruction.substring(7,10).equals("int"))
                {

                    // System.out.println("DATA TYPE INT DETECTED AND EXECUTED IN LINE: " + currentInstruction);

                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        // System.out.println("INPUT COMMAND DETECTED & EXECUTED IN LINE: " + currentInstruction);

                        System.out.println("Enter a int value for the variable: " + currentInstruction.substring(10,currentInstruction.indexOf("=")-1).trim());
                        
                        declardInts.put
                        (currentInstruction.substring(10,currentInstruction.indexOf("=")-1).trim(), 
                        scanInput.nextInt());
                        
                        variableNames.add(currentInstruction.substring(10,currentInstruction.indexOf("=")-1).trim());

                    }
                    else
                    {

                        declardInts.put
                        (currentInstruction.substring(10,currentInstruction.indexOf("=")-1).trim(), 
                        Integer.parseInt(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        
                        variableNames.add(currentInstruction.substring(10,currentInstruction.indexOf("=")-1).trim());

                        // System.out.println("INPUT COMMAND NOT DETECTED & REGULAR SUBSTRING IN LINE: " + currentInstruction);
                    
                    }

                }
                else if(currentInstruction.substring(7,14).equals("decimal"))
                {

                    // System.out.println("DATA TYPE DECIMAL DETECTED AND IN LINE: " + currentInstruction);

                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        // System.out.println("INPUT COMMAND DETECTED & IN LINE: " + currentInstruction);

                        System.out.println("Enter a decimal value for the variable: " + currentInstruction.substring(14,currentInstruction.indexOf("=")-1).trim());
                        
                        declardDecimals.put
                        (currentInstruction.substring(14,currentInstruction.indexOf("=")-1).trim(), 
                        scanInput.nextDouble());
                        
                        variableNames.add(currentInstruction.substring(14,currentInstruction.indexOf("=")-1).trim());

                    }
                    else
                    {
                     
                        // System.out.println("INPUT COMMAND NOT DETECTED & REGULAR SUBSTRING IN LINE: " + currentInstruction);

                        declardDecimals.put
                        (currentInstruction.substring(14,currentInstruction.indexOf("=")-1).trim(), 
                        Double.parseDouble(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        
                        variableNames.add(currentInstruction.substring(14,currentInstruction.indexOf("=")-1).trim());

                    }

                }
                else if(currentInstruction.substring(7,13).equals("String"))
                {

                    // System.out.println("DATA TYPE STRING DETECTED AND IN LINE: " + currentInstruction);
                    
                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        // System.out.println("INPUT COMMAND DETECTED & IN LINE: " + currentInstruction);

                        System.out.println("Enter a String value for the variable: " + currentInstruction.substring(13,currentInstruction.indexOf("=")-1).trim());
                        
                        declaredStrings.put
                        (currentInstruction.substring(13,currentInstruction.indexOf("=")-1).trim(), 
                        scanInput.nextLine());
                        
                        variableNames.add(currentInstruction.substring(13,currentInstruction.indexOf("=")-1).trim());

                    }
                    else
                    {
                        
                        // System.out.println("INPUT COMMAND NOT DETECTED & REGULAR SUBSTRING IN LINE: " + currentInstruction);

                        declaredStrings.put
                        (currentInstruction.substring(13,currentInstruction.indexOf("=")-1).trim(), 
                        String.valueOf(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        
                        variableNames.add(currentInstruction.substring(13,currentInstruction.indexOf("=")-1).trim());

                    }

                }
                else if(currentInstruction.substring(7,9).equals("bn"))
                {
                 
                    // System.out.println("DATA TYPE bn DETECTED AND IN LINE: " + currentInstruction);

                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        // System.out.println("INPUT COMMAND DETECTED & IN LINE: " + currentInstruction);

                        System.out.println("Enter a bn value for the variable: " + currentInstruction.substring(9,currentInstruction.indexOf("=")-1).trim());
                        
                        declaredBns.put
                        (currentInstruction.substring(9,currentInstruction.indexOf("=")-1).trim(), 
                        scanInput.nextBoolean());
                       
                        variableNames.add(currentInstruction.substring(9,currentInstruction.indexOf("=")-1).trim());

                    }
                    else
                    {
                   
                        // System.out.println("INPUT COMMAND NOT DETECTED & REGULAR SUBSTRING IN LINE: " + currentInstruction);

                        declaredBns.put
                        (currentInstruction.substring(9,currentInstruction.indexOf("=")-1).trim(), 
                        Boolean.parseBoolean(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        
                        variableNames.add(currentInstruction.substring(9,currentInstruction.indexOf("=")-1).trim());

                    }

                }
                else
                {
    
                    System.out.println("ERROR: INVALID DATA TYPE OF LINE;");
                    System.out.println("ERROR: VIEW READEME.md FOR MORE INFORMATION ON DATA TYPE DECLARATION");
    
                }

            }
            else if(currentInstruction.substring(0,6).equals("output"))
            {

                // System.out.println("OUTPUT COMMAND DETECTED & EXECUTED IN LINE: " + currentInstruction);

                if(variableNames.contains(currentInstruction.substring(6).trim()))
                {
                 
                    if(declaredStrings.containsKey(currentInstruction.substring(7)))
                    {

                        System.out.println(declaredStrings.get(currentInstruction.substring(7)));

                    }

                    if(declaredBns.containsKey(currentInstruction.substring(7)))
                    {
                        
                        System.out.println(declaredBns.get(currentInstruction.substring(7)));

                    }
                    
                    if(declardInts.containsKey(currentInstruction.substring(7)))
                    {
                        
                        System.out.println(declardInts.get(currentInstruction.substring(7)));

                    }
                    
                    if(declardDecimals.containsKey(currentInstruction.substring(7)))
                    {
                        
                        System.out.println(declardDecimals.get(currentInstruction.substring(7)));

                    }

                }

            }
            else if(currentInstruction.substring(0,4).equals("loop"))
            {

                //loop i from 0 to 5
                if(currentInstruction.contains("from"))
                {

                    declardInts.put
                    (currentInstruction.substring(5, currentInstruction.indexOf("from")).trim(),
                    Integer.parseInt(currentInstruction.substring(currentInstruction.indexOf("from")+4,
                    currentInstruction.indexOf("to")-1).trim()));

                    variableNames.add(currentInstruction.substring(5, currentInstruction.indexOf("from")).trim());

                    int endValue = Integer.parseInt(currentInstruction.substring(currentInstruction.indexOf("to")+2).trim());
                    
                    int startValue = Integer.parseInt(currentInstruction.substring(currentInstruction.indexOf("from")+4,
                    currentInstruction.indexOf("to")-1).trim());

                    for(int i = startValue; i < endValue; i++)
                    {

                        // reference i in exchange with declared variable
                        // wait for keyword reassign to be pushed and merged with master
                        // wait for keyword reassign to be pushed and merged with master

                    }

                }

                // 012345678901
                // loop while (bn expression)
                else if(currentInstruction.contains("while"))
                {

                    while(declaredBns.get(currentInstruction.substring(11)))
                    {

                        // wait for keyword reassign to be pushed and merged with master
                        // wait for keyword reassign to be pushed and merged with master

                    }

                }
                else if(currentInstruction.contains("forever"))
                {

                    while(true)
                    {

                        // wait for keyword reassign to be pushed and merged with master
                        // wait for keyword reassign to be pushed and merged with master

                    }

                }
                else
                {

                    System.out.println("ERROR: INVALID TYPE OF LOOP; NO TYPE DETECTED");
                    System.out.println("ERROR: VIEW READEME.md FOR MORE INFORMATION ON LOOPS");

                }

            }
            else if(currentInstruction.equals(""))
            {
                continue;
            }
            else
            {

                System.out.println("ERROR: INVALID START OF LINE; NO COMMAND DETECTED");
                System.out.println("ERROR: VIEW READEME.md FOR MORE INFORMATION ON COMMANDS");

            }

        }    
        
    }

    private void formInstructions()
    {

        while (scanFile.hasNext()) 
        {
            instructions.add(scanFile.nextLine());
        }

        String[] arr = instructions.toArray(new String[instructions.size()]);    

        System.out.println("Instruction Queue:");
        System.out.println();

        for (int i = 0; i < arr.length; i++) 
        {
        
            System.out.println("Instruction " + (i+1) + ": " + arr[i]);

        }

    }
    
}
 