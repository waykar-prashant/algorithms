package stacks;

import java.util.Stack;

import javax.swing.plaf.OptionPaneUI;

public class StackUtil {

	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		int choice = 9;
		switch (choice) {
		
		case 1: // Reverse stack using recursion
			ReverseStackRecursion r = new ReverseStackRecursion();
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			
			System.out.println("Default Stack: " + stack.toString());
			Stack<Integer> s = r.reverseStack(stack);
			System.out.println("After Reversing Stack : " + stack.toString());
			break;
		case 2: 
			String postfixExpression = "2 3 1 * + 9 -";
			EvaluatePostfixExpression eval = new EvaluatePostfixExpression();
			int result = eval.evaluatePostfix(postfixExpression);
			System.out.println("Postfix Evaluation of postfix expression: " + result);
			break;
			
		case 3:
			try {
				TwoStacksInArray ts = new TwoStacksInArray(5);
				ts.push1(5);
				ts.push2(10);
				ts.push2(15);
				ts.push1(11);
				ts.push2(7);
				System.out.println("Popped element from" + " stack1 is " + ts.pop1());
				ts.push2(40);
				System.out.println("Popped element from" + " stack2 is " + ts.pop2());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			ReverseStringUsingStack rs = new ReverseStringUsingStack();
			String reversedString = rs.reverseString("PRASHANT");
			System.out.println("After reversing the string : " + reversedString);
			break;
			
		case 5:
			BalancedParentheses bp = new BalancedParentheses();
			String exp = "{()}[]";
			boolean isBalanced = bp.areParenthesesBalanced(exp);
			if(isBalanced)
				System.out.println("Balanced Parentheses : " + exp);
			else 
				System.out.println("Not Balanced Parentheses : " + exp);
			break;
		case 6:
			NextGreaterElement nge = new NextGreaterElement();
			int arr[] = {4, 5, 2, 25};
			nge.printNextGreaterElement(arr);
			System.out.println("\nNGE using stack\n");
			nge.printNGEUsingStack(arr);
			break;
		case 7:
			StockSpanProblem ss = new StockSpanProblem();
			int arr1[] = {10, 4, 5, 90, 120, 80};
			ss.calculateStockSpan(arr1);
			ss.calculateStockSpanUsingStack(arr1);
			break;
		case 8:
			StackUsingQueue sq = new StackUsingQueue();
			try {
				sq.push(1);
				sq.printStack();
				sq.push(2);
				sq.printStack();
				sq.push(3);
				sq.printStack();
				sq.pop();
				sq.printStack();
				sq.push(4);
				sq.printStack();
				sq.pop();
				sq.printStack();
				sq.pop();
				sq.pop();
				sq.printStack();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case 9:
			TowerOfHahoi th = new TowerOfHahoi();
			th.moveDisksUsingRecursion(3, "A", "C", "B");
			break;
			
		default:
			break;
		}
		/*String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
		//op = abcd^e-fgh*+^*+i-
		InfixToPostfixConversion infixToPostfix = new InfixToPostfixConversion();
		String outputPostfixExpression = infixToPostfix.infixToPostfix(infixExpression);
		System.out.println(outputPostfixExpression);*/
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
	
	public static boolean isNumericDigit(char item) {
		if(item >= '0' && item <= '9') {
			return true;
		} else 
			return false;
	}

	public static int performOperation(char operator, int operand1, int operand2) throws Exception {
		if(operator == '+')
			return operand1 + operand2;
		else if(operator == '-')
			return operand1 - operand2;
		else if(operator == '*')
			return operand1 * operand2;
		else if(operator == '/')
			return operand1 / operand2;
		else {
			throw new Exception("Cannot perform operation");
		}
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
