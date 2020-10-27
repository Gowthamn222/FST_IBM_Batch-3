package SDET

class Activity_Exercise7 
{

	static void main(args)
	{
		File file = new File("C://SDET//Activity_Exercise7.txt")
		file.createNewFile()
		file.write("A quick brown Fox jumped over the lazy Cow\n")
			file.append("John Jimbo jingeled happily ever after\n")
				file.append("Th1\$ 1\$ v3ry c0nfu51ng")
				file.eachLine
				{
					line-> if (line ==~ /.*Cow$/)
					{ println "Line with cow is: $line"}
				}
				file.eachLine
				{
					line-> if (line ==~ /^J.*/)
					{ println "Line starting with J is: $line"}
				}
				
				file.eachLine
				{
					line-> if (line ==~ /.*\d\d.*/)
					{ println "Line with 2 consecutive numbers is: $line"}
				}
				
			def match1 = file.getText() =~ /\S+er/
			 println "Match 1 for '/\\S+er/' is : ${match1.findAll()}"
				
			 def match2 = file.getText() =~ /\S*\d\W/
			 println "Match 2 for '/\\S*\\d\\W/' is : ${match2.findAll()}"
			
		}
		
	}
	
