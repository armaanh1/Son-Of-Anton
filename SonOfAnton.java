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
        this.declaredStrings = new HashMap<>();
        this.declardInts = new HashMap<>();
        this.declardDecimals = new HashMap<>();
        this.declaredBns = new HashMap<>();
        this.variableNames = new ArrayList<>();

    }

    public void start() 
    {
    
        formInstructions();

        while(!instructions.isEmpty())
        {

            currentInstruction = instructions.remove();
            instructions.remove();

            if(currentInstruction.substring(0,6).equals("create"))
            {

                if(currentInstruction.substring(7,11).equals("int"))
                {

                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        declardInts.put
                        (currentInstruction.substring(11,currentInstruction.indexOf("=")-1), 
                        scanInput.nextInt());
                        variableNames.add(currentInstruction.substring(11,currentInstruction.indexOf("=")-1));

                    }
                    else
                    {

                        declardInts.put
                        (currentInstruction.substring(11,currentInstruction.indexOf("=")-1), 
                        Integer.parseInt(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        variableNames.add(currentInstruction.substring(11,currentInstruction.indexOf("=")-1));
                    
                    }

                }
                else if(currentInstruction.substring(7,15).equals("decimal"))
                {

                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        declardDecimals.put
                        (currentInstruction.substring(15,currentInstruction.indexOf("=")-1), 
                        scanInput.nextDouble());
                        variableNames.add(currentInstruction.substring(15,currentInstruction.indexOf("=")-1));

                    }
                    else
                    {
                     
                        declardDecimals.put
                        (currentInstruction.substring(15,currentInstruction.indexOf("=")-1), 
                        Double.parseDouble(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        variableNames.add(currentInstruction.substring(15,currentInstruction.indexOf("=")-1));
                   
                    }

                }
                else if(currentInstruction.substring(7,14).equals("String"))
                {
                    
                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        declaredStrings.put
                        (currentInstruction.substring(14,currentInstruction.indexOf("=")-1), 
                        scanInput.nextLine());
                        variableNames.add(currentInstruction.substring(14,currentInstruction.indexOf("=")-1));

                    }
                    else
                    {
                   
                        declaredStrings.put
                        (currentInstruction.substring(14,currentInstruction.indexOf("=")-1), 
                        String.valueOf(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        variableNames.add(currentInstruction.substring(14,currentInstruction.indexOf("=")-1));

                    }

                }
                else if(currentInstruction.substring(7,10).equals("bn"))
                {
                    
                    if((currentInstruction.substring(currentInstruction.indexOf("=")+1).trim()).equals("input"))
                    {

                        declaredBns.put
                        (currentInstruction.substring(10,currentInstruction.indexOf("=")-1), 
                        scanInput.nextBoolean());
                        variableNames.add(currentInstruction.substring(10,currentInstruction.indexOf("=")-1));

                    }
                    else
                    {
                   
                        declaredBns.put
                        (currentInstruction.substring(10,currentInstruction.indexOf("=")-1), 
                        Boolean.parseBoolean(currentInstruction.substring(currentInstruction.indexOf("=") + 1).trim()));
                        variableNames.add(currentInstruction.substring(10,currentInstruction.indexOf("=")-1));

                    }

                }
                else
                {
    
                    System.out.println("ERROR: INVALID DATA TYPE OF LINE;");
                    System.out.println("ERROR: VIEW READEME.md FOR MORE INFORMATION ON DATA TYPE DECLARATION");
    
                }

            }
            else if(currentInstruction.substring(0,5).equals("output"))
            {

                

            }
            else if(currentInstruction.substring(0,4).equals("loop"))
            {

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

    }
    
}
 