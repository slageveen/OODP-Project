import java.util.ArrayList;
import java.util.Scanner;

public class main {

	User currentUser;
	static Scanner sc = new Scanner(System.in);
	static MovieReview movieReview = MovieReview.getInstance();
	static ArrayList<Cineplex> cineplexes = new ArrayList<>();
	static ArrayList<Movie> movieListings = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("Welcome to MOBLIMA, the best way book your movie tickets.");
		System.out.println("What would you like to do?");
		loginScreen();
	}

	private static void loginScreen() {
		int sc_in;
		boolean loggedin = false;

		do {
			System.out.println("1. Login \n2. Continue as Guest \n3. Client Register\n4. Exit");
			sc_in = sc.nextInt();
			switch (sc_in) {
				case 1:
					loggedin = Login();
					break;
				case 2:
//					TODO make guest
					loggedin = true;
					break;
				case 3:
					loggedin = true;
					break;
				case 4:
					break;

                case 5:
					movieReview.addReview(new Review("pretty good i like","shrek",2,new Client("helol")));
					movieReview.addReview(new Review(" good i like","shrek",4,new Client("helol")));
					movieReview.addReview(new Review("pretty good i like","shrek",5,new Client("helol")));
					movieReview.addReview(new Review("pretty good i like","phineas",1,new Client("helol")));
					movieReview.addReview(new Review("pretty good i like","ferb",2,new Client("helol")));


					MovieEntity.printAllMoviesByRating();
					break;
				default:
					System.out.println("Invalid input, please choose from the following:");
					break;
			}

		} while (sc_in != 4 && !loggedin);
	}

	private static boolean Login() {
//		Maybe move this inside LogIn and pass allong the scanner or something?
		System.out.println("Please enter username or type 'back' to return");
		String user = sc.next();
		if (!user.equalsIgnoreCase("back") && !user.isEmpty()) {
			System.out.println("Please enter password or type 'back' to return");
			String pass = sc.next();
			if (!pass.equalsIgnoreCase("back") && !pass.isEmpty()) {
				String response = LogIn.checkLogin(user, pass);
				if(!response.isEmpty()) {
					LogIn.loadUser(response);
					return true;
				} else {
					System.out.println("User not found");
				}
			}
		}
		return false;
	}

}
