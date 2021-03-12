package groovytest

class Activity5 {

	static void main(args) {
		def List =[11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		
		def strlist= List.minus([11,2,19,5])
		def intlist = List.minus(["Mango", "Apple", "Watermelon"])
		
		//print lists
		println "Actual list is : ${List} " 
		println "Sorted String list: ${strlist.sort()}"
		println "Sorted integer list: ${intlist.sort()}"
		
	}
}