<%@ include file="../layouts/head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.dao.src.SiteSimple" %>
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
                        <th>Friendly url</th>
                        <th>Default url</th>
                        <th>Expire Date</th>
                        <th>Secure?</th>
                        <th>Password</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${sites}" var="site">
                        <tr>
                            <td>${site.key.captcha ? "Yes" : "No"}</td>
                            <td>${site.key.max_clic}</td>
                            <td>${site.key.nb_traffic}</td>
                            <td><a href="${site.value.friendly_url}"></a>${site.value.friendly_url}</td>
                            <td><a href="${site.value.default_url}"></a>${site.value.default_url}</td>
                            <td>${site.value.expire_date}</td>
                            <td>${site.value.is_secure == 1 ? "Yes" : "No"}</td>
                            <td>${site.value.password}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="../layouts/footer.jsp"%>
