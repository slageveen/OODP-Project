import java.util.ArrayList;

public class ShowingControl  {

    private static ArrayList<Showing> allShowings;

    public ShowingControl(){

    }

    public static void Initialize(){
        if ((allShowings = (ArrayList<Showing>) Data.getInstance().getObjectFromPath(SaveLoadPath.SHOWING_PATH,Showing.class)) == null){
            allShowings = new ArrayList<>();
        }
    }



    public static void addShowing(Showing showing){

        allShowings.add(showing);
        MovieControl.addLocation(showing,showing.getCineplex().getName(),showing.getTimeSlot());

    }

    public static boolean isAllocated(Showing showing, int i, int j)
    {
        if (showing.isAllocated(i, j) || showing.getSeatingPlan().getSeat(i, j).getType().equals(" "))
            return true;
        return false;
    }



    public static void printSeats(Showing showing)
    {
        Seat[][] seatingPlan = showing.getSeatingPlan().getSeats();
        
        for (int i = 0; i < seatingPlan.length; i ++)
        {
            for (int j = 0; j < seatingPlan[1].length; j++)
            {
                if (seatingPlan[i][j].isAllocated())
                    System.out.print("U");
                else
                    System.out.print(seatingPlan[i][j].getType());
            }
            System.out.println();
        }
    }


    public static ArrayList<Showing> getAllShowings() {
        return allShowings;
    }

    public static ArrayList<Showing> getAllShowingsAtCineplex(String cineplex) {

        int i = 0;
        System.out.println("All movies we have at your location\n");
        ArrayList<Cineplex> ar = new ArrayList<>();
        ArrayList<Showing> allAtLocation= new ArrayList<>();
        CineplexControl cp = new CineplexControl();

        for (Cineplex cpa:cp.getCineplexes()){

            if (cpa.getName().equals(cineplex)){

                for (Cinema cinema :cpa.getCinemas()) {

                    return cinema.getShowings();

                }

            }

        }
        return null;
    }

    public static ArrayList<Showing> getAllShowingOfMovie(Movie movie){

        ArrayList<Showing> allShowingsOfMovie = new ArrayList<>();

        for(Showing showing:allShowings) {
            if (movie.getName().equals(showing.getMovie().getName()) && showing.getMovie().getStatus() == Movie.Status.Showing) {

                allShowingsOfMovie.add(showing);

            }
        }

        return allShowingsOfMovie;
    }

}
