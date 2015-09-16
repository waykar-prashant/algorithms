package string.algorithms;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarpAlgorithm {
	private String text;
	private String pattern;
	private long patternHash; //pattern hash value
	private int M; //pattern length
	private long Q; //a large prime number, small enough to avoid long overflows
	private int radix; //radix
	private long RM; //R^(M-1) % Q
	private int N; //text length

	
	

	private void initializePattern(String pattern){
		if(pattern != null && pattern.length() > 0){
			this.pattern = pattern;
			this.radix = 256; //max size of integers 256 and for String a-zA-Z = 52
			this.M = pattern.length();
			this.Q = longRandomPrime();
			this.RM = 1;
			// precompute R^(M-1) % Q for use in removing leading digit (R = radix)
			for(int i = 0; i < (M - 1); i++){
				this.RM = (radix * this.RM) % Q;
			}
			// Calculate the hash value of pattern
			this.patternHash = calculateHash(this.pattern, M);
		}
	}
	
	public RabinKarpAlgorithm(String text, String pattern) {
		long textHash = 0;
		//initialize the pattern
		initializePattern(pattern);
		
		// Calculate the hash value of first window of text
		if(text != null && text.length() > 0){
			textHash = calculateHash(text, M);
			this.N = text.length();

			if(this.N < this.M){
				System.out.println("Not Found");
			}
			// Slide the pattern over text one by one
			// (N-M+1) (N-M => check for the rest of the characters and +1 for the 1st character of the pattern in the text)
			for(int i = 0; i < N - M + 1; i++){

				// Check the hash values of current window of text and pattern
				// If the hash values match then only check for characters on by one
				if(patternHash == textHash){
					if(check(text, i)){
						System.out.println("Pattern found at index : "+ i  +"\n");
					}
				}
				// Calculate hash value for next window of text: Remove leading digit, 
				// add trailing digit
				if ( i < N-M )
				{
					textHash = (radix*(textHash - text.charAt(i) * RM) + text.charAt(i+M)) % Q;
					
					// We might get negative value of t, converting it to positive
					if(textHash < 0) 
						textHash = (textHash + Q); 
				}
			}
		}
	}
	
	/**
     * Returns the index of the first occurrrence of the pattern string
     * in the text string.
     *
     * @param  txt the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; N if no such match
     */
    public int search(String txt){
    	return 0;
    }

	public static void main(String args[]){
		String pattern = "GEEK";
		String text = "GEEKS FOR A GEEKS";
		RabinKarpAlgorithm search = new RabinKarpAlgorithm(text, pattern);
		
	}

    // Las Vegas version: does pat[] match txt[i..i-M+1] ?
    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++) 
            if (pattern.charAt(j) != txt.charAt(i + j)) 
                return false; 
        return true;
    }

    // Compute hash for key[0..M-1]. 
    private long calculateHash(String key, int M) { 
        long hashValue = 0; 
        for (int j = 0; j < M; j++) 
            hashValue = (radix * hashValue + key.charAt(j)) % Q; 
        return hashValue; 
    } 

	
	// a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    

}
