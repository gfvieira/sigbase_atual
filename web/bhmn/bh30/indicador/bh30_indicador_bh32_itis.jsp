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
%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || DEPARTAMENTO PESSOAL</title>
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
                <a href="#" class="logo"><b>SIG-BASE || DEPARTAMENTO PESSOAL</b></a>
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
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span>Metas BH-30</span>
                            </a>
                            <ul class="sub">
                                <li><a href="../bh30_meta_inserir.jsp">Inserir</a></li>
                                <li><a href="../bh30_meta_update.jsp" style="color: red">Atualizar</a></li>
                                <li><a href="../ListaMeta.jsp?setor=31&userDiv=30&ano=<%out.print(year);%>">Visualizar BH-31</a></li>
                                <li><a href="../ListaMeta.jsp?setor=32&userDiv=30&ano=<%out.print(year);%>">Visualizar BH-32</a></li>
                                <li><a href="../ListaMeta.jsp?setor=33&userDiv=30&ano=<%out.print(year);%>">Visualizar BH-33</a></li>
                                <li><a href="../ListaMeta.jsp?setor=34&userDiv=30&ano=<%out.print(year);%>">Visualizar BH-34</a></li>
                                <li><a href="../ListaMeta.jsp?setor=CHAPA&userDiv=30&ano=<%out.print(year);%>">Visualizar CHaPA</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class=" fa fa-bar-chart-o"></i>
                                <span style="color: red">Pessoal</span>
                            </a>
                            <ul class="sub">
                                <li><a href="#" style="color: red">Listar</a></li>
                                <li><a href="#" style="color: red">Ferias</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a  href="../bh31/BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-bar-chart-o"></i> BH-31 pessoal</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="../bh32/bh32_home.jsp">
                                <i class="fa fa-bar-chart-o"></i> BH-32 Saúde</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="../bh33/bh33_home.jsp">
                                <i class="fa fa-bar-chart-o"></i> BH-33 Segurança</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="../bh34/BH34.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-bar-chart-o"></i> BH-34 Telamática</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="../chapa/bh30_chapa.jsp">
                                <i class="fa fa-bar-chart-o"></i> CHaPA</a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh30_indicadores.jsp">
                                <i class="fa fa-bar-chart-o"></i> Indicadores</a>
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
                    <div class="row mt">
                        <div class="col-lg-12 main-chart">
                            <div class="content-panel">		
                                <!--CUSTOM CHART START -->
                                <div class="border-head">
                                    <h3>BH-32 | Indicador de Tempo para I/S (ITIS) </h3>
                                    <h5 class="text-center" style="color: black;font-size: 10px;">(Melhores práticas – Abaixo de 10%)</h5>
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
                                            if (sate.getOficina().equals("MEDICINA")) {
                                                String mesInd = "";
                                                int mesTemp = Integer.parseInt(sate.getMes());
                                                switch (mesTemp) {
                                                    case 1:
                                                        mesInd = "JAN";
                                                        break;
                                                    case 2:
                                                        mesInd = "FEV";
                                                        break;
                                                    case 3:
                                                        mesInd = "MAR";
                                                        break;
                                                    case 4:
                                                        mesInd = "ABR";
                                                        break;
                                                    case 5:
                                                        mesInd = "MAI";
                                                        break;
                                                    case 6:
                                                        mesInd = "JUN";
                                                        break;
                                                    case 7:
                                                        mesInd = "JUL";
                                                        break;
                                                    case 8:
                                                        mesInd = "AGO";
                                                        break;
                                                    case 9:
                                                        mesInd = "SET";
                                                        break;
                                                    case 10:
                                                        mesInd = "OUT";
                                                        break;
                                                    case 11:
                                                        mesInd = "NOV";
                                                        break;
                                                    case 12:
                                                        mesInd = "DEZ";
                                                        break;
                                                }
                                                if (temp1 == 0) {
                                                    temp1 = 2; %>  
                                    <div class="bar" style="width: 6%; margin: 0px 4%; margin-left: 50px;">
                                        <%} else {%>
                                        <div class="bar" style="width: 6%; margin: 0px 4%;">
                                            <%}
                                                if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) <= 0.1) {%>
                                            <div class="title" style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></div>
                                            <div class="value tooltips" data-original-title="<%out.print(df.format(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100));%>" data-toggle="tooltip" data-placement="top" style="background: #006400"><%out.print(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100);%>%</div>
                                            <%} else if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) > 0.1 && sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) < 0.4) {%>
                                            <div class="title" style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></div>
                                            <div class="value tooltips" data-original-title="<%out.print(df.format(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100));%>" data-toggle="tooltip" data-placement="top" style="background: #FFFF00"><%out.print(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100);%>%</div>
                                            <%} else {%>
                                            <div class="title" style="color: black; font-size: 14px;"><%out.print(mesInd);%>/<%out.print(sate.getAno());%></div>
                                            <div class="value tooltips" data-original-title="<%out.print(df.format(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100));%>" data-toggle="tooltip" data-placement="top" style="background: #FF0000"><%out.print(sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) * 100);%>%</div>
                                            <%}%>
                                        </div>
                                        <% }
                                            }%>
                                    </div>
                                </div><!-- /panr -->	
                            </div>
                            <div class="col-lg-12 main-chart">
                                <div class="border-head">
                                    <h3 style="color: black;">Tempo médio  / Tempo ideal</h3>
                                </div>
                                <table class="table table-hover">
                                    <hr>
                                    <thead>
                                        <tr>
                                            <%for (Indicador_model_anual sate : sateAnual) {
                                                    if (sate.getOficina().equals("MEDICINA")) {
                                                        String mesInd = "";
                                                        int mesTemp = Integer.parseInt(sate.getMes());
                                                        switch (mesTemp) {
                                                            case 1:
                                                                mesInd = "JAN";
                                                                break;
                                                            case 2:
                                                                mesInd = "FEV";
                                                                break;
                                                            case 3:
                                                                mesInd = "MAR";
                                                                break;
                                                            case 4:
                                                                mesInd = "ABR";
                                                                break;
                                                            case 5:
                                                                mesInd = "MAI";
                                                                break;
                                                            case 6:
                                                                mesInd = "JUN";
                                                                break;
                                                            case 7:
                                                                mesInd = "JUL";
                                                                break;
                                                            case 8:
                                                                mesInd = "AGO";
                                                                break;
                                                            case 9:
                                                                mesInd = "SET";
                                                                break;
                                                            case 10:
                                                                mesInd = "OUT";
                                                                break;
                                                            case 11:
                                                                mesInd = "NOV";
                                                                break;
                                                            case 12:
                                                                mesInd = "DEZ";
                                                                break;
                                                        }
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) <= 1) {%> 
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
                                                    if (sate.getOficina().equals("MEDICINA")) {
                                                        if (sate.getTotalFechado() / (sate.getTotalAberto() + sate.getTotalFechado()) <= 1) {%> 
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
