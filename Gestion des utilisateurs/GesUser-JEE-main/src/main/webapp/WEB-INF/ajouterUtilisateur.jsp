<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@include file="inc/header.jsp"%>	
   <section>
    <c:if test="${!empty statusMessage}">
        <div class="alert alert-${status ? 'success' : 'danger'}">
            ${statusMessage}      
        </div>
    </c:if>
    
    <h1 id="titre-principal">Ajouter un utilisateur</h1>
    <form method="post" class="main">
        <div class="formItem">
            <label>Nom</label>
            <input type="text" name="nom" value="${utilisateur == null ? '' : utilisateur.nom}">
            <c:if test="${!empty erreurs.nom}">
                <span class="errorText">${erreurs.nom}</span>
            </c:if>
        </div>
        <div class="formItem">
            <label>Prénom</label>
            <input type="text" name="prenom" value="${utilisateur == null ? '' : utilisateur.prenom}">
            <c:if test="${!empty erreurs.prenom}">
                <span class="errorText">${erreurs.prenom}</span>
            </c:if>
        </div>
        <div class="formItem">
            <label>Login</label>
            <input type="text" name="login" value="${utilisateur == null ? '' : utilisateur.login}">
            <c:if test="${!empty erreurs.login}">
                <span class="errorText">${erreurs.login}</span>
            </c:if>
        </div>
        <div class="formItem">
            <label>Password</label>
            <input type="password" name="password">
            <c:if test="${!empty erreurs.password}">
                <span class="errorText">${erreurs.password}</span>
            </c:if>
        </div>
        <div class="formItem">
            <label>Password (confirmation)</label>
            <input type="password" name="passwordBis">
            <c:if test="${!empty erreurs.passwordBis}">
                <span class="errorText">${erreurs.passwordBis}</span>
            </c:if>
        </div>
        <div class="formItem"> 
            <input type="submit" value="Ajouter" />
        </div>
    </form>
</section>

<%@include file="inc/footer.jsp"%>	