# Son Of Anton 3.0
An Interpreter for a compact version of Java with shorthand notation similar to Python  
Named after the single best television character in existence, Bertram Gilfoyle's server, Anton  
  
## Syntax  
---------------------------------------------------------- 
----------------------------------------------------------  
### Data Types:  
  
int - whole numbers ranging from { Lower Bound: (-2^31 ::=2147483648) | Upper Bound: (2^31)-1 ::= 2147483647 }  
-> Default Value ::= 0  
-> **create** **int** (variable-name) ::= whole_number | arithmetic operation | method call with return value: int  
  
decimal - decimal numbers ranging from { Lower Bound: (2^1074) | Upper Bound: (2-(2^52))·(2^1023) }  
-> Default Value ::= 0.0  
-> **create** **double** (variable-name) ::= decimal_number | arithmetic operation | method call with return value: double  
  
String - any combination of characters encased in ""   
-> Default Value ::= ""  
-> **create** **String** (variable-name) ::= "" | method call with return value: String  
  
bn - a boolean value {true | false} (int representation: true = 1 | false = 0)  
-> Default Value ::= false  
-> **create** **bn** (variable-name) ::= true | false | method call with return value: bn  
  
----------------------------------------------------------
----------------------------------------------------------  
### Data Type Declaration:  
  
All variable declarations are denoted/triggered by the keyword **create**  

----------------------------------------------------------  
----------------------------------------------------------  
### Console Input

All console inputs are denoted/triggered by the keyword **input**  


----------------------------------------------------------  
----------------------------------------------------------  
### Console Output

All console outputs are denoted/triggered by the keyword **output**  

----------------------------------------------------------  
----------------------------------------------------------  
### Loops  
  
All for and while loops are denoted/triggered by the keyword **loop**  
Loops follow a specific syntax listed below  
  
----------------------------------------------------------  
  
#### For Loops  
**loop** (variable name) from (begin-index) to (end-index)  
NOTE: For loops' default increments are (variable-name) = (variable-name) + 1
NOTE: There is currently no way to change the default increment