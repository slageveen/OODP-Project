import java.util.Scanner;


public class ClientApp {
    private Client current;

    public ClientApp (Client current) {
        this.current = current;
        run();
    }

    private void run() {
        int sc_in;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Welcome " + current.getName());
            System.out.println
                    ("1. Display movies " +
                            "\n2. Search for a movie" +
                            "\n3. Display all cineplexes" +
                            "\n4. View booking history" +                            
                            "\n5. Exit\n");


            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    System.out.println("Would you like to see \n1. Every movie\n2. Top 5 movies by ticket sales\n3. Top 5 movies by review score");
                    sc_in = sc.nextInt();
                    MovieControl mc = MovieControl.getInstance();
                    switch (sc_in) {
                        case 1:
                            mc.printAllMoviesByName();
                            break;
                        case 2:
                            mc.printMoviesByTicketSales();
                            break;
                        case 3:
                            mc.setAllMoviesByRating();
                    }

                    //TODO allow user to choose one of the movies
                    //TODO follow through to the next case (case 2) from here

                case 2:
                    //TODO take user input for a movie title and return that movie information (cast etc)
                    String mov;
                    System.out.println("Enter movie name: ");
                    mov = sc.next();
                    searchMovie(mov);

                    System.out.println("Would you like to see \n1. Reviews \n2. Listings\n for this movie?");
                    sc_in = sc.nextInt();
                    switch (sc_in) {
                        case 1:
                            //TODO Show reviews for the movie
                        case 2:
                            //TODO Show listings for the movie
                            //TODO allow user to choose listing
                            bookMovie();
                    }
                   
                case 3:
                    //TODO display every cineplex 
                    //TODO allow user to choose their cineplex
                    //TODO show movie listings for their chosen cineplex
                    //TODO allow user to choose listing
                    bookMovie();
                case 4:
                    //TODO display user's booking history
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);
    }

    public void bookMovie()
    {
        //TODO show user the room layout for their listing
        //TODO let user choose a seat and display the price
        //TODO process the booking
    }


    public void searchMovie(String movie){
        //TODO find movie
    }

}
