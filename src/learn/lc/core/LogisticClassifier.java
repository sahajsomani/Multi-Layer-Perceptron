package learn.lc.core;

import learn.math.util.VectorOps;

public class LogisticClassifier extends LinearClassifier {
	
	public LogisticClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A LogisticClassifier uses the logistic update rule
	 * (AIMA Eq. 18.8): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times h_w(x)(1-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
		// This must be implemented by you
		double[] w = this.weights;
		double wx = this.eval(x);
		
		for(int i = 0; i < w.length; i++) {
				this.weights[i] = w[i] + (alpha*(y-wx)*wx*(1-wx)*x[i]);
		}
	}
	
	/**
	 * A LogisticClassifier uses a 0/1 sigmoid threshold at z=0.
	 */
	public double threshold(double z) {
		// This must be implemented by you
		return (1/(1+java.lang.Math.exp(-1*z)));
	} //end threshold

}
