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
    String password = (String) request.getAttribute("senha");
    String temp = (String) request.getAttribute("status");%>

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
                    <div class="row">
                        <div class="col-lg-10 main-chart">
                            <div class="form-panel">
                                <h3 class="mb"><i class="fa fa-angle-double-right"></i> <b>SECOM</b> - Serviço de disponibilização de documentos<i></i> </h3>
                                <h3 class="mb text-center"><i class="fa fa-angle-double-down"></i> <b>Ordens de Serviço</b><i></i> </h3><br><br>
                                <%if (temp != null) {
                                        if (temp.equals("OK")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Documento salvo com sucesso!</div>
                                <%} else if (temp.equals("NOT")) {%>
                                <div class="alert alert-danger centered"><b>Error!</b> Documento não foi salvo!</div>
                                <%} else {%>
                                <div class="alert alert-danger"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                    }%>
                                <form class="form-horizontal style-form" action="UploadFile.jsp" method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label class="col-sm-1 col-sm-2 control-label">Mês:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="mes" required>
                                                <option value="01">Janeiro</option>
                                                <option value="02">Fevereiro</option>
                                                <option value="03">Março</option>
                                                <option value="04">Abril</option>
                                                <option value="05">Maio</option>
                                                <option value="06">Junho</option>
                                                <option value="07">Julho</option>
                                                <option value="08">Agosto</option>
                                                <option value="09">Setembro</option>
                                                <option value="10">Outubro</option>
                                                <option value="11">Novembro</option>
                                                <option value="12">Dezembro</option>
                                            </select>
                                        </div> 
                                        <label class="col-sm-1 col-sm-2 control-label">Ano:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="ano" required>
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
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Nome do Documento:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o nome do documento" maxlength="200" required>
                                            <input type="hidden" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Documento:</label>
                                        <div class="col-sm-4">
                                            <input type="file" class="" id="file" name="file" size="50" required>
                                        </div>

                                    </div>
                                    <br>
                                    <hr>
                                    <br>
                                    <div>
                                        <button type="submit" class="btn btn-theme">Enviar</button>
                                        <input type="button"  class="btn btn-theme"  value="Cancelar" onClick="Voltar()">
                                    </div>
                                    <br>
                                </form>
                            </div>
                        </div><!-- /col-lg-9 END SECTION MIDDLE -->
                    </div><!--/row -->
                    <br><br><br><br><br>
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
