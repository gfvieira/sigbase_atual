<%@page import="src.modelo.Identificacao_model"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="src.modelo.Pedido_model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%ArrayList<Identificacao_model> list = (ArrayList<Identificacao_model>) request.getAttribute("idiarray");
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String type = (String) request.getAttribute("tipo");%>
<%@ page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || IDENTIFICAÇÃO</title>

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
                <a href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>" class="logo"><b>SIG-BASE || <%out.print(usuario.getPost());%> - <%out.print(usuario.getGuerra());%></b></a>
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
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">

                        <p class="centered"><a href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>"><img src="assets2/img/CBV.png" class="img-circle" width="80"></a></p>
                        <h5 class="centered">BHMN</h5>

                        <li class="mt">
                            <a class="active" href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Crachá</span>
                            </a>
                            <ul class="sub">
                                <li><a href="identi_cad_cracha.jsp">Cadastrar</a></li>
                                <li><a href="Listar_identi.jsp?type=CARD">Listar</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Estacionamento</span>
                            </a>
                            <ul class="sub">
                                <li><a href="identi_cad_estacionamento.jsp">Cadastrar</a></li>
                                <li><a href="Listar_identi.jsp?type=PARK">Listar</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-tasks"></i>
                                <span>Duvidas?</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="emConstrucao.html">Manual</a></li>
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
                            <table class="table">
                                <%if (list.isEmpty()) {%>
                                <%if (type.equals("CARD")) {%>
                                <h2 class="centered">Nenhum crachá fora!</h2>
                                <%} else {%>
                                <h2 class="centered">Nenhum cartão de estacionamento fora!</h2>
                                <%}
                                } else{%>
                                <%if (type.equals("CARD")) {%>
                                <h2 class="centered"><%out.print(list.size());%> crachá(s) Encontrado(s):</h2>
                                <%} else {%>
                                <h2 class="centered"><%out.print(list.size());%> cartão(ões) de estacionamento Encontrado(s):</h2>
                                <%}
                                }%>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i>Numero</th>
                                        <th><i class="text-center"></i> Nome</th>
                                        <th><i class="text-center"></i> CPF</th>
                                        <th><i class="text-center"></i> NIP</th>
                                        <th><i class="text-center"></i> Destino</th>
                                        <th><i class="text-center"></i> Telefone</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Identificacao_model idi : list) {%>
                                    <tr class="active">
                                        <%if (type.equals("CARD")) {%>
                                        <td><%out.print(idi.getCracha());%></td>
                                        <%} else {%>
                                        <td><%out.print(idi.getEstacionamento());%></td>
                                        <%}%>
                                        <td><%out.print(idi.getNome());%></td>
                                        <td><%out.print(idi.getCpf());%></td>
                                        <td><%out.print(idi.getNip());%></td>
                                        <td><%out.print(idi.getDestino());%></td>
                                        <td><%out.print(idi.getTelefone());%></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="#" method="post">      
                                                <button type="submit" title="EXIBIR DADOS DA OS" class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                                <input type="hidden" id="cra" name="cra" value="<% out.print(idi.getCracha()); %>" > 
                                                <input type="hidden" id="park" name="park" value="<% out.print(idi.getEstacionamento()); %>" > 
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

        <!--script for this page-->
        <script src="assets2/js/sparkline-chart.js"></script>    
        <script src="assets2/js/zabuto_calendar.js"></script>	


        <script type="application/javascript">
            $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
            $(this).hide();
            });

            $("#my-calendar").zabuto_calendar({
            action: function () {
            return myDateFunction(this.id, false);
            },
            action_nav: function () {
            return myNavFunction(this.id);
            },
            ajax: {
            url: "show_data.php?action=1",
            modal: true
            },
            legend: [
            {type: "text", label: "Special event", badge: "00"},
            {type: "block", label: "Regular event", }
            ]
            });
            });


            function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
            }
        </script>


    </body>
</html>
