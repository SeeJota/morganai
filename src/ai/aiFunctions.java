package src.ai;
import java.lang.Math;
public class aiFunctions {

    static float E = 2.71828f;
    public static float getSigmoid( float x){
        return (float)(1/(1+Math.pow(E,-x)));
    }

}
