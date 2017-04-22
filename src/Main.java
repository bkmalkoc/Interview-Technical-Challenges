import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws java.lang.Exception
	{
//		System.out.println(Elementary1());
//		System.out.println(Elementary2());
//		System.out.println(Elementary3());
//		System.out.println(Elementary4());
		
//		String[] wordsArr = {"Apple", "Melon", "Orange", "Watermelon"};
//		String[] partsArr = {"a", "mel", "lon", "el", "An"};
		
//		String[] wordsArr = {"neuroses" ,"myopic" ,"sufficient" ,"televise" ,"coccidiosis" ,"gules" ,"during", "construe", "establish", "ethyl"};
//		String[] partsArr = {"aaaaa" ,"Aaaa" ,"E" ,"z" ,"Zzzzz" ,"a" ,"mel" ,"lon" ,"el" ,"An" ,"ise" ,"d", "g" ,"wnoVV" ,"i" ,"IUMc" ,"P" ,"KQ" ,"QfRz" ,"Xyj" ,"yiHS"};
		
		String[] wordsArr = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
				 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaac"};
		String[] partsArr = {"aaaaa", 
				 "bbbbb", 
				 "a", 
				 "aa", 
				 "aaaa", 
				 "AAAAA", 
				 "aaa", 
				 "aba", 
				 "aaaab", 
				 "c", 
				 "bbbb", 
				 "d", 
				 "g", 
				 "ccccc", 
				 "B", 
				 "C", 
				 "P", 
				 "D"};
		
		String[] strArr = findSubstrings(wordsArr, partsArr);
	}
	
	public static String Elementary1(){
		return "Hello World";
	}
	
	public static String Elementary2(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		return "Hello " + input;
	}
	
	public static String Elementary3(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		input.toLowerCase();
		if(input.equals("alice") || input.equals("bob")){
			return "Hello " +  input;
		}
		return null;
	}
	
	public static int Elementary4(){
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int sumOfNumbers = 0;
		
		for(int i = 1; i <= number; i++){
			sumOfNumbers = sumOfNumbers + 1;
		}
		return sumOfNumbers;
	}
	
	public static void Elementary5(){
		
	}
	
	//You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:
	//If several parts substrings occur in one string in words, choose the longest one. If there is still more than one such part, then choose the one that appears first in the string.
	//Example For words = ["Apple", "Melon", "Orange", "Watermelon"] and parts = ["a", "mel", "lon", "el", "An"], the output should be
	//findSubstrings(words, parts) = ["Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"]
	
	public static String[] findSubstrings(String[] words, String[] parts) {

//	    HashMap<String, String> hashMap = new HashMap<String, String>();
	    Hashtable<String, String> hashMap = new Hashtable<String, String>();
//	    Map<String, String> hashMap = new LinkedHashMap<String, String>();
	    
	    String[] resultArray = new String[words.length];
	    for(int i = 0; i < words.length; i++){
	    	hashMap.put(words[i], "");
	        for(String part : parts){
	            if(words[i].contains(part)){
	                if(hashMap.containsKey(words[i])){
	                	if(part.length() > hashMap.get(words[i]).length()){
	                		hashMap.replace(words[i], part);
	                		resultArray[i] = hashMap.get(i);
	                	}
	                }
	                else{
	                	hashMap.put(words[i], part);
                		resultArray[i] = hashMap.get(i);
	                }
	            }
	        }
	    }
	    int a = 0;
	    for(String str : hashMap.keySet()){
	    	resultArray[a] = str;
	    	if(resultArray[a].contains(hashMap.get(str))){
	    		if(hashMap.get(str) != ""){
		    		int index = resultArray[a].indexOf(hashMap.get(str));
		    		String newString = resultArray[a].substring(0, index) + "[" + hashMap.get(str) + "]" + resultArray[a].substring(index + hashMap.get(str).length());
		    		resultArray[a] = newString;
		    		System.out.println(newString);
	    		}
	    	}
	    	a++;
	    }
	    return resultArray;
	}

}
