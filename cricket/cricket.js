import java.util.Random;
import java.util.Scanner;

public class Start {
    private static Scanner sc;
    
    public static double playerOvers= 0;
    public static double compOvers= 0;
    public static int compTotal = 0;
    public static int playerTotal = 0;
    public static int compBalls = 0;
    public static int playerBalls = 0;
    public static int[][] players = new int[10][2];
    public static int[][] computers = new int[10][2];

    public static void main(String[] args) {
        System.out.print("Sololearn's code playground is unsupported.\n");
        System.out.print("Sup, Welcome to the game of Cricket!!\nToss Time\n\n");

        int playerChoice; //0 for bat 1 for Bowl 
        switch(choice()){
        case 0:
            System.out.print("Computer won the toss");
            if(choice()==0){
                System.out.println(" and choose to Bat.");
                compPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(computers);
                System.out.println("Your turn to bat.");
                playerPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(players);
            }
            else{
                System.out.println(" and choose to Bowl.");
                playerPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(players);
                System.out.println("Your turn to bowl.");
                compPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(computers);
            }
            break;
        case 1:
            System.out.print("You won the toss!!\n");
            System.out.print("Enter 0 to bat or 1 to Bowl :-");

            playerChoice=input();
            while (playerChoice!=0 && playerChoice!=1){
                System.out.print("Incorrect Entery!! Please Enter either 0 to bat and 1 to Bowl:-");
                playerChoice=input();
            }
            if(playerChoice==0){
                System.out.println("You choose to Bat.");
                playerPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(players);
                System.out.println("Your turn to bowl.");
                compPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(computers);
            }
            else if(playerChoice==1){
                System.out.println("You choose to Bowl.");
                compPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(computers);
                System.out.println("Your turn to bat.");
                playerPlay();
                System.out.println("\n\tSCORECARD");
                System.out.println("========================================\n");
                showScoreCard(players);
            }
            break;
        }
        for(int x=0;x<10;x++){
            compTotal += computers[x][0];
            compBalls += computers[x][1];
            playerTotal += players[x][0];
            playerBalls += players[x][1];
        }
        playerOvers = getOvers(playerBalls);
        compOvers = getOvers(compBalls);
        if(compTotal>playerTotal){
            System.out.print("You lost,Try again!!");
        }
        else if(compTotal<playerTotal){
            System.out.print("Congrats!! You won!");
        }
        else {
            compOvers=getOvers(compBalls);
            playerOvers=getOvers(playerBalls);
            System.out.print("Same runs.Computer finished its innings in "+compOvers+" overs and you finished your innings in "+playerOvers+" overs./n");
            if(compBalls>playerBalls)
                System.out.print("Congrats!! You won!");
            else if(compBalls<playerBalls)
                System.out.print("You lost,Try again!!");
            else     
                System.out.print("Tie.");
        }

    }

    //random choice of toss

    public static int choice(){
        Random rnd=new Random();
        return (rnd.nextInt(2));
    }

    //Random score generator for computer

    public static int score(){
        Random rnd=new Random();
        return (rnd.nextInt(6)+1);
    } 

    //input from player 

    public static int input(){
        sc = new Scanner(System.in);      
        return sc.nextInt(); 
    }

    //convert balls to overs

    public static double getOvers(int balls){
        double overs = 0;

        for(int x=6;x<balls;x=x+6){
            overs++;
        }

        for(int y=1;y<=(balls%6);y++){
            overs += 0.1;
        }

        return ((double)(int)(overs * 10)/10);
    }

    //Computer Batting method

    public static void compPlay(){
        for(int x=0;x<10;x++){
            int singleCompTotal=0; 
            int singleCompBalls=0;
            int compScore;
            int playerScore;
            loop:while (true){
                compScore=score();
                singleCompBalls++;
                playerScore=input();
                if(playerScore>=1 && playerScore<=6){
                    if(compScore==playerScore){
                        System.out.println("OUT!! Computer player "+ (x+1) +" managed to make "+singleCompTotal+" runs in " + singleCompBalls + " balls.");
                        break loop;
                    }
                    singleCompTotal +=compScore;
                    System.out.println(compScore);
                }
                else{
                    System.out.println("Please Enter between 1 and 6.");
                    singleCompBalls--;
                    continue loop;
                }
            }
            if(x<=8)
                System.out.println("Computer player " + (x+2) + "'s turn to bat.");
            
            computers[x][0] = singleCompTotal;
            computers[x][1] = singleCompBalls;
        } 
    }

    //Player Batting method

    public static void playerPlay(){
        for(int x=0;x<10;x++){
            int singlePlayerTotal=0;
            int singlePlayerBalls=0;
            int compScore;
            int playerScore;
            loop:while (true){
                compScore=score();
                singlePlayerBalls++;
                playerScore=input();
                if(playerScore>=1 && playerScore<=6){
                    if(compScore==playerScore){
                        System.out.println("OUT!! Your player " + (x+1) + " managed to make "+singlePlayerTotal+" runs in " + singlePlayerBalls + " balls.");
                        break loop;
                    }
                    singlePlayerTotal +=playerScore;
                    System.out.println(compScore);
                }
                else{
                    System.out.println("Please Enter between 1 and 6.");
                    singlePlayerBalls--;
                    continue loop;
                }
            } 
            if(x<=8)
                System.out.println("Your player " + (x+2) + "'s turn to bat.");
            
            players[x][0] = singlePlayerTotal;
            players[x][1] = singlePlayerBalls;
        }
    }

    //Print score card

    public static void showScoreCard(int[][] arr){

        int totalRuns = 0;
        int totalBalls = 0;

        System.out.println("Batsman\t\tScore\t\tBalls");

        for(int x=0;x<10;x++){
            System.out.print((x+1) + "\t\t" + arr[x][0] + "\t\t" + arr[x][1] + "\n");
            totalRuns += arr[x][0];
            totalBalls += arr[x][1];
        }

        System.out.println();
        System.out.println("Total Runs : " + totalRuns + "\tTotal Overs : " + getOvers(totalBalls));
    }
}
