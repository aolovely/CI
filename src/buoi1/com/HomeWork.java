package buoi1.com;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] map = {
				{"*", "*", "*", "*"},
				{"*", "*", "*", "*"}
		};
		
		int[] player = new int[2];
		int[] enemyx = new int[2];
		int[] enemyy = new int[2];
		int[] enemy = new int[2];
		int[][] gift = new int[3][2];
		int[][] box = new int[3][2];
		int[][] wall = new int[5][2];
		
		int addx = 1, addy = 1;
		// khoi tao player
		Random random = new Random();
		player[0] = random.nextInt(10);
		player[1] = random.nextInt(10);
		//khoi tao enemy chay giong player
		while(true) {
			enemy[0] = random.nextInt(10);
			enemy[1] = random.nextInt(10);
			if(enemy[0] == player[0] || enemy[1] == player[1]) break;		
		}
		// khoi tao gift
		lable:
		while(true) {
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 2; j++) {
					gift[i][j] = random.nextInt(10);
				}
			for(int k = 0; k < 3; k++) {
				if(gift[k][0] == player[0] && gift[k][1] == player[1]) continue lable;
			}
			break;
		}
		//khoi tao box
		lable1:
		while(true) {
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 2; j++) {
					box[i][j] = random.nextInt(10);
				}
			for(int k = 0; k < 3; k++) {
				if((box[k][0] == player[0] && box[k][1] == player[1]) ||
					(box[k][0] == enemy[0] && box[k][1] == enemy[1]) ||
					(box[k][0] == enemyx[0] && box[k][1] == enemyx[1]) ||
					(box[k][0] == enemyy[0] && box[k][1] == enemyy[1])) continue lable1;				
				for(int h = 0; h < 3; h++) {
					if(box[k][0] == gift[h][0] && box[k][1] == gift[h][0]) continue lable1;
				}
			}
			break;
		}
		
		//khoi tao wall
		lable2:
		while(true) {
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 2; j++) {
					wall[i][j] = random.nextInt(10);
				}
			for(int k = 0; k < 5; k++) {
				if((wall[k][0] == player[0] && wall[k][1] == player[1]) ||
					(wall[k][0] == enemy[0] && wall[k][1] == enemy[1]) ||
					(wall[k][0] == enemyx[0] && wall[k][1] == enemyx[1]) ||
					(wall[k][0] == enemyy[0] && wall[k][1] == enemyy[1])) continue lable2;
				for(int h = 0; h < 3; h++) {
					if(wall[k][0] == gift[h][0] && wall[k][1] == gift[h][1]) continue lable2;
				}
				for(int m = 0; m < 3; m++) {
					if(wall[k][0] == box[m][0] && wall[k][1] == box[m][1]) continue lable2;
				}
			}
			break;
		}
		// khoi tao enemy chay ngang
		while(true) {
			enemyx[0] = random.nextInt(10);
			enemyx[1] = random.nextInt(10);
			if(enemyx[0] == player[0] || enemyx[1] == player[1]) break;		
		}
		while(true) {
			enemyy[0] = random.nextInt(10);
			enemyy[1] = random.nextInt(10);
			if(enemyx[0] == enemyy[0] && enemyx[1] == enemyy[1])
				continue;
			if(enemyy[0] == player[0] || enemyy[1] == player[1])
				break;
		}
		
		lable3:
		while(true) {
			for(int y = 0;  y < 10; y++) {
				for(int x = 0; x < 10; x++) {
					
					boolean checkgift = false;
					for(int k = 0; k < 3; k++) {
						if(gift[k][0] == x && gift[k][1] == y) 
							checkgift = true;							
					}
					
					boolean checkbox = false;
					for(int k = 0; k < 3; k++) {
						if(box[k][0] == x && box[k][1] == y) 
							checkbox = true;
					}
					
					boolean checkwall = false;
					for(int k = 0; k < 5; k++) {
						if(wall[k][0] == x && wall[k][1] == y) 
							checkwall = true;	
					}
					
					if (x == player[0] && y == player[1]){
						System.out.print("P ");
					} else if((x == enemyx[0] && y == enemyx[1]) || (x == enemyy[0] && y == enemyy[1]) || (x == enemy[0] && y == enemy[1])){
						System.out.print("X ");
					} else if(checkgift) {
						System.out.print("G ");
					} else if(checkbox) {
						System.out.print("B ");
					} else if(checkwall) {
						System.out.print("# ");
					} else {
						System.out.print("* ");
					}		
				}
				System.out.println("");
			}
			
			System.out.println("move(A, D, W, S): ");
			
			String move = new Scanner(System.in).nextLine().toUpperCase();
			if(move.equals("A")) {
				for(int k = 0; k < 5; k++) {
					if(wall[k][0] == ((player[0] + 10 - 1)%10) && wall[k][1] == player[1])
						continue lable3 ;									
				}
				for(int k = 0; k < 3; k++) {
					if(box[k][0] == ((player[0] +10 - 1)%10) && box[k][1] == player[1]) {
						for(int h = 0; h < 5; h++) {
							if(wall[h][0] == ((box[k][0] + 10 - 1)%10) && wall[h][1] == box[k][1])
								continue lable3 ;									
						}
						box[k][0] = (box[k][0] +10 - 1) % 10;
						break;
					}
				}
				
				player[0] = (player[0] + 10 - 1) % 10;
				for(int k = 0; k < 5; k++) {
					if(wall[k][0] == ((enemy[0] + 10 - 2)%10) && wall[k][1] == enemy[1]) {
						enemy[0] = (enemy[0] + 10 + 4) % 10;
						break;
					}
				}
				enemy[0] = (enemy[0] + 10 -2) % 10;
			} else if(move.equals("D")) {
				for(int k = 0; k < 5; k++) {
					if(wall[k][0] == ((player[0] + 1)%10) && wall[k][1] == player[1])
						continue lable3 ;									
				}
				for(int k = 0; k < 3; k++) {
					if(box[k][0] == ((player[0] + 1)%10) && box[k][1] == player[1]) {
						for(int h = 0; h < 5; h++) {
							if(wall[h][0] == ((box[k][0] + 1)%10) && wall[h][1] == box[k][1])
								continue lable3 ;									
						}
						box[k][0] = (box[k][0] + 1) % 10;
						break;
					}
				}
				player[0] = (player[0] + 1) % 10;
				for(int k = 0; k < 5; k++) {
					if(wall[k][0] == ((enemy[0] + 2)%10) && wall[k][1] == enemy[1]) {
						enemy[0] = (enemy[0] + 10 - 4) % 10;
						break;
					}
				}
				enemy[0] = (enemy[0] + 2) % 10;
				
			} else if(move.equals("W")) {
				for(int k = 0; k < 5; k++) {
					if(wall[k][1] == ((player[1] + 10 - 1)%10) && wall[k][0] == player[0])
						continue lable3 ;									
				}
				for(int k = 0; k < 3; k++) {
					if(box[k][1] == ((player[1] + 10 - 1)%10) && box[k][0] == player[0]) {
						for(int h = 0; h < 5; h++) {
							if(wall[h][1] == ((box[k][1] + 10 - 1)%10) && wall[h][0] == box[k][0])
								continue lable3 ;									
						}
						box[k][1] = (box[k][1] +10 - 1) % 10;
						break;
					}
				}
				player[1] = (player[1] + 10 -1) % 10;
				for(int k = 0; k < 5; k++) {
					if(wall[k][1] == ((enemy[1] + 10 - 2)%10) && wall[k][0] == enemy[0]) {
						enemy[1] = (enemy[1] + 4) % 10;
						break;	
					}
				}
				enemy[1] = (enemy[1] + 10 -2) % 10;
						
			} else if(move.equals("S")) {
				for(int k = 0; k < 5; k++) {
					if(wall[k][1] == ((player[1] + 1)%10) && wall[k][0] == player[0])
						continue lable3 ;									
				}
				for(int k = 0; k < 3; k++) {
					if(box[k][1] == ((player[1] + 1)%10) && box[k][0] == player[0]) {
						for(int h = 0; h < 5; h++) {
							if(wall[h][1] == ((box[k][1] + 1)%10) && wall[h][0] == box[k][0])
								continue lable3 ;									
						}
						box[k][1] = (box[k][1] + 1) % 10;
						break;
					}
				}
				player[1] = (player[1] + 1) % 10;
				for(int k = 0; k < 5; k++) {
					if(wall[k][1] == ((enemy[1] + 2)%10) && wall[k][0] == enemy[0]) {
						enemy[1] = (enemy[1] + 10 - 4) % 10;
						break;		
					}
				}
				enemy[1] = (enemy[1] + 10 + 2) % 10;						
			} else {
				System.out.println("error");
				continue;
			}
			
			//enemyx va vao tuong
			for(int k = 0; k < 5; k++) {
				if(wall[k][0] == ((enemyx[0] + 10 + addx)%10) && wall[k][1] == enemyx[1]) {
					addx = -addx;
					break;
				}
			}
			for(int k = 0; k < 3; k++) {
				if(box[k][0] == ((enemyx[0] + 10 + addx)%10) && box[k][1] == enemyx[1]) {
					addx = -addx;
					break;
				}
			}
			//enemyy va vao wall
			for(int k = 0; k < 5; k++) {
				if(wall[k][1] == ((enemyy[1] + 10 + addy)%10) && wall[k][0] == enemyy[0]) {
					addy = -addy;
					break;
				}
			}
			//enemyy va vao box
			for(int k = 0; k < 3; k++) {
				if(box[k][1] == ((enemyy[1] + 10 + addy)%10) && box[k][0] == enemyy[0]) {
					addy = -addy;
					break;
				}
			}
			enemyx[0] = (enemyx[0] + addx + 10) % 10;
			enemyy[1] = (enemyy[1] + addy + 10) % 10;
			
			boolean win = false;
			for(int h = 0; h < 3; h++) {
				if(gift[h][0] == player[0] && gift[h][1] == player[1]) {
					System.out.println("you win");
					win = true;
					break;
				}
					
			}
			if(win) break;
			if((player[0] == enemyx[0] && player[1] == enemyx[1]) ||
				(player[0] == enemyy[0] && player[1] == enemyy[1]) ||
				(player[0] == enemy[0] && player[1] == enemy[1])) {
				System.out.println("game over");
				break;
			}
				
			
			
				
		}
	}


}
