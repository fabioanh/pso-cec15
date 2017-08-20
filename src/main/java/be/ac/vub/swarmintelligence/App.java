package be.ac.vub.swarmintelligence;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

/**
 * 
 * @author fabio
 *
 */
public class App {
	private static final String WEIGHT = "weight";
	private static final String DIMENSION = "dimension";
	private static final String MAX_EVAL = "maxeval";
	private static final String HELP = "help";
	private static final String NUM_PARTICLES = "numparticles";
	private static final String PROBLEM = "problem";
	private static final String SEED = "seed";
	private final static Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) throws IOException, ParseException {
		CommandLineParser parser = new DefaultParser();
		CommandLine line = parser.parse(helpOptions(), args, true); // true so
																	// it
		// does not throw on unrecognized options
		if (line.hasOption(HELP)) {
			help(); // calls exit
		}
		Map<String, Object> cfg = getCLIConfig(args);
		RandomUtils.getInstance((Integer) cfg.get(SEED));
		// TODO: Create instance of the solver passing the cfg object as
		// parameter and call the method to solve the problem

	}

	private static Map<String, Object> getCLIConfig(String[] args) {
		CommandLineParser parser = new DefaultParser();
		Map<String, Object> response = new HashMap<>();
		try {
			// parse the command line arguments
			CommandLine cliArgs = parser.parse(getOptions(), args);
			if (cliArgs.hasOption(HELP)) {
				help();
			}
			if (cliArgs.hasOption(PROBLEM)) {
				response.put(PROBLEM, Integer.valueOf(cliArgs.getOptionValue(PROBLEM)));
			} else {
				response.put(PROBLEM, 1);
			}
			if (cliArgs.hasOption(NUM_PARTICLES)) {
				response.put(NUM_PARTICLES, Integer.valueOf(cliArgs.getOptionValue(NUM_PARTICLES)));
			} else {
				response.put(NUM_PARTICLES, 20);
			}
			if (cliArgs.hasOption(WEIGHT)) {
				response.put(WEIGHT, Double.valueOf(cliArgs.getOptionValue(WEIGHT)));
			} else {
				response.put(WEIGHT, 1.0);
			}
			if (cliArgs.hasOption(DIMENSION)) {
				response.put(DIMENSION, Integer.valueOf(cliArgs.getOptionValue(DIMENSION)));
			} else {
				response.put(DIMENSION, 30);
			}
			if (cliArgs.hasOption(SEED)) {
				response.put(SEED, Integer.valueOf(cliArgs.getOptionValue(SEED)));
			} else {
				response.put(SEED, 1234);
			}
			if (cliArgs.hasOption(MAX_EVAL)) {
				response.put(MAX_EVAL, Integer.valueOf(cliArgs.getOptionValue(MAX_EVAL)));
			} else {
				response.put(MAX_EVAL, 10000);
			}
		} catch (ParseException ex) {
			// oops, something went wrong
			LOGGER.error("Parsing failed.  Reason: " + ex.getMessage());
		}

		LOGGER.debug("\n****************************\n****************************\n"
				+ "Configuration to be used:\n" + prettyPrintMap(response)
				+ "****************************\n****************************\n");

		return response;
	}

	private static String prettyPrintMap(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Object> entry = iter.next();
			sb.append(entry.getKey());
			sb.append(" = ");
			sb.append(entry.getValue());
			// sb.append('"');
			// if (iter.hasNext()) {
			sb.append('\n');
			// }
		}
		return sb.toString();

	}

	private static Options getOptions() {
		Options options = new Options();

		//@formatter:off
		Option problem = Option.builder("p").
				argName(PROBLEM).
				hasArg().
				longOpt(PROBLEM).
				desc("Problem number to test the solution on").
				build();
		options.addOption(problem);
		//@formatter:on
		
		//@formatter:off
		Option numParticles = Option.builder("n").
				argName(NUM_PARTICLES).
				hasArg().
				longOpt(NUM_PARTICLES).
				desc("Number of particles to be used in the swarm").
				build();
		options.addOption(numParticles);
		//@formatter:on

		//@formatter:off
		Option weight = Option.builder("w").
				argName(WEIGHT).
				hasArg().
				longOpt(WEIGHT).
				desc("Initial inertia weight parameter to control the speed of convergence").
				build();
		options.addOption(weight);
		//@formatter:on

		//@formatter:off
		Option dimension = Option.builder("d").
				argName(DIMENSION).
				hasArg().
				longOpt(DIMENSION).
				desc("Number of dimensions to be used in the solutions for the problems").
				build();
		options.addOption(dimension);
		//@formatter:on

		//@formatter:off
		Option seed = Option.builder("s").
				argName(SEED).
				hasArg().
				longOpt(SEED).
				desc("Seed value used in the random numbers generation").
				build();
		options.addOption(seed);
		//@formatter:on

		//@formatter:off
		Option maxEval = Option.builder("m").
				argName(MAX_EVAL).
				hasArg().
				longOpt(MAX_EVAL).
				desc("Maximum number of evaluations to be run for each round in the solution").
				build();
		options.addOption(maxEval);
		//@formatter:on

		//@formatter:off
		Option help = Option.builder("h").
				argName(HELP).
				hasArg(false).
				longOpt(HELP).
				desc("Shows these instructions").
				build();
		options.addOption(help);
		//@formatter:on

		return options;
	}

	private static Options helpOptions() {
		//@formatter:off
		Options options = new Options();
		Option help = Option.builder("h").
			argName(HELP).
			hasArg(false).
			longOpt(HELP).
			desc("Shows these instructions").
			build();
		//@formatter:on
		options.addOption(help);
		return options;
	}

	private static void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("CEC 2015 - PSO", getOptions());
		System.exit(0);
	}
}