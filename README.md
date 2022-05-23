# Son Of Anton
An Interpreter for a compact version of Java with shorthand notation similar to Python  
Named after the single best television character in existence, Bertram Gilfoyle's server, Anton  
  
## Syntax  
----------------------------------------------------------  
### Data Types:  
  
int - whole numbers ranging from { Lower Bound: (-2^31 = 2147483648) | Upper Bound: (2^31)-1 = 2147483647 }  
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
### Data Type Declaration:  
  
All variable declarations are denoted by the keyword **create**  