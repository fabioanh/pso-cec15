package be.ac.vub.swarmintelligence.swarm;

import java.util.Arrays;
import java.util.Iterator;

public class Swarm implements Iterable<Particle> {
	private Particle[] particles;
	private double[] bestPosition;
	private int dimension;
	private double[] inertia;

	@Override
	public Iterator<Particle> iterator() {
		return Arrays.asList(particles).iterator();
	}

}
