package src.ai;

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
            "number"

    };
    public static String[] Outputs = new String[]{
            "AAA",
            "BBB",
            "CCC",
            "DDD",
            "EEE",
            "FFF",
            "GGG",
            "HHH",
            "III",
            "JJJ",
            "KKK",
            "LLL"

    };
    public static String[][] TrainingData= new String[][]{
        {"I'm injured, Contract?","AAA-well if your injured you should call a legal asistant"},
        {"What is the Statute?","BBB-this is the statute #### "}


    };
    public static float[][] TrainingDataOut= new float[][]{

            {0f,0f,3f,0f,0f,0f,0f,0f,0f,0f,0f,0f}
    };
}
