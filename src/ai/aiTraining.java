package src.ai;

import java.util.*;

public class aiTraining{
    private static ArrayList<neuron> inputNurons;
    private static ArrayList<neuron> hiddenNuronLayer1;
    private static ArrayList<Float> DesiredValues;
    private static ArrayList<neuron> outputNurons;

    public static void main(String[] args){
        InitializeNetwork();
        LoadNetworkValues();
        RunNetwork();

        for(int i = 0; i < 1; i++){
            backPropigationOfBias();
            RunNetwork();
        }

    }
    public static ArrayList<neuron> GetOutputNuronArray(){
        return outputNurons;
    }
    public static ArrayList<Float> GetDesiredValuesArray(){
        //return DesiredValues;
        ArrayList<Float> output =  new ArrayList<>(Arrays.asList(0f,1f));
        return output;
    }

    public static void SetDesiredValues(){
        //same length as output nurons
        DesiredValues = new ArrayList<>(Arrays.asList(1f,1f));
    }
    public static void InitializeNetwork(){



        System.out.println("Initializing network");



        //set up basic net work

        inputNurons = new ArrayList<>(Arrays.asList(new neuron(),
                                                                        new neuron()));
        //initializing values
        for (neuron n : inputNurons){
            n.value = 1f;
            //n.initialize();
        }

        hiddenNuronLayer1 = new ArrayList<>(Arrays.asList(new neuron(0f,inputNurons, new ArrayList<Float>(Arrays.asList(.2f,.4f))),
                                                          new neuron(0f,inputNurons, new ArrayList<Float>(Arrays.asList(.2f,.4f))),
                                                          new neuron(0f,inputNurons, new ArrayList<Float>(Arrays.asList(.2f,.4f)))));

        outputNurons = new ArrayList<>(Arrays.asList(new neuron(0f,hiddenNuronLayer1, new ArrayList<Float>(Arrays.asList(.2f,.2f,.5f))),
                                                     new neuron(0f,hiddenNuronLayer1, new ArrayList<Float>(Arrays.asList(.2f,.2f,.5f)))));
    }
    public static void RunNetwork(){

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
    public static void LoadNetworkValues(){
        System.out.println("loaded values to network");
    }

    public static void backPropigationOfBias(){

        //start in output
        for(int i = 0; i < outputNurons.size(); i++){

            ArrayList<neuron> proceedingNurons = outputNurons.get(i).getProceedingNurons();
            ArrayList<Float> weightsOfProceedingNurons = outputNurons.get(i).getWeightedInputOfInputNurons();
            ArrayList<Float> errorCorrections = aiFunctions.ErrorOfOutput();

            //goes through all proceeding nurons connected to current output nuron
            for(int c = 0; c < weightsOfProceedingNurons.size(); c++){
                //changes the bias of the proceeding nuron based on the correction value times the weights associated
                proceedingNurons.get(c).bias = proceedingNurons.get(c).bias + errorCorrections.get(i) * weightsOfProceedingNurons.get(c);
                proceedingNurons.get(c).lastBiasCorrectionValue = errorCorrections.get(i) * weightsOfProceedingNurons.get(c);
                //System.out.println(" for hidden " + c + " bias is changed " + errorCorrections.get(i) * weightsOfProceedingNurons.get(c));

            }



        }

        //start in Hidden layer (assuming there is only 1 hidden layer
        for(int i = 0; i < hiddenNuronLayer1.size(); i++){

            System.out.println(" for hidden " + i + "bias has been totally changed to" + hiddenNuronLayer1.get(i).bias);

            ArrayList<neuron> proceedingNurons = hiddenNuronLayer1.get(i).getProceedingNurons();
            ArrayList<Float> weightsOfProceedingNurons = hiddenNuronLayer1.get(i).getWeightedInputOfInputNurons();
            ArrayList<Float> errorCorrections = aiFunctions.ErrorOfOutputLiniar();

            //goes through all proceeding nurons connected to current output nuron
            for(int c = 0; c < weightsOfProceedingNurons.size(); c++){
                //changes the bias of the proceeding nuron based on the correction value times the weights associated
                proceedingNurons.get(c).bias = proceedingNurons.get(c).bias + hiddenNuronLayer1.get(i).lastBiasCorrectionValue * weightsOfProceedingNurons.get(c);

            }

        }
        System.out.println("");
        //debug the weights for the inputs
        for(int i = 0; i < inputNurons.size(); i++) {


                System.out.println("initial correctioin val " + aiFunctions.ErrorOfOutputLiniar().get(i));
                System.out.println(" for input " + i + "bias has been totally changed to" + inputNurons.get(i).bias);
            }
        }
}
