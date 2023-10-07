package src.ai;
import java.util.ArrayList;
import java.lang.Math;
public class neuron{

    private float bias = 0.0f;
    private float value = 0.0f;
    private ArrayList<neuron> inputNurons;
    private ArrayList<Float> weightedInputOfInputNurons;

    public neuron(float bias){
        this.bias = bias;
    }
    public neuron(){
        this.bias = 0.0f;
    }
    public void compute(){

        float sum =0.0f;
        //loops through all pairings of weights to nurons
        for(int i =0; i < inputNurons.size() && i < weightedInputOfInputNurons.size(); i++){
            sum = sum + inputNurons.get(i).getValue() * weightedInputOfInputNurons.get(i);
        }

        value = aiFunctions.getSigmoid(sum+ bias);
    }
    public void initialize(){
        value = (float)(Math.random());
    }

    public float getValue(){
        return value;
    }

}

