
package part1;
import java.io.*;

public class Lexical_Analyser {
   // check if its keyword 
    static boolean iskeyword(String str)
    {
        String keyword[] ={"pattern","DerivedFrom","TrueFor","Else",
            "Ity","Sity","Cwq","CwqSequence" 
                ,"Ifity","Sifity","Valueless","Logical","BreakFromThis",
                "Whatever","Respondwith","Srap"
        ,"Scan","Conditionof","Require"};
        if(!Character.isAlphabetic(str.charAt(0)))
        {
           return false;
        }
        for(int i=0;i<keyword.length;i++)
        {
            if(str.matches(keyword[i]))
            {     
               return true;
            }
        }
        return false;
    }
    public BufferedWriter bufferedWriter ;
public static  boolean coomentBool = false;
// static counter for Errors line by line
public static  int errors = 0;
   // static int count=0;
   static void tokenize(String str) throws IOException{
        
       FileWriter fileWriter =new FileWriter("output.txt",true);
      
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String lexeme="";

    /**
     *
     */
         
           // bufferedWriter.write(++count);
            for(int i=0;i<str.length();i++){
                if(coomentBool){
                    if(i<str.length()-1 &&(str.charAt(i)=='-'&& str.charAt(i+1)=='/')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : Comment");
                    bufferedWriter.write(lexeme+" : Comment");
                    lexeme="";
                    coomentBool=false;
                } 
                    
                    break;}

//  check if  is letter

                  bufferedWriter.write(" \n");// write in file
                  // check if its Identifier or keyword
                if(Character.isLetter(str.charAt(i))){
                // create word from letters at lexeme string
                    lexeme+=str.charAt(i++);
                    while(i<str.length()&&(Character.isLetterOrDigit(str.charAt(i))||str.charAt(i)=='_')){
                        lexeme+=str.charAt(i++);
                    }
                    i--;

                    // check if ther keyword in the  row
                    if(iskeyword(lexeme)){
                        if(lexeme.matches("pattern")){
                        System.out.println(lexeme+" : Class"); 
                        bufferedWriter.write(lexeme+" : Class");
                        }
                        
                        else if(lexeme.matches("DerivedFrom")){
                        System.out.println(lexeme+" : Inheritance");
                        bufferedWriter.write(lexeme+" : Inheritance");
                        }
                           else if(lexeme.matches("TrueFor")){
                        System.out.println(lexeme+" : Condition"); 
                             bufferedWriter.write(lexeme+" : Condition"); 
                           }
                           else if(lexeme.matches("Else")){
                        System.out.println(lexeme+" : Condition");
                            bufferedWriter.write(lexeme+" : Condition");
                           }
                           else if(lexeme.matches("Ity")){
                        System.out.println(lexeme+"  Integer");
                             bufferedWriter.write(lexeme+" : Integer");
                         
                           }
                           else if(lexeme.matches("Sity")){
                        System.out.println(lexeme+" : SInteger");
                           bufferedWriter.write(lexeme+" : SInteger"); 
                           }
                              else if(lexeme.matches("Cwq")){
                        System.out.println(lexeme+" : Character"); 
                             bufferedWriter.write(lexeme+" : Character");   
                              
                              }
                              else if(lexeme.matches("CwqSequence")){
                        System.out.println(lexeme+" : String"); 
                              bufferedWriter.write(lexeme+" : String");
                               
                              
                              }
                              else if(lexeme.matches("Ifity")){
                        System.out.println(lexeme+" : Float"); 
                            bufferedWriter.write(lexeme+" : Float"); 
                                 
                              }
                           else if(lexeme.matches("Sifity")){
                        System.out.println(lexeme+" : SFloat"); 
                            bufferedWriter.write(lexeme+" : SFloat");  
                           }
                           else if(lexeme.matches("Valueless")){
                        System.out.println(lexeme+" : Void"); 
                            bufferedWriter.write(lexeme+" : Void");
                           }
                           else if(lexeme.matches("Logical")){
                        System.out.println(lexeme+" : Boolean"); 
                         bufferedWriter.write(lexeme+" : Boolean");
                           
                           }
                        
                        
                           
                           else if(lexeme.matches("BreakFromThis")){
                        System.out.println(lexeme+" : Break"); 
                            bufferedWriter.write(lexeme+" : Break"); }
                           else if(lexeme.matches("Whatever")){
                        System.out.println(lexeme+" : Loop"); 
                           bufferedWriter.write(lexeme+" : Loop");   
                           }
                           else if(lexeme.matches("Respondwith")){
                        System.out.println(lexeme+" : Return");
                           bufferedWriter.write(lexeme+" : Return");
                           }
                           else if(lexeme.matches("Srap")){
                        System.out.println(lexeme+" : Struct"); 
                            bufferedWriter.write(lexeme+" : Struct");
                           }
                           else if(lexeme.matches("Scan")){
                        System.out.println(lexeme+" : Switch");
                           bufferedWriter.write(lexeme+" : Switch");
                           }
                           else if(lexeme.matches("Conditionof")){
                        System.out.println(lexeme+" : Switch"); 
                            bufferedWriter.write(lexeme+" : Switch");
                           }
                           else if(lexeme.matches("Require")){
                        System.out.println(lexeme+" : Inclusion");
                          bufferedWriter.write(lexeme+" : Inclusion"); }
                           
                           
                   
                    }
                    // if not from keyword its Identifier
                    else {
                        System.out.println(lexeme+" : Identifier");
                        bufferedWriter.write(lexeme+" : Identifier");
                    }  
                    lexeme="";
                }

                // find Constant and Errors of the Identifier
                              else      if(Character.isDigit(str.charAt(i))){
                    int flag1=0,flag2=0;
                    lexeme+=str.charAt(i++);
                    while(i<str.length()&&(Character.isDigit(str.charAt(i))||str.charAt(i)=='.'||str.charAt(i)=='E'||str.charAt(i)=='+'||str.charAt(i)=='-'||Character.isLetter(str.charAt(i)))){
                       
                        if(Character.isDigit(str.charAt(i))||Character.isLetter(str.charAt(i))){
                            lexeme+=str.charAt(i++);
                        }
//                        else if(str.charAt(i)=='.' && flag1==0){
//                            if(Character.isDigit(str.charAt(i+1)) && flag2==0){
//                                flag1=1;
//                                lexeme+=str.charAt(i++);
//                            }
//                            else{
//                                break;
//                            }
//                        }
                        else if(str.charAt(i)=='E' && flag2==0&& i<str.length()-1){
                            if(Character.isDigit(str.charAt(i+1))){
                                flag2=1;
                                lexeme+=str.charAt(i++);    
                            }
                            else if((str.charAt(i+1)=='+' || str.charAt(i+1)=='-') && i<str.length()-2  ){
                                if(Character.isDigit(str.charAt(i+2))){
                                    flag2=1;
                                    lexeme+=str.charAt(i++);
                                }
                            }
                            else{
                                break;
                            }
                        }
                        else if((str.charAt(i)=='+'||str.charAt(i)=='-') && i<str.length()-1){
                            if(str.charAt(i-1)=='E' && Character.isDigit(str.charAt(i+1))){
                                lexeme+=str.charAt(i++);
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                        
                    }
                    i--;
     // if no letters its Constant               
 if (lexeme.matches("[0-9]+") ) {
     
      System.out.println(lexeme+" : Constant");
                    bufferedWriter.write(lexeme+" : Constant");
 }
 // its Error if Stat with digit
 else{
     errors++;
 
 
 }
                   
                    lexeme="";
                }
                          // mult line  Comment check        
                  if(i<str.length()-1 &&(str.charAt(i)=='/'&& str.charAt(i+1)=='-')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : Comment");
                    bufferedWriter.write(lexeme+" : Comment");
                    lexeme="";
                    coomentBool=true;
                   
                }
                 
                
                  else if(i<str.length()-1 &&(str.charAt(i)=='-'&& str.charAt(i+1)=='-')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : Comment");
                    bufferedWriter.write(lexeme+" : Comment");
                    lexeme="";
                   break; 
                }
                // find if its a sing or error
                 else if(!Character.isLetter(str.charAt(i))||!Character.isDigit(str.charAt(i)) ){
                 
//                     if(i<str.length()-1 &&Character.isLetter(str.charAt(i+1))){
//                     errors++;
//                     break;
//                     }
                 
                    if(i<str.length()-1 &&(str.charAt(i)=='-'&& str.charAt(i+1)=='>')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : Access Operator");
                    bufferedWriter.write(lexeme+" : Access Operator");
                    lexeme="";
                }
                else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                    System.out.println(str.charAt(i)+" : Arithmetic Operation");
                    bufferedWriter.write(str.charAt(i)+" : Arithmetic Operation");
                }
                 
                else if(str.charAt(i)=='<'||str.charAt(i)=='>'||str.charAt(i)=='='||str.charAt(i)=='!'){
                    lexeme+=str.charAt(i++);
                    if(i<str.length()&&str.charAt(i)=='='){
                        lexeme+=str.charAt(i++);
                    }
                    i--;
                    if(lexeme.matches("=")){
                        System.out.println(lexeme+" : Assignment operator");
                        bufferedWriter.write(lexeme+" : Assignment operator");
                    }
                    else if(lexeme.matches("!")){
                        System.out.println(lexeme+" : not");
                        bufferedWriter.write(lexeme+" : not");
                    }
                    else{
                        System.out.println(lexeme+": relational operators");
                        bufferedWriter.write(lexeme+": relational operators");
                    }
                    lexeme="";
                }
                else if(i<str.length()-1 &&(str.charAt(i)=='&'&& str.charAt(i+1)=='&')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : logic operators");
                    bufferedWriter.write(lexeme+" : logic operators");
                    lexeme="";
                }
                else if(i<str.length()-1 &&(str.charAt(i)=='|'&& str.charAt(i+1)=='|')){
                    lexeme+=str.charAt(i++);
                    lexeme+=str.charAt(i);
                    System.out.println(lexeme+" : logic operators");
                    bufferedWriter.write(lexeme+" : logic operators");
                    lexeme="";
                }
                else if(str.charAt(i)=='~'){
                    
                    System.out.println(str.charAt(i)+" : logic operators");
                    bufferedWriter.write(str.charAt(i)+" : logic operators");;
                   
                }
              
                
                else if(str.charAt(i)=='@'){
                    
                    System.out.println(str.charAt(i)+" : Stat Symbol");
                    bufferedWriter.write(str.charAt(i)+" : Stat Symbol");
                   
                } else if(str.charAt(i)=='$'){
                    
                    System.out.println(str.charAt(i)+" : End Symbol");
                    bufferedWriter.write(str.charAt(i)+" : End Symbol");;
                   
                }
                
                else if(str.charAt(i)=='#'){
                    
                    System.out.println(str.charAt(i)+" : Token Delimiter");
                    bufferedWriter.write(str.charAt(i)+" : Token Delimiter");
                   
                }
                else if(str.charAt(i)=='^'){
                    
                    System.out.println(str.charAt(i)+" : Line Delimiter");
                    bufferedWriter.write(str.charAt(i)+" : Line Delimiter");
                   
                }
                 else if(str.charAt(i)=='.'){
                    
                    System.out.println(str.charAt(i)+" : End line");
                    bufferedWriter.write(str.charAt(i)+" : End line");
                   
                }
                
                else if(str.charAt(i)=='('||str.charAt(i)==')'||
                        str.charAt(i)=='{'||str.charAt(i)=='}'||
                        str.charAt(i)=='['||str.charAt(i)==']'){
                        System.out.println(str.charAt(i)+"   :  Braces  ");
                    bufferedWriter.write(str.charAt(i)+"   :  Braces  ");
                }
             
               
                else if(str.charAt(i)==','){
                    System.out.println(str.charAt(i)+" : Quotation Mark");
                    bufferedWriter.write(str.charAt(i)+" : Quotation Mark");
                }
                
                
                else if(Character.isWhitespace(str.charAt(i))){
                    
                }
                
                
                
                
               }
                else if(Character.isWhitespace(str.charAt(i))){
                    
                }
                
                
                
                
                
                // its error if not one of the above
                else{
                    System.out.println("Error : "+str.charAt(i));
                    bufferedWriter.write("error ");
                }
            }
            bufferedWriter.newLine();
        }
   }
   // static counter for all errors
  public static  int x;
    //public static void main(String[] args) {
   public static void main(String args) throws FileNotFoundException, IOException {
      // read file line by line 
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {}
        catch (IOException e) {}
        String line;
        
         try {
            //FileReader fileReader =new FileReader("input.txt");
            FileReader fileReader =new FileReader(args);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                int i=1;
                while((line = bufferedReader.readLine()) != null) {
                    try (FileWriter f = new FileWriter("output.txt", true);
                BufferedWriter b = new BufferedWriter(f);
           PrintWriter p = new PrintWriter(b);) { 
           // add line number to the out but file
            p.println("Line#"+i++);
          p.println("    --------------------");
        } 
            
                    System.out.println("Line#"+i);
                    tokenize(line);
                    System.out.println("    --------------------");
                }
            }
        }
        
        catch(Exception ex) {}
       x =errors;
         System.out.print("number of errors :         "+x);
         errors=0;
    }
}