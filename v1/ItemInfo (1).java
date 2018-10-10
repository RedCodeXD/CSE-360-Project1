import java.util.Scanner;
import java.util.LinkedList;

public class ItemInfo 
{
	//****** V3 ********
	private ItemInfo Parent;
	private ItemInfo LeftMostChild;	
	private ItemInfo NextChild;
	private int duration;
	private String name;
	private boolean flag;
	//****** V3 *********
	
	Scanner reader = new Scanner(System.in);
	
	ItemInfo()
	{	
		this.duration = 0;
		this.name = "";
		this.flag = false;
		this.Parent = null;//V3
		this.LeftMostChild = null;//V3
		this.NextChild = null;
		
	}
	
	ItemInfo(int inDuration, String inName, ItemInfo Parent, ItemInfo LeftMostChild, ItemInfo NextChild )//V3
	{
		this.duration = inDuration;
		this.name = inName;
		this.flag = false;
		this.Parent = Parent;
		this.LeftMostChild = LeftMostChild;
		this.NextChild = NextChild;
	}
	
	
	private ItemInfo makeFirstOccurrence()
	{
		//instantiation of Struct/class null
		System.out.println("Enter In Activity Name");
		String inName = reader.next();
		//Get Activity name
		System.out.println("Enter In Activity Duration");
		int inDuration = reader.nextInt();
		//Get Activity Duration
		ItemInfo firstOccurrance = new ItemInfo(inDuration, inName, null , null, null);

		return 
				firstOccurrance;
	}
	
	private ItemInfo newOccurrence() 
	{
		//instantiation of Struct/class null
		System.out.println("Enter In Activity Name");
		String inName = reader.next();
		//Get Activity name
		System.out.println("Enter In Activity Duration");
		int inDuration = reader.nextInt();
		//Get Activity Duration
		ItemInfo newParent = getParents();
		ItemInfo newOccurrance = new ItemInfo(inDuration, inName, newParent, null, null );
		
		return 
				newOccurrance;
	}
	
	private ItemInfo getParents() 
	{
			//This is where we would need to parse the input for commas and check each input divided by the commas to see if
			//there is actually a node in the list matching that exact name
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
		//This is the hard part, we have to input our linked list then get all the possible paths for the 
		//list so If A->B->C
		//               ->D it would have to first return A-B-C and give its duration then A-B-D and its duration
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
	
	public String getParent() {
		return this.Parent.name;
	}
	
	public String getLeftMostChild() {
		return this.LeftMostChild.name;
	}
	
	public String getNextChild() {
		return this.NextChild.name;
	}
	

	
}

