<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="src.modelo.Indicador_model"%>
<%@page import="src.modelo.Usuario"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
Timestamp tm = new Timestamp(System.currentTimeMillis());
    String t = new SimpleDateFormat("yyyy").format(tm);
    int year = Integer.parseInt(t);%>
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
                            <a class="active" href="../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="BH50.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-50</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="BH50.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
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
                    <div class="row">
                        <div class="col-lg-10 main-chart">
                            <div class="form-panel">
                                <h3 class="mb"><i class="fa fa-angle-double-right"></i><i>Serviço de cadastro de viatura.</i> </h3><br><br>
                                <form class="form-horizontal style-form" action="OficinaBh50_cadViatura.jsp" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-1 col-sm-2 control-label">Status</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" size="1" name="status" required>
                                                <option value="">Selecione!</option>
                                                <option value="0">Operante</option>
                                                <option value="1">Inoperante</option>
                                            </select>
                                        </div>      
                                        <label class="col-sm-1 col-sm-2 control-label">Tipo</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" size="1" name="tipo" required>
                                                <option value="">Selecione!</option>
                                                <option value="0">Caminhão</option>
                                                <option value="1">Ônibus</option>
                                                <option value="2">Van</option>
                                                <option value="3">Pick-up</option>
                                                <option value="4">Passeio</option>
                                            </select>
                                        </div>                                            
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Marca</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="marca" name="marca" placeholder="Marca do veiculo" maxlength="200" required>
                                        </div>
                                        <label class="col-sm-1 col-sm-2 control-label">Modelo</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="modelo" name="modelo" placeholder="Modelo do veiculo" maxlength="30" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Ano</label>
                                        <div class="col-sm-3">
                                            <select class="form-control" size="1" name="ano" required>
                                                <option value="">Selecione!</option>
                                                <%for(int i = year; i > 1960; i--){
                                                    %><option value="<%out.print(i);%>"><%out.print(i);%></option><%}%>
                                            </select>                                        
                                        </div>
                                            <label class="col-sm-2 col-sm-2 control-label">Data da Vistoria</label>
                                        <div class="col-sm-4">
                                            <input type="date" class="form-control" id="dataVistoria" name="dataVistoria" placeholder="Data da Vistoria do Veículo" maxlength="10" required>
                                        </div>
                                    </div>
                                    <br>
                                    <hr>
                                    <br>
                                    <div>
                                        <input type="hidden" id="user" name="user" value="<%out.print(usuario.getTypeAccess());%>" > 
                                        <button type="submit" class="btn btn-theme">Cadastrar</button>
                                        <input type="button"  class="btn btn-theme"  value="Cancelar" onClick="Voltar()">
                                    </div>
                                    <br>
                                </form>
                            </div>
                        </div>
                    </div><!--/row -->
                    <br><br><br><br><br>
                </section>
            </section>

            <!--main content end-->
            <!--footer start-->
            
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
