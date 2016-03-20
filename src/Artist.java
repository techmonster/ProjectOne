/**
 * Created by delog on 3/19/2016.
 */
public class Artist {
    private int artistID;
    private String artistName;
    private int musicID;
    private String title;
    private String appraisedValue;


    public Artist(int artistID, String artistName){

        this.artistID = artistID;
        this.artistName = artistName;
    }

    public Artist(int artistID, String artistName, int musicID, String title, String appraisedValue){
        setID(artistID);
        setName(artistName);
        setMusicID(musicID);
        setTitle(title);
        setAppraisedValue(appraisedValue);
    }

    public int getID() {
        return artistID;
    }

    public void setID(int artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return artistName;
    }

    public void setName(String artistName) {
        this.artistName = artistName;
    }

    public String getNameById(int artistID) {return this.artistName;}

    //@Override
    public String toString(){
        return getID()+"\t" + getName();

    }

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppraisedValue() {
        return appraisedValue;
    }

    public void setAppraisedValue(String appraisedValue) {
        this.appraisedValue = appraisedValue;
    }
}
