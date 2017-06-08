<%@page import="src.modelo.Usuario"%>
<%@page import="src.modelo.Pedido_model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%ArrayList<Pedido_model> list = (ArrayList<Pedido_model>) request.getAttribute("sate");
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    int qntd = (Integer) request.getAttribute("qnt");%>
<%@ page contentType="text/html; charset=UTF-8" %>
    <%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE</title>
        <!--<link rel="shortcut icon" href="assets/images/gt_favicon.png">-->
        <!-- Bootstrap core CSS -->
        <link href="../assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="../assets3/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="../assets3/css/style.css" rel="stylesheet">
        <link href="../assets3/css/style-responsive.css" rel="stylesheet">
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="../assets3/js/time_session.js" type="text/javascript"></script>



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
                <a href="#" class="logo"><b>SIG-BASE || DEPARTAMENTO DE APOIO BH-50</b></a>
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
                                <span>Principal BH-50</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-34</span>
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
                            <a  href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-34</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Pedidos</span>
                            </a>
                            <ul class="sub">
                                <li><a href="OfList.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=EM">Aguardando aprovação</a></li>
                                <li><a href="OfList.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=NOT">Não Iniciado</a></li>
                                <li><a href="OfList.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=IN">Em Aberto</a></li>
                                <li><a href="OfList.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=MES">Pedidos do Mês</a></li>
                                <li><a href="OfList.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=ALL">Todos os Pedidos</a></li>
                                <li><a  href="bh50_pedidos_por_oficina.jsp">Pedidos por Oficina</a></li>
                            </ul>
                        </li>
                        <%if (usuario.getTypeAccess().equals("ENCARREGADOBH")
                                    || usuario.getTypeAccess().equals("ENCARREGADOBH")
                                    || usuario.getTypeAccess().equals("ENCARREGADOBH")) {%>                  
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Faturamento</span>
                            </a>
                            <ul class="sub">
                                <li><a href="Faturar.jsp">Faturar</a></li>
                                <li><a href="Faturado.jsp?fat=MES">Faturado no Mês</a></li>
                                <li><a href="Faturado.jsp?fat=ALL">Todas as Faturas</a></li>
                            </ul>
                        </li><%}%>  
                        <%if (usuario.getTypeAccess().equals("CHEFEBH50")
                                    || usuario.getTypeAccess().equals("GARAGEM")
                                    || usuario.getTypeAccess().equals("ENCARREGADOBH53")
                                    || usuario.getTypeAccess().equals("TOTAL")) {%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Viaturas</span>
                            </a>
                            <ul class="sub">
                                <li><a href="oficina50_cad_viatura.jsp">Cadastrar</a></li>
                                <li><a href="#">Historico</a></li>
                            </ul>
                        </li><%}%>   
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-tasks"></i>
                                <span>Duvidas?</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="emConstrucao.html">Manual</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="BH50.jsp?ind=MES&access=<%out.print(usuario.getTypeAccess());%>">Do mês</a></li>
                                <li><a  href="oficina50_por_periodo.jsp">Por periodo</a></li>
                                <li><a  href="BH50.jsp?ind=ALL&access=<%out.print(usuario.getTypeAccess());%>">Todos os pedidos</a></li>
                                    <%if (usuario.getTypeAccess().equals("CHEFEBH50")
                                                || usuario.getTypeAccess().equals("ENCARREGADOBH52")
                                                || usuario.getTypeAccess().equals("ENCARREGADOBH53")
                                                || usuario.getTypeAccess().equals("TOTAL")) {%>
                                <li><a  href="bh50_indicadores.jsp">Anual</a></li>
                                    <%}%>
                            </ul>
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
                    <div class="col-md-12 mt">
                        <div class="content-panel">
                            <table class="table table-hover">
                                <%if (qntd == 0) {%>
                                <h2 class="centered">Nenhum Pedido encontrado!</h2>
                                <%} else {%>
                                <h2 class="centered"><%out.println(list.size());%> Pedido(s) Encontrado(s):</h2>
                                <%}%>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> OS</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Solicitante</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Oficina</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Solicitação</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Pedido_model sate : list) {%>
                                    <tr>
                                        <td><%out.println(sate.getOs());%></td>
                                        <td><%out.println(sate.getNome());%></td>
                                        <td><%out.println(sate.getNip());%></td>
                                        <td><%out.println(sate.getAtendimento());%></td>
                                        <td><%out.println(sate.getSolicitacao());%></td>
                                        <%if (sate.getStatus().equals("NÃO INICIADO")) {%>
                                        <td><span class="label label-danger label-mini"><%out.println(sate.getStatus());%></span></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="OsManage.jsp" method="post">      
                                                <button type="submit" title="EXIBIR DADOS DA OS" class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                                <input type="hidden" id="os" name="os" value="<% out.print(sate.getOs()); %>" > 
                                                <input type="hidden" id="type" name="type" value="1" > 
                                                <input type="hidden" id="user" name="user" value="<%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%>" > 
                                            </form>
                                            <form class="col-sm-2 control-label" action="OsManage.jsp" method="post">      
                                                <button type="submit" title="INICIAR OS" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <input type="hidden" class="form-control" id="os" name="os" value="<% out.print(sate.getOs()); %>" >
                                                <input type="hidden" id="type" name="type" value="2" > 
                                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%>" > 
                                            </form>
                                        </td>
                                        <%} else if (sate.getStatus().equals("EM ANDAMENTO")) {%>
                                        <td><span class="label label-warning label-mini"><%out.println(sate.getStatus());%></span></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="OsManage.jsp" method="post">      
                                                <button type="submit" title="EXIBIR DADOS DA OS" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                <input type="hidden" class="form-control" id="os" name="os" value="<% out.print(sate.getOs()); %>" >
                                                <input type="hidden" id="type" name="type" value="1" > 
                                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%>" > 
                                            </form>
                                        </td>
                                        <%} else if (sate.getStatus().equals("FINALIZADO")) {%>
                                        <td><span class="label label-success label-mini"><%out.println(sate.getStatus());%></span></td>
                                        <td>
                                            <form class="col-sm-2 control-label" action="OsManage.jsp" method="post">      
                                                <button type="submit" title="EXIBIR DADOS DA OS" class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                                <input type="hidden" class="form-control" id="os" name="os" value="<% out.print(sate.getOs()); %>" > 
                                                <input type="hidden" id="type" name="type" value="1" > 
                                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%>" > 
                                            </form>
                                        </td>
                                        <%} else {%>
                                        <td><%out.println(sate.getStatus());%></td>
                                        <%}%>
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
            
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="../assets3/js/jquery.js"></script>
        <script src="../assets3/js/jquery-1.8.3.min.js"></script>
        <script src="../assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="../assets3/js/jquery.sparkline.js"></script>


        <!--common script for all pages-->
        <script src="../assets3/js/common-scripts.js"></script>

        <script type="text/javascript" src="../assets3/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="../assets3/js/gritter-conf.js"></script>


    </body>
</html>
