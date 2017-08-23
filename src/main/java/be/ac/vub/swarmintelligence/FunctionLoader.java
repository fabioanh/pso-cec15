package be.ac.vub.swarmintelligence;

import java.io.File;
import java.util.Scanner;

public class FunctionLoader {
	public Function load(Integer functionNumber, Integer n) {
		Function function = new Function();

		File fpt = new File(FunctionLoader.class
				.getResource("input_data/shift_data_" + functionNumber + ".txt").getFile());

		Scanner input = new Scanner(fpt);

		for (int k = 0; k < n; k++) {
			x[k] = input.nextDouble();
		}

		for (int ii = 0; ii < n; ii++) {
			// System.out.println(x[i]);
		}

		input.close();

		for (int j = 0; j < n; j++) {
			x[1 * n + j] = 0.0;
			// System.out.println(x[1*n+j]);
		}
		return function;
	}
}
