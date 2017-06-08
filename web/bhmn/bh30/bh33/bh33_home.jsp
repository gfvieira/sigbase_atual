<%@page import="src.modelo.Servidor_indicador"%>
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
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
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

    <body onload="time()">

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
                <a href="#" class="logo"><b>SIG-BASE || Divisão de Segurança BH-33</b></a>
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
                            <a href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-30</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="#">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-33</span>
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
                            <a  href="#">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-33</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="#">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-33</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Visitante a Bordo</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarVisitante?type=1">Crachá</a></li>
                                <li><a href="ListarVisitante?type=2">Veículo</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Cadastro</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh33_cadastrar_cracha.jsp">Crachá</a></li>
                                <li><a href="bh33_cadastrar_veiculo.jsp">Veículo</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Crachá</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh33_cracha_buscar.jsp">Buscar</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=0">Tripulação</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=2">Oficiais</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=1">Praças</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=15">SubOficiais</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=14">Sargentos</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=13">Cabos</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=12">Marinheiros</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=3">TTC's</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=4">Civis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Veículo</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh33_veiculo_buscar.jsp">Buscar</a></li>
                                <li><a href="ListarSeg.jsp?doc=2&type=0">Tripulação</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=2">Oficiais</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=1">Praças</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=15">SubOficiais</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=14">Sargentos</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=13">Cabos</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=12">Marinheiros</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=3">TTC's</a></li>
                                <li><a href="ListarSeg.jsp?doc=2type=4">Civis</a></li>
                            </ul>
                        </li><li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Crachá por OM</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=1">CNPA</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=2">BHMN</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=3">DHN</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=4">GNHO</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=5">CAMR</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=6">CHM</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=7">NAVIOS</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Veículo por OM</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=1">CNPA</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=2">BHMN</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=3">DHN</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=4">GNHO</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=5">CAMR</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=6">CHM</a></li>
                                <li><a href="ListarSeg.jsp?doc=1&type=9&om=7">NAVIOS</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#">Crachá</a></li>
                                <li><a href="#">Crachá por OM</a></li>
                                <li><a href="#">Veículo</a></li>
                                <li><a href="#">Veículo por OM</a></li>
                                <li><a href="#">2º via Crachá</a></li>
                                <li><a href="#">2º via Veículo</a></li>
                                <li><a href="#">Visitante</a></li>
                            </ul>
                        </li>
                    </ul>
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
                            <div class="content-panel">		
                                <!--CUSTOM CHART START -->
                                <div class="border-head">
                                    <h3>DEPARTAMENTO PESSOAL || BH-31</h3>
                                </div>
<!--                                <div class="custom-bar-chart">
                                    <ul class="y-axis">
                                        <li><span><%//out.print(df.format(qntd));%></span></li>
                                        <li><span><%//out.print(df.format((qntd / 5) * 4));%></span></li>
                                        <li><span><%//out.print(df.format((qntd / 5) * 3));%></span></li>
                                        <li><span><%//out.print(df.format((qntd / 5) * 2));%></span></li>
                                        <li><span><%//out.print(df.format(qntd / 5));%></span></li>
                                        <li><span>0</span></li>
                                    </ul>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">OFICIAL SUPERIOR</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalOf.getCmg() + pessoalOf.getCf() + pessoalOf.getCc());%>" data-toggle="tooltip" data-placement="top"><%//out.print(((pessoalOf.getCmg() + pessoalOf.getCf() + pessoalOf.getCc()) * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">OFICIAL INTERMEDIARIO</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalOf.getCt());%>" data-toggle="tooltip" data-placement="top"><%//out.print((pessoalOf.getCt() * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">OFICIAL SUBALTERNO</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalOf.getT1() + pessoalOf.getT2() + pessoalOf.getGm());%>" data-toggle="tooltip" data-placement="top"><%//out.print(((pessoalOf.getT1() + pessoalOf.getT2() + pessoalOf.getGm()) * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">SUBOFICIAS</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalPr.getSo());%>" data-toggle="tooltip" data-placement="top"><%//out.print((pessoalPr.getSo() * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">SARGENTOS</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalPr.getSg1() + pessoalPr.getSg2() + pessoalPr.getSg3());%>" data-toggle="tooltip" data-placement="top"><%//out.print(((pessoalPr.getSg1() + pessoalPr.getSg2() + pessoalPr.getSg3()) * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">CABOS</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalPr.getCb());%>" data-toggle="tooltip" data-placement="top"><%//out.print((pessoalPr.getCb() * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">MARINHEIROS</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalPr.getMn() + pessoalPr.getRc());%>" data-toggle="tooltip" data-placement="top"><%//out.print(((pessoalPr.getMn() + pessoalPr.getRc()) * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">TTC's</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalTtc.getTtc());%>" data-toggle="tooltip" data-placement="top"><%//out.print((pessoalTtc.getTtc() * 100) / qntd);%>%</div>
                                    </div>
                                    <div class="bar" style="margin: 0px 2.5%;">
                                        <div class="title">CIVIS</div>
                                        <div class="value tooltips" data-original-title="<%//out.print(pessoalCv.getCv());%>" data-toggle="tooltip" data-placement="top"><%//out.print((pessoalCv.getCv() * 100) / qntd);%>%</div>
                                    </div>
                                </div>-->
                            </div>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->
                    </div><!--/row -->
                </section>
            </section>
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="../../assets3/js/jquery.js"></script>
        <script src="../../assets3/js/jquery-1.8.3.min.js"></script>
        <script src="../../assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="../../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="../../assets3/js/jquery.sparkline.js"></script>

        <!--common script for all pages-->
        <script src="../../assets3/js/common-scripts.js"></script>

        <script type="text/javascript" src="../../assets3/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="../../assets3/js/gritter-conf.js"></script>	
    </body>
</html>
