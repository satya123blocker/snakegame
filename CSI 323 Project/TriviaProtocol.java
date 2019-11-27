//THE PROTOCOL USED BY THE SERVER TO CHECK QUESTIONS SENT BY SERVER
import java.net.*;
import java.io.*;

public class TriviaProtocol {
    private String[] answers = {"C","D","A","C", "D","B","C","A", "C","B", "C","B","D","D", "A","C","A","B", "A","D" };
	private int state = 0, i = 0;
    public String processInput(String theInput) {
    String theOutput = null;
		if (state == 0 || theInput.equalsIgnoreCase("newGame")){
		 		theOutput = "Press Next to Begin. Goodluck" ;
        		state = 1;
       	  }
             
        else if(i < 20){ 
          	if(theInput.equalsIgnoreCase("Exit")) {  
               theOutput = "bye";
             }  
           	else if (theInput.equalsIgnoreCase(answers[i])){
        		theOutput = "Correct";
        		i++;
        	}
        	else{	
        		theOutput = "INCORRECT !!!" ;
           		i++;
        	}
                
      if(i  == 20 ) i = 0;   
         
         }		
             
        return theOutput;
    }
}

