package be.ac.vub.swarmintelligence.solvers;

public class BasePSOSolver {

	private Integer dimension;

	public BasePSOSolver(Integer dimension) {
		this.dimension = dimension;
	}

	public Boolean terminate(Integer eval) {
		return 10000 * dimension <= eval;
	}
}
