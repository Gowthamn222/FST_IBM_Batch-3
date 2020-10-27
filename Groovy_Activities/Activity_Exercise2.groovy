package SDET

class Activity_Exercise2 {

	static void main(args) {
		// TODO Auto-generated method stub
		def marks =[40,60,70,75,85]
		def sum =0
		int avg =0
		
		marks.each{sum+=it}
		avg = sum/marks.size()
		
		println(marks.max())
		println(marks.min())
		println(avg)
		
		switch(avg)
		{
		case 90..100:
			println "Grade: A"
			break
		case 80..89:
			println "Grade: B"
			break
		case 70..79:
			println "Grade: C"
			break
		case 50..69:
			println "Grade: D"
			break
		case 1..50:
			println "Grade: E"
			break
		default:
			println "Grade: Invalid"
		}
		
	}
}
