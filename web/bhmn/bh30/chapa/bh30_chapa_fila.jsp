<%@page import="src.modelo.Chapa_model"%>
<%@page import="src.modelo.Secom_doc"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%ArrayList<Chapa_model> list = (ArrayList<Chapa_model>) request.getAttribute("chapa");
Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>= BHMN =</title>

        <!-- Bootstrap Core CSS -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets/css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="assets/fonts/font.css" rel="stylesheet" type="text/css">
        <link href="assets/fonts/font2.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="brand"><a href="http://www.bhmn.mb" style="margin-left: 0px; margin-right: 45px; margin-bottom: 0px"><img src="assets/img/logos/BHMN.png" class="" alt="" width="70"></a>
            Base de Hidrografia da Marinha em Niterói
            <a href="http://www.mar.mb" style="margin-left:45px; margin-right:0px; margin-bottom: 0px" ><img src="assets/img/logos/navy.png" class="" alt="bhmn" width="180" ></a></div> 

        <div class="address-bar">Diretoria de Hidrografia e Navegação</div>

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
                    <a class="navbar-brand" href="index.html">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="http://www.bhmn.mb/netuno.html" style="color: black">Programa Netuno</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.bhmn.mb/bhmnews.html" style="color: black">BHMNews</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.bhmn.mb/secom.html" style="color: black">SECOM</a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Sistemas<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="https://dhn3.dhn.mb/">Lotus Web</a></li>
                                <li><a href="http://www.bhmn.mb/sigdem.html">SiGDEM</a></li>
                                <li><a href="http://dpmm.mb/?q=node/97">SiSBOL</a></li>
                                <li><a href="http://www.aplicacoes.dpmm.mb/seguranca/login.asp">BDPes</a></li>
                                <li><a href="https://bponline.papem.mar.mil.br/views/default.php">BP On-line</a></li>
                                <li><a href="https://econsigmb.papem.mar.mil.br/mb/login/login_servidor.jsp#no-back">eConsig</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.bhmn.mb:8080/sigbase" style="color: black">SIG-BASE</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.bhmn.mb/chapa.html" style="color: black">CHaPA</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.bhmn.mb:8080/sigbase/bhmn/bh05/contact.html" style="color: black">Fale Conosco</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <%if (list.size() == 0) {%>
                        <h2 class="intro-text text-center">
                            <strong>Nenhum Militar encontrado!</strong>
                        </h2>
                        <%} else {%>
                        <h2 class="intro-text text-center">
                            <strong><%out.print(list.size());%> Militar(es) encontrado(s):</strong>
                        </h2>
                        <%}%>

                        <hr>
                        <hr class="visible-xs">
                        <%Timestamp tp = new Timestamp(System.currentTimeMillis());
                        String t = new SimpleDateFormat("HH:mm:ss").format(tp);
                        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(tp);%>
                        <p class="text-center" style="font-size: 12px">
                            Data da consulta: <%out.print(d1);%> às: <%out.print(t);%>        
                        </p>
                        <div class="content-panel">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th><i class="text-center"></i> Posição</th>
                                        <th><i class="text-centerr"></i> Posto/Grad</th>
                                        <th><i class="text-center"></i> Nome</th>
                                        <th><i class="text-center"></i> Nip</th>
                                        <th><i class="text-center"></i> OM</th>
                                        <th><i class="text-center"></i> Inscrição</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <%int count = 0;
                                            for (Chapa_model chapa : list) {%>
                                        <td><%out.print(++count);%></td>
                                        <%String grad = "";
                                            switch (chapa.getGrad()) {
                                                case 1:
                                                    grad = "MN-RC";
                                                    break;
                                                case 2:
                                                    grad = "MN";
                                                    break;
                                                case 3:
                                                    grad = "MNE";
                                                    break;
                                                case 4:
                                                    grad = "CB";
                                                    break;
                                                case 5:
                                                    grad = "3SG";
                                                    break;
                                                case 6:
                                                    grad = "2SG";
                                                    break;
                                                case 7:
                                                    grad = "1SG";
                                                    break;
                                                case 8:
                                                    grad = "SO";
                                                    break;
                                                case 9:
                                                    grad = "GM";
                                                    break;
                                                case 10:
                                                    grad = "2T";
                                                    break;
                                                case 11:
                                                    grad = "1T";
                                                    break;
                                                case 12:
                                                    grad = "CT";
                                                    break;
                                                case 13:
                                                    grad = "CC";
                                                    break;
                                                case 14:
                                                    grad = "CF";
                                                    break;
                                                case 15:
                                                    grad = "CMG";
                                                    break;
                                                case 16:
                                                    grad = "CA";
                                                    break;
                                                case 17:
                                                    grad = "VA";
                                                    break;
                                                case 18:
                                                    grad = "AE";
                                                    break;
                                                case 19:
                                                    grad = "SC";
                                                    break;
                                            }%>
                                        <td><%out.print(grad);%></td>
                                        <td><%out.print(chapa.getNome());%></td>
                                        <td><%out.print(chapa.getNip());%></td>
                                        <%String OM = "";
                                            switch (chapa.getOm()) {
                                                case 1:
                                                    OM = "BHMN";
                                                    break;
                                                case 2:
                                                    OM = "DHN";
                                                    break;
                                                case 3:
                                                    OM = "GNHO";
                                                    break;
                                                case 4:
                                                    OM = "CAMR";
                                                    break;
                                                case 5:
                                                    OM = "CHM";
                                                    break;
                                                case 6:
                                                    OM = "NApOc Ary Rongel";
                                                    break;
                                                case 7:
                                                    OM = "NHi Sirius";
                                                    break;
                                                case 8:
                                                    OM = "NHo amorim do Vale";
                                                    break;
                                                case 9:
                                                    OM = "NHo Cruzeiro do Sul";
                                                    break;
                                                case 10:
                                                    OM = "NHo Taurus";
                                                    break;
                                                case 11:
                                                    OM = "NHoF Graça Aranha";
                                                    break;
                                                case 12:
                                                    OM = "NOc Antares";
                                                    break;
                                                case 13:
                                                    OM = "NPo Maximiano";
                                                    break;
                                                case 14:
                                                    OM = "NPqHo Vital de Oliveira";
                                                    break;
                                            }%>
                                        <td><%out.print(OM);%></td>
                                        <td><%out.print(chapa.getMsg());%></td>
                                    </tr>
                                    <% }%>
                                </tbody>
                                </tbody>
                            </table>
                        </div>
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
        <script src="assets/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="assets/js/bootstrap.min.js"></script>

        <!--<script type="text/javascript">
            $(document).ready(function () {
                $('#myModal1').modal({
                    show: true
                });
            });
        </script>-->

    </body>

</html>
