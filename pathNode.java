package Project;

public class pathNode {
	String path;
	int duration;
	
	pathNode(){
		this.duration=0;
		this.path ="";
	}
	pathNode(String path, int duration){
		this.path = path;
		this.duration = duration;
	}
	
	public void setDuration(int inDuration)
	{
		this.duration = inDuration;
	}
	public int getDuration()
	{
		return this.duration;
	}
	
	public void setPath(String inPath)
	{
		this.path = inPath;
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	
}
