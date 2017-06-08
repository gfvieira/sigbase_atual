<%@page import="src.modelo.Meta_model"%>
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
<%ArrayList<Meta_model> list = (ArrayList<Meta_model>) request.getAttribute("metaarray");%>
<%String temp = (String) request.getAttribute("mensagem");%>
<%Integer setor = (Integer) request.getAttribute("setor");%>
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
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Metas BH-50</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh50_meta_inserir.jsp">Inserir</a></li>
                                <li><a href="ListaMeta.jsp?setor=51&userDiv=50&ano=<%out.print(year);%>">Visualizar BH-51</a></li>
                                <li><a href="ListaMeta.jsp?setor=52&userDiv=50&ano=<%out.print(year);%>">Visualizar BH-52</a></li>
                                <li><a href="ListaMeta.jsp?setor=53&userDiv=50&ano=<%out.print(year);%>">Visualizar BH-53</a></li>
                                <li><a href="ListaMeta.jsp?setor=54&userDiv=50&ano=<%out.print(year);%>">Visualizar BH-54</a></li>
                                <li><a href="ListaMeta.jsp?setor=55&userDiv=50&ano=<%out.print(year);%>">Visualizar BH-55</a></li>
                            </ul>
                        </li>                        
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

            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="content-panel">
                                <h2 class="centered">Metas do BH-<%out.print(setor);%></h2>
                                <%if (list.size() > 0) {%>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i></th>
                                            <th><i class="text-center"></i> Prazo</th>
                                            <th><i class="text-center"></i> Meta</th>
                                            <th><i class="text-center"></i> Porcentagem concluida</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Meta_model meta : list) {%>
                                        <tr>
                                            <td width="50">
                                                <form class="col-sm-2 control-label">      
                                                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal<%out.print(meta.getId());%>" title="ATUALIZAR META"><i class="fa fa-pencil"></i></button>
                                                </form>
                                                <div class="modal fade bs-example-modal-sm" id="myModal<%out.print(meta.getId());%>" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog modal-sm">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                                <h4 class="modal-title" id="myModalLabel">Porcentagem Concluida:</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form  class="form login" name="form1" action="UpdateMeta.jsp" method="post">
                                                                    <div class="login-wrap">
                                                                        <select class="form-control" size="1" name="porcent">
                                                                            <option value="Selecione">Selecione!</option>
                                                                            <option value="10">10%</option>
                                                                            <option value="20">20%</option>
                                                                            <option value="30">30%</option>
                                                                            <option value="40">40%</option>
                                                                            <option value="50">50%</option>
                                                                            <option value="60">60%</option>
                                                                            <option value="70">70%</option>
                                                                            <option value="80">80%</option>
                                                                            <option value="90">90%</option>
                                                                            <option value="100">100%</option>
                                                                        </select>
                                                                        <br><br>
                                                                        <input type="hidden" name="meta_id" value="<%out.print(meta.getId());%>" > 
                                                                        <input type="hidden" name="user" value="<%out.print(usuario.getNip());%>" > 
                                                                        <input type="hidden" name="setor" value="<%out.print(meta.getSetor());%>" > 
                                                                        <input type="hidden" name="userDiv" value="50" > 
                                                                        <button class="btn btn-theme btn-block" type="submit" ><i class="glyphicon glyphicon-ok-circle"></i> Enviar</button>
                                                                        <hr>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                            <%switch (meta.getTipo()) {
                                                    case 3:%><td width="100" style=" color: red">Longo Prazo</td><%
                                                    break;
                                                case 2:%><td width="100" style=" color: darkgreen">Médio Prazo</td><%
                                                break;
                                            case 1:%><td width="100" style=" color: blue">Curto Prazo</td><%
                                                    break;
                                                default:%><%
                                            }%>

                                            <td width="600"><%out.print(meta.getMeta());%></td>
                                            <td>
                                                <div class="progress">
                                                    <%if (meta.getConcluido() <= 30) {%>
                                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%} else if (meta.getConcluido() > 30 && meta.getConcluido() < 70) {%>
                                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%} else {%>
                                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<%out.print(meta.getConcluido());%>" aria-valuemin="0" aria-valuemax="100" style="width: <%out.print(meta.getConcluido());%>%;">
                                                        <%out.print(meta.getConcluido());%>%
                                                    </div>
                                                    <%}%>
                                                </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <%} else {%>
                                <h2 class="centered">Não existem metas para este Setor!</h2>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><i class="text-center"></i></th>
                                            <th><i class="text-center"></i> Prazo</th>
                                            <th><i class="text-center"></i> Meta</th>
                                            <th><i class="text-center"></i> Porcentagem concluida</th>
                                        </tr>
                                    </thead>
                                </table>
                                <%}%>
                            </div>
                            <br>
                        </div>
                    </div><! --/row -->
                </section>
            </section>
            <!--footer end-->
        </section>
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

        <!--script for this page-->
        <script src="../assets3/js/sparkline-chart.js"></script>    
        <script src="../assets3/js/zabuto_calendar.js"></script>



        <script type="application/javascript">
            $(document).on("input", "#TxtObservacoes", function () {
            var limite = 5000;
            var caracteresDigitados = $(this).val().length;
            var caracteresRestantes = limite - caracteresDigitados;

            $(".caracteres").text(caracteresRestantes);
            });
        </script>


    </body>
</html>
