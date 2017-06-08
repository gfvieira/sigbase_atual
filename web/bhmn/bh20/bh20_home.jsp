<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE</title>

        <!-- Bootstrap core CSS -->
        <!-- Bootstrap core CSS -->
        <link href="../assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../assets3/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="../assets3/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="../assets3/lineicons/style.css">    

        <!-- Custom styles for this template -->
        <link href="../assets3/css/style.css" rel="stylesheet">
        <link href="../assets3/css/style-responsive.css" rel="stylesheet">

        <script src="../assets3/js/chart-master/Chart.js"></script>
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="../assets3/js/time_session.js" type="text/javascript"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body onload="time()">

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="#" class="logo"><b>SIG-BASE || DEPARTAMENTO INTENDÊNCIA</b></a>
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
                            <a class="active" href="../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="bh20_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-20</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="bh20_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Metas BH-20</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh20_meta_inserir.jsp">Inserir</a></li>
                                <li><a href="ListaMeta.jsp?setor=21&userDiv=20&ano=<%out.print(year);%>">Visualizar BH-21</a></li>
                                <li><a href="ListaMeta.jsp?setor=22&userDiv=20&ano=<%out.print(year);%>">Visualizar BH-22</a></li>
                                <li><a href="ListaMeta.jsp?setor=23&userDiv=20&ano=<%out.print(year);%>">Visualizar BH-23</a></li>
                                <li><a href="ListaMeta.jsp?setor=24&userDiv=20&ano=<%out.print(year);%>">Visualizar BH-24</a></li>
                                <li><a href="ListaMeta.jsp?setor=25&userDiv=20&ano=<%out.print(year);%>">Visualizar BH-25</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a  href="#"><!--bh21/bh21_home.jsp-->
                                <i class="fa fa-bar-chart-o"></i> BH-21 Contabilidade</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="#"><!--bh22/bh22_home.jsp-->
                                <i class="fa fa-bar-chart-o"></i> BH-22 Obtenção</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="#"><!--bh23/bh23_home.jsp-->
                                <i class="fa fa-bar-chart-o"></i> BH-23 Pagamento</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="#"><!--bh24/bh24_home.jsp-->
                                <i class="fa fa-bar-chart-o"></i> BH-24 Material</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh25/Contador25.jsp">
                                <i class="fa fa-bar-chart-o"></i> BH-25 Municiamento</a>
                        </li>
                        <!--li class="sub-menu">
                            <a  href="indicador/bh20_indicadores.jsp">
                                <i class="fa fa-bar-chart-o"></i> Indicadores</a>
                        </li-->
                    </ul>
                    <!-- sidebar menu end-->
                    <footer class="site-footer">
                        <div class="text-center">
                            <%out.print(year);%> - BHMN
                        </div>
                    </footer>
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
                                <!-- TWITTER PANEL -->
                                <div class="col-md-4 mb">
                                    <div class="darkblue-panel pn">
                                        <div class="darkblue-header">
                                            <h5>FILA</h5>
                                        </div>
                                        <canvas id="serverstatus02" height="120" width="120"></canvas>
                                        <script>
                                            var doughnutData = [
                                                {
                                                    value: 60,
                                                    color: "#68dff0"
                                                },
                                                {
                                                    value: 40,
                                                    color: "#444c57"
                                                }
                                            ];
                                            var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
                                        </script>
                                        <p>April 17, 2014</p>
                                        <footer>
                                            <div class="pull-left">
                                                <h5><i class="fa fa-hdd-o"></i> 17 GB</h5>
                                            </div>
                                            <div class="pull-right">
                                                <h5>60% Used</h5>
                                            </div>
                                        </footer>
                                    </div>
                                </div><!-- /col-md-4 -->

                                <div class="col-md-4 mb">
                                    <div class="darkblue-panel pn">
                                        <div class="darkblue-header">
                                            <h5>VAGO</h5>
                                        </div>
                                        <canvas id="serverstatus023" height="120" width="120"></canvas>
                                        <script>
                                            var doughnutData3 = [
                                                {
                                                    value: 30,
                                                    color: "#68dff0"
                                                },
                                                {
                                                    value: 70,
                                                    color: "#444c57"
                                                }
                                            ];
                                            var myDoughnut3 = new Chart(document.getElementById("serverstatus023").getContext("2d")).Doughnut(doughnutData3);
                                        </script>
                                        <p>April 17, 2014</p>
                                        <footer>
                                            <div class="pull-left">
                                                <h5><i class="fa fa-hdd-o"></i> 17 GB</h5>
                                            </div>
                                            <div class="pull-right">
                                                <h5>30% Used</h5>
                                            </div>
                                        </footer>
                                    </div><!-- /darkblue panel -->
                                </div><!-- /col-md-4 -->

                                <div class="col-md-4 mb">
                                    <div class="darkblue-panel pn">
                                        <div class="darkblue-header">
                                            <h5>OCUPADO</h5>
                                        </div>
                                        <canvas id="serverstatus013" height="120" width="120"></canvas>
                                        <script>
                                            var doughnutData2 = [
                                                {
                                                    value: 30,
                                                    color: "#68dff0"
                                                },
                                                {
                                                    value: 70,
                                                    color: "#444c57"
                                                }
                                            ];
                                            var myDoughnut2 = new Chart(document.getElementById("serverstatus013").getContext("2d")).Doughnut(doughnutData2);
                                        </script>
                                        <p>April 17, 2014</p>
                                        <footer>
                                            <div class="pull-left">
                                                <h5><i class="fa fa-hdd-o"></i> 17 GB</h5>
                                            </div>
                                            <div class="pull-right">
                                                <h5>30% Used</h5>
                                            </div>
                                        </footer>
                                    </div><!-- /darkblue panel -->
                                </div><!-- /col-md-4 -->
                            </div><!-- /row -->
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->
                    </div><!--/row -->
                    <br><br><br><br><br>
                </section>
            </section>

            <!--footer end-->
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="../assets3/js/jquery.js"></script>
        <script src="../assets3/js/jquery-1.8.3.min.js"></script>
        <script src="../assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="../assets3/js/jquery.sparkline.js"></script>


        <!--common script for all pages-->
        <script src="../assets3/js/common-scripts.js"></script>
        <script type="text/javascript" src="../assets3/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="../assets3/js/gritter-conf.js"></script>
    </body>
</html>
