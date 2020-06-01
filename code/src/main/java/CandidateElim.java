import java.util.ArrayList;
import java.util.HashSet;

public class CandidateElim {
	TrainingData td = new TrainingData();
	SpecializeGBoundary sgb = new SpecializeGBoundary();

	public HashSet<Hypothesis> SBoundary = new HashSet<Hypothesis>();// Creating the Specific Boundary.
	// The General boundary is defined inside the SpecializeGBoundaryTest class.

	public CandidateElim() {
		// adding the initial Hypothesis values
		SBoundary.add(new Hypothesis(6, "S"));
		sgb.GBoundary.add(new Hypothesis(6, "G"));
	}

	Generalize gen = new Generalize();

	void positiveInst(String[] d) {
		for (Hypothesis hyp : sgb.GBoundary) // Iterate over G list
		{
			if (!hyp.isConsistentWithDataPoint(d, true)) {
				sgb.GBoundary.remove(hyp);
			}

		}

		for (Hypothesis hyp : SBoundary) // Iterate over S list
		{

			if (!hyp.isConsistentWithDataPoint(d, true)) {

				SBoundary.addAll(gen.min_generalizations(hyp, d));// adding the newly generated Hypothesis after
																	// Generalisation of S
				// using Generalize class.
				SBoundary.remove(hyp);// Removing the Hypothesis which was Generalised.

			}
		}

	}

	void negativeInst(String[] d, ArrayList<ArrayList<String>> f_pssibleValues) {
		// if the Training data is consistent with any hypothesis in the S Boundary,
		// remove the hypothesis from the list.
		for (Hypothesis hyp : SBoundary) {
			if (hyp.isConsistentWithDataPoint(d, true)) {

				SBoundary.remove(hyp);
			}
		}

		for (Hypothesis hyp : sgb.GBoundary) {
			if (!hyp.isConsistentWithDataPoint(d, false)) {

				sgb.specialize(d, SBoundary, f_pssibleValues, hyp);// The removals and additions to the G Boundary list
				// are done in the specialize method itself.
			}
		}
	}

	public void CanElim() {
		ArrayList<ArrayList<String>> f_possibleValues = new ArrayList<>();
		// Adding the possible features inside the LIST.
		ArrayList<String> f1 = new ArrayList<>();
		ArrayList<String> f2 = new ArrayList<>();
		ArrayList<String> f3 = new ArrayList<>();
		ArrayList<String> f4 = new ArrayList<>();
		ArrayList<String> f5 = new ArrayList<>();
		ArrayList<String> f6 = new ArrayList<>();
		f1.add("Sunny");
		f1.add("Clear");
		f1.add("Cloudy");
		f2.add("Warm");
		f2.add("Cold");
		f3.add("Normal");
		f3.add("High");
		f3.add("Low");
		f4.add("Strong");
		f4.add("Weak");
		f5.add("Warm");
		f5.add("Cool");
		f6.add("Same");
		f6.add("Change");
		f_possibleValues.add(f1);
		f_possibleValues.add(f2);
		f_possibleValues.add(f3);
		f_possibleValues.add(f4);
		f_possibleValues.add(f5);
		f_possibleValues.add(f6);
		String[] m;
		boolean classification = true;
		for (int i = 0; i < td.tr1.size(); i++) { // Iterate over the Training Data Examples
			m = td.tr1.get(i);
			if (i > 1)
				classification = false; // added because of just testing purpose without extracting the classification
										// of the example.
			if (classification == true) {

				positiveInst(m);

			} else {

				negativeInst(m, f_possibleValues);

			}
		}
		// Display Specific Boundary
		for (Hypothesis s1 : SBoundary) {

			System.out.println(s1 + "s");
		}
		// Display General Boundary
		for (Hypothesis s2 : sgb.GBoundary) {
			System.out.println(s2 + "g");
		}
	}

	//Creating a test main class to Test the Methods and calling the CanElim method.
	public static void main(String args[]) { 
		CandidateElim ce = new CandidateElim();
		ce.CanElim();
	}

}
