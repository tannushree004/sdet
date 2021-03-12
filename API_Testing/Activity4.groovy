package groovytest

class Activity4 {

	static void main(args) {
		def str="This is a Groovy Language"
		
		//reverse string
		def revstr = str.reverse()
		println "reversed string is : " +revstr
		
		//substring
		def substr= str.substring(10)
		println "SubString is : " +substr
		
		//split str
		def splitstr = str.split(" ")
		println "split string: " +splitstr
		
		//remove str
		def remstr =str.minus("Groovy")
		println "New string is:  "+ remstr
		
		//uppercase
		def uprcase =str.toUpperCase()
		println "Uppercase string: " +uprcase
		
		//lowercase
		def lwrcase =str.toLowerCase()
		println "Uppercase string: " +lwrcase
		
		//REGEX OPERATIONS
		//matches()
		def matchStatus = str.matches("(.*)Groovy(.*)")
		if(matchStatus) { println "String matches" }
		
		//replaceAll()
		def replaceWith = "very Groovy"
		println(str.replaceAll("Groovy", replaceWith))
		//Notice that the original string is not changed
		println str
		
	}
}