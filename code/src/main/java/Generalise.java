public class Generalise
{
	//The idea is to create a new generalised S.
	//used in case of positive test case 
	void  generalise_S( Hypothesis s, TrainingData d)

	{
		ArrayList() <Hypothesis> G; //Creating the General and Specific boundary with an array list
		ArrayList() <Hypothesis> S;

		general= new Hypothesis();
	
		for(int i=0; i<s.features.length, i++)

			{
				if(s.features[i].equals('-'))         
				general.features[i]=d.features[i]; 

           
				// if the features are all null that means it is the starting point. 
				// Therefore we assign the values of the first Positive Training instance's values to it.


				else if(s.features[i].equals(d.features[i]))
				general.features[i]=d.features[i];


				else if(!s.features[i].equals(d.features[i]))
				general.features[i]='?';

				else if(s.features[i].equals('?'))
				general.features[i]='?';

		 }

		//Here we have to run a for loop to add the newly created generalisation iff the Generalisation is LESS
  		//general than at least one generalisation in G. Or we can use the moreSpecificThan method too.

		for (int j=0; j<G.size();j++)
		{
			if(!general.moreSpecificThan(G.get(i))
			return;
		}
	    
			general=null;	

	}
}
			
					