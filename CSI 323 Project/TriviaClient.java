/*
 *
 *
 * our names and reg numbers
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;



public class TriviaClient  { //THE TRIVIA CLASS
  
  //DECLARATION AND INSTANTATION OF VARIABLES USED IN THE PROGRAM
  static Socket kkSocket = null;
  static String server =null;
  public static int i = 0;
  static int begin = 0;
  static ButtonGroup group = new ButtonGroup();
  static JTextArea quesArea = new JTextArea();
  static JButton submitButton = new JButton();
  static JButton nextButton = new JButton();
  static JRadioButton aRadioButton = new JRadioButton();
  static JRadioButton bRadioButton = new JRadioButton();
  static JRadioButton dRadioButton = new JRadioButton();
  static JRadioButton cRadioButton = new JRadioButton();
  static JRadioButton invis = new JRadioButton();
  static JFrame frame = new JFrame("Cricket Trivia 3.0");
  static int correct = 0;
  static boolean nGame = false;
  static JMenuItem newGame = new JMenuItem("New Game");
  //THE QUESTIONS ASKED IN THE GAME
  static String[] questions = {
   								"QUESTION 1\nWhich batsman has the highest ODI score?\n\n(A)   Saurav Ganguly\n(B)   Sachin Tendulkar\n(C)   Saeed Anwar\n(D)   Sanath Jayasurya\n",
								"QUESTION 2\nWhich cricket team won the first ever world cup contested?\n\n(A)   Austrailia\n(B)   Pakistan\n(C)   England\n(D)   West Indies\n",
								"QUESTION 3\nWhich team has scored the most runs in an ODI match?\n\n(A)   Sri Lanka\n(B)   Austrailia\n(C)   India\n(D)   West Indies\n",
								"QUESTION 4\nWhich batsman has scored the most ODI centuries?\n\n(A)   Saeed Anwar\n(B)   Mark Waugh\n(C)   Sachin Tendulkar\n(D)   Saurav Ganguly\n",
								"QUESTION 5\nWhich bowler is considered by wisden as the greatest ODI bowler?\n\n(A)   Waqar Younis\n(B)   Muttiah Muralitharan\n(C)   Shane Warne\n(D)   Wasim Akram\n",
								"QUESTION 6\nWhich one of the following teams have won the world cup only once?\n\n(A)   West Indies\n(B)   India\n(C)   England\n(D)   New Zealand\n",
								"QUESTION 7\nWhich batsman has scored the fastest ODI century?\n\n(A)   John Davison\n(B)   Vivian Richards\n(C)   Shahid Afridi\n(D)   Sachin Tendulkar\n",
								"QUESTION 8\nWhich batsman has scored the most ODI runs?\n\n(A)   Sachin Tendulkar\n(B)   Aravinda de Silva\n(C)   Saurav Ganguly\n(D)   Inzamam-Ul-Haq\n",
								"QUESTION 9\nWhere has the world cup been hosted the most number of times?\n\n(A)   Austrailia\n(B)   South Africa\n(C)   England\n(D)   India\n",
								"QUESTION 10\nWhat is the national colour of the England cricket team?\n\n(A)   Yellow\n(B)   Blue\n(C)   Green\n(D)   Black\n",
								"QUESTION 11\nWho is the world record holder for the most runs in an test innings?\n\n(A)   Sachin Tendulkar\n(B)   Gary Sobers\n(C)   Brian Lara\n(D)   Donald Bradman\n",
								"QUESTION 12\nOn which ground was the highest individual test score made?\n\n(A)   Kensington Oval\n(B)   Antigua Recreation ground\n(C)   Melbourne Cricket Ground\n(D)   Lords\n",
								"QUESTION 13\nWho has the record for the most test wickets?\n\n(A)   Kapil Dev\n(B)   Wasim Akram\n(C)   Shane Warne\n(D)   Courtney Walsh\n",
								"QUESTION 14\nWho has the most test centuries?\n\n(A)   Sachin Tendulkar\n(B)   Gary Sobers\n(C)   Steve Waugh\n(D)   Sunil Gavasker\n",
								"QUESTION 15\nWhich batsman has the most runs in test cricket?\n\n(A)   Allan Border\n(B)   Sunil Gavaskar\n(C)   Mark Waugh\n(D)   Inzamam-Ul-Haq\n",
								"QUESTION 16\nWhich team has the most consecutive wins in test cricket?\n\n(A)   West Indies\n(B)   India\n(C)   Austrailia\n(D)   South Africa\n",
								"QUESTION 17\nWhich is the last team to gain test status?\n\n(A)   Bangladesh\n(B)   Kenya\n(C)   Sri Lanka\n(D)   Canada\n",
								"QUESTION 18\nWhich player has won the most man of the match awards in his test career?\n\n(A)   Brian Lara\n(B)   Wasim Akram\n(C)   Courtney Walsh\n(D)   Sunil Gavaskar\n",
								"QUESTION 19\nWhich batsman has scored the highest amount of runs in a single test series?\n\n(A)   Donald Bradman\n(B)   Vivian Richards\n(C)   Mark Taylor\n(D)   Brian Lara\n",
								"QUESTION 20\nWho has the most double centuries in test cricket?\n\n(A)   Brian Lara\n(B)   Marvan Attapattu\n(C)   Javed Miandad\n(D)   Donald Bradman\n",


								"QUESTION 1\nWho was Wasim Akram's 500th ODi victim?\n\n(A)   Daan van Bunge\n(B)   Mrcus Trescothick\n(C)   Nick Stratham\n(D)   Damien Martyn\n",
								"QUESTION 2\nWhich batsman has the highest score in a world cup match?\n\n(A)   Saurav Ganguly \n(B)   Sachin Tendulkar\n(C)   Brian Lara\n(D)   Gary Kirsten\n",
								"QUESTION 3\nOn which cricket ground was the highest ODI attendance made?\n\n(A)   Eden Gardens - India(Calcutta) \n(B)   Lords - England\n(C)   Melbourne Cricket Ground (MCG) - Austrailia\n(D)   Kensington Oval - West Indies(Barbados)\n",
								"QUESTION 4\nWhich one of the following bowlers has taken a wicket with his first ball in his ODI career?\n\n(A)   Shane Warne\n(B)   Wasim Akram\n(C)   Wavell Hinds\n(D)   Muttiah Muralitharan\n",
								"QUESTION 5\nWhich team has played the most ODIs?\n\n(A)   India\n(B)   West Indies\n(C)   Austrailia \n(D)   Pakistan\n",
								"QUESTION 6\nWhich two batsmen has the record for the highest partnership in ODIs for any wicket?\n\n(A)   Brian Lara and Carl Hooper\n(B)   Rahul Dravid and Saurav Ganguly \n(C)   Mark Waugh and Steve Waugh\n(D)   Sanath Jayasurya and Marvan Attapattu\n",
								"QUESTION 7\nWhich of the following batsmen has scored three consecutive ODI centuries?\n\n(A)   Saeed Anwar,Zaheer Abbas,Sachin Tendulkar\n(B)   Mark Waugh,Sachin Tendulkar,Herchelle Gibbs\n(C)   Herchelle Gibbs,Zaheer Abbas,Saeed Anwar\n(D)   Brian Lara,Herchelle Gibbs,Sachin Tendulkar\n",
								"QUESTION 8\nWhich of the following batsmen have more than 50 half centuries in ODIs?\n\n(A)   Sachin Tendulkar, Aravinda de Silva, Inzamam-Ul-Haq, Saurav Ganguly\n(B)   Sachin Tendulkar, Saeed Anwar, Herchelle Gibbs, Mark Waugh\n(C)   Brian Lara, Sachin Tendulkar, Aravinda de Silva, Steve Waugh\n(D)   Vivian Richards, Martin Crowe, Sachin Tendulkar\n",
								"QUESTION 9\nWhich one of the following players had the highest batting average at the 2003 World cup?\n\n(A)  Sachin Tendulkar\n(B)   Ricky Pointing\n(C)   Rahul Dravid\n(D)   Saurav Ganguly\n",
								"QUESTION 10\nWhich team has achieved the highest run chase batting second in a day night match?\n\n(A)   Pakistan\n(B)   India\n(C)   Austrailia\n(D)   West Indies\n",
								"QUESTION 11\nWhich of the following fielders(excluding wicketkeepers) has taken the most test catches?\n\n(A)   Mark Taylor\n(B)   Brian Lara\n(C)   Mark Waugh\n(D)   Allan Border\n",
								"QUESTION 12\nWhich of the following batsmen averages over 50 in test cricket?\n\n(A)   Brian Lara, Steve Waugh, Inzamam-Ul-Haq\n(B)   Rahul Dravid, Vivian Richards, Javed Miandad\n(C)   Sachin Tendulkar, Alvin Kalicharran, Alec Stewart\n(D)   Adam Gilchrist, Nasser Hussain, Michael Vaughan\n",
								"QUESTION 13\nWhich of the following team has won a test match after following on?\n\n(A)   Austrailia\n(B)   Pakistan\n(C)   West Indies\n(D)   England\n",
								"QUESTION 14\nWhich current player has the most consecutive centuries in innings?\n\n(A)   Everton Weekes\n(B)   Andy Flower\n(C)   Brian Lara\n(D)   Rahul Dravid\n",
								"QUESTION 15\nWhich of the following pairs has the record for the highest partnership for any wicket in test cricket?\n\n(A)   Sanath Jaysurya and M. Mahanama\n(B)   Mark Taylor and Michael Slater\n(C)   Gary Sobers and Rohan Kanhai\n(D)   Rahul Dravid and VVS Laxman\n",
								"QUESTION 16\nWhich of the following teams has never produced a batsman that has scored a triple century in test cricket?\n\n(A)   England\n(B)   Pakistan\n(C)   India\n(D)   Sri Lanka\n",
								"QUESTION 17\nWhich of the following bowlers took 10 wickets in a single innings?\n\n(A)   Jim Laker\n(B)   Curtly Ambrose\n(C)   Jeff Thompson\n(D)   Wasim Akram\n",
								"QUESTION 18\nWhich wicket keeper has effected the most dismisals in his career\n\n(A)  Jeffrey Dujon\n(B)   Ian Healy\n(C)   Moin Khan\n(D)   Alec Atewart\n",
								"QUESTION 19\nWhich batsman has scored the most test runs in a calendar year?\n\n(A)   Vivian Richards\n(B)   Brian Lara\n(C)   Michael Vaughan\n(D)   Rahul Dravid\n",
								"QUESTION 20\nWhich bowler has taken the most wickets in a calendar year?\n\n(A)   Muttiah Muralitharan\n(B)   Allan Donald\n(C)   Malcom Marshall\n(D)   Dennis Lillee\n",
								" "
    
							        					     
        					     };
  
  
 //THE MAIN METHOD 
 public static void main(String [] args) throws IOException{
  
  	JPanel contentPane = new JPanel();
  	JMenuBar jMenuBar1 = new JMenuBar();
  	JMenu jMenuFile = new JMenu();
  	JMenuItem jMenuFileExit = new JMenuItem();
  	JMenu jMenuHelp = new JMenu();
  	JMenuItem jMenuHelpAbout = new JMenuItem();
   	JPanel jPanel1 = new JPanel();
  	GridBagLayout gridBagLayout1 = new GridBagLayout();
	JMenuItem helptopics = new JMenuItem("Help Topics");
	JMenuItem readme = new JMenuItem("Read Me");
	
 	quesArea.setEditable(false);
    contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(gridBagLayout1);
    frame.setSize(new Dimension(300, 500));
    frame.setResizable(false);
    jMenuFile.setText("File");
    jMenuFileExit.setText("Exit");
    jMenuHelp.setText("Help");    
    jMenuHelp.add(helptopics);   
    jMenuHelp.add(readme);    
    jMenuFile.add(newGame);
    quesArea.setText("\n\n\tWelcome To Cricket Trivia");
    quesArea.setLineWrap(true);
    quesArea.setWrapStyleWord(true);
    submitButton.setLabel("Submit");
    nextButton.setLabel("Next");
    group.add(aRadioButton);
	    group.add(bRadioButton);
	    group.add(cRadioButton);
	    group.add(dRadioButton);
	    group.add(invis);
	aRadioButton.setText("(A)");
    bRadioButton.setText("(B)");
    dRadioButton.setText("(C)");
    cRadioButton.setText("(D)");
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    frame.setJMenuBar(jMenuBar1);
    newGame.setEnabled(false);
    nextButton.setVisible(false);
    submitButton.setVisible(true);
    submitButton.setLabel("Start");
    jMenuHelpAbout.setText("About");
    
    
    //EXIT GAME ACTION LISTENER
    jMenuFileExit.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
       
		Object[] options = {"Quit Game", "Continue Game"};
		int n = JOptionPane.showOptionDialog(frame,
    	"Do You Wish To Quit?",
    	"Exit Game",
    	JOptionPane.YES_NO_OPTION,
    	JOptionPane.QUESTION_MESSAGE,
    	null,     
    	options,  
    	options[0]); 

		if(n == 0){
			System.exit(1);
		}
      
        
      }
    });
    
       
    //NEW GAME ACTION LISTENER
    newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nextButton.setVisible(false);
				submitButton.setVisible(true);
				submitButton.setLabel("Start");
				nGame = true;
				quesArea.setText("\n\n\tWelcome to Trivia");
				invis.setSelected(true);
				i = 0;
				
				
			}
		});
    
    //HELP ACTION LISTENER
    helptopics.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				helpMethod(0);
			}
		});
	//README ACTION LISTENER	
	readme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				helpMethod(1);
			}
		});
	//ABOUT ACTION LISTENER
    jMenuHelpAbout.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        	JOptionPane.showMessageDialog(frame, "Cricket Trivia\nVersion 3.0\nRegistered To User 102001\nDesigned By BP Systems Inc\nCopyright BP Inc. (C) 2003");
	     
      }
    });
    
    
    //ACTION LISTENER FOR THE NEXT QUESTION BUTTON
    nextButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
           	quesArea.setText(questions[i]);
        	invis.setSelected(true);
        	i ++;
        	submitButton.setVisible(true);
        	nextButton.setVisible(false);
      }
    });
    
    
   
    //PALCE COMPONENTS ON TO CONTENT PANE
    contentPane.add(quesArea,  new GridBagConstraints(0, 0, 4, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(22, 24, 0, 19), 0, 144));
    contentPane.add(submitButton,  new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(13, 83, 25, 19), 29, 7));
    contentPane.add(nextButton,  new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(13, 81, 25, 21), 43, 7));
    contentPane.add(aRadioButton,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 24, 0, 0), -1, 0));
    contentPane.add(bRadioButton,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 61, 0, 0), -2, 0));
    contentPane.add(cRadioButton,  new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(21, 71, 0, 19), -3, 0));
    contentPane.add(dRadioButton,  new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 65, 0, 0), -3, 0));
    
   
     	//ALLOW USER TO SUPPLY SERVER'S NAME AND CAPTURE INPUT  
    	System.out.println("This program is a Cricket Trivia Grame Enjoy !!!\n");
		System.out.print("\nEnter the Server Name: ");
		BufferedReader ser = new BufferedReader(new InputStreamReader(System.in));
        server = ser.readLine();
    
    	//SET UP SOCKET TO SERVER AND PORT 
        try {
            kkSocket = new Socket(server, 4444);
            } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + server);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + server);
            System.exit(1);
        }
    
        
    
  //SUBMIT BUTTON ACTION LISTNER 
  submitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
    	String fromServer = null;
        String fromUser = null;
    	int inv = 0;
    	
        nextButton.setVisible(true);
        submitButton.setLabel("Submit");
        submitButton.setVisible(false);
        newGame.setEnabled(false);
        //OPEN STREAMS FROM CLIENT AND TO SERVER
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException ei) {
            System.err.println("Don't know about host: " + server);
            System.exit(1);
        } catch (IOException eo) {
            System.err.println("Couldn't get I/O for the connection to: " + server);
            System.exit(1);
        }
        
	    //CHECK USER'S INPUT IN RESPONCE TO A QUESTION AND SEND TO SERVER
	    try{
	       if(aRadioButton.isSelected()) fromUser = "A";
	       else if(bRadioButton.isSelected()) fromUser = "B";
	       else if(cRadioButton.isSelected()) fromUser = "D";
	       else if(dRadioButton.isSelected()) fromUser = "C";
	       else fromUser = null;
       			
       		 if (fromUser != null) {                
                out.println(fromUser);
                System.out.println(fromUser);
	            }
	         else if(invis.isSelected()){
                	if(nGame){}
                	else{
                	 JOptionPane.showMessageDialog(frame, "You Must Make A Selection");
	        	   	 nextButton.setVisible(false);
	        	   	 submitButton.setVisible(true);
	        	   	 inv = 1;
	        	   }
	           }
	  
	    if(inv == 1){
	    	fromServer = null; 
	    	submitButton.setVisible(true);
	    	}
	    
	    else if (nGame){
				fromServer = ("Press Next to Begin. Goodluck");
				nGame = false;
			
			
			}
	    
	    else fromServer = in.readLine();

	    if(fromServer.equalsIgnoreCase("Press Next to Begin. Goodluck")){    
		    Object[] options = {"Beginners", "Advance"};
		    int n = JOptionPane.showOptionDialog(frame,
    		"Before You Begin\nChoose Skill Level",
    		"Level",
    		JOptionPane.YES_NO_OPTION,
    		JOptionPane.QUESTION_MESSAGE,
    		null,    
    		options,  
    		options[0]); 
    		

			if(n == 0){
				begin = 1;
				fromServer = null;
			}
			
			else {
				i = 20;
			    begin = 2;
			    System.out.println("begin is " + begin + " i is " + i);
				fromServer = null;
				}
		}
	    
	    
	    
	    if(fromServer != null ) {
	    	  	quesArea.setText("");
            	
            	if(fromServer.equals("Correct")){
            	
            	JOptionPane.showMessageDialog(frame, "CORRECT !!!");
            	quesArea.setText(questions[i++]);
        		invis.setSelected(true);
        		correct++;
            	submitButton.setVisible(true);
        		nextButton.setVisible(false);
            	}
            	else if(fromServer.equalsIgnoreCase("INCORRECT !!!")) {
            		
            		JOptionPane.showMessageDialog(frame, fromServer);
            		
            		quesArea.setText(questions[i++]);
            		
            	
        		invis.setSelected(true);
        		
            	submitButton.setVisible(true);
        		nextButton.setVisible(false);
            		
              }
              
              else if((fromServer.equalsIgnoreCase("Press Next to Begin. Goodluck")) || nGame == false){
              	quesArea.setText(questions[i]);
              	invis.setSelected(true);
        		
            	submitButton.setVisible(true);
        		nextButton.setVisible(false);
              }
        
      
	   
	   } 
	    
        
		
	    
         
          }catch (IOException el) {
            System.err.println("Couldn't get I/O for the connection to: " + server);
            System.exit(1);
        } 
        
        
         //CHECK IF END OF GAME
         if(i == 21 && begin == 1 || i == 41 && begin == 2){
	        	quesArea.setText(" ");
	        	if(i == 41 || i == 21 && fromServer.equals("D"))correct++;
	        	JOptionPane.showMessageDialog(frame, "Game Over\nGoodbye\nYou Got " + correct + " Correct.");
	        	correct = 0;
	        	quesArea.setText("\n\tThank You For Playing Cricket Trivia\n\tTo Select A New Game Click File/New Game\n");
	        	newGame.setEnabled(true);
	        	submitButton.setVisible(false);
	        	nextButton.setVisible(false);
	        }
     
        
        
        
      }
    });



//Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    
//SET UP THE FRAME TO BE VISIBLE TO USER
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.pack(); 






}
  
  
 
    //METHOD TO SHOW README AND HELP FILES	
	public static void helpMethod(int i){
		JFrame frame = new JFrame("Help Topics");
		JScrollPane spane = new JScrollPane();
		JTextArea htext = new JTextArea();
		JPanel pane = new JPanel();
		Container ct = frame.getContentPane();
		frame.setSize(500,500);
		htext.setLineWrap(true);
    	htext.setWrapStyleWord(true);
		spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spane.getViewport().add(htext, null);
		ct.add(spane,BorderLayout.CENTER);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	Dimension frameSize = frame.getSize();
    	if (frameSize.height > screenSize.height) {
      	frameSize.height = screenSize.height;
    	}
    	if (frameSize.width > screenSize.width) {
      	frameSize.width = screenSize.width;
    	}
    	frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    	frame.setVisible(true);
		
		
		frame.show();
		try
                   {
                   if(i == 1){	
                   	BufferedReader in = new BufferedReader(new FileReader("readme.txt"));
					frame.setTitle("Read Me");
					htext.read(in, "");
                    in.close();
					}
				   else {BufferedReader in = new BufferedReader(new FileReader("helptopics.txt"));                   
                    frame.setTitle("Help Topics");
                    htext.read(in, "");
                    in.close();
                  	frame.repaint();
                  }
                   
                   
                  }
                  catch(IOException s){
                  	System.out.println("Error");
                }
				
	
		}
    
    

}