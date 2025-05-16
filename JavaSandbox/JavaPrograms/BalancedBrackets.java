//Checking when the brackats are balanced or not
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;
class Solution{
	public static void main(String args[]) {
		Scanner  scan = new Scanner(System.in);
		System.out.println("Enter a valid bracket string");
		String userInput = scan.nextLine();
		
		Solution sol= new Solution();
		System.out.println(sol.isBalanced(userInput));
		scan.close();
	}
	public boolean isBalanced(String s) {
		HashMap<Character,Character> BracketMap= new HashMap<>();
		BracketMap.put(')','(');
		BracketMap.put(']','[');
		BracketMap.put('}','{');
		
		Stack<Character> trackClose = new Stack<>();
		
		for(int i=0; i< s.length(); i++) {
			char currentChar = s.charAt(i);
			
			if 	(BracketMap.containsValue(currentChar)) {
				trackClose.push(currentChar);
			}
			else if(BracketMap.containsKey(currentChar)){
				if(trackClose.isEmpty() || trackClose.pop() != currentChar) {
					return false;
				}
			}
			
		}
		return trackClose.isEmpty();	
	}
}