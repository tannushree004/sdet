package groovytest

class Activity3 {

	static void main(args) {
		
			//Variable declarations
			def a = 0, b= 1, n = 10;
			//Print first number
			print a
			n.times {
				//Assign next value to a
				(a,b) = [b,a+b]
	 
				//print a
				print "," + a
			}
		}
		
	}
