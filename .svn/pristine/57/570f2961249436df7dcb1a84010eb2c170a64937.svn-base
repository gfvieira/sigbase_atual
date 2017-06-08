<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="src.modelo.Pessoal_model"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Pessoal_model> list = (ArrayList<Pessoal_model>) request.getAttribute("servidorarray");
    Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%@ page contentType="text/html; charset=UTF-8" %>
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

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="col-md-12 mt">
                        <div class="content-panel">
                            <table class="table table-hover">
                                <%if (list.size() == 0) {%>
                                <h2 class="centered">Nenhum Militar encontrado!</h2>
                                <%} else {%>
                                <h2 class="centered"><%out.print(list.size());%> TTC('s) Encontrado(s):</h2>
                                <%}%>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Posto/Graduação</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Quadro</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Nome de Guerra</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Nip</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Departamento</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Divisão</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Pessoal_model servidor : list) {%>
                                    <tr>
                                <td><i class="text-center"></i><%out.print(servidor.getGrad());%></td>
                                <td><i class="text-center"></i><%out.print(servidor.getQuadro());%></td>
                                <td><i class="center-block"></i><%out.print(servidor.getGuerra());%></td>
                                <td><i class="center-block"></i><%out.print(servidor.getNip());%></td>
                                <td><i class="text-center"></i>BH-<%out.print(servidor.getDep());%></td>
                                <td><i class="text-center"></i><%out.print(servidor.getDiv());%></td>
                                <td>
                                    <form class="col-sm-2 control-label" action="SargenteanteExibePessoal.jsp" method="post">      
                                        <button type="submit" title="EXIBIR DADOS DO MILITAR" class="btn btn-primary btn-xs center-block"><i class="fa fa-check"></i></button>
                                        <input type="hidden" class="form-control" id="nip" name="nip" value="<% out.print(servidor.getNip()); %>" >
                                        <input type="hidden" id="type" name="type" value="3" > 
                                    </form>
                                </td>
                                </tr>
                                <% }%>
                                </tbody>
                            </table>
                        </div><!--/row -->
                    </div><!--/row --> 
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
