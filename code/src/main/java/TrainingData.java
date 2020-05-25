import java.util.*;
public class TrainingData {

	String[] res;
	public List <String> tr1= new ArrayList<String>();
	
	Hypothesis attr = new Hypothesis();

	TrainingData() {
		tr1.add("Sunny Windy Warm Dry Yes");
		tr1.add("Sunny NWind Hot Dry Yes");
		tr1.add("NSunny Windy Hot Wet Yes");
			}

	boolean classification = false;

	
	void genNxt(int index, TrainingData d)
	{
				res=tr1.get(index).split(" ");
				for (int i = 0; i < (res.length)-1; i++) 
				{	
					if ("Yes".equalsIgnoreCase(res[i])) 
					{
						classification = true;
					}
					d.attr.features[i] = res[i];
					
					
				}
				
		
			
	}
	
}
