<%@page import="src.modelo.Ouvidoria_model"%>
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
<%ArrayList<Ouvidoria_model> list = (ArrayList<Ouvidoria_model>) request.getAttribute("ouvidoriaarray");%>
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
                                    <li role = "separator" class="divider"></li>
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
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="content-panel">
                                <h2 class="centered">Ouvidoria BHMN</h2>
                                <h5 class="text-center" style="color: blue;font-size: 12px;"><%out.print(list.size());%> Contato(s) encontrado(s)!</h5>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Data/Hora</th>
                                            <th><i class="text-center"></i> Nome</th>
                                            <th><i class="text-center"></i> E-mail</th>
                                            <th><i class="text-center"></i> Contato</th>
                                            <th><i class="text-center"></i> Situação</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Ouvidoria_model ouvidoria : list) {%>
                                        <tr>
                                            <td><%out.print(ouvidoria.getDatacad());%> às <%out.print(ouvidoria.getHoracad());%></td>
                                            <td><%out.print(ouvidoria.getNome());%></td>
                                            <td><%out.print(ouvidoria.getEmail());%></td>
                                            <td><%out.print(ouvidoria.getContato());%></td>
                                            <%if(ouvidoria.getSituacao() == 0){%>
                                            <td><span class="label label-danger label-mini">Não Respondido</span></td>
                                            <%} else if(ouvidoria.getSituacao() == 0){%>
                                            <td><span class="label label-warning label-mini">Réplica</span></td>
                                            <%}else{%>
                                            <td><span class="label label-success label-mini">Respondido</span></td>
                                            <%}%>
                                            <td>
                                                <form class="col-sm-2 control-label" action="RespOuvidoria.jsp" method="post">      
                                                    <button type="submit" title="VISUALIZAR" class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                                    <input type="hidden" name="protocolo" value="<% out.print(ouvidoria.getProtocolo()); %>" > 
                                                    <input type="hidden" name="type" value="1" > 
                                                </form>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                            <br>
                        </div>
                    </div><!--/row -->
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
        <script src="assets3/js/jquery.js"></script>
        <script src="assets3/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="assets3/js/fullcalendar/fullcalendar.min.js"></script>    
        <script src="assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets3/js/jquery.scrollTo.min.js"></script>
        <script src="assets3/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets3/js/common-scripts.js"></script>

    </body>
</html>
