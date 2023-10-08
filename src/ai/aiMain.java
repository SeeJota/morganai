package src.ai;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class aiMain{
    public static void main(String[] args){


        // read the files
        ArrayList<Float> inputs = new ArrayList<>(Arrays.asList(1f,0f,0f,1f));
        aiTraining.RunNetwork(aiInterface.getNurons(),inputs);
        ArrayList<neuron> outputs =  aiTraining.GetOutputNuronArray();

        int nuronIndex = -1;
        nuronIndex = runNetwork(outputs);
        float uncertainty = getUncertainty(outputs);

        System.out.println("It was neuron " + nuronIndex + " with an uncertainty of " + uncertainty);


    }
    public static int runNetwork(ArrayList<neuron> outputs){



        //get the maximum value as the responce
        int maxNuronIndex = 0;
        for(int i = 0; i < outputs.size(); i++){
            System.out.println("nuron "+ i +" val of "+outputs.get(i).value);
            if(outputs.get(i).value > outputs.get(maxNuronIndex).value){

                maxNuronIndex = i;
            }
        }
        return maxNuronIndex;
    }
    public static float getUncertainty(ArrayList<neuron> outputs){
        //the average distribution for gauging certainty
        float sum = 0f;
        for(int i = 0; i < outputs.size(); i++){

            sum += outputs.get(i).value;
        }
        float average = sum/outputs.size();

        float sum2 = 0f;
        for(int i = 0; i < outputs.size(); i++){

            sum += (float)(Math.pow((outputs.get(i).value-average),2f));
        }
        float meanAbsoluteDeviation = sum2/ outputs.size();//AKA uncertainty
        return meanAbsoluteDeviation;
    }
}
