/*
Team DrDolla - Yikai Wang, Richard Wang
APCS1 Pd9
HW33 -- Do You Even Add, Bro?
2015-11-18
 */

public class Rational{
    private int numerator;
    private int denominator;
    
    public Rational() { //default constructor
	numerator = 0;
	denominator = 1;
    }
    
    public Rational( int num, int dem ) { //custom
	if (dem == 0) {
	    numerator = 0;
	    denominator = 1;
	    System.out.println("Cannot divide by 0");
	}
	else {
	    numerator = num;
	    denominator = dem;
	}
    }

    public String toString() { //gives fraction and decimal forms
	String s1 = "Fraction : "+numerator +"/"+denominator;
	String s2 = "Decimal : "+ (numerator * 1.0 / denominator);
	return s1 +"\n"+ s2;
    }

    public double floatValue() { //returns "decimal" value
	return numerator * 1.0 / denominator;
    }

    //methods for multiplying, dividing, adding, and subtracting
    public void multiply (Rational r) { //multiplying fractions
	numerator *= r.numerator;
	denominator *= r.denominator;
    }

    public void divide (Rational r) { //dividing fractions
	if( r.numerator != 0 ) {
	numerator *= r.denominator;
	denominator *= r.numerator;
	}
    }

    public void add (Rational r) { //adding fractions
	numerator = numerator * r.denominator + r.numerator * denominator;
	denominator = denominator * r.denominator;
    }

    public void subtract (Rational r) { //subtracting fractions
	numerator = numerator * r.denominator - r.numerator * denominator;
	denominator = denominator * r.denominator;
    }

    public int gcd() {
	int r; //remainder
	int mx = Math.max( Math.abs(numerator), Math.abs(denominator) ); //max value
	int mn = Math.min( Math.abs(numerator), Math.abs(denominator) ); //min value
	//uses abs since the input is negatice, but negative numbers still have the same gcd as their positive counterparts
		
	while(mn!=0)
	{
	    r = mx % mn; //gets remainder ex: 30%12 = 6
	    mx = mn;//max becomes min ex: 12
	    mn = r; //min becomes remainder ex: 6
	}
		return mx; //returns gcd
    }

    //~~~~~~STATIC VERSION OF GCD~~~~~~~~~
    public static int gcd( int n, int d ){
    int r; //remainder
	int mx = Math.max( Math.abs(n), Math.abs(d) ); //max value
	int mn = Math.min( Math.abs(n), Math.abs(d) ); //min value
	//uses abs since the input is negatice, but negative numbers still have the same gcd as their positive counterparts
		
	while(mn!=0)
	{
	    r = mx % mn; //gets remainder ex: 30%12 = 6
	    mx = mn;//max becomes min ex: 12
	    mn = r; //min becomes remainder ex: 6
	}
		return mx; //returns gcd
    }
    //~~~~~~END GCD (STATIC)~~~~~~~~

    public void reduce() {
	int gcd = gcd(); //get greatest common factor
	denominator /= gcd; //simplifies fraction
	numerator /= gcd;
    }

    public int compareTo( Rational r ) {
    	double val = floatValue();
    	double vlr = r.floatValue();
    	if( val == vlr ) { //if the calling object is equal
    		return 0;
    	}

    	else if( val > vlr ){//if calling object is bigger
    		return 1;
    	}

    	return -1; //smaller
    }
    
    public static void main(String[] args){
	Rational r1 = new Rational(1,5); //rational number 1/5
	Rational r2 = new Rational(1,2); //rational number 1/2
	
	r1.multiply(r2); //Multiplies r1 by r2, changes r1 to 1/10 (0.1)
	System.out.println( r1 );
	System.out.println( r1.denominator ); //10
	System.out.println( r1.numerator ); //1
	
	System.out.println();
	r2.divide(r1); //Divides r2 by r1, changes r2 to 5/1 (5.0)
	System.out.println( r2 );
	System.out.println( r2.denominator );//2
	System.out.println(r2.numerator);//10

	System.out.println();
	System.out.println(r2.gcd()); //2

	System.out.println();
	r2.reduce();
	System.out.println( r2.denominator ); //1
	System.out.println(r2.numerator);//5

	System.out.println();
	System.out.println( r1.compareTo( r2 ) );//-1
	System.out.println( r2.compareTo( r1 ) );//1

	System.out.println();
	System.out.println( gcd( 32, 12 ));//4

	System.out.println();
	r1.add( r2 );
	System.out.println( r1 ); //5.1

	System.out.println();
	r2.subtract( r1 );
	System.out.println( r2 ); //-0.1

	System.out.println();
	System.out.println( r1.compareTo( r2 ) );//1
	System.out.println( r2.compareTo( r1 ) );//-1

	Rational r3 = new Rational( 3, 4 );
	Rational r4 = new Rational( 4, 5 );

	System.out.println();
	System.out.println( r3.compareTo( r4 ) );//-1
	System.out.println( r4.compareTo( r3 ) );//1		
    }
}
