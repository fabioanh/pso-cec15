package be.ac.vub.swarmintelligence.swarm;

public class Particle {
	private int dimension;
	private double[] velocity;
	private double fitness;
	private double personalBestFitness;
	private double localBestFitness;
	private double[] position;
	private double[] personalBestPosition;
	private double[] localBestPosition;

	public Particle() {
		super();
		initArrays();
	}

	/**
	 * Initializes arrays for vector-like values needed for the particle to use
	 * them later without problems
	 */
	private void initArrays() {
		this.position = new double[dimension];
		this.personalBestPosition = new double[dimension];
		this.localBestPosition = new double[dimension];
		this.velocity = new double[dimension];
	}

	public Particle(int dimension, double fitness, double[] velocity, double[] position) {
		super();
		this.dimension = dimension;
		initArrays();
		this.fitness = fitness;
		this.velocity = velocity;
		this.position = position;
	}

	/**
	 * Updates best position with current position
	 */
	public void updateBestPosition() {
		for (int i = 0; i < dimension; i++) {
			this.personalBestPosition[i] = this.position[i];
		}
	}

}