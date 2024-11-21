package dal;

import dal.impl.UtilisateurBinaryImplDao;
import dal.impl.UtilisateurJsonImplDao;

public abstract class UtilisateurFactoryDao {

	public static UtilisateurDao createInstance(String dao) {
		if(dao.equals("json")) return jsonImpl();
		if(dao.equals("binary")) return binaryImpl();
		return null;
	}

	private static UtilisateurJsonImplDao jsonImpl() {
		return new UtilisateurJsonImplDao();
	}

	private static UtilisateurBinaryImplDao binaryImpl() {
		return new UtilisateurBinaryImplDao();
	}
}
