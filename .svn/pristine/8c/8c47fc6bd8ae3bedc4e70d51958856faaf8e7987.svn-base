<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="src.modelo.Indicador_model"%>
<%@page import="src.modelo.Usuario"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    double qntd = (Integer) request.getAttribute("qnt");
    Indicador_model el = (Indicador_model) request.getAttribute("eletrica");
    Indicador_model mo = (Indicador_model) request.getAttribute("refrigeracao");
    Indicador_model cp = (Indicador_model) request.getAttribute("carpintaria");
    Indicador_model mt = (Indicador_model) request.getAttribute("metalurgia");
    Indicador_model cav = (Indicador_model) request.getAttribute("cav");
    Indicador_model prefe = (Indicador_model) request.getAttribute("prefeitura");
    Indicador_model moto = (Indicador_model) request.getAttribute("garagem");
    DecimalFormat df = new DecimalFormat("0.00");%>
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
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12 main-chart">
                            <%if (usuario.getTypeAccess().equals("CHEFEBH50")
                                        || usuario.getPri().equals("TOTAL")) {%>
                            <div class="row">

                                <div class="col-lg-12 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>Departamento de Apoio || BH-50</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(qntd));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(qntd / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">ELÉTRICA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">REFRIGERAÇÃO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">CARPINTARIA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">METALURGIA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">CAV-AGUADA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">PREFEITURA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(prefe.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((prefe.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 4%;">
                                                <div class="title">GARAGEM</div>
                                                <div class="value tooltips" data-original-title="<%out.print(moto.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((moto.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->
                                </div>
                                <%}%>
                            </div>
                            <%if (usuario.getTypeAccess().equals("ENCARREGADOBH52")
                                        || usuario.getPri().equals("TOTAL")) {%>
                            <div class="row">

                                <div class="col-lg-12 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>Divisão de Manutenção e Reparos || BH-52</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(qntd));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((qntd / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(qntd / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="margin: 0px 6%;">
                                                <div class="title">ELÉTRICA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 6%;">
                                                <div class="title">REFRIGERAÇÃO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 6%;">
                                                <div class="title">CARPINTARIA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 6%;">
                                                <div class="title">METALURGIA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                            <div class="bar" style="margin: 0px 6%;">
                                                <div class="title">CAV-AGUADA</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getTotal());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getTotal() * 100) / qntd);%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->
                                </div>
                                <%}%>
                            </div>
                            <%if ((usuario.getTypeAccess().equals("ELETRICA")
                                        || usuario.getPri().equals("TOTAL")) && el != null) {%>
                            <div class="row">

                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>OFICINA DE ELETRÍCIDADE</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(el.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((el.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((el.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((el.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(el.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getAguadando_enc() * 100) / el.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getNao_iniciado() * 100) / el.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getEm_andamento() * 100) / el.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(el.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((el.getFinalizado() * 100) / el.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /panr -->	
                                </div>
                                <%}%>

                            </div>
                            <% if ((usuario.getTypeAccess().equals("REFRIGERACAO")
                                        || usuario.getPri().equals("TOTAL")) && mo != null) {%>
                            <div class="row">
                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>OFICINA DE REFRIGERAÇÃO</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(mo.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((mo.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((mo.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((mo.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(mo.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title" >AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getAguadando_enc() * 100) / mo.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title" >NÃO INICADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getNao_iniciado() * 100) / mo.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getEm_andamento() * 100) / mo.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mo.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((mo.getFinalizado() * 100) / mo.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /pane -->	
                                </div>
                            </div>
                            <%}%>
                            <%if ((usuario.getTypeAccess().equals("CARPINTARIA")
                                        || usuario.getPri().equals("TOTAL")) && cp != null) {%>
                            <div class="row ">
                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>CARPINTARIA</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(cp.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((cp.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((cp.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((cp.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(cp.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getAguadando_enc() * 100) / cp.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getNao_iniciado() * 100) / cp.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getEm_andamento() * 100) / cp.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cp.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((cp.getFinalizado() * 100) / cp.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->	
                                </div>
                                <%}%>

                            </div>
                            <%  if ((usuario.getTypeAccess().equals("METALURGIA")
                                        || usuario.getPri().equals("TOTAL")) && mt != null) {%>
                            <div class="row ">
                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>METALURGIA</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(mt.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((mt.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((mt.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((mt.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(mt.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getAguadando_enc() * 100) / mt.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getNao_iniciado() * 100) / mt.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getEm_andamento() * 100) / mt.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(mt.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((mt.getFinalizado() * 100) / mt.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->	
                                </div>
                                <%}%>
                            </div>
                            <%if ((usuario.getTypeAccess().equals("PREFEITURA")
                                        || usuario.getPri().equals("TOTAL")
                                        || usuario.getTypeAccess().equals("ENCARREGADOBH53")) && prefe != null) {%>
                            <div class="row ">

                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>PREFEITURA NAVAL</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(prefe.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((prefe.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((prefe.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((prefe.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(prefe.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(prefe.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((prefe.getAguadando_enc() * 100) / prefe.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(prefe.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((prefe.getNao_iniciado() * 100) / prefe.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(prefe.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((prefe.getEm_andamento() * 100) / prefe.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(prefe.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((prefe.getFinalizado() * 100) / prefe.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->	
                                </div>
                                <%}%>
                            </div>
                            <% if ((usuario.getTypeAccess().equals("AGUADA")
                                        || usuario.getPri().equals("TOTAL")) && cav != null) {%>
                            <div class="row ">
                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>OFICINA DE CAV | AGUADA</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(cav.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((cav.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((cav.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((cav.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(cav.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getAguadando_enc() * 100) / cav.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getNao_iniciado() * 100) / cav.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getEm_andamento() * 100) / cav.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(cav.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((cav.getFinalizado() * 100) / cav.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->	
                                </div>
                                <%}%>
                            </div>
                            <%if ((usuario.getTypeAccess().equals("GARAGEM")
                                        || usuario.getTypeAccess().equals("ENCARREGADOBH53")
                                        || usuario.getPri().equals("TOTAL")) && moto != null) {%>
                            <div class="row">
                                <div class="col-lg-10 main-chart">
                                    <div class="content-panel">		
                                        <!--CUSTOM CHART START -->
                                        <div class="border-head">
                                            <h3>GARAGEM</h3>
                                        </div>
                                        <div class="custom-bar-chart">
                                            <ul class="y-axis">
                                                <li><span><%out.print(df.format(moto.getTotal()));%></span></li>
                                                <li><span><%out.print(df.format((moto.getTotal() / 5) * 4));%></span></li>
                                                <li><span><%out.print(df.format((moto.getTotal() / 5) * 3));%></span></li>
                                                <li><span><%out.print(df.format((moto.getTotal() / 5) * 2));%></span></li>
                                                <li><span><%out.print(df.format(moto.getTotal() / 5));%></span></li>
                                                <li><span>0</span></li>
                                            </ul>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">AGUARDANDO ENCARREGADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(moto.getAguadando_enc());%>" data-toggle="tooltip" data-placement="top"><%out.print((moto.getAguadando_enc() * 100) / moto.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">NÃO INICIADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(moto.getNao_iniciado());%>" data-toggle="tooltip" data-placement="top"><%out.print((moto.getNao_iniciado() * 100) / moto.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">EM ANDAMENTO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(moto.getEm_andamento());%>" data-toggle="tooltip" data-placement="top"><%out.print((moto.getEm_andamento() * 100) / moto.getTotal());%>%</div>
                                            </div>
                                            <div class="bar" style="width: 10%; margin: 0px 6%;">
                                                <div class="title">FINALIZADO</div>
                                                <div class="value tooltips" data-original-title="<%out.print(moto.getFinalizado());%>" data-toggle="tooltip" data-placement="top"><%out.print((moto.getFinalizado() * 100) / moto.getTotal());%>%</div>
                                            </div>
                                        </div>
                                    </div><!-- /row -->	
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>
                    <!-- **********************************************************************************************************************************************************
                    RIGHT SIDEBAR CONTENT
                    *********************************************************************************************************************************************************** -->                  

                    </div><!--/row -->
                    <br><br><br><br><br>
                </section>
            </section>

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
