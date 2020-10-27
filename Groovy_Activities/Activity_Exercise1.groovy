package SDET

class Activity_Exercise1 {
	static void main(args) {
	def x
	int y
	
	def arr = [1,2.0,"Rahil",true,x,y]
	
	arr.each {println "Value $it has datatype:"+it.getClass()}
	}
}
