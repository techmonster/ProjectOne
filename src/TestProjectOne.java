/**
 * Created by Nate Holloway on 3/19/2016.
 * This class will demonstrate project one.
 */
import java.util.ArrayList;

public class TestProjectOne {
    public static void main(String[] args) {

        Artist catalog;
        String fileName = "p1artists.txt";
        String fileArts = "p1arts.txt";
        ArrayList<Artist> artTable = new ArrayList<Artist>();
        int artID;

        CreateFile myFile1 = new CreateFile();
        myFile1.openFile("artistTableOut.txt");

        CreateFile myFile2 = new CreateFile();
        myFile2.openFile("p1arts_out2.txt");

        String line;


        LineReader fileReader = new LineReader(fileName);

        while ((line = fileReader.readLine()) != null) {
            //split each line at the tabbed space and place in and array
            String splitArray[] = line.split("\t");
            String firstEntry = splitArray[0];
            try {
                //convert the string to an integer
                artID = (Integer.valueOf(firstEntry));
                String artistName = splitArray[1];

                //create a new Artist object
                catalog = new Artist(artID, artistName);

                artTable.add(catalog);

                //print the Artist that was added
                //  System.out.println(catalog.toString());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            // System.out.println(line);
        }
        makeFile(artTable, myFile1);
        myFile1.closeFile();

        //Always close
        fileReader.close();


        /////////////////AT THIS POINT SHOPPING CART 2 HAS ALL THE ID's AND NAMES/////////////////////////////////


        LineReader reader = new LineReader(fileArts);
        String musicID;
        String title;
        String thirdEntry = null;
        String appValue;
        String artName;
        int appraisedValueTotal = 0;
        int artWork = 0;

        while ((line = reader.readLine()) != null) {

            //split each line at the tabbed space and place in and array
            try {
                String splitArray2[] = line.split("\t");
                musicID = splitArray2[0];    //ArtID
                title = splitArray2[1];      //Title
                thirdEntry = splitArray2[2]; //artistID
                appValue = splitArray2[3];   //appraisedValue

                //convert the string to an integer
                int artistID = (Integer.valueOf(thirdEntry));
                appraisedValueTotal += (Integer.valueOf(appValue));
                artWork++;

                //go to the artTable
                //get the catalog object that is at the artistID's index position
                //return the name using the ID
                artName = artTable.get(artistID-1).getNameById(artistID);
                String record = (musicID + "\t" + title + "\t" +artName+ "\t" + thirdEntry + "\t" + appValue);
                System.out.println(record);
                myFile2.addRecords(record + "\n");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        String finalRecord = ("\n" + "Total number of artists: "+ thirdEntry + "\n"
                + "Total number of titles: "+ artWork + "\n"
                + "Total appraised Value: $"+ appraisedValueTotal);
        myFile2.addRecords(finalRecord);

        myFile2.closeFile();

    }

    private static void makeFile(ArrayList<Artist> aList, CreateFile aFile)
    {
        String records;

        System.out.println("The cart contains the following: ");
        Object[] listArray = aList.toArray();
        for (Object aListArray : listArray) {
            records = (aListArray.toString()+ " \n");
            //writer.println(record);
            aFile.addRecords(records);
            //  System.out.println(record);
        }

        aFile.closeFile();
        System.out.println();
    }


}






