package src.ai;

import java.io.File;

public class InputAndOutputIndex {
    public static String[] keywords = new String[]{
            "Jurisdiction",
            "Liability",
            "Litigation",
            "Contract",
            "Defendant",
            "Case",
            "Evidence",
            "Settlement",
            "Statute",
            "When",
            "?",
            "number",
            "Morgan",
            "case",
            "evidence",
            "settlement",
            "lawyers",
            "lawyer",
            "trial",
            "account",
            "login",
            "password",
            "office",
            "Offices",
            "Office",
            "offices",
            "attorney",
            "attorneys",
            "outcome",
            "outcomes",
            "status",
            "location",
            "Location",
            "deadline",
            "result",
            "current",
            "state"


    };
    public static String[] Outputs = new String[]{
            "AAA",
            "BBB",
            "CCC",
            "DDD",
            "EEE",
            "FFF",
            "GGG"

    };
    public static String[] stringOutputs = new String[]{
            "Text A",
            "Text B",
            "Text C",
            "Text D",
            "Text E",
            "Text F",
            "Text G"

    };

    public static String[][] TrainingData= aiInterface.getTrainingData(new File("Training_Data.csv"));
//            new String[][]{
//        {"I'm injured, Contract?","AAA-well if your injured you should call a legal asistant"},
//        {"What is the Statute?","BBB-this is the statute #### "}
//    };
    public static float[][] TrainingDataOut=  aiInterface.setTrainingOutputs(TrainingData,7,.1f);

}
