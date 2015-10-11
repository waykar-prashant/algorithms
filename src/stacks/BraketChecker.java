package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BraketChecker {
	
	private static String inputString;
	
	public static void main(String args[]){
		//Read
		readInputExpression();
		//check
		boolean isValid = checkExpression();
		System.out.println("Is A Valid Expression : " + isValid);
	}

	private static boolean checkExpression() {
		Stack<Character> stack = new Stack<>();
		if(inputString != null && inputString.length() > 0){
			for(int i = 0; i < inputString.length(); i++){
				Character ch = inputString.charAt(i);
				switch(ch){
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
				case ']':
				case ')':
						if(!stack.isEmpty()){
							char poppedCharacter = (Character)stack.pop();
							if((ch == '}' && poppedCharacter != '{') ||
									(ch == ']' && poppedCharacter != '[') || 
										(ch == ')' && poppedCharacter != '(')){
								//error
								return false;

							}else{
								//continue
							}
						}
					break;
				}
			}
			if(stack.isEmpty()){
				return true;
			}
		}
		return false;
	}

	private static void readInputExpression() {
		System.out.println("Enter the expression : ");
		Scanner in = new Scanner(System.in);
		inputString = in.nextLine();
	}
}
