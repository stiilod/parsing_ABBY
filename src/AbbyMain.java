import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AbbyMain {
    public static void main(String[] args) throws Exception {

        //file with a list of all positions
        File sourceAbbyPositions = new File("C:\\Users\\stilo\\Desktop\\ABBY\\ABBY2.txt");

        //positions from appveriftype
        String sourceLine = "YNNNNNYNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";

        BufferedReader fileReaderForPositions = new BufferedReader(new FileReader(sourceAbbyPositions));

        String f = "";

        //array with positions
        List<String> allDocumentsPositions = new ArrayList<>();

        while ((f = fileReaderForPositions.readLine()) != null) {
            allDocumentsPositions.add(f);
        }
        char[] mP = sourceLine.toCharArray();

        ArrayList<Integer> mArL = new ArrayList<>();

        for (int i = 0; i < mP.length; i++) {
            if (mP[i] == 'Y') {
                mArL.add(i + 1);
            }
        }
        for (String s : allDocumentsPositions) {
            for (int i : mArL) {
                if (s.endsWith(" " + i)) {
                    System.out.println(s);
                    continue;
                }
            }
        }
        System.out.println();
    }
}