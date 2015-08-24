/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P      A     H    N
A  P  L  S  I  I  G
Y      I     R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
package Easy;

public class ZigZagConversion6 {

	public static void main(String[] args) {
		String a= null;
		a =convert("uvifijcbhrmzwebwfgunpvlhkldvfzvzwdfhojkyczxydauiioxzlkhvvmqamnakrfrhqefsddq",12);
			
			System.out.println(a);
		
	}
	
	public static  String convert(String s, int nRows) {

        if(nRows <=1)
            return s;

       StringBuilder[] r = new StringBuilder[nRows];
       for( int i=0; i<nRows; i++ )
       {
           r[i] = new StringBuilder();
          
	   }

        int base = nRows+nRows-2;
        char[] toks = s.toCharArray();
        for(int i = 0; i < toks.length; i++)
        {
            int t = i % base;
            if(t < nRows)
            {
                r[t].append(toks[i]);
                System.out.println(r[t]+"  "+toks[i]);
            }
            else
            {
                r[base-t].append(toks[i]);
                System.out.println(r[base-t]+"  "+toks[i]);
            }
    
        }

        for( int i = 1; i<nRows; i++ )
            r[0].append( r[i] );
        return r[0].toString();
    }
}
