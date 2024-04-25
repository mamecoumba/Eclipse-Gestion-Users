package form;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AddUserForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";

	private static final String EMPTY_FIELD_ERROR_MSG = "Vous devez renseigner ce champ";
	private static final String NON_CONFORM_PASSWORDS_ERROR_MSG = "Les mots de passe ne sont pas conformes";

	private Utilisateur utilisateur;
	private HashMap<String, String> erreurs;
	private HttpServletRequest request;
	private boolean status;
	private String statusMessage;

	public AddUserForm(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.statusMessage = "Echec de l'ajout !";
		this.erreurs = new HashMap<String, String>();
	}

	public boolean ajouter() {
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);

		this.utilisateur = new Utilisateur(nom, prenom, login, password);

		this.validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		this.validerPassword();

		if (this.erreurs.isEmpty())

		{
			this.status = UtilisateurDao.ajouter(utilisateur);

			if (this.status)

			{
				this.statusMessage = "Utilisateur ajouté avec succés !";
			}

		}

		return this.status;
	}

	private void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);

		if (password != null && passwordBis != null && !password.equals(passwordBis)) {
			this.erreurs.put(CHAMP_PASSWORD, NON_CONFORM_PASSWORDS_ERROR_MSG);
			this.erreurs.put(CHAMP_PASSWORD_BIS, NON_CONFORM_PASSWORDS_ERROR_MSG);
		}
	}

	public void validerChamps(String... champs) {
		for (String champ : champs) {
			if (this.getParameter(champ) == null)

			{
				this.erreurs.put(champ, EMPTY_FIELD_ERROR_MSG);
			}
		}

	}

	private String getParameter(String parameter)

	{
		String valeur = request.getParameter(parameter);

		if (valeur != null && !valeur.isBlank())

		{
			return valeur.trim();
		}

		return null;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public HashMap<String, String> getErreurs() {
		return erreurs;
	}

	public boolean getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

}
