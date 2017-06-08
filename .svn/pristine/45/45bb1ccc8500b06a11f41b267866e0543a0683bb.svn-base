<%@page import="src.modelo.FolhanItem"%>
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
<%String tipo = (String) request.getAttribute("tipo");%>
<%ArrayList<FolhanItem> folhaEquipamento = (ArrayList<FolhanItem>) request.getAttribute("equipamento");%>
<%ArrayList<FolhanItem> folhaEquipagem = (ArrayList<FolhanItem>) request.getAttribute("equipagem");%>
<%ArrayList<FolhanItem> folhaEmprestimo = (ArrayList<FolhanItem>) request.getAttribute("emprestimo");%>
<%ArrayList<FolhanItem> folhaOm = (ArrayList<FolhanItem>) request.getAttribute("folhaOm");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
    double total = 0;
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || FOLHA N</title>

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
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="#" class="logo"><b>SIG-BASE || FOLHA N</b></a>
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
                            <a href="../bh10_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-10</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="folhan_home.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal FOLHA-N</span>
                            </a>
                        </li>
                        <%} else if (usuario.getPri().equals("BH10")) {%>
                        <li class="sub-menu">
                            <a href="../bh10_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-10</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="folhan_home.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal FOLHA-N</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="sub-menu">
                            <a  href="folhan_home.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal FOLHA-N</span>
                            </a>
                        </li>
                        <%}%><li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>OM's</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#">Cadastrar</a></li>
                                <li><a href="ExibeOM.jsp?tipo=1">Listar Todas</a></li>
                                <li><a href="ExibeOM.jsp?tipo=2">Om's Terra</a></li>
                                <li><a href="ExibeOM.jsp?tipo=3">Om's Navio</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Exibir</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ExibeFolha.jsp?tipo=1">Completo</a></li>
                                <li><a href="ExibeFolha.jsp?tipo=2">OM</a></li>
                            </ul>
                        </li>
                    </ul>
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
                            <div class="form-panel">
                                <%if (tipo.equals("2")) {%>
                                <form class="form-horizontal style-form" action="ExibeFolha.jsp" method="post">
                                    Organização Militar:<br><br>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label text-center">Mês:</label>
                                        <div class="col-sm-3">
                                            <select class="form-control" size="1" name="om" required>
                                                <option value="">Selecione!</option>
                                                <%for (FolhanItem folhaitem : folhaOm) {%>
                                                <option value="<%out.print(folhaitem.getSiglaOm());%>"><%out.print(folhaitem.getSiglaOm());%></option>
                                                <%}%>
                                            </select>
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <input type="hidden" class="form-control" id="type" name="tipo"  value="0"> 
                                            <button type="submit" class="btn btn-theme">Visualizar</button>
                                        </div> 
                                    </div>
                                </form>
                                <%} else {%>
                                <%if (tipo.equals("0")) {%>
                                <h2 class="centered" ><%out.print(folhaEquipamento.get(0).getNomeOm());%></h2>
                                <%}%>
                                <h4 class="centered">Equipamento</h4>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Identificador</th>
                                            <th><i class="text-center"></i> Item</th>
                                            <th><i class="text-center"></i> Marca</th>
                                            <th><i class="text-center"></i> Situação</th>
                                            <th><i class="text-center"></i> Ano GM</th>
                                            <th><i class="text-center"></i> Quantidade</th>
                                            <th><i class="text-center"></i> Valor Unitário</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (FolhanItem folhaitem : folhaEquipamento) {
                                                total = total + folhaitem.getVlUnitario();%>
                                        <tr>
                                            <td><%out.print(folhaitem.getNumeroIdentificacao());%></td>
                                            <td><%out.print(folhaitem.getNomeItem());%></td>
                                            <td><%out.print(folhaitem.getNomeFantasia());%></td>
                                            <td><%out.print(folhaitem.getNomeMovimentacao());%></td>
                                            <td><%out.print(folhaitem.getAnoGM());%></td>
                                            <td><%out.print(folhaitem.getQnt());%></td>
                                            <td><%out.print(folhaitem.getVlUnitario());%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <h4 class="text-right" style="margin-right: 30px">Total de R$ <%out.print(total);%></h4>
                                <%total = 0;%>
                                <br>
                                <h4 class="centered">Equipagem</h4>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Identificador</th>
                                            <th><i class="text-center"></i> Item</th>
                                            <th><i class="text-center"></i> Marca</th>
                                            <th><i class="text-center"></i> Situação</th>
                                            <th><i class="text-center"></i> Ano GM</th>
                                            <th><i class="text-center"></i> Quantidade</th>
                                            <th><i class="text-center"></i> Valor Unitário</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (FolhanItem folhaitem : folhaEquipagem) {
                                                total = total + folhaitem.getVlUnitario();%>
                                        <tr>
                                            <td><%out.print(folhaitem.getNumeroIdentificacao());%></td>
                                            <td><%out.print(folhaitem.getNomeItem());%></td>
                                            <td><%out.print(folhaitem.getNomeFantasia());%></td>
                                            <td><%out.print(folhaitem.getNomeMovimentacao());%></td>
                                            <td><%out.print(folhaitem.getAnoGM());%></td>
                                            <td><%out.print(folhaitem.getQnt());%></td>
                                            <td><%out.print(folhaitem.getVlUnitario());%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <h4 class="text-right" style="margin-right: 30px">Total de R$ <%out.print(total);%></h4>
                                <%total = 0;%>
                                <br>
                                <h4 class="centered">Material Emprestado</h4>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Identificador</th>
                                            <th><i class="text-center"></i> Item</th>
                                            <th><i class="text-center"></i> Marca</th>
                                            <th><i class="text-center"></i> Situação</th>
                                            <th><i class="text-center"></i> Ano GM</th>
                                            <th><i class="text-center"></i> Quantidade</th>
                                            <th><i class="text-center"></i> Valor Unitário</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (FolhanItem folhaitem : folhaEmprestimo) {
                                                total = total + folhaitem.getVlUnitario();%>
                                        <tr>
                                            <td><%out.print(folhaitem.getNumeroIdentificacao());%></td>
                                            <td><%out.print(folhaitem.getNomeItem());%></td>
                                            <td><%out.print(folhaitem.getNomeFantasia());%></td>
                                            <td><%out.print(folhaitem.getNomeMovimentacao());%></td>
                                            <td><%out.print(folhaitem.getAnoGM());%></td>
                                            <td><%out.print(folhaitem.getQnt());%></td>
                                            <td><%out.print(folhaitem.getVlUnitario());%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <h4 class="text-right" style="margin-right: 30px" >Total de R$ <%out.print(total);%></h4>
                                <%total = 0;
                                    }%>
                            </div>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->
                    </div><!--/row -->
                </section>
            </section>
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
