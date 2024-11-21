package dal;

public abstract class DAOBuilder {
	// DAOA OR DAOB
	public static final DAOInterface DAO = new DAOA();
	
	public static DAOInterface createInstance() {
		return DAO;
	}
}
