import java.util.*;

public class TrainingData {

	String[] res;
	public ArrayList<String[]> tr1 = new ArrayList<String[]>();

	TrainingData() {
		tr1.add(new String[] { "sunny", "warm", "normal", "strong", "cool", "same" });
		tr1.add(new String[] { "sunny", "warm", "high", "strong", "cool", "same" });
		tr1.add(new String[] { "cloudy", "cold", "high", "weak", "warm", "change" });
		tr1.add(new String[] { "cloudy", "cold", "high", "weak", "warm", "same" });

	}
}