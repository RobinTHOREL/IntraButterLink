<%--
  Created by IntelliJ IDEA.
  User: Brixton le Brave
  Date: 25/05/2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ page pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8" />
            <title>ButterLink - Sites</title>
            <!-- Compiled and minified CSS -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" href="../assets/css/style.css">
        </head>

<body>

<nav>
    <a href="#" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center">ButterLink</a>
        <ul id="nav-mobile" class="left hide-on-med-and-down">
            <li><a href="sass.html">Présentation</a></li>
            <li><a href="/">Raccourcir</a></li>
            <%
                String currentSession = (String) session.getAttribute( "currentSessionUser" );
                String currentId = (String) session.getAttribute( "currentSessionId" );

                if ( currentSession != null ) {

            %>
            <li><a href="/sites" class="active">Mes URLs</a></li>
            <li><a href="/stats">Statistiques</a></li>
            <li><a href="/logout">Se déconnecter</a></li>

            <%
                }
                if ( currentSession == null ) {

            %>
            <a class="btn-floating btn-large halfway-fab waves-effect waves-light teal" href="/login">
                <i class="material-icons">add</i>
            </a>

            <%
            } else {
            %>
            <a class="btn-floating btn-large halfway-fab waves-effect waves-light teal" href="/profile">
                <i class="material-icons">person</i>
            </a>
            <%
                }
            %>
        </ul>
    </div>
</nav>

<ul id="slide-out" class="sidenav">
    <li>
        <div class="user-view">
            <div class="background">
                <img src="http://materializecss.com/images/office.jpg">
            </div>

        </div>
    </li>
    <li><a href="#!"><i class="material-icons">chat_bubble_outline</i>Présentation</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a href="#!"><i class="material-icons">content_cut</i>Racccourcir une URL</a></li>
    <%

        if ( currentSession != null ) {

    %>
    <li><a href="/sites"><i class="material-icons">call_split</i>Mes URLs</a></li>
    <li><a href="/stats"><i class="material-icons">show_chart</i>Statistiques</a></li>
    <li><a href="/profile"><i class="material-icons">account_circle</i>Informations personnelles</a></li>
    <li><a href="/logout"><i class="material-icons">close</i>Se déconnecter</a></li>
    <%

    } else {

    %>
    <li><a href="/login"><i class="material-icons">account_circle</i>Se connecter</a></li>
    <%

        }

    %>

</ul></title>
</head>
<body>

</body>
</html>
