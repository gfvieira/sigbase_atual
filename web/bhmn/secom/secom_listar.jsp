<%@page import="src.modelo.Secom_doc"%>
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
<%ArrayList<Secom_doc> list = (ArrayList<Secom_doc>) request.getAttribute("secomarray");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String t = new SimpleDateFormat("HH").format(tm);
    String year = new SimpleDateFormat("yyyy").format(tm);
    String temp = (String) request.getAttribute("menssagem");%>

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
        <link href="assets2/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets2/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">    

        <!-- Custom styles for this template -->
        <link href="assets2/css/style.css" rel="stylesheet">
        <link href="assets2/css/style-responsive.css" rel="stylesheet">

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
                <a href="#" class="logo"><b>SECRETARIA DO COMANDO BH-04</b></a>
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
                        <h5 class="centered"><%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%></h5>
                        <h5 class="centered"> BHMN</h5>
                        <%if (usuario.getPri().equals("TOTAL")) {%>
                        <li class="mt">
                            <a class="active" href="../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="secom_home.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-04</span>
                            </a>
                        </li>
                        <%} else{%>
                        <li class="mt">
                            <a class="active" href="Contador25.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Documentação</span>
                            </a>
                            <ul class="sub">
                                <li><a href="secom_enviar_os.jsp">Enviar OS</a></li>
                                <li><a href="secom_enviar_port.jsp">Enviar Portaria</a></li>
                                <li><a href="ListarFile.jsp?type=home">Listar</a></li>
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
                    <div class="col-md-12 mt">
                        <div class="content-panel">
                            <%if (temp != null) {
                                    if (temp.equals("OK")) {%>
                            <div class="alert alert-success centered"><b>Concluido!</b> Documento Eliminado com sucesso!</div>
                            <%} else if (temp.equals("NOT")) {%>
                            <div class="alert alert-danger centered"><b>Error!</b> Documento não foi Eliminado!</div>
                            <%} else {%>
                            <%}
                                }%>
                            <%if (list.size() == 0) {%>
                            <h2 class="centered">Nenhum documento encontrado!</h2>
                            <br><br><br><br><br><br><br><br>
                            <%} else {%>
                            <h2 class="centered"><%out.print(list.size());%> documento(s) encontrado(s):</h2>
                            <table class="table">
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Documento</th>
                                        <th><i class="text-center"></i> Tipo de documento</th>
                                        <th><i class="text-center"></i> Ano</th>
                                        <th><i class="text-center"></i> Mês</th>
                                        <th><i class="text-center"></i> Cadastrado Por:</th>
                                        <th><i class="text-center"></i> Data/Hora de Cadastro</th>
                                        <th><i class="text-center"></i> IP</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Secom_doc secom : list) {%>
                                    <tr>
                                        <td><a href="<%out.print(secom.getDoc());%>" target="_blank"> <%out.print(secom.getNome_doc());%></a></td>
                                        <td><%out.print(secom.getType_doc());%></td>
                                        <td><%out.print(secom.getAno_doc());%></td>
                                        <%switch (secom.getMes_doc()) {
                                                case 1: %><td>Janeiro</td><% break;
                                                    case 2: %><td>Fevereiro</td><% break;
                                                    case 3: %><td>Março</td><% break;
                                                    case 4: %><td>Abril</td><% break;
                                                    case 5: %><td>Maio</td><% break;
                                                    case 6: %><td>Junho</td><% break;
                                                    case 7: %><td>Julho</td><% break;
                                                    case 8: %><td>Agosto</td><% break;
                                                    case 9: %><td>Setembro</td><% break;
                                                    case 10: %><td>Outubro</td><% break;
                                                    case 11: %><td>Novembro</td><% break;
                                                    case 12: %><td>Dezembro</td><% break;
                                                    }%>
                                        <td><%out.print(secom.getUser());%></td>
                                        <td><%out.print(secom.getDatacad());%> às <%out.print(secom.getHoracad());%></td>
                                        <td><%out.print(secom.getIp());%></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="RetiraDoc.jsp" method="post"> 
                                                <input type="hidden" id="id" name="id" value="<%out.print(secom.getId_doc());%>" > 
                                                <input type="hidden" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                                <button type="submit" title="TIRAR DA LISTA" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                            <%}%>
                        </div><!--/row -->
                    </div><!--/row -->
                </section>
            </section>

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    <%out.print(year);%> - BHMN
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

    </body>
</html>
