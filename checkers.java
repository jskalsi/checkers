import java.util.Scanner;

public class checkers {
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		System.out.print("You are about to start the game 'Checkers'. 'Checkers' is played by two opponents, on opposite sides of the gameboard."
							+ " One player has the 'R' pieces; the other has the 'B' pieces.\n Players alternate turns. A player may not move an opponent's piece. A move consists of moving a piece diagonally to an adjacent unoccupied square.\n"
							+ " If the adjacent square contains an opponent's piece, and the square immediately beyond it is vacant, the piece may be captured (and removed from the game) by jumping over it. Force jump is unabled and multiple jumps too."
							+ "\n When one of the players checker reaches opposite side of the board to the starting point his checker becomes a 'King' checker, so it can move and jump over opponents checkers forward and backwards."
							+ " \nChoose on which board you wamt to play: 1)8x8 or 2)10x10.\nType 1 or 2 to choose, please: ");
		int choice  = s.nextInt();
		char array[][]=createBoard(choice);
		displayBoard(array);
		while(gameIsOn(array)==' '){ 
			playerTurn(array,1);
			if (gameIsOn(array)=='R')
				break;
			playerTurn(array,2);
		}
		if(gameIsOn(array)=='B')
			System.out.println("B wins");
		if(gameIsOn(array)=='R')
			System.out.println("R wins");
	}
	public static void displayBoard(char array[][]){
    	if (array.length==10){
    		System.out.print("   ");
    	  for (int i = 0;i<=9;i++){
    		  System.out.print(i+"   ");
    	  }
    	  System.out.println();
    	  for (int i=0;i<=9;i++){
    		  System.out.printf("%d ",i);
    		for (int j = 0;j<=9;j++){
    			System.out.print("|"+array[i][j]+"|"+" ");
    		}
    		System.out.println();
    		System.out.println();
    	  }
    	}
    	
    	else {
    		System.out.print("   ");
      	    for (int i = 0;i<=7;i++){
      		    System.out.print(i+"   ");
      	    }
      	    System.out.println();
    		for (int i=0;i<=7;i++){
    			System.out.printf("%d ",i);
        		for (int j = 0;j<=7;j++){
        			System.out.print("|"+array[i][j]+"|"+" ");
        		}
        		System.out.println();
        		System.out.println();
        	  }
    	}
    }
    
    public static char[][] createBoard(int choice){
    	char array[][];
    	//creating 8x8 board
    	if (choice==1){
    		array=new char[8][8];
    		for(int i = 0; i < 8; i++){
		    	for(int j = 0; j < 8; j++) {
		    		if(i < 3) {
			    		if(i % 2 == 0){ 
			    				if(j % 2 != 0) array[i][j] = 'B';
			    		} else
			    			if(j % 2 == 0) array[i][j] = 'B';
		    		}	
		    		if(i > 4) {
		    			if(i % 2 == 0) { 
			    				if(j % 2 != 0) array[i][j] = 'R';
			    		}
			    		else
			    			if(j % 2 == 0) array[i][j] = 'R';
		    		}
		    	}
		    }
    		
    	}
    	//creating 10x10 board
    	else {
    		array=new char[10][10];
    		for (int i=0;i<10;i++){
    			for(int j=0;j<10;j++){
    				if (i<4){
    					if(i%2==0){
    						if (j%2!=0) array [i][j] = 'B';
    					}
    					else
    						if(j%2==0) array[i][j]='B';
    				}
    				if (i>5){
    					if(i%2==0){
    						if (j%2!=0) array[i][j]='R';
    					}
    					else
    						if (j%2==0) array[i][j]='R';
    				}
    			}
    		}
    	}
    	return array;
    }
    		
    public static void playerTurn(char array[][], int player){
    	int board_Bound=0;
    	Scanner s = new Scanner (System.in);
    	if(player==1)
    		System.out.print("Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column): ");
    	else
    		System.out.print("Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column): ");
    	String k = s.nextLine();
    	int temp1=k.charAt(6), temp2=k.charAt(0), temp3=k.charAt(7), temp4=k.charAt(1);
   
    		
    	if(player == 1){
    		//line 117 to 245 checking if the turn is legal for player 'R'
    		while(true){
    		while (array[temp2-48][temp4-48]!='R'&&array[temp2-48][temp4-48]!='r'){
    			System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    			k = s.nextLine();
    			temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    		}
    		if (array.length==8) {
    			board_Bound = 6;
    		}
    		else
    			board_Bound = 8;
    			 
    		if ((temp4-48!=0)&&(temp4-48!=1)&&(temp4-48!=board_Bound)&&(temp4-48!=board_Bound+1)){
    			if (array[temp2-48][temp4-48]=='r'){
    				while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
        					&&((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        					&&((temp2-48-2!=temp1-48)||(temp4-48-2!=temp3-48))
        					&&((temp2-48-2!=temp1-48)||(temp4-48+2!=temp3-48))
        					&&((temp2-48+1!=temp1-48)||(temp4-48-1!=temp3-48))
        					&&((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48-2!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48+2!=temp3-48))){			
        				System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
        				k=s.nextLine();
        				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        			}
    			}
    			else if (array[temp2-48][temp4-48]=='R')  {
    				while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
    					&&((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
    					&&((temp2-48-2!=temp1-48)||(temp4-48-2!=temp3-48))
    					&&((temp2-48-2!=temp1-48)||(temp4-48+2!=temp3-48))){			
    				System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    				k=s.nextLine();
    				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    			    }
    			}	
    		}
    		 else{
    			if (temp4-48==0){
    				if (array[temp2-48][temp4-48]=='r'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
    							&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))){
    						System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    						k=s.nextLine();
    						temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    					}
    				}
    				else if (array[temp2-48][temp4-48]=='R') {
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
    							&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))){
    						System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    						k=s.nextLine();
    						temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    					}
    				}
    			}
    			else if (temp4-48==1){
    				if (array[temp2-48][temp4-48]=='R'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    				else if (array[temp2-48][temp4-48]=='r'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    				
    			}
    			else if (temp4-48==board_Bound){
    				if (array[temp2-48][temp4-48]=='R'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    				else if (array[temp2-48][temp4-48]=='r'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))
        				        &&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    				
    			}
    			else if (temp4-48==board_Bound+1){
    				if (array[temp2-48][temp4-48]=='R'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
            				System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        				}
    				}
    				else if (array[temp2-48][temp4-48]=='r'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        						&&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
            				System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        				}
    				}
    				
    			}
    		 }
    		//line 247 to 312 statements of jumping for player 'R'
    		if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==2 && array[temp2-48][temp4-48]=='r' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48+1] == 'B' || array[temp2-48+1][temp4-48+1] == 'b')){                      //down
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48+1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==-2 && array[temp2-48][temp4-48]=='r' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48-1] == 'B' || array[temp2-48+1][temp4-4-+1] == 'b')){
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48+1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==2 && array[temp2-48][temp4-48]=='r' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48+1] == 'B' || array[temp2-48-1][temp4-48+1] == 'b')){                 //up
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48-1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==-2 && array[temp2-48][temp4-48]=='r' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48-1] == 'B' || array[temp2-48-1][temp4-48-1] == 'b')){
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48-1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==-1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1) && array[temp2-48][temp4-48]=='r'){           //down
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1) && array[temp2-48][temp4-48]=='r'){          //up
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==2 && (temp1-48)==0 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48+1] == 'B' || array[temp2-48-1][temp4-48+1] == 'b')){
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48-1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==-2 && (temp1-48)==0 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48-1] == 'B' || array[temp2-48-1][temp4-48-1] == 'b')){
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48-1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==1 && (temp1-48)==0 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1)){
    			array[temp1-48][temp3-48] = 'r';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==2 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48+1] == 'B' || array[temp2-48-1][temp4-48+1] == 'b')){
    			array[temp1-48][temp3-48] = 'R';
    			array[temp2-48-1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==-2 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48-1] == 'B' || array[temp2-48-1][temp4-48-1] == 'b')){
    			array[temp1-48][temp3-48] = 'R';
    			array[temp2-48-1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1)){
    			array[temp1-48][temp3-48] = 'R';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		else{
    			System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
				k=s.nextLine();
				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
				continue;
    		}
    		break;
    		}
    		
    	}
    	else if(player == 2){
    		//line 316 to 440 checking if the turn is legal for player 'B'
    		while(true){
    		while (array[temp2-48][temp4-48]!='B'&&array[temp2-48][temp4-48]!='b'){
    			System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    			k = s.nextLine();
    			temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    		}
    		if ((temp4-48!=0)&&(temp4-48!=1)&&(temp4-48!=board_Bound)&&(temp4-48!=board_Bound+1)){
    			if (array[temp2-48][temp4-48]=='B'){
    				while (((temp2-48+1!=temp1-48)||(temp4-48-1!=temp3-48))
        					&&((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48-2!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48+2!=temp3-48))){			
        				System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
        				k=s.nextLine();
        				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        			}
    			}
    			else if (array[temp2-48][temp4-48]=='b'){
    				while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
        					&&((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        					&&((temp2-48-2!=temp1-48)||(temp4-48-2!=temp3-48))
        					&&((temp2-48-2!=temp1-48)||(temp4-48+2!=temp3-48))
        					&&((temp2-48+1!=temp1-48)||(temp4-48-1!=temp3-48))
        					&&((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48-2!=temp3-48))
        					&&((temp2-48+2!=temp1-48)||(temp4-48-2!=temp3-48))){			
        				System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
        				k=s.nextLine();
        				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        			}
    			}
    				
    		}
    		 else{
    			if (temp4-48==0){
    				if (array[temp2-48][temp4-48]=='B'){
    					while (((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))){
            				System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        				}
    				}
    				else if (array[temp2-48][temp4-48]=='b'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
    							&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))){
    						System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
    						k=s.nextLine();
    						temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
    					}
    				}
    				
    			}
    			else if (temp4-48==1){
    				if (array[temp2-48][temp4-48]=='B'){
    					while (((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    			
    				else if (array[temp2-48][temp4-48]=='b'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48+2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+2!=temp1-48)||(temp4-48+2)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))
    							&&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    			}
    			else if (temp4-48==board_Bound){
    				if (array[temp2-48][temp4-48]=='B'){
    					while (((temp2-48+1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    				
    				else if (array[temp2-48][temp4-48]=='b'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48+1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        				        &&((temp2-48-1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        				        &&((temp2-48+1!=temp1-48)||(temp4-48+1)!=(temp3-48))
        				        &&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
        					System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);	
        				}
    				}
    			}
    			else if (temp4-48==board_Bound+1){
    				if (array[temp2-48][temp4-48]=='B'){
    					while (((temp2-48+1!=temp1-48)||(temp4-48-1!=temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
            				System.out.print("Wrong selection!!! Player Blue type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        				}
    				}
    				
    				else if (array[temp2-48][temp4-48]=='b'){
    					while (((temp2-48-1!=temp1-48)||(temp4-48-1!=temp3-48))
        						&&((temp2-48-2!=temp1-48)||(temp4-48-2)!=(temp3-48))
        						&&((temp2-48+1!=temp1-48)||(temp4-48-1)!=(temp3-48))
        						&&((temp2-48+2!=temp1-48)||(temp4-48-2)!=(temp3-48))){
            				System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
            				k=s.nextLine();
            				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
        				}
    				}
    			}
    		 }
    		//line 443 to 508 statements of jumping for player 'B'
    		if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==2 && array[temp2-48][temp4-48]=='b' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48+1] == 'R' || array[temp2-48+1][temp4-48+1] == 'r')){                      //down
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48+1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==-2 && array[temp2-48][temp4-48]=='b' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48-1] == 'R' || array[temp2-48+1][temp4-4-+1] == 'r')){
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48+1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==2 && array[temp2-48][temp4-48]=='b' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48+1] == 'R' || array[temp2-48-1][temp4-48+1] == 'r')){                 //up
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48-1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==2 && (temp3-48)-(temp4-48)==-2 && array[temp2-48][temp4-48]=='b' && array[temp1-48][temp3-48] == ' ' && (array[temp2-48-1][temp4-48-1] == 'R' || array[temp2-48-1][temp4-48-1] == 'r')){
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48-1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==-1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1) && array[temp2-48][temp4-48]=='b'){           //down
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1) && array[temp2-48][temp4-48]=='b'){          //up
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==2 && (temp1-48)==array.length-1 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48+1] == 'R' || array[temp2-48+1][temp4-48+1] == 'r')){
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48+1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==-2 && (temp1-48)==array.length-1 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48-1] == 'R' || array[temp2-48+1][temp4-48-1] == 'r')){
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48+1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==-1 && (temp1-48)==array.length-1 &&  (((temp3-48)-(temp4-48)==-1) || (temp3-48)-(temp4-48)==1)){
    			array[temp1-48][temp3-48] = 'b';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==2 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48+1] == 'R' || array[temp2-48+1][temp4-48+1] == 'r')){
    			array[temp1-48][temp3-48] = 'B';
    			array[temp2-48+1][temp4-48+1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if ((temp2-48)-(temp1-48)==-2 && (temp3-48)-(temp4-48)==-2 && array[temp1-48][temp3-48] == ' ' && (array[temp2-48+1][temp4-48-1] == 'R' || array[temp2-48+1][temp4-48-1] == 'r')){
    			array[temp1-48][temp3-48] = 'B';
    			array[temp2-48+1][temp4-48-1] = ' ';
        		array[temp2-48][temp4-48] = ' ';
    		}
    		else if((temp2-48)-(temp1-48)==-1 && ((temp3-48)-(temp4-48)==-1 || (temp3-48)-(temp4-48)==1)){
    			array[temp1-48][temp3-48] = 'B';
    			array[temp2-48][temp4-48] = ' ';
    		}
    		else{
    			System.out.print("Wrong selection!!! Player Red type your dice position and where you want to  move it , for example: '52 to 43'(first number represents row, second number represents column):");
				k=s.nextLine();
				temp1=k.charAt(6); temp2=k.charAt(0); temp3=k.charAt(7); temp4=k.charAt(1);
				continue;
    		}
    		break;
    		}
    		
    		
    	}
    	displayBoard(array);
    }
    //Checking if the game can still continue
    public static char gameIsOn(char array[][]){
    	int countB=0, countR=0;
    	for (int i=0;i<array.length;i++){
    		for (int j=0;j<array.length;j++){
    			if (array[i][j]=='B'|| array[i][j]=='b')
    				countB=countB+1;
    			if (array[i][j]=='R'|| array[i][j]=='r')
    				countR = countR+1;
    		}
    	}
    	if (countB==0)
    		return 'R';
    	else if (countR==0)
    		return 'B';
    	else
    		return ' ';
    	
    	
    }

}