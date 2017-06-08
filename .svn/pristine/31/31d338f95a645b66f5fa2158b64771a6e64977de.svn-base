<%@page import="src.modelo.Chapa_Permissionario"%>
<%@page import="src.modelo.Chapa_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="src.modelo.Chapa_Apto_model"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    ArrayList<String> apts = (ArrayList<String>) request.getAttribute("aptos");
    String bloco = (String) request.getAttribute("bloco");
    ArrayList<Chapa_Permissionario> moradoresDoBloco = (ArrayList<Chapa_Permissionario>) request.getAttribute("moradoresDoBloco");
    Chapa_Permissionario moradorAtual = null;
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
%>

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
                <a href="#" class="logo"><b>SIG-BASE || CHAPA</b></a>
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
                        <%}
                            if (usuario.getPri().equals("BH30")) {%>
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

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->

            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-md-12 mt">
                            <div class="content-panel">
                                <%if (apts.size() == 0) {%>
                                <h2 class="centered">Fila vazia!</h2>
                                <%} else {%>
                                <h2 class="centered"><%out.print(apts.size());%> Apartamento(s)</h2>
                                <%}%>
                                <hr>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i> Apartamento</th>
                                            <th><i class="text-centerr"></i> Bloco</th>
                                            <th><i class="text-center"></i> Permissionário</th>
                                            <th><i class="text-center"></i>Editar/Incluir</th>
                                            <th><i class="text-center"></i>Excluir</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (String apt : apts) {%>
                                        <tr>
                                            <td class="col-sm-2"><%out.print(apt);%></td>
                                            <td class="col-sm-2"><%out.print(bloco);%></td>
                                            <% boolean temMorador = false;
                                                for (Chapa_Permissionario morador : moradoresDoBloco) {
                                                    if (morador.getApto().equals(apt)) {
                                                        moradorAtual = morador;
                                                        System.out.println(moradorAtual.getNip());
                                                        temMorador = true;
                                                    }
                                                }
                                                if (temMorador) {
                                                    String nipa = moradorAtual.getNip().replace(".", "");%>
                                            <td class="col-sm-4"><%out.print(moradorAtual.getNome());%></td>
                                            <td class="col-sm-2">                                                
                                                    <form action="ExibePermissionario.jsp" method="post">      
                                                        <button type="submit" title="EXIBIR PERMISSIONARIO" class="btn btn-primary btn-xs"><i class="fa fa-check"></i></button>
                                                        <input type="hidden" class="form-control" id="nip" name="nip" value="<% out.print(moradorAtual.getNip()); %>" >
                                                        <input type="hidden" id="apto" name="apto" value="<%out.print(apt);%>">
                                                        <input type="hidden" id="bloco" name="bloco" value="<%out.print(bloco);%>">
                                                    </form>
                                            </td>
                                            <td class="col-sm-2">
                                                <button title="Excluir Permissionários" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal<%out.print(nipa);%>"><i class="fa fa-trash-o"></i></button>
                                                <div class="modal fade" id="myModal<%out.print(nipa);%>" role="dialog">
                                                    <div class="modal-dialog">
                                                        <!-- Modal content-->
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                <h4 class="modal-title">Desalocar Permissionário</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <p>Tem certeza que deseja desalocar este Permissionário deste apartamento?</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <form class="col-sm-2 control-label" action="RetiraPermissionario.jsp" method="post">
                                                                    <input type="hidden" id="nip" name="nip" value="<%out.print(moradorAtual.getNip());%>" > 
                                                                    <input type="hidden" id="apto" name="apto" value="<%out.print(apt);%>" > 
                                                                    <input type="hidden" id="bloco" name="bloco" value="<%out.print(bloco);%>" >
                                                                    <button type="submit" class="btn btn-default">Sim</button>
                                                                </form>
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>                                                    
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </td>
                                            <% moradorAtual = null;
                                                temMorador = false;
                                            } else {%>
                                            <td class="col-sm-4">-</td>
                                            <td class="col-sm-2">
                                                <form class="control-label" action="ListaCadPermissionario.jsp" method="post"> 
                                                    <input type="hidden" id="type" name="type" value="1" > 
                                                    <input type="hidden" id="apto" name="apto" value="<%out.print(apt);%>" > 
                                                    <input type="hidden" id="bloco" name="bloco" value="<%out.print(bloco);%>" >
                                                    <button type="submit" title="Incluir" class="btn btn-primary btn-xs"><i class="fa fa-check"></i></button>
                                                </form>
                                            </td>
                                            <td class="col-sm-2">-</td>
                                            <%}%>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>


                            </div><!--/row -->
                        </div>
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

        <script type="text/javascript">
                                $(document).ready(function () {
                                    var unique_id = $.gritter.add({
                                        // (string | mandatory) the heading of the notification
                                        title: 'Bem-vindo ao SIG-BASE!',
                                        // (string | mandatory) the text inside the notification
                                        //text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
                                        // (string | optional) the image to display on the left
                                        image: 'assets2/img/CBV.png',
                                        // (bool | optional) if you want it to fade out on its own or just sit there
                                        sticky: true,
                                        // (int | optional) the time you want it to be alive for before fading out
                                        time: '',
                                        // (string | optional) the class name you want to apply to that specific message
                                        class_name: 'my-sticky-class'
                                    });

                                    return false;
                                });
        </script>

        <script type="text/javascript">
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
