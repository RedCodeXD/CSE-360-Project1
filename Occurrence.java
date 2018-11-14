package Project;
public class Occurrence
{
	//****** V5 ********
    int duration;
	private boolean flag;
	String name;
	String[] parents;
	//****** V5 *********
	
	
	Occurrence()
	{	
		this.duration = 0;
		this.name = "";
		this.flag = false;
		this.parents = null;//V4

		
	}
	
	Occurrence(int inDuration, String inName )//V4
	{
		this.duration = inDuration;
		this.name = inName;
		this.flag = false;
		
	}
	
	public void setName(String inName)
	{
		this.name = inName;
	}
	
	public void setDuration(int inDuration)
	{
		this.duration = inDuration;
	}
	
	public void setParents(String[] input) 
	{
		
		this.parents = input;
	}
	
	public void setTrue()
	{
		this.flag = true;
	}
	
	public int getDuration()
	{
		return this.duration;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	String[] getParents() 
	{
		return this.parents;
	}

	
}
