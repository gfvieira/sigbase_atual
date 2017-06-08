<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%String temp = (String) request.getAttribute("mensagem");%>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || WEB-MASTER</title>

        <!-- Bootstrap core CSS -->
        <link href="assets2/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets2/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets2/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="assets2/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="assets2/lineicons/style.css">    

        <!-- Custom styles for this template -->
        <link href="assets2/css/style.css" rel="stylesheet">
        <link href="assets2/css/style-responsive.css" rel="stylesheet">

        <script src="assets2/js/chart-master/Chart.js"></script>
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

    <body>

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
                <a href="index.html" class="logo"><b>SIG-BASE || WEB-MASTER</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="/sigbase/LogOff.jsp">Sair</a></li>
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
                        <h5 class="centered">ADMIN</h5>
                        <h5 class="centered"> 
                            <script language=javascript type="text/javascript">
            document.write(dayName[now.getDay() ] + ", " + now.getDate() + " de " + monName [now.getMonth() ] + " de " + now.getFullYear());
                            </script>
                        </h5>
                        <h5 class="centered"><div id="txt"></div></h5>
                        <li class="mt">
                            <a class="active" href="admin_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="admin_cadastro.jsp" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Cadastrar</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Listar</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarUsuariosAdmin.jsp?type=0">Todos</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=9">Desativados</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=1">Comando</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=2">Assessorias</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=3">BH-10</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=4">BH-20</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=5">BH-30</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=6">BH-40</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=7">BH-50</a></li>
                                <li><a href="ListarUsuariosAdmin.jsp?type=8">Sargenteante</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Auditoria</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarUsuariosLogon.jsp?type=1">Hoje</a></li>
                                <li><a href="ListarUsuariosLogon.jsp?type=2">Anteriores</a></li>
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
                    <div class="row mt">
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <h3 class="mb"><i class="fa fa-angle-double-right"></i> <b>Cadastro de Usuarios</b></h3><br><br>
                                <%if (temp != null) {
                                        if (temp.equals("OK1")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> O Usuario foi cadastrado com sucesso.</div>
                                <%} else if (temp.equals("OK2")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> O Usuario foi atualizado com sucesso.</div>
                                <%} else {%>
                                <div class="alert alert-danger"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                    }%>
                                <form class="form-horizontal style-form" action="CadastroAdmin.jsp" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Nome</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" id="nome" name="nome" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">NIP</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="nip" name="nip" required="">
                                        </div>
                                        <label class="col-sm-1 col-sm-2 control-label">Nome de Guerra</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="guerra" name="guerra"  required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Posto/Graduação</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="grad">
                                                <option value="Selecione">Selecione!</option>
                                                <option value="SC">SC</option>
                                                <option value="MN">MN</option>
                                                <option value="CB">CB</option>
                                                <option value="3SG">3ºSG</option>
                                                <option value="2SG">2ºSG</option>
                                                <option value="1SG">1ºSG</option>
                                                <option value="SO">SO</option>
                                                <option value="GM">GM</option>
                                                <option value="2T">2ºT</option>
                                                <option value="1T">1ºT</option>
                                                <option value="CT">CT</option>
                                                <option value="CC">CC</option>
                                                <option value="CF">CF</option>
                                                <option value="CMG">CMG</option>
                                                <option value="CA">CA</option>
                                                <option value="VA">VA</option>
                                                <option value="AE">AE</option>
                                            </select>
                                        </div> 
                                        <label class="col-sm-1 col-sm-2 control-label">Ramal</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="ramal" name="ramal" maxlength="4" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Grupo</label>
                                        <div class="col-sm-3">
                                            <select class="form-control" size="1" id="grupo" name="grupo">
                                                <option value="Selecione">Selecione!</option>
                                                <option value="0">ADMIN</option>
                                                <option value="1">Comando</option>
                                                <option value="2">Assesoria</option>
                                                <option value="3">Chefe Departamento</option>
                                                <option value="4">Encarregado</option>
                                                <option value="6">Sargenteante</option>
                                                <option value="10">BH-10</option>
                                                <option value="20">BH-20</option>
                                                <option value="30">BH-30</option>
                                                <option value="40">BH-40</option>
                                                <option value="50">BH-50</option>
                                            </select>
                                        </div> 
                                        <label class="col-sm-2 col-sm-2 control-label">Tipo de acesso</label>
                                        <div class="col-sm-3">
                                            <select class="form-control" size="1" id="type" name="type">
                                                <option value="Selecione">Selecione!</option>
                                            </select>
                                        </div> 
                                    </div>
                                    <br>
                                    <hr>
                                    <br>
                                    <div>
                                        <button type="submit" class="btn btn-theme">Cadastrar</button>
                                        <input type="button"  class="btn btn-theme"  value="Cancelar" onClick="Voltar()">
                                    </div>
                                    <br>
                                    <br>
                                </form>
                            </div>
                        </div>
                    </div><!--/row -->
                    <br><br><br><br><br>
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

        <script type="text/javascript">
                                            $(document).ready(function () {
                                                $('#grupo').change(function (e) {
                                                    var pais = $('#grupo').val();
                                                    if (pais === 0) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="ADMIN">ADMIN</option>';
                                                    } else if (pais === 2) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="TOTAL">BH-01</option>';
                                                        option += '<option value="TOTAL">BH-02</option>';
                                                        option += '<option value="BH05">BH-05</option>';
                                                    } else if (pais === 3) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="BH08">BH-08</option>';
                                                    } else if (pais === 4) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="CHEFEBH10">BH-10 Chefe Departamento</option>';
                                                        option += '<option value="CHEFEBH20">BH-20 Chefe Departamento</option>';
                                                        option += '<option value="CHEFEBH30">BH-30 Chefe Departamento</option>';
                                                        option += '<option value="CHEFEBH40">BH-40 Chefe Departamento</option>';
                                                        option += '<option value="CHEFEBH50">BH-50 Chefe Departamento</option>';
                                                    } else if (pais === 5) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="ENCARREGADOBH31">BH-31 Encarregado(a)</option>';
                                                        option += '<option value="ENCARREGADOBH32">BH-32 Encarregado(a)</option>';
                                                        option += '<option value="ENCARREGADOBH33">BH-33 Encarregado(a)</option>';
                                                        option += '<option value="ENCARREGADOBH34">BH-34 Encarregado(a)</option>';
                                                        option += '<option value="ENCARREGADOBH52">BH-52 Encarregado(a)</option>';
                                                        option += '<option value="ENCARREGADOBH53">BH-53 Encarregado(a)</option>';
                                                    } else if (pais == 6) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="01">BH-01 Sargenteante</option>';
                                                        option += '<option value="04">BH-04 Sargenteante</option>';
                                                        option += '<option value="08">BH-08 Sargenteante</option>';
                                                        option += '<option value="10">BH-10 Sargenteante</option>';
                                                        option += '<option value="11">BH-11 Sargenteante</option>';
                                                        option += '<option value="12">BH-12 Sargenteante</option>';
                                                        option += '<option value="20">BH-20 Sargenteante</option>';
                                                        option += '<option value="21">BH-21 Sargenteante</option>';
                                                        option += '<option value="22">BH-22 Sargenteante</option>';
                                                        option += '<option value="23">BH-23 Sargenteante</option>';
                                                        option += '<option value="24">BH-24 Sargenteante</option>';
                                                        option += '<option value="25">BH-25 Sargenteante</option>';
                                                        option += '<option value="30">BH-30 Sargenteante</option>';
                                                        option += '<option value="31">BH-31 Sargenteante</option>';
                                                        option += '<option value="32">BH-32 Sargenteante</option>';
                                                        option += '<option value="33">BH-33 Sargenteante</option>';
                                                        option += '<option value="34">BH-34 Sargenteante</option>';
                                                        option += '<option value="40">BH-40 Sargenteante</option>';
                                                        option += '<option value="41">BH-41 Sargenteante</option>';
                                                        option += '<option value="42">BH-42 Sargenteante</option>';
                                                        option += '<option value="43">BH-43 Sargenteante</option>';
                                                        option += '<option value="44">BH-44 Sargenteante</option>';
                                                    } else if (pais === 10) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="NACIONAL">BH-30 Cartas Nacional</option>';
                                                        option += '<option value="ESTRANGEIRA">BH-40 Cartas Estrangeira</option>';
                                                        option += '<option value="FOLHAN">BH-50 Folha N</option>';
                                                    } else if (pais === 20) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="MUNICIAMENTO">BH-25 Municiamento</option>';
                                                    } else if (pais === 30) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="CHAPA">BH-30 CHaPA</option>';
                                                        option += '<option value="PESSOAL">BH-31 Pessoal</option>';
                                                        option += '<option value="SUPERVISORBH34">BH-34 Supervisor</option>';
                                                        option += '<option value="HARDWARE">BH-34 Hardware</option>';
                                                        option += '<option value="REDE">BH-34 Rede</option>';
                                                        option += '<option value="LOTUS">BH-34 Lotus-SiGDEM</option>';
                                                        option += '<option value="TELEFONIA">BH-34 Telefônia</option>';
                                                    } else if (pais === 40) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="40">40</option>';
                                                    } else if (pais === 50) {
                                                        var option = '<option>Selecione</option>';
                                                        option += '<option value="ELETRICA">BH-50 Eletrica</option>';
                                                        option += '<option value="AGUADA">BH-50 Aguada/CAV</option>';
                                                        option += '<option value="REFRIGERACAO">BH-50 Refrigeração</option>';
                                                        option += '<option value="CARPINTARIA">BH-50 Carpintaria</option>';
                                                        option += '<option value="METALURGIA">BH-50 Metalurgia</option>';
                                                        option += '<option value="PREFEITURA">BH-50 Prefeitura</option>';
                                                        option += '<option value="GARAGEM">BH-50 Garagem</option>';
                                                    } else {
                                                        Reset();
                                                    }
                                                    $('#type').html(option).show();
                                                });
                                                function Reset() {
                                                    $('#type').empty().append('<option>erro</option>>');
                                                }
                                            });
        </script>


    </body>
</html>
