<%@page import="src.modelo.Chapa_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%ArrayList<Chapa_model> list = (ArrayList<Chapa_model>) request.getAttribute("chapa");
    Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%String temp = (String) request.getAttribute("mensagem");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
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
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="col-md-12 mt">
                        <div class="content-panel">
                            <table class="table">
                                <%if (list.size() == 0) {%>
                                <h2 class="centered">Fila vazia!</h2>
                                <%} else {%>
                                <h2 class="centered"><%out.print(list.size());%> Militares na Fila!</h2>
                                <%}%>
                                <%if (temp != null) {
                                        if (temp.equals("OK")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Militar retirado da fila com sucesso.</div>
                                <%} else if (temp.equals("UPDATE")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Militar atualizado com sucesso.</div>
                                <%} else {%>
                                <div class="alert alert-danger centered"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                    }%>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="text-center"></i> Posição</th>
                                        <th><i class="text-centerr"></i> Posto/Grad</th>
                                        <th><i class="text-center"></i> Nome</th>
                                        <th><i class="text-center"></i> Nip</th>
                                        <th><i class="text-center"></i> OM</th>
                                        <th><i class="text-center"></i> Ramal</th>
                                        <th><i class="text-center"></i> Mensagem</th>
                                        <th><i class="text-center"></i> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <%int count = 0;
                                            for (Chapa_model chapa : list) {%>
                                        <td><%out.print(++count);%></td>
                                        <%String grad = "";
                                            switch (chapa.getGrad()) {
                                                case 1:
                                                    grad = "MN-RC";
                                                    break;
                                                case 2:
                                                    grad = "MN";
                                                    break;
                                                case 3:
                                                    grad = "MNE";
                                                    break;
                                                case 4:
                                                    grad = "CB";
                                                    break;
                                                case 5:
                                                    grad = "3SG";
                                                    break;
                                                case 6:
                                                    grad = "2SG";
                                                    break;
                                                case 7:
                                                    grad = "1SG";
                                                    break;
                                                case 8:
                                                    grad = "SO";
                                                    break;
                                                case 9:
                                                    grad = "GM";
                                                    break;
                                                case 10:
                                                    grad = "2T";
                                                    break;
                                                case 11:
                                                    grad = "1T";
                                                    break;
                                                case 12:
                                                    grad = "CT";
                                                    break;
                                                case 13:
                                                    grad = "CC";
                                                    break;
                                                case 14:
                                                    grad = "CF";
                                                    break;
                                                case 15:
                                                    grad = "CMG";
                                                    break;
                                                case 16:
                                                    grad = "CA";
                                                    break;
                                                case 17:
                                                    grad = "VA";
                                                    break;
                                                case 18:
                                                    grad = "AE";
                                                    break;
                                                case 19:
                                                    grad = "SC";
                                                    break;
                                            }%>
                                        <td><%out.print(grad);%></td>
                                        <td><%out.print(chapa.getNome());%></td>
                                        <td><%out.print(chapa.getNip());%></td>
                                        <%String OM = "";
                                            switch (chapa.getOm()) {
                                                case 1:
                                                    OM = "BHMN";
                                                    break;
                                                case 2:
                                                    OM = "DHN";
                                                    break;
                                                case 3:
                                                    OM = "GNHO";
                                                    break;
                                                case 4:
                                                    OM = "CAMR";
                                                    break;
                                                case 5:
                                                    OM = "CHM";
                                                    break;
                                                case 6:
                                                    OM = "NApOc Ary Rongel";
                                                    break;
                                                case 7:
                                                    OM = "NHi Sirius";
                                                    break;
                                                case 8:
                                                    OM = "NHo amorim do Vale";
                                                    break;
                                                case 9:
                                                    OM = "NHo Cruzeiro do Sul";
                                                    break;
                                                case 10:
                                                    OM = "NHo Taurus";
                                                    break;
                                                case 11:
                                                    OM = "NHoF Graça Aranha";
                                                    break;
                                                case 12:
                                                    OM = "NOc Antares";
                                                    break;
                                                case 13:
                                                    OM = "NPo Maximiano";
                                                    break;
                                                case 14:
                                                    OM = "NPqHo Vital de Oliveira";
                                                    break;
                                            }%>
                                        <td><%out.print(OM);%></td>
                                        <td><%out.print(chapa.getRamal());%></td>
                                        <td><%out.print(chapa.getMsg());%></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="RetiraFila.jsp" method="post"> 
                                                <input type="hidden" id="nip" name="nip" value="<%out.print(chapa.getNip());%>" > 
                                                <input type="hidden" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                                <button type="submit" title="TIRAR DA FILA" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></button>
                                            </form>
                                            <form class="col-sm-2 control-label" action="EditMilitar.jsp" method="post"> 
                                                <input type="hidden" id="type" name="type" value="1" > 
                                                <input type="hidden" id="id" name="id" value="<%out.print(chapa.getId());%>" > 
                                                <input type="hidden" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                                <button type="submit" title="EDITAR" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
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
