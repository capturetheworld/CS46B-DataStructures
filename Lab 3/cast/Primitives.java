package cast;

public class Primitives {

	public static void dumpMaxValues() {
		System.out.println("Byte: " + Byte.MAX_VALUE);
		System.out.println("Short: " + Short.MAX_VALUE);
		System.out.println("Long: " + Long.MAX_VALUE);
		System.out.println("Int: " + Integer.MAX_VALUE);
		System.out.println("Double: " + Double.MAX_VALUE);
		System.out.println("Float: " + Float.MAX_VALUE);
	}
	
	public static void main(String [] args) {
		dumpMaxValues();
		
		//long to int
		long l = Long.MAX_VALUE;
		int i = (int)l;
		System.out.println("\n long to int: "+ l+ ", "+ i);
		
		//long to int -5
		long l2 = Long.MAX_VALUE;
		int i2 = (int)(l2-5);
		System.out.println("long to int -5: "+ l2+ ", "+ i2);
		
		//int to long
		int i3 = Integer.MAX_VALUE;
		long l3 = i3;
		System.out.println("int to long: "+ i3+ ", "+ l3);
		
		//byte to double, approx the same
		byte b4 = 100;
		double d4 = b4;
		System.out.println("byte to double: "+ b4+ ", "+ d4);
		
		//double to byte
		double d5 = 45.67;
		byte b5 = (byte)d5;
		System.out.println("double to byte: "+ d5+ ", "+ b5);
		
		//double to byte more numbers
		double d6 = 456.789;
		byte b6 = (byte)d6;
		System.out.println("double to byt more numbers: "+ d6+ ", "+ b6);
		
		//float to long
		float f7 = 12345.6789f;
		long l7 = (long)f7;
		System.out.println("float to long: "+ f7+ ", "+ l7);
		
		//float to long MAX
		float f8 = Float.MAX_VALUE;
		long l8 = (long)f8;
		System.out.println("float to long MAX: "+ f8+ ", "+ l8);
		
		//long to float
		long l9 = Long.MAX_VALUE;
		float f9 = l9;
		System.out.println("long to float: "+ l9+ ", "+ f9);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
