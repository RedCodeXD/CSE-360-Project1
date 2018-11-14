package Project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Functionality {
	static ArrayList<Occurrence> List = new ArrayList<Occurrence>();
	static ArrayList<pathNode> pathList = new ArrayList<pathNode>();
	static ArrayList<Integer> durationList = new ArrayList<Integer>();
	static String compareList ="";
	Scanner scan = new Scanner(System.in);
	boolean validDuration = false;
	static boolean validDependencies= true;
	

		
	public static void makeOccurrence(String inName, int inDuration, String[] inDependencies)
	{
		
		String name = inName;
		
		Occurrence Node = new Occurrence(inDuration, name);
		if(inDependencies[0].equals("")) {
			inDependencies = null; 
		}
		
		Node.setParents(inDependencies);
		
		List.add(Node);
		
		
	}
	
	public static void makeCompareList(ArrayList<Occurrence> List)
	{	
		for (int i = 0; i < List.size(); i++)
		{
			if(List.get(i).parents == null) {
				
			}
			else {
				for(int j = 0; j < List.get(i).parents.length; j++)
				{	
					if(List.get(i).parents.equals(null)) {
						
					}
					else {
					compareList = compareList + List.get(i).parents[j];
					}
				}
			}
		}
	}

	
	public static void getPathsPartOne(ArrayList<Occurrence> List, Occurrence Node, String compiledPath) {
		try {
		if(Node == null) {
			String[] compareListArray = compareList.split("");
			for(int i=0; i < List.size(); i++) {
				boolean wasFound = false;
				for(int j=0; j < compareListArray.length; j++) {
					if(compareListArray[j].equals(List.get(i).name)) {

						wasFound = true;
						break;
					}
				}
				if(wasFound == false) {
					Node = List.get(i);	
				}	
			}
		}
		
		if(Node != null) {
		
		compiledPath = Node.getName()+ "-" + compiledPath;
		
		
		
		if(Node.getParents() == null)
		{
			pathNode node = new pathNode(compiledPath, 0);
			pathList.add(node);
		}
		else
		{
			for(int i = 0; i < Node.parents.length; i++)
			{
				boolean wasFound = false;
				
				for(int j = 0; j < List.size(); j++)
				{
					if(Node.parents[i].equals(List.get(j).name)) {
						wasFound = true;
						getPathsPartOne(List, List.get(j), compiledPath);
					}
				}
				if(wasFound != true)
				{
					validDependencies = false;
				}
			}
		}
	}
	}
		catch(StackOverflowError e) {
			System.out.println("Cycle");
		}
	}
	
	public static void getDurations(ArrayList<Occurrence> List, ArrayList<pathNode> pathList) {
		for(int i =0; i < pathList.size(); i++) {
			int durationCount =0;
			String[] durationCompare = pathList.get(i).path.split("-");
			for(int j=0; j< durationCompare.length;j++) {
				for(int k=0; k<List.size(); k++) {
					if(durationCompare[j].equals(List.get(k).name)) {
						durationCount = durationCount + List.get(k).duration;
					}
				}
			}
			durationList.add(durationCount);
		}
		
		for(int i=0; i < pathList.size(); i++) {
			pathList.get(i).setDuration(durationList.get(i));
		}

		Collections.sort(pathList, new Comparator<pathNode>() {
		       @Override public int compare(pathNode p1, pathNode p2) {
		            return p2.duration - p1.duration; // Descending
		        }
			});
	}
	
	public static void getPaths(ArrayList<Occurrence> List, Occurrence Node, String compiledPath)
	{
		makeCompareList(List);
		getPathsPartOne(List,Node,compiledPath);
		getDurations(List,pathList);
	}
	
	public static int getDurationCount(ArrayList<Occurrence> List, Occurrence Node){

		int totalDur = Node.duration;
		String[] dependencies = Node.getParents();
		for (int i=0; i < List.size(); i++){
			String check = List.get(i).name;
			int dur = List.get(i).duration;
			for(int j=0; j<dependencies.length; j++){
				if(dependencies[j].equals(check)){
					totalDur = totalDur + dur;
				}
			}
		}
		return totalDur;
	}

	public static String listOfNames(ArrayList<Occurrence> List){

		/*String compiledList = "";
		for(int i=0; i < List.size(); i++){
			compiledList = compiledList + ( List.get(i)).getName() + "\n";
		}
		return compiledList;*/
		String string="";
		String[] compiledList = new String[List.size()];
		for(int i=0; i < List.size(); i++){
			compiledList[i] = List.get(i).getName();
		}
		Arrays.sort(compiledList);
		for(int i=0; i < compiledList.length; i++){
			string = string + compiledList[i] + " \n";
		}
		
		return string;
	}
	
	public static String listOfDurations(ArrayList<Occurrence> List){
		
		String string = "";
		String[] compiledList = new String[List.size()];
		for(int i=0; i < List.size(); i++){
			compiledList[i] = List.get(i).getName();
		}
		Arrays.sort(compiledList);
		for(int i=0; i < compiledList.length; i++){
			for(int j=0;j< List.size();j++) {
			if(compiledList[i].equalsIgnoreCase(List.get(j).getName())) {
				string = string  + ( List.get(j)).getDuration() + " \n";
				break;
				}
			}
		}
		return string;
	}



	public static ArrayList<Occurrence> getArrayList() {
		return List;
	}
	
	public static ArrayList<pathNode> getPathList() {
		return pathList;
	}
	public static void setArrayList(ArrayList<Occurrence> newList) {
		List = newList;
	}
	public static void setPathList(ArrayList<pathNode> newPath) {
		pathList = newPath;
	}
	public static void clearArrays() {
		List.clear();
		pathList.clear();
		durationList.clear();
		compareList = "";
		
	}
	public static void clearPaths() {
		pathList.clear();
		durationList.clear();
	}
	public static Boolean getFlag() {
		return validDependencies; 
	}
	
	public static boolean checkCycles(ArrayList<String> outer, ArrayList<String> inner) {
	
		int j = 0;
		
		for(int i =0; i < outer.size();i++) {
			for( j = 0 ; j<inner.size();j++) {
				if( outer.get(i).equalsIgnoreCase(inner.get(j))) 
					break;
			}
				if(j == inner.size()) { 
					return false;
				}
	}
		return true;
}
}
	


