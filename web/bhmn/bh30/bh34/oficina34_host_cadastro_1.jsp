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
<%String ip = request.getParameter("host");%>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);%>


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
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <h3 class="mb"><i class="fa fa-angle-double-right"></i> <b>Cadastro de IP</b></h3><br>
                                <br>
                                <form class="form-horizontal style-form" action="HostIp.jsp" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Nome do Host</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="host" name="host" required="">
                                        </div>
                                        <label class="col-sm-2 col-sm-2 control-label">IP</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" value="<%out.print(ip);%>" disabled>
                                            <input type="hidden" class="form-control" id="ip" name="ip" value="<%out.print(ip);%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">MAC Address</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="mac" name="mac" required="">
                                        </div>
                                        <label class="col-sm-2 col-sm-2 control-label">Setor</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="setor" required>
                                                <option value="">Selecione!</option>
                                                <option value="BH-01">BH-01</option>
                                                <option value="BH-02">BH-02</option>
                                                <option value="BH-03">BH-03</option>
                                                <option value="BH-04">BH-04</option>
                                                <option value="BH-05">BH-05</option>
                                                <option value="BH-06">BH-06</option>
                                                <option value="BH-07">BH-07</option>
                                                <option value="BH-08">BH-08</option>
                                                <option value="BH-10">BH-10</option>
                                                <option value="BH-11">BH-11</option>
                                                <option value="BH-12">BH-12</option>
                                                <option value="BH-13">BH-13</option>
                                                <option value="BH-20">BH-20</option>
                                                <option value="BH-21">BH-21</option>
                                                <option value="BH-22">BH-22</option>
                                                <option value="BH-23">BH-23</option>
                                                <option value="BH-24">BH-24</option>
                                                <option value="BH-25">BH-25</option>
                                                <option value="BH-30">BH-30</option>
                                                <option value="BH-31">BH-31</option>
                                                <option value="BH-32">BH-32</option>
                                                <option value="BH-33">BH-33</option>
                                                <option value="BH-34">BH-34</option>
                                                <option value="BH-40">BH-40</option>
                                                <option value="BH-41">BH-41</option>
                                                <option value="BH-42">BH-42</option>
                                                <option value="BH-43">BH-43</option>
                                                <option value="BH-44">BH-44</option>
                                                <option value="BH-45">BH-45</option>
                                                <option value="BH-50">BH-50</option>
                                                <option value="BH-51">BH-51</option>
                                                <option value="BH-52">BH-52</option>
                                                <option value="BH-53">BH-53</option>
                                                <option value="BH-54">BH-54</option>
                                                <option value="BH-50">BH-55</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group" id="infoHost">
                                        <label class="col-sm-2 control-label">Tipo de Host</label>


                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="type" required>
                                                <option value="">Selecione!</option>
                                                <option value="HARDWARE">Estação de Trabalho</option>
                                                <option value="SERVER">Servidor</option>
                                                <option value="SWITCH">Switch</option>
                                                <option value="SCANNER">Scanner</option>
                                                <option value="BIOMETRIA">Biometria</option>
                                                <option value="PRINT">Impressora</option>
                                                <option value="DVR">DVR</option>                                                
                                            </select>
                                        </div> 
                                        <label class="col-sm-2 col-sm-2 control-label">Sistema Operacional</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="so" id="selectSO" onchange="campoObservacao();" required>
                                                <option value="">Selecione!</option>
                                                <option value="Windows XP">Windows XP</option>
                                                <option value="Windows Serve 2003">Windows Serve 2003</option>
                                                <option value="Windows 7 32bits">Windows 7 32bits</option>
                                                <option value="Windows 7 64bits">Windows 7 64bits</option>
                                                <option value="Windows 8 32bits">Windows 8 32bits</option>
                                                <option value="Windows 8 64bits">Windows 8 64bits</option>
                                                <option value="Linux - Ubunto">Linux - Ubunto</option>
                                                <option value="Linux - Suse">Linux - Suse</option>
                                                <option value="Linux - Oracle">Linux - Oracle</option>
                                                <option value="VMware">VMware</option>
                                                <option value="FreeNas">FreeNas</option>
                                                <option value="Impressora OKI">Impressora OKI</option>
                                                <option value="Switch gerenciavel">Switch gerenciavél</option>
                                                <option value="Switch não-gerenciavel">Switch não-gerenciavél</option>
                                                <option value="DVR">DVR</option>
                                                <option value="OUTROS">Outros</option>
                                            </select>
                                        </div> 
                                    </div>

                                    <div class="form-group" >
                                        <label class="col-sm-2 col-sm-2 control-label">Lacre</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="lacre" name="lacre">
                                        </div>
                                        <label class="col-sm-2 col-sm-2 control-label">Responsavél</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="resp" name="resp" required="">
                                        </div>
                                    </div>
                                    <input type="hidden" class="form-control" id="nip" name="nip" value="<%out.print(usuario.getNip());%>">
                                    <br>
                                    <hr>
                                    <br>
                                    <button type="submit" class="btn btn-theme">Cadastrar</button>
                                    <input type="button"  class="btn btn-theme"  value="Cancelar" onClick="Voltar()">
                                    <div class="centered"><font color="red">${mensagem}</font></div>
                                </form>
                            </div>
                            <br>
                            <br>
                        </div>
                    </div><! --/row -->
                </section>
            </section>

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
        <script type="text/javascript" src="../../assets/js/js_bh34_telematica.js"></script>

        <script type="text/javascript" src="../../assets3/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="../../assets3/js/gritter-conf.js"></script>	


    </body>
</html>