<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>ButterLink - Welcome</title>
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

    if ( currentSession != null ) {

%>
            <li><a href="/links">Mes URLs</a></li>
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
    <li><a href="/links"><i class="material-icons">call_split</i>Mes URLs</a></li>
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

</ul>

<div class="row">
    <div class="col s10 m8 offset-s1 offset-m2" style="margin-top: 30px;">
        <div class="card-panel ">
            <h3 class="center">Raccourcir une URL</h3>
            <div class="row">
                <form class="col s12" action="/generate" method="post">
                    <input type="hidden" name="isLogged" value="<%= ( currentSession != null ) ? "1" : "0" %>">
                    <div class="row">
                        <div class="input-field col s10 offset-s1" style="margin-top: 70px;">
                            <i class="mdi-communication-email prefix"></i>
                            <input id="url" type="text" name="url" class="validate">
                            <label for="url">URL à raccourcir</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s8 m8 offset-s2 offset-m2">
                            <p>
                                <label>
                                    <input type="text" class="filled-in" name="password" placeholder="password"/>
                                </label>
                            </p>
<%

    if ( currentSession != null ) {

%>
                            <p>
                                <label>
                                    <input type="checkbox" name="captcha" class="filled-in" />
                                    <span >Captcha</span>
                                </label>
                            </p>

                            <p>
                                <label>
                                    <input type="date" name="expire_date" class="filled-in" placeholder="date d'expiration"/>
                                </label>
                            </p>

                            <p>
                                <label>
                                    <input type="text" name="max_clics" class="filled-in" placeholder="limite de clics" />
                                </label>
                            </p>
<%

    }

%>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <button type="submit" class="btn waves-effect waves-light right">
                                <h6>Raccourcir</h6>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function() {
        $('.sidenav').sidenav();
    });
</script>

</html>