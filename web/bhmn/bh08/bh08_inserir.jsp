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
<%String temp = (String) request.getAttribute("mensagem");%>
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
        <link rel="stylesheet" href="assets2/js/bh08/morris-0.4.3.min.css">    
<!--        <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">    -->

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
                <section class="wrapper">
                    <%if (temp != null) {
                            if (temp.equals("OK")) {%>
                    <div class="alert alert-success centered"><b>Concluido!</b> O Consumo foi cadastrado com sucesso.</div>
                    <%} else if (temp.equals("OK2")) {%>
                    <div class="alert alert-success centered"><b>Concluido!</b> O Consumo foi atualizado com sucesso.</div>
                    <%} else {%>
                    <div class="alert alert-danger"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                    <%}
                        }%>
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <form class="form-horizontal style-form" action="CadConsumo.jsp" method="post">
                                <h3 class=""><i class="fa fa-angle-double-right"></i>Cadastro Consumo Energia Elétrica CNPA</h3><br><br>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-1 control-label">Consumo:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="con" name="con" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-1 control-label">Ano:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="ano" required>
                                            <option value="">Selecione!</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                            <option value="2013">2013</option>
                                            <option value="2014">2014</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                            <option value="2021">2021</option>
                                            <option value="2022">2022</option>
                                            <option value="2023">2023</option>
                                            <option value="2024">2024</option>
                                            <option value="2025">2025</option>
                                        </select>
                                    </div> 
                                    <label class="col-sm-2 col-sm-1 control-label">Mês:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="mes" required>
                                            <option value="">Selecione!</option>
                                            <option value="1">Janeiro</option>
                                            <option value="2">Fevereiro</option>
                                            <option value="3">Março</option>
                                            <option value="4">Abril</option>
                                            <option value="5">Maio</option>
                                            <option value="6">Junho</option>
                                            <option value="7">Julho</option>
                                            <option value="8">Agosto</option>
                                            <option value="9">Setembro</option>
                                            <option value="10">Outubro</option>
                                            <option value="11">Novembro</option>
                                            <option value="12">Dezembro</option>
                                        </select>
                                    </div> 
                                </div>
                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="1">
                                <button type="submit" class="btn btn-theme center-block">Cadastrar</button>
                            </form>
                        </div>
                    </div>     
                    <br><br>
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <form class="form-horizontal style-form" action="CadConsumo.jsp" method="post">
                                <h3 class=""><i class="fa fa-angle-double-right"></i>Cadastro Consumo Aguada CNPA</h3><br><br>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-1 control-label">Consumo:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="con" name="con" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-1 control-label">Ano:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="ano" required>
                                            <option value="">Selecione!</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                            <option value="2013">2013</option>
                                            <option value="2014">2014</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                            <option value="2021">2021</option>
                                            <option value="2022">2022</option>
                                            <option value="2023">2023</option>
                                            <option value="2024">2024</option>
                                            <option value="2025">2025</option>
                                        </select>
                                    </div> 
                                    <label class="col-sm-2 col-sm-1 control-label">Mês:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="mes" required>
                                            <option value="">Selecione!</option>
                                            <option value="1">Janeiro</option>
                                            <option value="2">Fevereiro</option>
                                            <option value="3">Março</option>
                                            <option value="4">Abril</option>
                                            <option value="5">Maio</option>
                                            <option value="6">Junho</option>
                                            <option value="7">Julho</option>
                                            <option value="8">Agosto</option>
                                            <option value="9">Setembro</option>
                                            <option value="10">Outubro</option>
                                            <option value="11">Novembro</option>
                                            <option value="12">Dezembro</option>
                                        </select>
                                    </div> 
                                </div>
                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="2">
                                <button type="submit" class="btn btn-theme center-block">Cadastrar</button>
                            </form>
                        </div>
                    </div> 
                </section>
            </section>
            <!-- /MAIN CONTENT -->

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
        <script class="include" type="text/javascript" src="../../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
<!--        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>-->
        <script src="assets2/js/bh08/raphael-min.js"></script>
        <script src="assets2/js/bh08/morris-0.4.3.min.js"></script>
        <script src="../assets3/js/common-scripts.js"></script>

        <!--script for this page-->
        <!--<script src="assets2/js/morris-conf.js"></script>-->

        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>
