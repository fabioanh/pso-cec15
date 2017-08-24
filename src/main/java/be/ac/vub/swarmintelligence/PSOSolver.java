package be.ac.vub.swarmintelligence;

public interface PSOSolver {
	void solve();

	public void initSwarm();
	
	Boolean terminate();
}
