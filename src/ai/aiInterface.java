package src.ai;

import java.io.*;
import java.util.ArrayList;

public class aiInterface{
    static File file = new File("neuron_info.txt");
    public static void main(String[] args){
        System.out.println("hellowowofwfoerhgerdoifngbvodfkbnhdofbnhdfobghnfd");




    }


    private static ArrayList<ArrayList<neuron>> getNurons(){
        return aiTraining.networkNeurons;
    }
    public static void writeNeuronToFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file); //"/data/neuron_info.csv"
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            file.delete();
            oos.writeObject(getNurons());
            System.out.println(getNurons().get(0));
            oos.flush();
            oos.close();
        } catch( IOException e){

        }

    }
    public static ArrayList<ArrayList<neuron>> readObjFromFile() throws IOException, ClassNotFoundException{
        ArrayList<ArrayList<neuron>> returnal = null;
        try (FileInputStream fis = new FileInputStream(file); //"/data/neuron_info.csv"
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            System.out.println("I Readered");
            returnal = (ArrayList<ArrayList<neuron>>) ois.readObject();
        }catch( IOException e) {
            System.out.println("I fartered: " + e);
        }catch( ClassNotFoundException e) {
            System.out.println("I classerted");
        }

        return returnal;


    }



}
