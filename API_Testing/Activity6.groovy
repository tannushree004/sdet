package groovytest

class Activity6 {

	static void main(args) {
	         def map= [:]
			 
			 map.put(1, "Cats")
			 map.put(2, "Dogs")
			 map.put(3, "wolves")
			 map.put(4, "Horses")
			 map.put(5, "Donkeys")
			 
			 // get values
			for (def item :map ) {
				println item
			}
			// merging with new map
			
			def newmap = map.plus([6: "monkeys",7:"Lion"])
			println newmap
			
			//
			println newmap.values().sort()
            println newmap.values().sort { it.length() }
			
			 
		
	}
}