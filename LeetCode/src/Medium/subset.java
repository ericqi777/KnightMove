package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {
	public static void main(String[] args){
		int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
		List a = spiralOrder(num);
		for(int i =0; i<a.size();i++){
			System.out.print(a.get(i));
		}
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0){
            return list;
        }
        
        int half = Math.min(matrix.length,matrix[0].length);
        for(int i = 0; i<= half/2;i++){
            int j=i;
            int root = i;
            boolean ver = false;
            boolean hor = false;
            list.add(matrix[i][j]);
            while(j+1<matrix[0].length){
                j++;
                list.add(matrix[i][j]);
                hor = true;
            }
            while(i+1<matrix.length){
                i++;
                list.add(matrix[i][j]);
                ver = true;
            }
            while(ver&&j-1>=root){
                j--;
                list.add(matrix[i][j]);
            }
            while(hor&&ver&&i-1>root){
                i--;
                list.add(matrix[i][j]);
            }
        }
        return list;
    }
}
