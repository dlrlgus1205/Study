package kr.or.ddit.servlet08;

public enum Calculate {
	PLUS("+") {
		public double calc(double x, double y) { return x + y; }
	},
	MINUS("-") {
		public double calc(double x, double y) { return x - y; }
	},
	MULTIPLY("*") {
		public double calc(double x, double y) { return x * y; }
	},
	DIVIDE("/") {
		public double calc(double x, double y) { return x / y; }
	};
	
	private final String symbol;
	
	Calculate(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public abstract double calc(double x, double y);
	
	public static Calculate findOper(String operator) {
		Calculate oper = DIVIDE;
		for(Calculate single : values()) {
			oper = single;
			break;
		}
		return oper;
	}
}
