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
<%String protocolo = (String) request.getAttribute("protocolo");%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>= BHMN =</title>
        <link rel="shortcut icon" href="assets3/images/gt_favicon.png">

        <!-- Bootstrap Core CSS -->
        <link href="../../css/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../../css/css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <!--        <link href="css/fonts/font.css" rel="stylesheet" type="text/css">
                <link href="css/fonts/font2.css" rel="stylesheet" type="text/css">-->

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!--[endif]-->
    </head>

    <body>
        <div class="brand"><a href="http://www.bhmn.mb" style="margin-left: 0px; margin-right: 45px; margin-bottom: 0px"><img src="../../css/img/logos/BHMN.png" class="" alt="" width="70"></a>
            Base de Hidrografia da Marinha em Niterói
            <a href="http://www.mar.mb" style="margin-left:45px; margin-right:0px; margin-bottom: 0px" ><img src="../../css/img/logos/navy.png" class="" alt="bhmn" width="180" ></a></div> 

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
                            <a href="netuno.html" style="color: black">Programa Netuno</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="bhmnews.html" style="color: black">BHMNews</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="secom.html" style="color: black">SECOM</a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Sistemas<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="http://www.bhmn.mb:8080/sigbase">SIG-BASE</a></li>
                                <li><a href="https://dhn3.dhn.mb/">Lotus Web</a></li>
                                <li><a href="sigdem.html">SiGDEM</a></li>
                                <li><a href="http://www.sigbase.mb/?q=imce">Licitações</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="#" style="color: black">Sustentabilidade</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="chapa.html" style="color: black">CHaPA</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="contact.html" style="color: black">Fale Conosco</a>
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
                        <h2 class="intro-text text-center">
                            <strong>A Base de Hidrografia agradece a sua colaboração!</strong>
                        </h2>
                        <hr>
                        <br><br>
                        <div class="content-panel">
                            <p class="text-center" style="font-size: 17px">Sua mensagem foi registrada em nosso sistema e gerou um número de protocolo para acompanhamento:</p>
                            <p class="text-center" style="font-size: 20px; color: red"> <%out.print(protocolo);%>
                            <p class="text-center" style="font-size: 12px">(Guarde este número pois através dele será possível visualizar a sua resposta!)</p>
                        </div>
                            <br><br>
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
