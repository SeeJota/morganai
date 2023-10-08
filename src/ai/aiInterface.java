package src.ai;

import java.io.*;
import java.util.ArrayList;

public class aiInterface{
    static final String FILE_PATH = "/data/neuron_info.csv";
    public static void main(String[] args){
        System.out.println("hellowowofwfoerhgerdoifngbvodfkbnhdofbnhdfobghnfd");




    }

    public static ArrayList<ArrayList<neuron>> getNurons(){
        return aiTraining.networkNeurons;
    }
    public static void writeNeuronToFile(File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file); //"/data/neuron_info.csv"
    private ArrayList<ArrayList<neuron>> getNurons(){
        return aiTraining.networkNeurons;
    }
    public void writeNeuronToFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH); //"/data/neuron_info.csv"
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            try {
                fos.getChannel().truncate(0);
            } catch (IOException e) {
            }
            oos.writeObject(getNurons());
//            for (ArrayList<neuron> aN : getNurons()) {
//                oos.writeObject(aN);
////
////                for(neuron n : aN){
////                    oosf.writeObject(n);
////                }
//            }
            oos.flush();
        } catch( IOException e){

        }

    }
    public ArrayList<ArrayList<neuron>> readObjFromFile() throws IOException, ClassNotFoundException{
        ArrayList<ArrayList<neuron>> returnal = null;
        try (FileInputStream fis = new FileInputStream(FILE_PATH); //"/data/neuron_info.csv"
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            returnal = (ArrayList<ArrayList<neuron>>) ois.readObject();
        }catch( IOException e) {
        }

        return returnal;


    }



}
