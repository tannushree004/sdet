package groovytest

class Activity2 {
	
	static  void main (def args) {
		def marks =[25,49,50,87,95]
		def sum=0;
		def avg=0;
		def grade="F";
		
		//calculate avg
		marks.each { sum+=it }
		avg=sum/marks.size() as Integer;
		
		//get grade
		switch(avg) {
			case 90..100:
			    grade="A"
				break
			case 80..89:
			    grade="B"
				break
			case 70..79:
			    grade="C"
				break
			case 60..69:
			    grade="D"
				break
			case 50..59:
			    grade="E"
				break
		    case 0..49:
			    grade="F"
				break
			default:
			   println "invalid"
		}
			   //Print results
			   println "Maximum marks: " + marks.max()
			   println "Minimum marks: " + marks.min()
			   println "Average Grade: " + avg
			   println "Grade: " + grade
		
		
	}
}