package learn.nn.core;

/**
 * A PerceptronUnit is a Unit that uses a hard threshold
 * activation function.
 */
public class PerceptronUnit extends NeuronUnit {

	/**
	 * The activation function for a Perceptron is a hard 0/1 threshold
	 * at z=0. (AIMA Fig 18.7)
	 */
	@Override
	public double activation(double z) {
		if(z >= 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Update this unit's weights using the Perceptron learning
	 * rule (AIMA Eq 18.7).
	 * Remember: If there are n input attributes in vector x,
	 * then there are n+1 weights including the bias weight w_0.
	 */
	@Override
	public void update(double[] x, double y, double alpha) { //x is the array of weights. y is the error of the child
		// This must be implemented by you
		
//		double wx = this.h_w(x);
//		int i = 0;
//		
//		for(Connection c : this.incomingConnections) {
//			c.weight = c.weight + (alpha*(y-wx)*x[i]);
//			i++;
//		}
		
		double wx = this.h_w(x);
		for (int i=0; i < this.incomingConnections.size(); i++) {
			double wi = this.incomingConnections.get(i).weight;
			double xi = (i == 0) ? 1.0 : x[i-1];
			setWeight(i, wi + (alpha*(y-wx)*xi));
		}
	} //end update
}
