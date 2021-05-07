package registerSimulation.googleAuthorization;

public class GoogleAuthorizationManager {

	public void register(String email, String password) {
		System.out.println(" google authorization kaydý gerçekleþti : " + email);
	}

	public boolean login(String email, String password) {
		System.out.println(" google ile login olundu : " + email);
		return true;
	}

	public void logOut(String email) {
		System.out.println("Google ile çýkýþ yapýldý : " + email);
	}

}
