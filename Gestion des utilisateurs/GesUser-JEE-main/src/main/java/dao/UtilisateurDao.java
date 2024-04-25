package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {

	private static int lastId = 1;
	private static final ArrayList<Utilisateur> ListUtilisateur = new ArrayList<Utilisateur>();

	public static ArrayList<Utilisateur> lister() {
		return ListUtilisateur;

	}

	public static boolean ajouter(Utilisateur utilisateur) {
		utilisateur.setId(lastId++);
		ListUtilisateur.add(utilisateur);
		return true;
	}

	public static Utilisateur get(int id) {
		for (Utilisateur utilisateur : ListUtilisateur) {
			if (utilisateur.getId() == id) {
				return utilisateur;
			}
		}
		return null;
	}

	public static boolean supprimer(int id) {

		for (Utilisateur utilisateur : ListUtilisateur) {
			if (utilisateur.getId() == id) {
				ListUtilisateur.remove(utilisateur);
				return true;
			}
		}
		return false;
	}

	public static boolean modifier(Utilisateur user) {

		for (Utilisateur utilisateur : ListUtilisateur) {
			if (utilisateur.getId() == user.getId()) {
				utilisateur.setNom(user.getNom());
				utilisateur.setPrenom(user.getPrenom());
				utilisateur.setLogin(user.getLogin());
				utilisateur.setPassword(user.getPassword());

				return true;
			}
		}
		return false;
	}

}
