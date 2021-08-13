import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExercicioProposto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String path = "/home/neemias/list.csv";
		String path2 = "/home/neemias/subdir/summary.csv";
		
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			
			while (line != null) {
				
				String[] vect = line.split(",");
				String name = vect[0];
				Double value = Double.parseDouble(vect[1]);
				Integer amount = Integer.parseInt(vect[2]);
				
				String total = String.format("%.2f", value * amount);
				String str = (name + "," + total);
				
				list.add(str);
				
				line = br.readLine();
								
			}
						
		} 
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {
			for (String line : list) {
				bw.write(line);
				bw.newLine();
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
