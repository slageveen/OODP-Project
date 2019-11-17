import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Movie Manager for movies which handles all interfacing with the Movie class.
 * has all the static methods to seperate from the purely
 *
 */

public class MovieControl {

    private static ArrayList<Movie> allMovies = null;

    public static void Reinitialize(){

        if ((allMovies = (ArrayList<Movie>) Data.getInstance().getObjectFromPath(SaveLoadPath.MOVIE_PATH,Movie.class)) == null){
            allMovies = new ArrayList<>();
        }
    }

    public MovieControl() {
    }

    public static void addMovieListing(ArrayList<Movie> movie) {

        ArrayList<Movie> movies= getAllMovies();
        movies.addAll(movie);
        Data.saveObjectToPath(SaveLoadPath.MOVIE_PATH,movies);

    }

    public static void addMovieListing(Movie movie) {

        if (!allMovies.contains(movie)) {
            allMovies.add(movie);
            Data.getInstance().saveObjectToPath(SaveLoadPath.MOVIE_PATH, allMovies);
        }

    }

    public static ArrayList<Movie> getMoviesByTicketSales() {

        ArrayList<String> ticketSalesName = getAllMoviesNames();
        Map<String, Integer> ticketSales = new HashMap<String, Integer>();
        for (int i = 0; i < ticketSalesName.size(); i++) {
            ticketSales.put(ticketSalesName.get(i), 0);
        }

        HashSet<Booking> bookings = new HashSet<>(BookingControl.getBookings());
        for (Booking booking : bookings) {
            for (Ticket ticket : booking.getTickets()) {
                for (Map.Entry<String, Integer> entry : ticketSales.entrySet()) {
                    if (ticket.getShowingMovieName().equals(entry.getKey()))
                        entry.setValue(entry.getValue() + 1);
                }
            }
        }

        ticketSales.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
        return null;
    }

    public static ArrayList<Movie> getAllMoviesByRating() {
        Reinitialize();
        int i = 0;
        ArrayList<Movie> movies = new ArrayList<>();
        System.out.println("The top rated movies are \n");
        ArrayList<Review> sortedList = ReviewControl.getAllReviews();
        sortedList.sort(new CustomComparitor());
        String oldReviewMovie = sortedList.get(0).getMovieName();
        Review oldReview;
        double total;
        boolean exitCond=false;
        for (i = 0; i < sortedList.size(); i++) {
            total = 0;
            int j = 0;
            int index = i;

            oldReviewMovie = sortedList.get(i).getMovieName();

            while (i+j < sortedList.size() && j+index < sortedList.size() &&sortedList.get(i+j).getMovieName().equals(oldReviewMovie)) {
                System.out.println("old -" + oldReviewMovie);
                System.out.println("new - i + j- " + sortedList.get(i+j).getMovieName() +"\n");
                total += sortedList.get(index+j).getRating();
                oldReview = sortedList.get(index+j);
                oldReviewMovie = oldReview.getMovieName();
                j++;
                if(index+j == sortedList.size())
                    exitCond = true;

            }

            for(Movie movie:getAllMovies()){
                if (movie.getName().equalsIgnoreCase(sortedList.get(i).getMovieName()))
                    movies.add(movie);
            }
            //System.out.println("total " + sortedList.get(i).getMovieName() + " " + total + "\n");

            if (exitCond)
                break;
        }

        return movies;
    }

    public static Movie getMovie(String name) {

        Reinitialize();

        for (int i =0; i< allMovies.size();i++) {
            if(allMovies.get(i).getName().equals(name));
            return allMovies.get(i);
        }
        return null;
    }

    public static ArrayList<String> getAllMoviesNames() {

        Reinitialize();

        System.out.println("All movies are\n");

        ArrayList<String> names = new ArrayList<>();

        for (Movie movie:allMovies){

            names.add(movie.getName());

        }

        return names;
        //System.out.println("All Movies: " + uniqueMovies);
    }

    public static ArrayList<Movie> getAllMovies() {

        return (ArrayList<Movie>) Data.getObjectFromPath(SaveLoadPath.MOVIE_PATH,Movie.class);
        //System.out.println("All Movies: " + uniqueMovies);
    }


    private static class CustomComparitor implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }


//    public static void addLocation(Showing showing,String cineplexName,int whichCinema){
//
//        for (Movie mov: allMovies){
//
//            if (mov.equals(showing.getMovie())){
//
//                CineplexControl.addShowingToCinema(showing);
//                Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH,CineplexControl.getCineplexes());
//
//            }
//
//        }
//
//    }
//
//    public static void RemoveLocation(Movie movie,String cineplexName){
//
//        for (Movie mov: allMovies){
//
//            if (mov.equals(movie)){
//                if(CineplexControl.getCineplex(cineplexName).getMovies().size()!=0) {
//                    CineplexControl.getCineplex(cineplexName).getMovies().remove(movie);
//                    MovieControl.getAllMovies().remove(movie);
//                }
//                Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH,CineplexControl.getCineplexes());
//
//            }
//
//        }
//
//    }

}
