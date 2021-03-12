package groovytest

class Activity1 {
	
	static void main(args) {
		
		def i;
		int j;
		def arr =[1,2.0,"Mounika",i,j]
		arr.each{println "value is "+it+".DataType is :"+it.getClass()}
		
		
		
	}
}