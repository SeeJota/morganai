package src.ai;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class aiMain{
    public static void main(String[] args){


        // read the files
        String inputStr = "I'm injured, Contract?";
        System.out.println("accociated inputs are ### " + ConvertInput(inputStr));
        aiTraining.RunNetwork(aiInterface.getNurons(),ConvertInput(inputStr));
        ArrayList<neuron> outputs =  aiTraining.GetOutputNuronArray();

        int nuronIndex = -1;
        nuronIndex = runNetwork(outputs);
        float uncertainty = getUncertainty(outputs);
        System.out.println("Does the network do neuron? Answer: " + aiInterface.getNurons());
        System.out.println("It was neuron " + nuronIndex + " with an uncertainty of " + uncertainty);
        ArrayList<ArrayList<neuron>> test = new ArrayList<>();

        try {
            test = aiInterface.readObjFromFile();
//            System.out.println("I tried to readered");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Did this explodedered? Answer: " + test);

    }
    public static ArrayList<Float> ConvertInput(String str){
        ArrayList<Float> inputs = new ArrayList<>();

        for(int i =0; i<InputAndOutputIndex.keywords.length;i++){
            inputs.add((float)lookForWord(str,InputAndOutputIndex.keywords[i])/str.length()*InputAndOutputIndex.keywords[i].length());
        }
        return  inputs;
    }
    public static int lookForWord(String str, String word) {
        int count = 0;
        for (int i = 0; i <= str.length() - word.length(); i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                count++;
            }
        }
        return count;
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
