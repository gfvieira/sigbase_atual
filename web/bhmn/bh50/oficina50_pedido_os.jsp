<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="src.modelo.Pedido_move"%>
<%@page import="src.modelo.Pedido_model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%Pedido_model oficina = (Pedido_model) request.getAttribute("oficina");
    String os = oficina.getOs();%>
<%ArrayList<Pedido_move> list = (ArrayList<Pedido_move>) request.getAttribute("oficinamove");%>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
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
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form class="form-horizontal style-form" action="">
                                    <h3 class="centered"><i class="fa fa-angle-double-right"></i> <b>Detalhes da OS:</b> <i><%out.println(oficina.getOs());%></i> </h3><br><br>
                                    <h4 class="mb centered"><i class="fa fa-angle-double-down"></i> <b>Status:</b> <i><%out.println(oficina.getStatus());%></i> </h4>
                                    <hr>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getPost());%>-<%out.print(oficina.getNome());%></p>
                                        </div>
                                        <label class="col-sm-1 col-sm-2 control-label">NIP:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getNip());%></p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Ramal:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getRamal());%></p>
                                        </div>
                                        <label class="col-sm-1 col-sm-2 control-label">Setor:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getSetor());%></p>
                                        </div>                                            
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Atendimento:</label>
                                        <div class="col-sm-8">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getAtendimento());%></p>
                                        </div>
                                    </div><div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Solicitação:</label>
                                        <div class="col-sm-8">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getSolicitacao());%></p>
                                        </div>
                                    </div>
                                    <%if (oficina.getDataevento() == null) {%>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                                        <div class="col-sm-8">
                                            <p class="form-control-static" style="text-align: left;"><%out.println(oficina.getDescricao());%></p>
                                        </div>
                                    </div>
                                    <%}
                                if (oficina.getDataevento() != null) {%>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Data do Evento:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.println(oficina.getDataevento());%></p>
                                        </div>
                                        <label class="col-sm-2 col-sm-2 control-label">Pessoa a Bordo:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.println(oficina.getPob());%></p>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Saida BHMN:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.println(oficina.getHoraevento());%></p>
                                        </div> 
                                        <label class="col-sm-2 col-sm-2 control-label">Previsão de Retorno:</label>
                                        <div class="col-sm-3">
                                            <p class="form-control-static" style="text-align: left;"><%out.println(oficina.getHorafim());%></p>
                                        </div>                             
                                    </div>
                                    <%}%>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Observação:</label>
                                        <div class="col-sm-8">
                                            <p class="form-control-static" style="text-align: left;"><%out.print(oficina.getObs());%></p>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>    
                        <div class="col-md-12 mt">
                            <div class="content-panel">
                                <table class="table table-hover">
                                    <h4><i class="fa fa-angle-right centered"></i> HISTORICO</h4>
                                    <hr>
                                    <thead>
                                        <tr>
                                            <th><i class="fa fa-angle-double-right text-center"></i> DATA</th>
                                            <th><i class="fa fa-angle-double-right text-center"></i> MOVIMENTAÇÃO</th>
                                            <th><i class="fa fa-angle-double-right text-center"></i> IP</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Pedido_move satemove : list) {%>
                                        <tr>
                                            <td><%out.print(satemove.getDatacadmov());%> / <%out.print(satemove.getHoracadmov());%></td>
                                            <td><%out.print(satemove.getDescricao_move());%></td>
                                            <td><%out.print(satemove.getIp());%></td>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div><! --/content-panel -->
                        </div><!-- /col-md-12 -->
                        <%if (oficina.getStatus().equals("EM ANDAMENTO")) {%>
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form class="form-horizontal style-form" action="Movi50.jsp" method="post">
                                    <div class="form-group"><br>
                                        <label class="col-sm-2 col-sm-2 control-label">Lançamento</label>
                                        <div class="col-sm-8">
                                            <input type="hidden" class="form-control" id="os" name="os" value="<%out.print(os);%>">
                                            <input type="text" class="form-control" id="mov" name="mov" maxlength="100" required="">
                                            <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                        </div>
                                    </div>                                    
                                    <button type="submit" class="btn btn-theme center-block">Registrar Lançamento:</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form class="form-horizontal style-form" action="UploadFile50.jsp" method="post" enctype="multipart/form-data">
                                    <div class="form-group"><br>
                                        <label class="col-sm-3 col-sm-3 control-label">Inserir Relação de material</label>
                                        <div class="col-sm-8">
                                            <input type="hidden" class="form-control" id="of" name="of" value="<%out.print(oficina.getAtendimento());%>">
                                            <input type="hidden" class="form-control" id="os" name="os" value="<%out.print(os);%>">
                                            <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                            <input type="file" class="" id="file" name="file" size="500" multiple required >
                                        </div>
                                    </div>                                    
                                    <button type="submit" class="btn btn-theme center-block">Registrar Lançamento:</button>
                                </form>
                            </div>
                        </div>
                        <br>
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form class="form-horizontal style-form" action="Finaly50.jsp" method="post">
                                    <div class="form-group"><br>
                                        <label class="col-sm-2 col-sm-2 control-label">Finalizar?</label>
                                        <div class="col-sm-8">
                                            <input type="hidden" class="form-control" id="os" name="os" value="<%out.print(os);%>">
                                            <input type="text" class="form-control" id="mov" name="mov" maxlength="100" required="">
                                            <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                        </div>
                                    </div>                                    
                                    <button type="submit" class="btn btn-theme center-block">Finalizar</button>
                                </form>
                            </div>
                            <br>
                            <br>
                        </div>
                        <br>
                        <%if (usuario.getTypeAccess().equals("ENCARREGADOBH53")
                                    || usuario.getTypeAccess().equals("ENCARREGADOBH52")
                                    || usuario.getTypeAccess().equals("CHEFEBH50")) {%> 
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form class="form-horizontal style-form" action="TrocarOf50.jsp" method="post">
                                    <div class="form-group">
                                        <br>
                                        <label class="col-sm-3 col-sm-3 control-label">Redirecionar para oficina:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" size="1" name="atendimento" required>
                                                <option value="">Selecione!</option>
                                                <option value="ELETRICA">Elétrica</option>
                                                <option value="REFRIGERACAO">Refrigeração</option>
                                                <option value="CARPINTARIA">Carpintaria</option>
                                                <option value="METALUGIA">Metalurgia</option>
                                                <option value="PREFEITURA">Prefeitura</option>
                                                <option value="AGUADA">CAV-Aguada</option>
                                            </select>
                                            <input type="hidden" class="form-control" id="os" name="os" value="<%out.println(os);%>">
                                            <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>" > 
                                        </div>
                                        <button type="submit" class="btn btn-theme">Registrar Alteração</button>
                                        <br>
                                    </div>                                    
                                </form>
                            </div>
                        </div>
                        <%}
                            }%>
                    </div><!--/row -->
                </section>
            </section>

            <!--main content end-->

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
