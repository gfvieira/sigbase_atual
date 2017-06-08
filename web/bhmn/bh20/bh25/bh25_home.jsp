<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    int semana1 = (Integer) request.getAttribute("semana1");
    int semana2 = (Integer) request.getAttribute("semana2");
    int semana3 = (Integer) request.getAttribute("semana3");
    int semana4 = (Integer) request.getAttribute("semana4");
    double qntd = semana1 + semana2 + semana3 + semana4;
    DecimalFormat df = new DecimalFormat("0.00");
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    int temp = Integer.parseInt(new SimpleDateFormat("MM").format(tm));
    String mes = "";
    switch(temp){
        case 1: mes = "Janeiro"; break;
        case 2: mes = "Fevereiro"; break;
        case 3: mes = "Março"; break;
        case 4: mes = "Abril"; break;
        case 5: mes = "Maio"; break;
        case 6: mes = "Junho"; break;
        case 7: mes = "Julho"; break;
        case 8: mes = "Agosto"; break;
        case 9: mes = "Setembro"; break;
        case 10: mes = "Outubro"; break;
        case 11: mes = "Novembro"; break;
        case 12: mes = "Dezembro"; break;
    }

%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE</title>

        <!-- Bootstrap core CSS -->
        <!-- Bootstrap core CSS -->
        <link href="../../assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../../assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../../assets3/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="../../assets3/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="../../assets3/lineicons/style.css">    

        <!-- Custom styles for this template -->
        <link href="../../assets3/css/style.css" rel="stylesheet">
        <link href="../../assets3/css/style-responsive.css" rel="stylesheet">

        <script src="../../assets3/js/chart-master/Chart.js"></script>
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="../../assets3/js/time_session.js" type="text/javascript"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Clique Aqui Para Abrir/Fechar Menu"></div>
                </div>
                <!--logo start-->
                    <a href="#" class="logo"><b>SIG-BASE || MUNICIAMENTO</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li>
                            <div style="margin-top: 22px; margin-right: 20px; color: white">
                                <div id="timeout"></div>
                            </div>
                        </li>
                        <li>
                            <div class="btn-group" style="margin-top: 15px">
                                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-cog"></i> <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li><a href="#">Perfil</a></li>
                                    <li><a href="#">Alterar Senha</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="/sigbase/LogOff.jsp">Sair</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <h5 class="centered"><%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%></h5>
                        <h5 class="centered"> 
                            <script language=javascript type="text/javascript">
                                document.write(dayName[now.getDay() ] + ", " + now.getDate() + " de " + monName [now.getMonth() ] + " de " + now.getFullYear());
                            </script>
                        </h5>
                        <h5 class="centered"><div id="txt"></div></h5>
                        <%if (usuario.getPri().equals("TOTAL")) {%>
                        <li class="mt">
                            <a class="active" href="../../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="../bh20_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-20</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="Contador25.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-25</span>
                            </a>
                        </li>
                        <%} else if (usuario.getPri().equals("BH20")) {%>
                        <li class="mt">
                            <a class="active" href="../bh20_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-20</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="Contador25.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-25</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="Contador25.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%> 
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Pesquisas</span>
                            </a>
                            <ul class="sub">
                                <li><a class="fa fa-angle-double-down"> Praça D'armas</a></li>
                                <li><a href="Pergunta.jsp?type=1">Perguntas</a></li>
                                <li><a href="Pergunta.jsp?type=99">Historico de perguntas</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Indicadores Praça D'armas</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh25_semanal.jsp">Semanal</a></li>
                                <li><a href="bh25_diario.jsp">Diario</a></li>
                                <li><a href="Contador25.jsp">semanal X Quantidade</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12 main-chart">
                            <div class="row">
                                <div class="col-lg-12 main-chart">
                                    <div class="content-panel">		
                                        <div class="border-head">
                                            <h3><b>Demostrativo semanal X Quantidade de avaliação</b> do mês de <%out.print(mes);%></h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(qntd));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(qntd / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="margin: 0px 8%;">
                                                <div class="title">01-07</div>
                                                <div class="value tooltips" data-original-title="<%out.print(semana1);%>" data-toggle="tooltip" data-placement="top"><%out.print((semana1 * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 8%;">
                                                <div class="title">08-14</div>
                                                <div class="value tooltips" data-original-title="<%out.print(semana2);%>" data-toggle="tooltip" data-placement="top"><%out.print((semana2 * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 8%;">
                                                <div class="title">15-21</div>
                                                <div class="value tooltips" data-original-title="<%out.print(semana3);%>" data-toggle="tooltip" data-placement="top"><%out.print((semana3 * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 8%;">
                                                <div class="title">22-31</div>
                                                <div class="value tooltips" data-original-title="<%out.print(semana4);%>" data-toggle="tooltip" data-placement="top"><%out.print((semana4 * 100) / qntd);%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </section>

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2015 - BHMN
                    <a href="index.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets2/js/jquery.js"></script>
        <script src="assets2/js/jquery-1.8.3.min.js"></script>
        <script src="assets2/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets2/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets2/js/jquery.scrollTo.min.js"></script>
        <script src="assets2/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="assets2/js/jquery.sparkline.js"></script>


        <!--common script for all pages-->
        <script src="assets2/js/common-scripts.js"></script>

        <script type="text/javascript" src="assets2/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="assets2/js/gritter-conf.js"></script>

        <!--script for this page-->
        <script src="assets2/js/sparkline-chart.js"></script>    
        <script src="assets2/js/zabuto_calendar.js"></script>	


    </body>
</html>
