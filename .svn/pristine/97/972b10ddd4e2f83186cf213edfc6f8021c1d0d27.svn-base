<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Pessoal_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    Pessoal_model servidor = (Pessoal_model) request.getAttribute("servidor");
    ArrayList<Pessoal_model> servidorFerias = (ArrayList<Pessoal_model>) request.getAttribute("servidorarray");
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>


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
                <a href="#" class="logo"><b>SIG-BASE || Sargenteante BH-<%out.print(usuario.getTypeAccess());%></b></a>
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
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal Sargenteante</span>
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
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal Sargenteante</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Tripulação</span>
                            </a>
                            <ul class="sub">
                                <li><a href="SargenteanteListaPessoal.jsp?type=0&access=<%out.print(usuario.getTypeAccess());%>">Tripulação</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=2&access=<%out.print(usuario.getTypeAccess());%>">Oficiais</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=1&access=<%out.print(usuario.getTypeAccess());%>">Praças</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=15&access=<%out.print(usuario.getTypeAccess());%>">SubOficiais</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=14&access=<%out.print(usuario.getTypeAccess());%>">Sargentos</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=13&access=<%out.print(usuario.getTypeAccess());%>">Cabos</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=12&access=<%out.print(usuario.getTypeAccess());%>">Marinheiros</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=3&access=<%out.print(usuario.getTypeAccess());%>">TTC's</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=4&access=<%out.print(usuario.getTypeAccess());%>">Civis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Controle de férias</span>
                            </a>
                            <ul class="sub">
                                <li><a href="SargenteanteFeriasControle.jsp?type=2&access=<%out.print(usuario.getTypeAccess());%>">Oficiais</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=1&access=<%out.print(usuario.getTypeAccess());%>">Praças</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=3&access=<%out.print(usuario.getTypeAccess());%>">TTC's</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=4&access=<%out.print(usuario.getTypeAccess());%>">Cívis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">Pessoal</a></li>
                                <li><a href="SargenteanteFerias.jsp?access=<%out.print(usuario.getTypeAccess());%>">Férias</a></li>
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
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h3 class="centered"><i class="fa fa-angle-double-right"></i><b>Cadastro de Férias</b></h3><br><br>
                            <form class="form-horizontal style-form" action="SargenteanteFeriasPessoal.jsp" method="post">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Data de início:</label>
                                    <div class="col-sm-3"> 
                                        <input name="ini" id="ini" type="date" class="form-control" required="" min="1910-01-01" max="2016-01-01">
                                    </div> 
                                    <label class="col-sm-2 col-sm-2 control-label">Data de Termíno:</label>
                                    <div class="col-sm-3"> 
                                        <input name="ter" id="ter" type="date" class="form-control" required="" min="1910-01-01" max="2016-01-01">
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Ano:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="ano" name="ano" required>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label">Dias totais:</label>
                                    <div class="col-sm-3"> 
                                        <input type="text" class="form-control" id="dias" name="dias" required>
                                    </div> 
                                </div>
                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">
                                <input type="hidden" class="form-control" id="nip_ferias" name="nip" value="<%out.print(servidor.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="<%out.print(servidor.getType());%>">
                                <button type="submit" class="btn btn-theme center-block">Cadastrar</button>
                            </form>
                        </div>
                    </div> 
                    <div class="col-md-12 mt">
                        <div class="content-panel">
                            <table class="table table-hover">
                                <h4><i class="fa fa-angle-right centered"></i> HISTORICO</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Ano</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Dias </th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Data Início</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Data Término</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Pessoal_model ferias : servidorFerias) {
                                            if (ferias.getId_ferias() != 0) {%>
                                    <tr>
                                        <td><%out.print(ferias.getAnoFerias());%></td>
                                        <td><%out.print(ferias.getDiasFerias());%></td>
                                        <td><%out.print(ferias.getDate_ini());%></td>
                                        <td><%out.print(ferias.getDate_ter());%></td>
                                        <td>
                                            <form class="col-sm-2 control-label">      
                                                <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal<%out.print(ferias.getId_ferias());%>" title="APAGAR ENTRADA DE FÉRIAS"><i class="fa fa-pencil"></i></button>
                                            </form>
                                            <div class="modal fade bs-example-modal-sm" id="myModal<%out.print(ferias.getId_ferias());%>" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-sm">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" align="center" id="myModalLabel">Cancelar Férias</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <p align="center">Digite sua senha para confirmar exclusão</p>
                                                            <form  class="form login" name="form1" action="SargenteanteDeleteFerias.jsp" method="post">
                                                                <div class="login-wrap">
                                                                       <input class="center-block" name="senha" type="password" required placeholder="" autofocus>
                                                                    <br><br>
                                                                    <input type="hidden" name="ferias_id" value="<%out.print(ferias.getId_ferias());%>" > 
                                                                    <input type="hidden" name="user" value="<%out.print(usuario.getNip());%>" > 
                                                                    <input type="hidden" name="servidor" value="<%out.print(servidor.getNip());%>" > 
                                                                    <input type="hidden" name="type" value="<%out.print(servidor.getType());%>">
                                                                    <button class="btn btn-theme btn-block" type="submit" ><i class="glyphicon glyphicon-ok-circle"></i> Enviar</button>
                                                                    <hr>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <%} else {%>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <%}
                                        }%>
                                </tbody>
                            </table>
                        </div><!--/content-panel -->
                    </div><!-- /col-md-12 -->
                </section>
            </section>
            <!--main content end-->
        </section>
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
