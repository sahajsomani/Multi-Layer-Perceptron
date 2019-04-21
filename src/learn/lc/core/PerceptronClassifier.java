package learn.lc.core;

import learn.math.util.VectorOps;
import java.lang.*;

public class PerceptronClassifier extends LinearClassifier {
	
	public PerceptronClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A PerceptronClassifier uses the perceptron learning rule
	 * (AIMA Eq. 18.7): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
		// This must be implemented by you
		double[] w = this.weights;
		double wx = this.eval(x);
		
		for(int i = 0; i < w.length; i++) {
				this.weights[i] = w[i] + alpha*x[i]*(y-wx);
		}
	} //end update
	
	/**
	 * A PerceptronClassifier uses a hard 0/1 threshold.
	 */
	public double threshold(double z) {
		// This must be implemented by you
		if(z >= 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
