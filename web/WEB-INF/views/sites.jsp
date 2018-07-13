<%@ include file="../layouts/head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col s10 m8 offset-s1 offset-m2" style="margin-top: 30px;">
        <div class="card-panel ">
            <h3 class="center">Mes URLS (<%= currentId %>)</h3>


            <div class="row">

                <table>
                    <thead>
                    <tr>
                        <th>Captcha</th>
                        <th>Max clic</th>
                        <th>Nb trafic</th>
                        <th>id_simple_site</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${sites}" var="site">
                        <tr>
                            <td>${site.captcha}</td>
                            <td>${site.max_clic}</td>
                            <td>${site.nb_traffic}</td>
                            <td>${site.id_simple_site}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<%@ include file="../layouts/footer.jsp"%>
