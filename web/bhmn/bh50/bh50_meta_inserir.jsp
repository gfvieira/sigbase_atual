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
<%String temp = (String) request.getAttribute("mensagem");%>
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
                            <div class="form-panel">
                                <h3 class="mb"><i class="fa fa-angle-double-right"></i> <b>Cadastro de Metas</b></h3><br>
                                <%if (temp != null) {
                                        if (temp.equals("OK")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Meta cadastrada com sucesso.</div>
                                <%} else if (temp.equals("OK1")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Meta atualizada com sucesso.</div>
                                <%} else {%>
                                <div class="alert alert-danger"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                    }%>
                                <br>
                                <form class="form-horizontal style-form" action="InsereMeta.jsp" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label2">Meta</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" rows="3" id="TxtObservacoes" name="meta" maxlength="5000" placeholder="Digite aqui a descrição do problema!" required></textarea>
                                            <span class="caracteres">5000</span> Restantes
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label2">Tipo de Meta</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="tipo" required>
                                                <option value="">Selecione!</option>
                                                <option value="1">Curto prazo</option>
                                                <option value="2">Médio prazo</option>
                                                <option value="3">Longo prazo</option>
                                            </select>
                                        </div>
                                        <label class="col-sm-2 col-sm-2 control-label2 ">Ano da Meta</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="ano" required>
                                                <option value="">Selecione!</option>
                                                <option value="2016">2016</option>
                                                <option value="2017">2017</option>
                                                <option value="2018">2018</option>
                                                <option value="2019">2019</option>
                                                <option value="2020">2020</option>
                                            </select>
                                        </div> 
                                        <label class="col-sm-1 col-sm-1 control-label">Setor</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" size="1" name="setor" required>
                                                <option value="">Selecione!</option>
                                                <option value="1">BH-01</option>
                                                <option value="2">BH-02</option>
                                                <option value="3">BH-03</option>
                                                <option value="4">BH-04</option>
                                                <option value="5">BH-05</option>
                                                <option value="6">BH-06</option>
                                                <option value="7">BH-07</option>
                                                <option value="8">BH-08</option>
                                                <option value="10">BH-10</option>
                                                <option value="11">BH-11</option>
                                                <option value="12">BH-12</option>
                                                <option value="13">BH-13</option>
                                                <option value="20">BH-20</option>
                                                <option value="21">BH-21</option>
                                                <option value="22">BH-22</option>
                                                <option value="23">BH-23</option>
                                                <option value="24">BH-24</option>
                                                <option value="25">BH-25</option>
                                                <option value="30">BH-30</option>
                                                <option value="31">BH-31</option>
                                                <option value="32">BH-32</option>
                                                <option value="33">BH-33</option>
                                                <option value="34">BH-34</option>
                                                <option value="40">BH-40</option>
                                                <option value="41">BH-41</option>
                                                <option value="42">BH-42</option>
                                                <option value="43">BH-43</option>
                                                <option value="44">BH-44</option>
                                                <option value="45">BH-45</option>
                                                <option value="50">BH-50</option>
                                                <option value="51">BH-51</option>
                                                <option value="52">BH-52</option>
                                                <option value="53">BH-53</option>
                                                <option value="54">BH-54</option>
                                                <option value="55">BH-55</option>
                                                <option value="301">CHaPA</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input type="hidden" class="form-control" name="user" value="<%out.print(usuario.getNip());%>">
                                    <input type="hidden" class="form-control" name="userDiv" value="50">
                                    <br>
                                    <hr>
                                    <br>
                                    <button type="submit" class="btn btn-theme">Cadastrar</button>
                                    <input type="button"  class="btn btn-theme"  value="Cancelar" onClick="Voltar()">
                                </form>
                            </div>
                            <br>
                            <br>
                        </div>
                    </div><! --/row -->
                </section>
            </section>
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
