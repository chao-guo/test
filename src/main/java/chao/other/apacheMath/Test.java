package chao.other.apacheMath;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/15 14:27:00
 */
public class Test {
    public static void main(String[] args) {
        final WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(1, 2);
        obs.add(3, 4);

        // Instantiate a third-degree polynomial fitter.
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (double c : coeff) {
            System.out.println(c);
        }

    }
}