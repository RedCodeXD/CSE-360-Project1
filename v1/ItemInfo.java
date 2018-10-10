import java.util.Scanner;
import java.util.LinkedList;

public class ItemInfo 
{
	//****** V2 ********
	private ListNodes[] Parents;
	private ListNodes[] Children;	
	private int duration;
	private String name;
	private boolean flag;
	//****** V2 *********
	
	Scanner reader = new Scanner(System.in);
	
	ItemInfo()
	{	
		this.duration = 0;
		this.name = "";
		this.flag = false;
		this.Parents = null;//V2
		this.Children = null;//V2
		
	}
	
	ItemInfo(int inDuration, String inName, ListNodes[] Parents, ListNodes[] Children )//V2
	{
		this.duration = inDuration;
		this.name = inName;
		this.flag = false;
		this.Parents = Parents;
		this.Children = Children;
	}
	
	
	private ItemInfo makefirstOccurrence()
	{
		//instantiation of Struct/class null
		System.out.println("Enter In Activity Name");
		String inName = reader.next();
		//Get Activity name
		System.out.println("Enter In Activity Duration");
		int inDuration = reader.nextInt();
		//Get Activity Duration
		ItemInfo firstOccurrance = new ItemInfo(inDuration, inName, null , null);
		
		return 
				firstOccurrance;
	}
	
	private ItemInfo makeOccurrence() 
	{
		//instantiation of Struct/class null
		System.out.println("Enter In Activity Name");
		String inName = reader.next();
		//Get Activity name
		System.out.println("Enter In Activity Duration");
		int inDuration = reader.nextInt();
		//Get Activity Duration
		ListNodes[] newParents = getParents();
		ItemInfo newOccurrance = new ItemInfo(inDuration, inName, newParents, null );
		
		return 
				newOccurrance;
	}
	
	private ListNodes[] getParents() 
	{
		int i = 0;
		boolean isOver = false;
		String[] dependencies = null;
		
		while(isOver!=true) 
		{
			System.out.println("Enter In Activity Predecessor");
			dependencies[i] = reader.next();
			i++;
			System.out.println("More Dependencies? Enter Int: Yes(1)/No(0)");
				if(reader.nextInt() == 0 ) 
				{
					isOver = true;
				}
		}
		return dependencies;
	}

	
	private int getDurationCount(ItemInfo[] listOfActivities)
	{
		int durationCount=0, i=0;
		
		while(listOfActivities[i]!=null) 
		{
			durationCount = listOfActivities[i].getDuration() + durationCount;
			i++;
		}
		
		return durationCount; 
	}
	
	private ItemInfo[] getPaths(ItemInfo[] listOfActivities)
	{
		ItemInfo[] listOfPaths = null;
		
		int endOfList = listOfActivities.length;
		ItemInfo marker = new ItemInfo();
		
		while(endOfList != 0)
		{
			marker = listOfActivities[endOfList];
			
			//marker.dependancy;
			
		}
	}
	
	public void setDuration(int inDuration)
	{
		this.duration = inDuration;
	}
	
	public int getDuration()
	{
		return this.duration;
	}
	
	public void setName(String inName)
	{
		this.name = inName;
	}
	
	public String getName()
	{
		return this.name;
	}


	
}

