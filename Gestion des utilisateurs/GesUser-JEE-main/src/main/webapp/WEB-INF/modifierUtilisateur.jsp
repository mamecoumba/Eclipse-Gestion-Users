<%@page import="beans.Utilisateur"%>
<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>

<%@include file="inc/header.jsp"%>	
<section>
        <h1 id="titre-principal">Modification d'un utilisateurs</h1>
        <form class="main" method="post">
            <div class="formItem">
                <label>Nom</label>
		        <input type="text" name="nom" value="${ utilisateur.nom }"/> <br>
            </div>
            <div class="formItem">
                <label>Prénom</label>
                <input type="text" name="prenom" value="${ utilisateur.prenom }" /><br>
            </div>
            <div class="formItem">
                <label>Login</label>
		        <input type="text" name="login" value="${ utilisateur.login }" /><br>
            </div>
		    <div class="formItem">
                <label>Password</label>
                <input type="password" name="password" value="${ utilisateur.password }" /><br>
            </div>
            <div class="formItem">
		        <input type="submit" value="Modifier" />
		    </div>
        </form>
     </section>
<%@include file="inc/footer.jsp"%>	