import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SonOfAnton
{

    private static File codeFile;
    private static LinkedList<String> instructions;
    private static LinkedList<String> loopInstructions;
    private static Scanner scanFile;
    private static Scanner scanInput;
    private static HashMap<String, String> declaredStrings;
    private static HashMap<String, Integer> declardInts;
    private static HashMap<String, Double> declardDecimals;
    private static HashMap<String, Boolean> declaredBns;
    private static String currentInstruction;
    private static ArrayList<String> variableNames;


    public SonOfAnton(String codePath) throws FileNotFoundException
    {

        codeFile = new File(codePath);
        scanFile = new Scanner(codeFile);
        scanInput = new Scanner(System.in);
        instructions = new LinkedList<String>();
        declaredStrings = new HashMap<String,String>();
        declardInts = new HashMap<String,Integer>();
        declardDecimals = new HashMap<String,Double>();
        declaredBns = new HashMap<String,Boolean>();
        variableNames = new ArrayList<String>();

    }

    public static void start()
    {

        formInstructions();

        while(!instructions.isEmpty())
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

                loop();

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

    private static void loop()
    {

        LinkedList<String> loopInstructions = formLoopInstructions();

        

    }

    private static LinkedList<String> formLoopInstructions()
    {

        // loopInstructions = new LinkedList<String>();


        return loopInstructions;

    }

    private static void formInstructions()
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