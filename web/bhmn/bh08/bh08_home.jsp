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
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>SIG-BASE</title>
        <link rel="shortcut icon" href="assets/images/gt_favicon.png">
        <!-- Bootstrap core CSS -->
        <link href="../assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets2/css/morris-0.4.3.min.css">    

        <!-- Custom styles for this template -->
        <link href="../assets3/css/style.css" rel="stylesheet">
        <link href="../assets3/css/style-responsive.css" rel="stylesheet">
        
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
                <a href="#" class="logo"><b>SIG-BASE || ENGENHARIA <%out.print(usuario.getSetor());%></b></a>
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
                            <a  href="bh08_home.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-08</span>
                            </a>
                        </li>
                        <%} else{%>
                        <li class="mt">
                            <a class="active" href="bh08_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Energia</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh08_inserir.jsp">Inserir</a></li>
                                <li><a href="#" style="color: red">Consultar</a></li>
                                <li><a href="#" style="color: red">Gráfico</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Água</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh08_inserir.jsp">Inserir</a></li>
                                <li><a href="#" style="color: red">Consultar</a></li>
                                <li><a href="#" style="color: red">Gráfico</a></li>
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
                <section class="wrapper site-min-height">
                    <h3><i class="fa fa-angle-right"></i> Consumo de Energia Elétrica do CNPA (kW/h)</h3>
                    <!-- page start-->
                    <div id="morris">
                        <div class="row mt">
                            <div class="col-lg-12">
                                <div class="content-panel">
                                    <div class="panel-body">
                                        <div id="hero-graph" class="graph"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- page end-->
                    <br><br>
                    <h3><i class="fa fa-angle-right"></i> Consumo de Água do CNPA (m³)</h3>
                    <!-- page start-->
                    <div id="morris">
                        <div class="row mt">
                            <div class="col-lg-12">
                                <div class="content-panel">
                                    <div class="panel-body">
                                        <div id="hero-graph2" class="graph"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    <%out.print(year);%> - BHMN
                </div>
            </footer>
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="../assets3/js/jquery.js"></script>
        <script src="../assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets2/js/bh08/raphael-min.js"></script>
        <script src="assets2/js/bh08/morris-0.4.3.min.js"></script>
        <script src="../assets3/js/common-scripts.js"></script>

        <!--script for this page-->
        <!--<script src="assets2/js/morris-conf.js"></script>-->
        <script>
            $(document).ready(function () {
//getting JSON data from external sources
                var json_data1 = (function () {
                    var json1;
                    $.ajax({
                        type: 'GET',
                        url: '/sigbase/bhmn/bh08/ChartsEl.jsp',
                        async: false,
                        global: false,
                        success: function (data) {
                            json1 = data;
                        },
                        error: function () {
                            alert("Error loading chart");
                        }
                    });
                    return json1;
                })();
                var json_data2 = (function () {
                    var json3;
                    $.ajax({
                        type: 'GET',
                        url: '/sigbase/bhmn/bh08/ChartsAg.jsp',
                        async: false,
                        global: false,
                        success: function (data) {
                            json3 = data;
                        },
                        error: function () {
                            alert("Error loading chart");
                        }
                    });
                    return json3;
                })();
                var json_date = (function () {
                    var json2;
                    $.ajax({
                        type: 'GET',
                        url: '/sigbase/bhmn/bh08/ChartsAno.jsp',
                        async: false,
                        global: false,
                        success: function (data1) {
                            json2 = data1;
                        },
                        error: function () {
                            alert("Error loading chart");
                        }
                    });
                    return json2;
                })();
                //tax_data = [
                //{"period": "2013 Q4", "licensed": 3407, "sorned": 660, "teste": null},
                //{"period": "2012 Q4", "licensed": 3351, "sorned": 629, "teste": null},
                //{"period": "2011 Q4", "licensed": 3269, "sorned": 618, "teste": 4000},
                //{"period": "2010 Q4", "licensed": 3246, "sorned": 661, "teste": 1500},
                //{"period": "2009 Q4", "licensed": 3171, "sorned": 676, "teste": 1500},
                //{"period": "2008 Q4", "licensed": 3155, "sorned": 681, "teste": 400},
                //{"period": "2007 Q4", "licensed": 3226, "sorned": 620, "teste": 1500},
                //{"period": "2006 Q4", "licensed": 3245, "sorned": null, "teste": 1500},
                //{"period": "2005 Q4", "licensed": 3289, "sorned": null, "teste": 50}
                //];
                new Morris.Line({
                    // ID of the element in which to draw the chart.
                    element: 'hero-graph',
                    data: json_data1,
                    parseTime: false,
                    xkey: 'period',
                    ykeys: ['item1', 'item2', 'item3', 'item4'],
                    labels: json_date,
                    lineColors: ['#0000FF', '#FF0000', '#006400', '#000000']
                });

                new Morris.Line({
                    // ID of the element in which to draw the chart.
                    element: 'hero-graph2',
                    data: json_data2,
                    parseTime: false,
                    xkey: 'period',
                    ykeys: ['item1', 'item2', 'item3', 'item4'],
                    labels: json_date,
                    lineColors: ['#0000FF', '#FF0000', '#006400', '#000000']
                });
            });
        </script>

        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>
