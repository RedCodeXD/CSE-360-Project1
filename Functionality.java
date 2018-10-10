import java.util.ArrayList;
import java.util.Scanner;

public class Functionality {
	static ArrayList<Occurrence> List = new ArrayList<Occurrence>();
	Scanner scan = new Scanner(System.in);
	boolean validDuration = false;
	boolean firstRun= true;
	
	public void makeFirstOccurrance(int inDuration, String inName)
	{
		int duration = validateDuration(inDuration);

		String name = inName;
		
		Occurrence root = new Occurrence(duration, name);	
		
		List.add(root);
		
	}
	
	public static void makeOccurrence(String inName, int inDuration, String[] inDependencies)
	{
		int duration = validateDuration(inDuration);
		
		String name = inName;
		
		String[] listOfDependencies = validateDependencies(inDependencies);
		
		Occurrence Node = new Occurrence(duration, name);
		
		Node.setParents(listOfDependencies);
		
		List.add(Node);
		
		
	}
	
	
	private static int validateDuration(int inDuration) {	
		while(true)
		{
			try
			{
				 
				 if(inDuration > 0)
				 {
					 break;
				 }
			}
			catch(NumberFormatException ex)
			{
				System.out.println("This is not a number");
			}
		}	
		return inDuration;
	}

	
	private static String[] validateDependencies(String[] listOfDependencies)
	{

		for(int i = 0; i < listOfDependencies.length; i++ )
			{
				if(List.contains(listOfDependencies[i]) == true)
				{
					System.out.println(listOfDependencies[i] + "is not a valid entry");
					break;
				}
			}
		
		
		return listOfDependencies;
		
	}


	public static String getPaths(ArrayList<Occurrence> List)
	{
		String pathsOut = " ";
		
		for (int i = List.size() - 1; i >= 0; i--) {
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

	public static ArrayList<Occurrence> getArrayList() {
		return List;
	}
}




