package Project;
import java.util.ArrayList;
import java.util.Scanner;

public class Functionality {
	ArrayList List = new ArrayList<Occurrence>();
	Scanner scan = new Scanner(System.in);
	boolean validDuration = false;
	boolean firstRun= true;
	
	public void makeFirstOccurrance(String inDuration, String inName)
	{
		int duration = validateDuration(inDuration);
		

		String name = inName;
		
		Occurrence root = new Occurrence(duration, name);	
		
		List.add(root);
		
	}
	
	public void makeOccurrence(String inDuration, String inName, String inDependencies)
	{
		int duration = validateDuration(inDuration);
		
		
		String name = inName;
		
		String[] listOfDependencies = validateDependencies(inDependencies);
		
		Occurrence Node = new Occurrence(duration, name);
		
		Node.setParents(listOfDependencies);
		
		List.add(Node);
		
		
	}
	
	
private int validateDuration(String inDuration)
	{
		int duration = 0;
		
		while(true)
		{
			try
			{
				 duration = Integer.parseInt(inDuration);
				 
				 if(duration > 0)
				 {
					 break;
				 }
			}
			catch(NumberFormatException ex)
			{
				System.out.println("This is not a number");
			}
		}	
		
		
		return 
				duration;



	}

	
	private String[] validateDependencies(String inString)
	{
		boolean isValid = false;
		String[] listOfDependencies = null;
		
		while (isValid != true)
		{

			listOfDependencies = inString.split(",");
			
			for(int i = 0; i < listOfDependencies.length; i++ )
			{
				if(List.contains(listOfDependencies[i]) == true)
				{
					System.out.println(listOfDependencies[i] + "is not a valid entry");
					break;
				}
				isValid = true;
			}
			
		}
		
		return
				listOfDependencies;
		
	}


	public static String getPaths(ArrayList<Occurrence> List)
	{
		String pathsOut = " ";
		
for (int i = List.size() - 1; i >= 0; i--)
{
Occurrence current =  List.get(i);
			
String[] dependencies = current.getParents();

String printOut = current.getName() + "->"+ dependencies.toString();		

int duration = getDurationCount(List, ( List.get(i)).getParents(), (Occurrence) List.get(i));

printOut = printOut +    " " + duration + "\n";

		pathsOut = printOut;
}

		return pathsOut;
	
	}
	
	private static int getDurationCount(ArrayList<Occurrence> bigList, String[] givenList, Occurrence Node){

		int totalDur = Node.duration;
		
		for (int i=0; i < bigList.size(); i++){
			for(int j=0; j<givenList.length; j++){
				if(givenList[j] == bigList.get(i).name){
					totalDur = totalDur + bigList.get(i).duration;
				}
}
		}
		return totalDur;
	}


public static int listOfDurations(ArrayList<Occurrence> List){
	int compiledList = 0;
	for(int i=0; i < List.size(); i++){
		compiledList = ( List.get(i)).getDuration();
}
return compiledList;
}

public static String listOfNames(ArrayList<Occurrence> List){
	String compiledList = " ";
	for(int i=0; i < List.size(); i++){
		compiledList = ( List.get(i)).getName() + compiledList ;
}
return compiledList;
}
}




