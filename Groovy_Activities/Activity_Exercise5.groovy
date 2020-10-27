package SDET

class Activity_Exercise5 {

	static void main(args) {
		
 def list = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
 def strlist =[],intlist = []
 String type
 list.each{
	 type = it.getClass()
	 if(type.matches("(.*)Integer(.*)"))
		 {intlist.add(it)}
     else
		 {strlist.add(it)}
 }
 
 
 
 println "Sorted int list is ${intlist.sort()}"
 println "Sorted String list is ${strlist.sort()}"
		
	}
}
