package src.ai;

import java.util.*;

public class aiTraining{
    public static void main(String[] args){
        System.out.println("Initializing test");



        //set up basic net work

        ArrayList<neuron> inputNurons = new ArrayList<>(Arrays.asList(new neuron(),
                                                                        new neuron()));
        //initializing values
        for (neuron n : inputNurons){
            n.value = 1f;
            //n.initialize();
        }

        ArrayList<neuron> hiddenNuronLayer1 = new ArrayList<>(Arrays.asList(new neuron(0f,inputNurons, new ArrayList<>(.2f,.4f)),
                                                                        new neuron(0f,inputNurons, new ArrayList<>(.2f,.4f)),
                                                                        new neuron(0f,inputNurons, new ArrayList<>(.2f,.4f))));

        ArrayList<neuron> outputNurons = new ArrayList<>(Arrays.asList(new neuron(0f,hiddenNuronLayer1, new ArrayList<>(.2f,.4f,.3f)),
                                                                        new neuron(0f,hiddenNuronLayer1, new ArrayList<>(.2f,.4f,.3f)));
        //computes hidden nurons
        for (neuron n : hiddenNuronLayer1){
            n.compute();

        }
        //computes output nurons
        for (neuron n : outputNurons){
            n.compute();
            System.out.println("nuron output = " + n.value);
        }



    }
}
