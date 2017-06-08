<%@page import="src.modelo.Meta_model"%>
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
<%ArrayList<Meta_model> list = (ArrayList<Meta_model>) request.getAttribute("metaarray");%>
<%String temp = (String) request.getAttribute("mensagem");%>
<%Integer setor = (Integer) request.getAttribute("setor");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE</title>
        <!--<link rel="shortcut icon" href="assets/images/gt_favicon.png">-->
        <!-- Bootstrap core CSS -->
        <link href="assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets3/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets3/css/style.css" rel="stylesheet">
        <link href="assets3/css/style-responsive.css" rel="stylesheet">
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="assets3/js/time_session.js" type="text/javascript"></script>



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
                <a href="#" class="logo"><b>SIG-BASE || COMANDO <%out.print(usuario.getSetor());%></b></a>
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
                        <li class="mt">
                            <a class="active" href="cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>   
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-bar-chart-o"></i>
                                <span>Fale Conosco</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListarOuvidoria.jsp?type=NOT">Não respondido</a></li>
                                <li><a href="ListarOuvidoria.jsp?type=YES">Respondido</a></li>
                                <li><a href="ListarOuvidoria.jsp?type=ALL">Todos</a></li>
                            </ul>
                        </li>  
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-bar-chart-o"></i>
                                <span>Plano de metas</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListaMeta.jsp?setor=1&tipo=1&userDiv=1&ano=<%out.print(year);%>">Curto Prazo</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=2&userDiv=1&ano=<%out.print(year);%>">Médio Prazo</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">Longo Prazo</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-04</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-05</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-06</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-07</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-08</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-10</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-20</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-30</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-40</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">BH-50</a></li>
                                <li><a href="ListaMeta.jsp?setor=1&tipo=3&userDiv=1&ano=<%out.print(year);%>">Indicador</a></li>
                            </ul>
                        </li>  
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Assessorias</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#" style="color: red" >Netuno BH-05</a></li>
                                <li><a href="#" style="color: red" >Secom BH-04</a></li>
                                <li><a href="bh08/bh08_home.jsp">Engenharia BH-08</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Serviço Naútico BH-10</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh10/bh10_home.jsp">BH-10</a></li>
                                <li><a href="#" style="color: red">Cartas Naúticas</a></li>
                                <li><a href="#" style="color: red">Oficinas</a></li>
                                <li><a href="bh10/folhaN/folhan_home.jsp">FolhaN</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Intendência BH-20</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#" style="color: red">BH-20</a></li>
                                <li><a href="#" style="color: red">Obtenção BH-22</a></li>
                                <li><a href="bh20/bh25/Contador25.jsp">Municiamento BH-25</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Administração BH-30</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh30/bh30_home.jsp">BH-30</a></li>
                                <li><a href="bh30/bh31/BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">BH-31 pessoal</a></li>
                                <li><a href="#" style="color: red">BH-32 Saúde</a></li>
                                <li><a href="#"style="color: red" >BH-33 Segurança</a></li>
                                <li><a href="bh30/bh34/BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">BH-34 Telamática</a></li>
                                <li><a href="bh30/chapa/bh30_chapa.jsp">CHaPA</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>GráficaBH-40</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#" style="color: red">BH-40</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="bh50/BH50.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Apoio BH-50</span>
                            </a>
                        </li>
                    </ul>
                    <footer class="site-footer">
                        <div class="text-center">
                            <%out.print(year);%> - BHMN
                        </div>
                    </footer>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->

            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="content-panel">
                                <h2 class="centered">Metas BHMN</h2>
                                <h5 class="text-center" style="color: blue;font-size: 12px;"><%out.print(list.size());%> mestas encontradas!</h5>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Prazo</th>
                                            <th><i class="text-center"></i> Setor</th>
                                            <th><i class="text-center"></i> Meta</th>
                                            <th><i class="text-center"></i> Porcentagem concluida</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Meta_model meta : list) {%>
                                        <tr>
                                            <%switch (meta.getTipo()) {
                                                    case 3:%><td style=" color: red">Longo Prazo</td><%
                                                    break;
                                                case 2:%><td style=" color: darkgreen">Médio Prazo</td><%
                                                break;
                                            case 1:%><td style=" color: blue">Curto Prazo</td><%
                                                    break;
                                                default:%>
                                            <%}%>
                                            <%if (meta.getSetor() < 10) {%>
                                            <td width="100">BH-0<%out.print(meta.getSetor());%></td>
                                            <%} else {%>
                                            <td width="100">BH-<%out.print(meta.getSetor());%></td>
                                            <%}%>
                                            <td width="600"><%out.print(meta.getMeta());%></td>
                                            <td>
                                                <div class="progress">
                                                    <%if (meta.getConcluido() <= 30) {%>
                                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%} else if (meta.getConcluido() > 30 && meta.getConcluido() < 70) {%>
                                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%} else {%>
                                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%}%>
                                                </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                            <br>
                        </div>
                    </div><! --/row -->
                </section>
            </section>
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
       <script src="assets3/js/jquery.js"></script>
            <script src="assets3/js/jquery-ui-1.9.2.custom.min.js"></script>
            <script src="assets3/js/fullcalendar/fullcalendar.min.js"></script>    
            <script src="assets3/js/bootstrap.min.js"></script>
            <script class="include" type="text/javascript" src="assets3/js/jquery.dcjqaccordion.2.7.js"></script>
            <script src="assets3/js/jquery.scrollTo.min.js"></script>
            <script src="assets3/js/jquery.nicescroll.js" type="text/javascript"></script>


            <!--common script for all pages-->
            <script src="assets3/js/common-scripts.js"></script>

        </section>
    </body>
</html>
