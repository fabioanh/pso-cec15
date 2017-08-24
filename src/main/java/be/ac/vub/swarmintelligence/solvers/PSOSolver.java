package be.ac.vub.swarmintelligence.solvers;

public interface PSOSolver {
	void solve();

	public void initSwarm();
	
	Boolean terminate(Integer numEval);
}
