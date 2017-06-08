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
    String year = new SimpleDateFormat("yyyy").format(tm);%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || CHaPA</title>
        <!--<link rel="shortcut icon" href="assets/images/gt_favicon.png">-->
        <!-- Bootstrap core CSS -->
        <link href="assets2/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets2/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets2/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets2/css/style.css" rel="stylesheet">
        <link href="assets2/css/style-responsive.css" rel="stylesheet">
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="assets2/js/time_session.js" type="text/javascript"></script>



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
                <a href="#" class="logo"><b>SIG-BASE || CHaPA</b></a>
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
                            <a class="active" href="../../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-30</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh30_chapa.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal CHaPA</span>
                            </a>
                        </li>
                        <%} else if (usuario.getPri().equals("BH30")) {%>
                        <li class="mt">
                            <a class="active" href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-30</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh30_chapa.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal CHaPA</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="bh30_chapa.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Fila</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh30_chapa_cadfila.jsp">Cadastrar</a></li>
                                <li><a href="ExibeFila.jsp?type=home">Listar</a></li>
                            </ul>
                        </li> 
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Apartamentos</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh30_chapa_buscapermissionario.jsp">Buscar Permissionário</a></li>
                                <li><a href="RealocarPerm.jsp">Realocar Permissionário</a></li>
                                <li><a href="ExibirAptos.jsp?blc=223">Bloco 223</a></li>
                                <li><a href="ExibirAptos.jsp?blc=243A">Bloco 243A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=243B">Bloco 243B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=254">Bloco 254</a></li>
                                <li><a href="ExibirAptos.jsp?blc=308A">Bloco 308A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=308B">Bloco 308B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=331A">Bloco 331A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=331B">Bloco 331B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=338">Bloco 338</a></li>
                                <li><a href="ExibirAptos.jsp?blc=372">Bloco 372</a></li>
                                <li><a href="ExibirAptos.jsp?blc=416A">Bloco 416A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=416B">Bloco 416B</a></li>
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
            <%if (usuario.getTypeAccess().equals("CHAPA")) {%> 
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
            <%} else {%>
            <section id="main-content">
                <section class="wrapper">

                    <div class="row">
                        <div class="col-lg-9 main-chart">
                            <div class="row">
                                <!-- TWITTER PANEL -->
                                <div class="col-md-4 mb">
                                    <div class="darkblue-panel pn">
                                        <div class="darkblue-header">
                                            <h5>PRAÇAS</h5>
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
                                            <h5>OFICIAIS</h5>
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
                                            <h5>CIVIS</h5>
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


                        <!-- **********************************************************************************************************************************************************
                        RIGHT SIDEBAR CONTENT
                        *********************************************************************************************************************************************************** -->                  

                        <div class="col-lg-3 ds">
                            <!--COMPLETED ACTIONS DONUTS CHART-->
                            <h3>QUADRO DE AVISO</h3>
                            <!-- First Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>2 Minutes Ago</muted><br/>
                                    <a href="#">CMG DAROS</a> Reunião de conselho hoje.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Second Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>3 Hours Ago</muted><br/>
                                    <a href="#">CF LINS</a> Livro de parada.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Third Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>7 Hours Ago</muted><br/>
                                    <a href="#">CMG DAROS</a> Lic amanhã.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Fourth Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>11 Hours Ago</muted><br/>
                                    <a href="#">CF LINS</a> Reunião com BH-01 quarta às 10:00hrs.<br/>
                                    </p>
                                </div>
                            </div>
                            <!-- Fifth Action -->
                            <div class="desc">
                                <div class="thumb">
                                    <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                                </div>
                                <div class="details">
                                    <p><muted>18 Hours Ago</muted><br/>
                                    <a href="#">CMG NILBERTO</a> Indicadores.<br/>
                                    </p>
                                </div>
                            </div>

                        </div><!-- /col-lg-3 -->
                    </div><!--/row -->
                    <br><br><br><br><br>
                </section>
            </section>
            <%}%>
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

        <script type="text/javascript">
            $(document).ready(function () {
                var unique_id = $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'Bem-vindo ao SIG-BASE!',
                    // (string | mandatory) the text inside the notification
                    //text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
                    // (string | optional) the image to display on the left
                    image: 'assets2/img/CBV.png',
                    // (bool | optional) if you want it to fade out on its own or just sit there
                    sticky: true,
                    // (int | optional) the time you want it to be alive for before fading out
                    time: '',
                    // (string | optional) the class name you want to apply to that specific message
                    class_name: 'my-sticky-class'
                });

                return false;
            });
        </script>

        <script type="application/javascript">
            $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
            $(this).hide();
            });

            $("#my-calendar").zabuto_calendar({
            action: function () {
            return myDateFunction(this.id, false);
            },
            action_nav: function () {
            return myNavFunction(this.id);
            },
            ajax: {
            url: "show_data.php?action=1",
            modal: true
            },
            legend: [
            {type: "text", label: "Special event", badge: "00"},
            {type: "block", label: "Regular event", }
            ]
            });
            });


            function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
            }
        </script>


    </body>
</html>
