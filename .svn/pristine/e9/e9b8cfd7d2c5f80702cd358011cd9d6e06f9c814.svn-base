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
<%ArrayList<Secom_doc> list = (ArrayList<Secom_doc>) request.getAttribute("secomarray");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String t = new SimpleDateFormat("HH").format(tm);
    String year = new SimpleDateFormat("yyyy").format(tm);
%>

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
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="fonts/font.css" rel="stylesheet" type="text/css">
        <link href="fonts/font2.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="brand"><a href="http://www.bhmn.mb" style="margin-left: 0px; margin-right: 45px; margin-bottom: 0px"><img src="img/logos/BHMN.png" class="" alt="" width="70"></a>
            Base de Hidrografia da Marinha em Niterói
            <a href="http://www.mar.mb" style="margin-left:45px; margin-right:0px; margin-bottom: 0px" ><img src="img/logos/navy.png" class="" alt="bhmn" width="180" ></a></div> 

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
                                <li><a href="http://dpmm.mb/?q=node/97">SiSBOL</a></li>
                                <li><a href="http://www.aplicacoes.dpmm.mb/seguranca/login.asp">BDPes</a></li>
                                <li><a href="https://bponline.papem.mar.mil.br/views/default.php">BP On-line</a></li>
                                <li><a href="https://econsigmb.papem.mar.mil.br/mb/login/login_servidor.jsp#no-back">eConsig</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="http://www.sigbase.mb/?q=imce" style="color: black">Licitações</a>
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
                        <%if (list.size() == 0) {%>
                        <h2 class="intro-text text-center">
                            <strong>Nenhum documento encontrado!</strong>
                        </h2>
                        <%} else {%>
                        <h2 class="intro-text text-center">
                            <strong><%out.print(list.size());%> documento(s) encontrado(s):</strong>
                        </h2>
                        <%}%>

                        <hr>
                        <hr class="visible-xs">
                        <div class="content-panel">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Documento</th>
                                        <th><i class="text-center"></i> Tipo de documento</th>
                                        <th><i class="text-center"></i> Ano</th>
                                        <th><i class="text-center"></i> Mês</th>
                                        <th><i class="text-center"></i> Cadastrado Por:</th>
                                        <th><i class="text-center"></i> Data/Hora de Cadastro</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Secom_doc secom : list) {%>
                                    <tr>
                                        <td><a href="<%out.print(secom.getDoc());%>" target="_blank"> <%out.print(secom.getNome_doc());%></a></td>
                                        <td><%out.print(secom.getType_doc());%></td>
                                        <td><%out.print(secom.getAno_doc());%></td>
                                        <%switch(secom.getMes_doc()){
                                            case 1: %><td>Janeiro</td><% break;
                                            case 2: %><td>Fevereiro</td><% break;
                                            case 3: %><td>Março</td><% break;
                                            case 4: %><td>Abril</td><% break;
                                            case 5: %><td>Maio</td><% break;
                                            case 6: %><td>Junho</td><% break;
                                            case 7: %><td>Julho</td><% break;
                                            case 8: %><td>Agosto</td><% break;
                                            case 9: %><td>Setembro</td><% break;
                                            case 10: %><td>Outubro</td><% break;
                                            case 11: %><td>Novembro</td><% break;
                                            case 12: %><td>Dezembro</td><% break;
                                        }%>
                                        <td><%out.print(secom.getUser());%></td>
                                        <td><%out.print(secom.getDatacad());%> às <%out.print(secom.getHoracad());%></td>
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
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

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
