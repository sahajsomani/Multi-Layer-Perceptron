package learn.nn.core;

import java.util.List;

/**
 * A LogisticUnit is a Unit that uses a sigmoid
 * activation function.
 */
public class LogisticUnit extends NeuronUnit {

	/**
	 * The activation function for a LogisticUnit is a 0-1 sigmoid
	 * centered at z=0: 1/(1+e^(-z)). (AIMA Fig 18.7)
	 */
	@Override
	public double activation(double z) {
		return (1/(1+java.lang.Math.exp(-1*z)));
	}

	/**
	 * Derivative of the activation function for a LogisticUnit.
	 * For g(z)=1/(1+e^(-z)), g'(z)=g(z)*(1-g(z)) (AIMA p. 727).
	 * @see https://calculus.subwiki.org/wiki/Logistic_function#First_derivative
	 */
	public double activationPrime(double z) {
		double y = activation(z);
		return y * (1.0 - y);
	}

	/**
	 * Update this unit's weights using the logistic regression
	 * gradient descent learning rule (AIMA Eq 18.8).
	 * Remember: If there are n input attributes in vector x,
	 * then there are n+1 weights including the bias weight w_0.
	 */
	@Override
	public void update(double[] x, double y, double alpha) {
		// This must be implemented by you
		// w_ij <- w_ij + alpha * a_i * delta_j
//		double wx = this.h_w(x);
//		int i = 0;
//		
//		for(Connection c : this.incomingConnections) {
//			c.weight = c.weight + (alpha*(y-wx)*wx*(1-wx)*x[i]);
//			i++;
//		}
		double wx = this.h_w(x);
		for (int i=0; i < this.incomingConnections.size(); i++) {
			double wi = this.incomingConnections.get(i).weight;
			double xi = (i == 0) ? 1.0 : x[i-1];
			setWeight(i, wi + (alpha*(y-wx)*wx*(1-wx)*xi));
		}
		
	} //end update

}
