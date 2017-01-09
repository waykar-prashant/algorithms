package stacks;

import java.util.Stack;

import javax.swing.plaf.OptionPaneUI;

public class StackUtil {

	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
		//op = abcd^e-fgh*+^*+i-
		InfixToPostfixConversion infixToPostfix = new InfixToPostfixConversion();
		String outputPostfixExpression = infixToPostfix.infixToPostfix(infixExpression);
		System.out.println(outputPostfixExpression);
	}
	
	// Function to verify whether a character is english letter or numeric digit.
	// [a-z][A-Z][0-9]
	public static boolean isOperand(char item) {
		if(item >= '0' && item <= '9') return true;
		if(item >= 'a' && item <= 'z') return true;
		if(item >= 'A' && item <= 'Z') return true;
		return false;
	}
	
	// Function to verify whether a character is operator symbol or not. 
	public static boolean isOperator(char item) {
		if(item == '+' || item == '-' || item == '*' || item == '/' || item == '$' || item == '^'){
			return true;
		}
		return false;
	}
	
	private static int getOperatorWeight(char item) {
		int weight = -1;
		switch(item){
		case '+':
		case '-':
			weight = 1;
			break;
		case '*':
		case '/':
			weight = 2;
			break;
		case '^':
			weight = 3;	
			break;
		case '$':
			weight = 4;
			break;
		}
		return weight;
	}
	
	private static boolean isRightAssociative(char op) {
		if (op == '$') {
			return true;
		} else
			return false;
	}
	
	public static boolean hasHigherPrecedence(char op1, char op2) {
		int weight1 = getOperatorWeight(op1);
		int weight2 = getOperatorWeight(op2);
		// If operators have equal precedence, return true if they are left
		// associative.
		// return false, if right associative.
		// if operator is left-associative, left one should be given priority.
		if (weight1 == weight2) {
			if(isRightAssociative(op1))
				return false;
			else
				return true;
		} else
			return weight1 > weight2 ? true : false;
	}
  	
	public static Stack<Integer> getDefaultStack(){
		stack.push(60);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		//
		return stack;
	}

}
