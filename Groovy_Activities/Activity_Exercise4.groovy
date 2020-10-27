package SDET

class Activity_Exercise4 {

	static void main(args) {
		
		def line = "This is a Groovy Language"
		println "Oriinal String $line"
		def Reverse = line.reverse()
		println "Reverse is $Reverse";
		def Substring = line.substring(10,25)
		println "SubString is: $Substring" 
		def split = line.split(" ")
		println "Slip: $split" 
		def Minus = line - "Groovy"
		println "Minus:$Minus"
		def Lower = line.toLowerCase()
		println "Lower case: $Lower"
		def Upper = line.toUpperCase()
		println "Upper case: $Upper"
		
	}
}
