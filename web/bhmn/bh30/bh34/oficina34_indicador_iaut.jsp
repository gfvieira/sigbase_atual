<%@page import="src.modelo.Indicador_model_anual"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="src.modelo.Indicador_model"%>
<%@page import="src.modelo.Usuario"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    ArrayList<Indicador_model_anual> sateAnual = (ArrayList<Indicador_model_anual>) request.getAttribute("sate");
    DecimalFormat df = new DecimalFormat("0.0");
    DecimalFormat df2 = new DecimalFormat("0");
    String mes = "01";
    int temp1 = 0;
    int temp = Integer.parseInt(mes);
    switch (temp) {
        case 1:
            mes = "Janeiro";
            break;
        case 2:
            mes = "Fevereiro";
            break;
        case 3:
            mes = "Março";
            break;
        case 4:
            mes = "Abril";
            break;
        case 5:
            mes = "Maio";
            break;
        case 6:
            mes = "Junho";
            break;
        case 7:
            mes = "Julho";
            break;
        case 8:
            mes = "Agosto";
            break;
        case 9:
            mes = "Setembro";
            break;
        case 10:
            mes = "Outubro";
            break;
        case 11:
            mes = "Novembro";
            break;
        case 12:
            mes = "Dezembro";
            break;
    }

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

        <title>SIG-BASE || DIVISÃO DE TELEMÁTICA</title>

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
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Clique Aqui Para Abrir/Fechar Menu"></div>
                </div>
                <!--logo start-->
                <a href="#" class="logo"><b>SIG-BASE || Divisão de Telemática BH-34</b></a>
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
                            <a href="../bh30_home.jsp">
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
                        <%if (!usuario.getPri().equals("TOTAL")) {%>
                        <li class="mt">
                            <a class="active" href="oficina34_sate.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>SATE</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Pedidos</span>
                            </a>
                            <ul class="sub">
                                <li><a href="List.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=EM">Aguardando aprovação</a></li>
                                <li><a href="List.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=NOT">Não Iniciado</a></li>
                                <li><a href="List.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=IN">Em Aberto</a></li>
                                <li><a href="List.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=MES">Pedidos do Mês</a></li>
                                <li><a href="List.jsp?access=<%out.print(usuario.getTypeAccess());%>&type=ALL">Todos os Pedidos</a></li>
                            </ul>
                        </li>
                        <%if (usuario.getTypeAccess().equals("TELEFONIA")
                                    || usuario.getPri().equals("TOTAL")) {%>                  
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Pedidos de Som</span>
                            </a>
                            <ul class="sub">
                                <li><a href="List.jsp?access=SOM&type=EM">Aguardando aprovação</a></li>
                                <li><a href="List.jsp?access=SOM&type=NOT">Não Iniciado</a></li>
                                <li><a href="List.jsp?access=SOM&type=IN">Em Aberto</a></li>
                                <li><a href="List.jsp?access=SOM&type=MES">Pedidos do Mês</a></li>
                                <li><a href="List.jsp?access=SOM&type=ALL">Todos os Pedidos</a></li>

                            </ul>
                        </li><%}%> 
                        <%if (usuario.getTypeAccess().equals("TELEFONIA")
                                    || usuario.getPri().equals("TOTAL")) {%>                  
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Pedidos do Fonoclama</span>
                            </a>
                            <ul class="sub">
                                <li><a href="List.jsp?access=FONOCLAMA&type=EM">Aguardando aprovação</a></li>
                                <li><a href="List.jsp?access=FONOCLAMA&type=NOT">Não Iniciado</a></li>
                                <li><a href="List.jsp?access=FONOCLAMA&type=IN">Em Aberto</a></li>
                                <li><a href="List.jsp?access=FONOCLAMA&type=MES">Pedidos do Mês</a></li>
                                <li><a href="List.jsp?access=FONOCLAMA&type=ALL">Todos os Pedidos</a></li>
                            </ul>
                        </li><%}%> 
                        <%if (usuario.getTypeAccess().equals("SUPERVISORBH")
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
                        <%if (usuario.getTypeAccess().equals("HARDWARE")
                                    || usuario.getTypeAccess().equals("REDE")
                                    || usuario.getTypeAccess().equals("SUPERVISORBH34")
                                    || usuario.getTypeAccess().equals("ENCARREGADOBH34")
                                    || usuario.getPri().equals("TOTAL")) {%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Controle de IP's</span>
                            </a>
                            <ul class="sub">
                                <li><a href="Hosts.jsp?hostname=DISP">IP Disponível</a></li>
                                <li><a href="oficina34_host_cadastro.jsp">Cadastrar</a></li>
                                <li><a href="Hosts.jsp?hostname=HARDWARE">Estações de Trabalho</a></li>
                                <li><a href="Hosts.jsp?hostname=BIOMETRIA">Biometrias</a></li>
                                <li><a href="Hosts.jsp?hostname=SCANNER">Scanners</a></li>
                                <li><a href="Hosts.jsp?hostname=SERVER">Servidores</a></li>
                                <li><a href="Hosts.jsp?hostname=SWITCH">Switch's</a></li>
                                <li><a href="Hosts.jsp?hostname=PRINT">Impressoras</a></li>
                                <li><a href="Hosts.jsp?hostname=DVR">DVR</a></li>
                                <li><a href="Hosts.jsp?hostname=ALL">Todos IP's</a></li>
                            </ul>
                        </li><%}%> 
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Software</span>
                            </a>
                            <ul class="sub">
                                <li><a href="oficina34_sw.jsp">Enviar</a></li>
                                <li><a href="ListarFile34.jsp?type=home">Listar</a></li>
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
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="BH34.jsp?ind=MES&access=<%out.print(usuario.getTypeAccess());%>">Do mês</a></li>
                                <li><a  href="oficina34_por_periodo.jsp">Por periodo</a></li>
                                <li><a  href="BH34.jsp?ind=ALL&access=<%out.print(usuario.getTypeAccess());%>">Todos os pedidos</a></li>
                                    <%if (usuario.getTypeAccess().equals("SUPERVISORBH34")
                                                || usuario.getTypeAccess().equals("ENCARREGADOBH34")
                                                || usuario.getPri().equals("TOTAL")) {%>  
                                <li><a  href="Exibe_indicador_34.jsp?ind=iauo">Anual Oficinas</a></li>
                                <li><a  href="Exibe_indicador_34.jsp?ind=iaut">Anual Telefônia</a></li>
                                    <%}%>
                            </ul>
                        </li>

                    </ul>
                    <footer class="site-footer">
                        <div class="text-center">
                            <%out.print(year);%> - BHMN
                        </div>
                    </footer>
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row mt">
                        <div class="col-lg-12 main-chart">
                            <div class="content-panel">		
                                <!--CUSTOM CHART START -->
                                <div class="border-head">
                                    <h3>BH-34 | Seção de Telefônia - Indicador de Atendimento ao Usuário (IAUt) </h3>
                                    <h5 class="text-center" style="color: black;font-size: 10px;">(Melhores práticas – Acima de 90%)</h5>
                                </div>
                                <div class="custom-bar-chart">
                                    <ul class="y-axis">
                                        <li><span><%out.print(df.format(100));%></span></li>
                                        <li><span><%out.print(df.format(80));%></span></li>
                                        <li><span><%out.print(df.format(60));%></span></li>
                                        <li><span><%out.print(df.format(40));%></span></li>
                                        <li><span><%out.print(df.format(20));%></span></li>
                                        <li><span>0%</span></li>
                                    </ul>
                                    <%for (Indicador_model_anual sate : sateAnual) {
                                            if (sate.getOficina().equals("TELEFONIA")) {
                                                String mesInd = "";
                                                int mesTemp = Integer.parseInt(sate.getMes());
                                                switch (mesTemp) {
                                                    case 1:
                                                        mesInd = "Janeiro";
                                                        break;
                                                    case 2:
                                                        mesInd = "Fevereiro";
                                                        break;
                                                    case 3:
                                                        mesInd = "Março";
                                                        break;
                                                    case 4:
                                                        mesInd = "Abril";
                                                        break;
                                                    case 5:
                                                        mesInd = "Maio";
                                                        break;
                                                    case 6:
                                                        mesInd = "Junho";
                                                        break;
                                                    case 7:
                                                        mesInd = "Julho";
                                                        break;
                                                    case 8:
                                                        mesInd = "Agosto";
                                                        break;
                                                    case 9:
                                                        mesInd = "Setembro";
                                                        break;
                                                    case 10:
                                                        mesInd = "Outubro";
                                                        break;
                                                    case 11:
                                                        mesInd = "Novembro";
                                                        break;
                                                    case 12:
                                                        mesInd = "Dezembro";
                                                        break;
                                                }
                                                if (temp1 == 0) {
                                                    temp1 = 2; %>  
                                    <div class="bar" style="width: 6%; margin: 0px 4%; margin-left: 50px;">
                                        <%} else {%>
                                        <div class="bar" style="width: 6%; margin: 0px 4%;">
                                            <%}
                                                if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) >= 0.90) {%>
                                            <div class="title" style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></div>
                                            <div class="value tooltips" data-original-title="<%out.print(df.format(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100));%>" data-toggle="tooltip" data-placement="top" style="background: #006400"><%out.print(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100);%>%</div>
                                            <%} else {%>
                                            <div class="title" style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></div>
                                            <div class="value tooltips" data-original-title="<%out.print(df.format(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100));%>" data-toggle="tooltip" data-placement="top" style="background: #ff3333"><%out.print(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100);%>%</div>
                                            <%}%>
                                        </div>
                                        <% }
                                            }%>
                                    </div>
                                </div><!-- /panr -->	
                            </div>
                            <div class="col-lg-12 main-chart">
                                <div class="border-head">
                                    <h3>Numeros de pedidos Fechado / Numeros total de pedidos </h3>
                                </div>
                                <table class="table table-hover">
                                    <hr>
                                    <thead>
                                        <tr>
                                            <%for (Indicador_model_anual sate : sateAnual) {
                                                    if (sate.getOficina().equals("TELEFONIA")) {
                                                        String mesInd = "";
                                                        int mesTemp = Integer.parseInt(sate.getMes());
                                                        switch (mesTemp) {
                                                            case 1:
                                                                mesInd = "Janeiro";
                                                                break;
                                                            case 2:
                                                                mesInd = "Fevereiro";
                                                                break;
                                                            case 3:
                                                                mesInd = "Março";
                                                                break;
                                                            case 4:
                                                                mesInd = "Abril";
                                                                break;
                                                            case 5:
                                                                mesInd = "Maio";
                                                                break;
                                                            case 6:
                                                                mesInd = "Junho";
                                                                break;
                                                            case 7:
                                                                mesInd = "Julho";
                                                                break;
                                                            case 8:
                                                                mesInd = "Agosto";
                                                                break;
                                                            case 9:
                                                                mesInd = "Setembro";
                                                                break;
                                                            case 10:
                                                                mesInd = "Outubro";
                                                                break;
                                                            case 11:
                                                                mesInd = "Novembro";
                                                                break;
                                                            case 12:
                                                                mesInd = "Dezembro";
                                                                break;
                                                        }
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) >= 0.90) {%> 
                                            <th style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></th>
                                                <%} else {%>
                                            <th style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></th>
                                                <%}
                                                        }
                                                    }%>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <%for (Indicador_model_anual sate : sateAnual) {
                                                    if (sate.getOficina().equals("TELEFONIA")) {
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) >= 0.90) {%> 
                                            <td style="color: black;"><%out.print(df2.format(sate.getTotalFechado()));%>/<%out.print(df2.format(sate.getTotalFechado() + (sate.getTotalAberto())));%></td>
                                            <%} else if (sate.getTotalAberto() + sate.getTotalFechado() == 0) {%>
                                            <td style="color: red;">0</td>
                                            <% } else {%>
                                            <td style="color: black;"><%out.print(df2.format(sate.getTotalFechado()));%>/<%out.print(df2.format(sate.getTotalFechado() + (sate.getTotalAberto())));%></td>
                                            <%}
                                                    }
                                                }
                                            %>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                            <!-- som -->
                            <div class="col-lg-12 main-chart">
                                <div class="border-head">
                                    <h3 >INDICADOR DA UTILIZAÇÃO DO SISTEMA DE SOM </h3>
                                    <h5>Numeros de pedidos Fechado / Numeros total de pedidos </h5>
                                </div>
                                <table class="table table-hover">
                                    <hr>
                                    <thead>
                                        <tr>
                                            <%for (Indicador_model_anual sate : sateAnual) {
                                                    if (sate.getOficina().equals("SOM")) {
                                                        String mesInd = "";
                                                        int mesTemp = Integer.parseInt(sate.getMes());
                                                        switch (mesTemp) {
                                                            case 1:
                                                                mesInd = "Janeiro";
                                                                break;
                                                            case 2:
                                                                mesInd = "Fevereiro";
                                                                break;
                                                            case 3:
                                                                mesInd = "Março";
                                                                break;
                                                            case 4:
                                                                mesInd = "Abril";
                                                                break;
                                                            case 5:
                                                                mesInd = "Maio";
                                                                break;
                                                            case 6:
                                                                mesInd = "Junho";
                                                                break;
                                                            case 7:
                                                                mesInd = "Julho";
                                                                break;
                                                            case 8:
                                                                mesInd = "Agosto";
                                                                break;
                                                            case 9:
                                                                mesInd = "Setembro";
                                                                break;
                                                            case 10:
                                                                mesInd = "Outubro";
                                                                break;
                                                            case 11:
                                                                mesInd = "Novembro";
                                                                break;
                                                            case 12:
                                                                mesInd = "Dezembro";
                                                                break;
                                                        }
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) >= 0.90) {%> 
                                            <th style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></th>
                                                <%} else {%>
                                            <th style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></th>
                                                <%}
                                                        }
                                                    }%>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <%for (Indicador_model_anual sate : sateAnual) {
                                                    if (sate.getOficina().equals("SOM")) {
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) >= 0.90) {%> 
                                            <td style="color: black;"><%out.print(df2.format(sate.getTotalFechado()));%>/<%out.print(df2.format(sate.getTotalFechado() + (sate.getTotalAberto())));%></td>
                                            <%} else if (sate.getTotalAberto() + sate.getTotalFechado() == 0) {%>
                                            <td style="color: red;">0</td>
                                            <% } else {%>
                                            <td style="color: black;"><%out.print(df2.format(sate.getTotalFechado()));%>/<%out.print(df2.format(sate.getTotalFechado() + (sate.getTotalAberto())));%></td>
                                            <%}
                                                    }
                                                }
                                            %>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div><!-- /row -->
                </section>
            </section>

            <!--main content end-->
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
