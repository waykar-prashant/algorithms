package com.prashant.effectivejava.items;

public class Item22 {
	private static enum Color {
		RED(1), BLACK(2), WHITE(3);
		
		private int value;
			
		private Color(int val) {
			this.value = val;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	
	
	
	/*private static enum Operation {
		PLUS("+") {

			@Override
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {

			@Override
			double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {

			@Override
			double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {

			@Override
			double apply(double x, double y) {
				return x / y;
			}
		};

		private final String symbol;

		Operation(String symbol) {
			this.symbol = symbol;
		}

		abstract double apply(double x, double y);
	}*/

	public static void main(String args[]) {
		//Operation op = Item22.Operation.MINUS;
		//System.out.println(op.apply(1, 1));
		//System.out.println(op.symbol);
		Color c = Item22.Color.WHITE;
		System.out.println(c.getValue());
	}
}
