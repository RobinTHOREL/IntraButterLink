<%@ include file="../layouts/head.jsp"%>

<div class="row">
    <div class="col s10 m8 offset-s1 offset-m2" style="margin-top: 30px;">
        <div class="card-panel ">
            <h3 class="center">Mes URLS (<%= currentId %>)</h3>
            <div class="row">
                <table>
                    <thead>
                    <tr>
                        <th>Friendly URL</th>
                        <th>Default URL</th>
                        <th>Created date</th>
                        <th>Expire date</th>
                        <th>Stats</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td>Alvin</td>
                        <td>Eclair</td>
                        <td>$0.87</td>
                        <td>$0.87</td>
                        <td>$0.87</td>
                    </tr>
                    <tr>
                        <td>Alan</td>
                        <td>Jellybean</td>
                        <td>$3.76</td>
                        <td>$3.76</td>
                        <td>$3.76</td>
                    </tr>
                    <tr>
                        <td>Jonathan</td>
                        <td>Lollipop</td>
                        <td>$7.00</td>
                        <td>$7.00</td>
                        <td>$7.00</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="../layouts/footer.jsp"%>
