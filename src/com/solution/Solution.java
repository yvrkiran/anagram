package com.solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		returnChars("rather", "weather");

	}
	               
	static int returnChars(String S, String T) {	                
		char[] sOneArray = S.toCharArray();
		char[] sTwoArray = T.toCharArray();	      
		Map<Character, Integer> sOneMap = new HashMap<>();
		Map<Character, Integer> sTwoMap = new HashMap<>();
		for(char eachS1Char : sOneArray) {
			int s1CharCount = 0;
			for(char eachS2Char : sTwoArray) {
				if(eachS1Char == eachS2Char) {
					s1CharCount++;
				}
			}
			if(sOneMap.get(eachS1Char) == null) {
				sOneMap.put(eachS1Char, s1CharCount);
			}
		}
		for(char eachS2Char : sTwoArray) {
			int s2CharCount = 0;
			for(char eachS1Char : sOneArray) {
				if(eachS1Char == eachS2Char) {
					s2CharCount++;
				}
			}
			if(sOneMap.get(s2CharCount) == null) {
				sTwoMap.put(eachS2Char, s2CharCount);
			}
		}
		int s1Count = 0;
		Set<Entry<Character, Integer>> entrySetOne = sOneMap.entrySet();
		Iterator<Entry<Character, Integer>> itr = entrySetOne.iterator();
		while(itr.hasNext()) {
			Entry<Character, Integer> eachEntry = itr.next();
			if(eachEntry.getValue() == 0) {
				s1Count++;
			} else {
				Integer s2MatchingCount = sTwoMap.get(eachEntry.getKey());
				if(!(s2MatchingCount == eachEntry.getValue())) {
					if(s2MatchingCount > eachEntry.getValue()) {
						s1Count = s1Count + (s2MatchingCount - eachEntry.getValue());
					} else {
						s1Count =s1Count +(  eachEntry.getValue() - s2MatchingCount);
					}
				}
			}
		}

		int s2Count = 0;
		Set<Entry<Character, Integer>> entrySetTwo = sTwoMap.entrySet();
		Iterator<Entry<Character, Integer>> itr2 = entrySetTwo.iterator();
		while(itr2.hasNext()) {
			Entry<Character, Integer> eachEntry = itr2.next();
			if(eachEntry.getValue() == 0) {
				s2Count++;
			}
		}
		System.out.println("Character to be added = "+ (s1Count + s2Count));
		return s1Count + s2Count;
	}

}