package CircleUp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class KnightMove {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[][] scanMatrix() throws IOException{
		Scanner scan = null;
		int column = 0;
		int row = 0;
		String str = "";
		boolean first = true;
		try{
			scan = new Scanner(new File("g:\\matrix.txt"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		while(scan.hasNextLine()){
			str = str+scan.nextLine();
			if(first==true){
				column = str.length();
				first = false;
			}
			row++;
		}
		String[][] matrix = new String[row][column];
		
		for(int i = 0; i<row; i++){
			for(int j = 0; j<column; j++){
				matrix[i][j] = str.substring(i*column+j, i*column+j+1);
			}
		}
		return matrix;
	}
	
	public int[] findLength() throws IOException{
		int[] length = new int[2];
		int longest = 0;
		int shortest = 50;
		String str = null;
		Scanner scan = null;
		try{
			scan = new Scanner(new File("g:\\list.txt"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		while(scan.hasNextLine()){
			str = scan.nextLine();
			if(str.length()>=longest){
				longest = str.length();
			}
			if(str.length()<=shortest){
				shortest = str.length();
			}
		}
		length[0] = shortest;
		length[1] = longest;
		return length;
	}

	
	public HashMap<String, Integer> scanList() throws IOException{
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		Scanner scan = null;
		String str = null;

		try{
			scan = new Scanner(new File("e:\\list.txt"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(scan.hasNextLine()){
			str = scan.nextLine();
			map.put(str, str.length());
		}
		return map;
	}
	
	public int matching(
			HashMap<String, Integer> map, String[][] matrix, int maxLength){
	
		int row = matrix.length;
		int column = matrix.length;
		int count = 0;
		
		for(int i = 0; i<row; i++){
			for(int j = 0; j<column; j++){
				count+=generateWords(map, matrix, matrix[i][j], i, j, 1, maxLength, 0, count);
			}
		}

		System.out.println(count);
		return count;		
	}
	
	public int generateWords (HashMap<String, Integer> map, String[][] matrix, String str, int currX, int currY, int step, int maxLength, 
			int next, int count){
		int[][] move = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{2,1},{1,2}};
		int row = matrix.length;
		int column = matrix[0].length;
		while(step<=maxLength){
			next = 0;
			while(next<move.length){
				boolean x = currX+move[next][0]<0 || currX+move[next][0]>=column;
				boolean y = currY+move[next][1]<0 || currX+move[next][1]>=row;
				while(x || y){
					next++;
					x = currX+move[next][0]<0 || currX+move[next][0]>=column;
					y = currY+move[next][1]<0 || currY+move[next][1]>=row;
				}
				currX += move[next][0];
				currY += move[next][1];
				str += matrix[currY][currX];
				if(map.containsKey(str)){
					count++;
				}
				if(step<maxLength){
					generateWords(map, matrix, str, currX, currY, step+1, maxLength, next, count);
				}
				str = str.substring(0, str.length()-1);
			}
		}
		return count;
	}
	
	public String findFirst(String pre, String curr){
		String first = null;
		int rst = 0;
		int index = 0;
		while(rst==0&&index<pre.length()){
			rst = pre.charAt(index)-curr.charAt(index);
			if(rst!=0){
				if(rst>0)
					first = curr;
				else
					first = pre;
			}
		}
		return first;
	}
	
	public String findLast(String pre, String curr){
		String last = null;
		int rst = 0;
		int index = 0;
		while(rst==0&&index<pre.length()){
			rst = pre.charAt(index)-curr.charAt(index);
			if(rst!=0){
				if(rst>0)
					last = pre;
				else
					last = curr;
			}
		}
		return last;
	}
}
