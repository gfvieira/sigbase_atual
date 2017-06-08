<%@page import="src.modelo.Pesquisa_model"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="src.modelo.Resposta_model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%ArrayList<Resposta_model> list = (ArrayList<Resposta_model>) request.getAttribute("resultado");
    ArrayList<Pesquisa_model> list1 = (ArrayList<Pesquisa_model>) request.getAttribute("protocolo");
    DecimalFormat df = new DecimalFormat("0.0");%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>= BHMN =</title>
        <link rel="shortcut icon" href="assets/images/gt_favicon.png">

        <!-- Bootstrap Core CSS -->
        <link href="assets3/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets3/css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="assets3/fonts/font.css" rel="stylesheet" type="text/css">
        <link href="assets3/fonts/font2.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!--[endif]-->

    </head>

    <body>

        <div class="brand"><a href="/sigbase/index.html" style="margin-left: 0px; margin-right: 400px; margin-bottom: 0px"><img src="assets3/img/logos/BHMN.png" class="" alt="" width="80"></a>
            SIG-BASE
            <a href="http://www.mar.mb" style="margin-left:400px; margin-right:0px; margin-bottom: 0px" ><img src="assets3/img/mb.png" class="" alt="bhmn" width="80" ></a></div> 

        <div class="address-bar">Sistema de Informações Gerenciais da Base de Hidrografia da Marinha em Niterói</div>

        <!-- Navigation -->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                    <a class="navbar-brand" href="index3.html">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Serviço CNPA<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="sistemas/trocadeServico.jsp">Troca de Serviço</a></li>
                                <li><a href="sistemas/logintrocaServico.jsp">Acesso ao sistema</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="loginSigbase.jsp" style="color: black">Sig-base</a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Pedido de Serviço<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="emConstrucao.html">Ofícina BH-10</a></li>
                                <li><a href="pedido/oficinabh34.html">Telemática BH-34</a></li>
                                <li><a href="pedido/oficinabh50.html">Ofícina BH-50</a></li>
                                <li><a href="pedido/oficinabh50_viatura.html">Viatura BH-50</a></li>
                                <li><a href="emConstrucao.html">Atracação Navio MB</a></li>
                                <li><a href="emConstrucao.html">Atracação Navio Extra-MB</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Pesquisas <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="pesquisa/ResultadoPremiomais.jsp">Premio Ser humano +</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="manual.html" style="color: black">Como Utilizar?</a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Telemática<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="http://www.bhmn.mb:8080/telematica/">Home</a></li>
                                <li><a href="http://www.bhmn.mb:8080/telematica/down.html">Documentos</a></li>
                                <li><a href="http://www.bhmn.mb:8080/telematica/down.html">Downloads</a></li>
                                <li><a href="http://www.bhmn.mb:8080/telematica/video.html">Videos</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Premio Ser humano +
                    </h2>
                    <hr>
                    <br> 
                    <br> 
                    <h2 class="intro-text text-center">Perguntas</h2>
                    <br>
                    <label>1- VOCÊ CONHECE O INFORMATIVO BHMNEWS?</label>
                    <label>2- VOCÊ ACHA QUE O INFORMATIVO BHMNEWS CUMPRE O SEU PROPÓSITO DE VALORIZAR AS PESSOAS?</label>
                    <label>3- VOCÊ LÊ AS MATÉRIAS DO INFORMATIVO BHMNEWS?</label>
                    <label>4- VOCÊ JÁ SE VIU ALGUMA VEZ NAS PAGINAS DO BHMNEWS?</label>
                    <label>5- O SEU SETOR DE TRABALHO JÁ FOI CITADO ALGUMA VEZ NO BHMNEWS?</label>
                    <label>6- VOCÊ ACHA IMPORTANTE QUE O BHMNEWS TENHA CONTINUIDADE?</label>
                    <br> 
                    <br>                    
                    <h2 class="intro-text text-center">Resultado</h2>
                    <br><br>
                    <%int total = 0;%>
                    <%for (Resposta_model result : list) {
                            total = (int) result.getTotal();
                            if (result.getTotal() != 0) {%>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th><i class="fa fa-angle-double-right text-center"></i><%out.print(result.getDep());%></th>
                                <th><i class="fa fa-angle-double-right text-center"></i>Total:</th>
                                <th><i class="fa fa-angle-double-right text-center"></i><%out.print(result.getTotal());%></th>
                            </tr>
                            <tr>
                                <td><i class="center-block"></i>Pergunta 1</td>
                                <td><i class="center-block"></i> </td>
                                <td><i class="center-block"></i>Pergunta 2</td>
                                <td><i class="center-block"></i> </td>
                                <td><i class="center-block"></i>Pergunta 3</td>
                                <td><i class="center-block"></i> </td>
                                <td><i class="center-block"></i>Pergunta 4</td>
                                <td><i class="center-block"></i> </td>
                                <td><i class="center-block"></i>Pergunta 5</td>
                                <td><i class="center-block"></i> </td>
                                <td><i class="center-block"></i>Pergunta 6</td>
                                <td><i class="center-block"></i> </td>
                            </tr>
                            <tr>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp1() / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp2() / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp3() / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp4() / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp5() / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Sim</td>
                                <td><i class="center-block"></i><%out.print(df.format((result.getResp6() / result.getTotal()) * 100));%>%</td>
                            </tr>
                            <tr>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp1()) / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp2()) / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp3()) / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp4()) / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp5()) / result.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i>Não</td>
                                <td><i class="center-block"></i><%out.print(df.format(((result.getTotal() - result.getResp6()) / result.getTotal()) * 100));%>%</td>
                            </tr>
                        </tbody>
                    </table>
                    <%} else {%>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th><i class="fa fa-angle-double-right text-center"></i><%out.print(result.getDep());%> Dados não computados </th>
                            </tr>
                        </tbody>
                    </table>
                    <%}
                        }%>

                    <br><br><h2 class="intro-text text-center"><%out.print(total);%> Resultados registrados
                    </h2><br><br>
                    <hr>
                    <h2 class="intro-text text-center">Protocolos
                    </h2>
                    <hr>
                    <%String temp = "";%>
                    <%int count = 0;%>
                    <%for (Pesquisa_model result1 : list1) {
                            if (result1.getSetor().equals("BH-01")) {
                                if (!result1.getSetor().equals(temp)) {
                                    temp = result1.getSetor();
                                    out.println("<br><br>" + result1.getSetor() + "<br>");
                                    out.print(result1.getProtocolo());
                                } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-02")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-04")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-05")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-06")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-07")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-08")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-10")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-20")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-30")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-40")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else if (result1.getSetor().equals("BH-50")) {
                        if (!result1.getSetor().equals(temp)) {
                            temp = result1.getSetor();
                            out.println("<br><br>" + result1.getSetor() + "<br>");
                            out.print(result1.getProtocolo());
                        } else {%>
                    / <%out.print(result1.getProtocolo());%>
                    <%}
                    } else {%>
                    <%out.print("<br><br>" + result1.getSetor() + "Nenhum protocolo registrado" + "<br>");%>
                    <%}%>
                    <%}%>
                    <br><br>
                    <br><br> 
                </div>
            </div>
        </div>
        <!-- /.container -->

        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal1" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Comunicado aos servidores ? Pesquisa GPTW</h4>
                    </div>
                    <div class="modal-body">                                          



                    </div>
                </div>
            </div>
        </div>


        <footer>
            <div class="container">
                <div class="row">
                    <br>
                    <div style="font-size:11px; padding-bottom: 30px" class="col-lg-12 text-center">
                        <p>Todos os Direitos Reservados © 2016 - Base de Hidrografia da Marinha em Niterói</p>
                        <p>Rua Barão de Jaceguai s/n - CEP: 24048-900 - Ponta da Armação - Niterói - RJ</p>
                        <p>Tel: 2189-3469 - Retelma: 8112-3469 - Fax: 2189-3467 </p>
                        <p>Tel: 2189-3186 - Retelma: 8112-3186 (Sala de Estado)</p>
                    </div>
                    <br>
                    <br>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="assets3/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="assets3/js/bootstrap.min.js"></script>

        <!-- Script to Activate the Carousel -->
        <script>
            $('.carousel').carousel({
                interval: 5000 //changes the speed
            })
        </script>
        <!--<script type="text/javascript">
            $(document).ready(function () {
                $('#myModal1').modal({
                    show: true
                });
            });
        </script>-->

    </body>

</html>
