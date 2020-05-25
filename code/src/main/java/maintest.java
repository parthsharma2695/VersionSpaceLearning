import java.util.ArrayList;

public class maintest {
	public ArrayList<Hypothesis> G = new ArrayList<Hypothesis>(); // Creating the General and Specific boundary with an
																	// array list
	public ArrayList<Hypothesis> S = new ArrayList<Hypothesis>();
	
	// The idea is to create a new generalised S.
	// used in case of positive test case
	void generalise_S(Hypothesis h1, TrainingData d)

	{
				
		
		Hypothesis general = new Hypothesis();
		
				for (int i = 0; i < h1.features.length; i++) {
					

			if ("null".equals(h1.features[i])) {
				general.features[i] = d.attr.features[i];
				System.out.print(general.features[i]);

			}
			// if the features are all null that means it is the starting point.
			// Therefore we assign the values of the first Positive Training instance's
			// values to it.

			else if (h1.features[i].equals(d.attr.features[i])) {
				
				general.features[i] = d.attr.features[i];
				
			}

			else if (!h1.features[i].equals(d.attr.features[i]))
				general.features[i] = "?";

			else if (h1.features[i].equals("?"))
				general.features[i] = "?";
		}

		// Here we have to run a for loop to add the newly created generalisation iff
		// the Generalisation is LESS
		// general than at least one generalisation in G. Or we can use the
		// moreSpecificThan method too.
				
		for (int j = 0; j < G.size(); j++) 
		{
			if (!general.isMoreGeneralThan(G.get(j))) 
			{
				
			S.add(general);
			
			}
			
				return;
		}
		general = null;
		
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		maintest mt = new maintest();

		Hypothesis Gi= new Hypothesis();
		Hypothesis Si = new Hypothesis();

			for (int i = 0; i < Gi.features.length; i++) 
			{
				Gi.features[i] = "?";
			}
		
			mt.G.add(Gi);	
			
			for (int i = 0; i < Si.features.length; i++) 
				Si.features[i] = "null";
			mt.S.add(Si);

		Hypothesis att2 = new Hypothesis();
		TrainingData d = new TrainingData();
				for(int i=0;i<d.tr1.size();i++)
		{
				d.genNxt(i, d);
		
				mt.generalise_S(att2, d);
				
		}
				for(int j=0; j<mt.S.size();j++)
				{
					if((mt.S.get(j).equals(Si))==1)
					{
						mt.S.remove(j);
					}
				}
		System.out.println(mt.S);

	}

}
