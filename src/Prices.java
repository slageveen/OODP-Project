import java.io.Serializable;
import java.util.ArrayList;

public class Prices implements Serializable
{
    private int BASE_ADULT;
    private int BASE_CONCESSION;
    private int HOLIDAY_MARKUP;
    private int PREMIUM_MOVIE_MARKUP;
    private int PREMIUM_CINEMA_MARKUP;
    private int PREMIUM_SEAT_MARKUP;

    private static ArrayList<String> HOLIDAYS = new ArrayList<>();

    public static void Initialize(ArrayList<Prices> initialPrices){
    
        Data.saveObjectToPath(SaveLoadPath.PRICE_PATH, initialPrices);

    }

    public Prices(int bASE_ADULT, int BASE_CONCESSION, int hOLIDAY_MARKUP, int pREMIUM_CINEMA_MARKUP, int pREMIUM_MOVIE_MARKUP, int PREMIUM_SEAT_MARKUP, ArrayList<String> holidays)
    {
        this.BASE_ADULT = bASE_ADULT;
        this.BASE_CONCESSION = BASE_CONCESSION;
        this.HOLIDAY_MARKUP = hOLIDAY_MARKUP;
        this.PREMIUM_CINEMA_MARKUP = pREMIUM_CINEMA_MARKUP;
        this.PREMIUM_MOVIE_MARKUP = pREMIUM_MOVIE_MARKUP;
        this.PREMIUM_SEAT_MARKUP = PREMIUM_SEAT_MARKUP;
        this.HOLIDAYS = holidays;
    }
    
/**
 * @return the pREMIUM_SEAT_MARKUP
 */
public int getPREMIUM_SEAT_MARKUP() {
    return PREMIUM_SEAT_MARKUP;
}
/**
 * @param pREMIUM_SEAT_MARKUP the pREMIUM_SEAT_MARKUP to set
 */
public void setPREMIUM_SEAT_MARKUP(int pREMIUM_SEAT_MARKUP) {
    PREMIUM_SEAT_MARKUP = pREMIUM_SEAT_MARKUP;
}

    /**
     * @param bASE_ADULT the bASE_ADULT to set
     */
    public void setBASE_ADULT(int bASE_ADULT) {
        BASE_ADULT = bASE_ADULT;
    }

    /**
     * @param BASE_CONCESSION the BASE_CONCESSION to set
     */
    public void setBASE_CONCESSION(int BASE_CONCESSION) {
        BASE_CONCESSION = BASE_CONCESSION;
    }

    /**
     * @param hOLIDAYS the hOLIDAYS to set
     */
    public void setHOLIDAYS(ArrayList<String> hOLIDAYS) {
        HOLIDAYS = hOLIDAYS;
    }

    public void addHolyday(String holiday)
    {
        HOLIDAYS.add(holiday);
    }

    /**
     * @param hOLIDAY_MARKUP the hOLIDAY_MARKUP to set
     */
    public void setHOLIDAY_MARKUP(int hOLIDAY_MARKUP) {
        HOLIDAY_MARKUP = hOLIDAY_MARKUP;
    }

    /**
     * @param pREMIUM_CINEMA_MARKUP the pREMIUM_CINEMA_MARKUP to set
     */
    public void setPREMIUM_CINEMA_MARKUP(int pREMIUM_CINEMA_MARKUP) {
        PREMIUM_CINEMA_MARKUP = pREMIUM_CINEMA_MARKUP;
    }

    /**
     * @param pREMIUM_MOVIE_MARKUP the pREMIUM_MOVIE_MARKUP to set
     */
    public void setPREMIUM_MOVIE_MARKUP(int pREMIUM_MOVIE_MARKUP) {
        PREMIUM_MOVIE_MARKUP = pREMIUM_MOVIE_MARKUP;
    }

    /**
     * @return the bASE_ADULT
     */
    public int getBASE_ADULT() {
        return BASE_ADULT;
    }

    /**
     * @return the BASE_CONCESSION
     */
    public int getBASE_CONCESSION() {
        return BASE_CONCESSION;
    }

    /**
     * @return the hOLIDAYS
     */
    public ArrayList<String> getHOLIDAYS() {
        return HOLIDAYS;
    }

    /**
     * @return the hOLIDAY_MARKUP
     */
    public int getHOLIDAY_MARKUP() {
        return HOLIDAY_MARKUP;
    }

    /**
     * @return the pREMIUM_CINEMA_MARKUP
     */
    public int getPREMIUM_CINEMA_MARKUP() {
        return PREMIUM_CINEMA_MARKUP;
    }

    /**
     * @return the pREMIUM_MOVIE_MARKUP
     */
    public int getPREMIUM_MOVIE_MARKUP() {
        return PREMIUM_MOVIE_MARKUP;
    }

}