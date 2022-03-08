package com.hit.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Rabin_Karp_Algorithm extends AbstractAlgoStringMatching {
	    // d is the number of characters in the input alphabet
	    public final static int d = 256;
	  
	    /* pat -> pattern
	        txt -> text
	        q -> A prime number
	    */
	    public List<Integer> Search(String pat, String txt)
	    {
	    	List<Integer> indexs=new ArrayList<>();
	        int M = pat.length();
	        int N = txt.length();
	        int i, j;
	        int p = 0; // hash value for pattern
	        int t = 0; // hash value for txt
	        int h = 1;
	        int q = 101; //q -> A prime number
	  
	        // The value of h would be "pow(d, M-1)%q"
	        for (i = 0; i < M - 1; i++)
	            h = (h * d) % q;
	  
	        // Calculate the hash value of pattern and first window of text
	        for (i = 0; i < M; i++) {
	            p = (d * p + pat.charAt(i)) % q;
	            t = (d * t + txt.charAt(i)) % q;
	        }
	  
	        // Slide the pattern over text one by one
	        for (i = 0; i <= N - M; i++) {
	  
	            // Check the hash values of current window of text
	            // and pattern. If the hash values match then only check for characters on by one
	            if (p == t) {
	                /* Check for characters one by one */
	                for (j = 0; j < M; j++) {
	                    if (txt.charAt(i + j) != pat.charAt(j))
	                        break;
	                }
	  
	                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	                if (j == M)
//	                    System.out.println("Pattern found at index " + i);
	                	indexs.add(i);
	            }
	  
	            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
	            if (i < N - M) {
	                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
	  
	                // We might get negative value of t, converting it
	                // to positive
	                if (t < 0)
	                    t = (t + q);
	            }
	        }
	        return indexs;
	    }
	    /* Driver program to test above function */
	    /*
	     * 
	    @Test
	    public static void main(String[] args)
	    {
	        String txt = "GEEKS FOR GEEKS";
	        String pat = "GEEK";
	        int q = 101; // A prime number
	        search(pat, txt, q);
	    }
	     */
	    @Test
	    public void RK_Test()
	    {
	    	String pat = "GEEK";
	    	String txt = "GEEKS FOR GEEKS";
	    //	int q = 101; // A prime number
	    	Search(pat, txt);
	    }
	    public List<Integer> RKA(String pat,String txt) {
	    	return Search(pat,txt);
	    }
	}

////////////////////////////algorithm reused from GEEKS FOR GEEKS////////////////////////////////