<%@page import="src.modelo.pesquisa.Pesquisa_habilidade"%>
<%@page import="src.modelo.pesquisa.Pesquisa_sexo"%>
<%@page import="src.modelo.pesquisa.Pesquisa_nota"%>
<%@page import="src.modelo.Resposta_model"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%Pesquisa_nota nota = (Pesquisa_nota) request.getAttribute("nota");
    Pesquisa_sexo sexo = (Pesquisa_sexo) request.getAttribute("sexo");
    Pesquisa_habilidade habilidade = (Pesquisa_habilidade) request.getAttribute("habilidade");
    DecimalFormat df = new DecimalFormat("0.0");%>

<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>= BHMN =</title>
        <link rel="shortcut icon" href="assets/images/gt_favicon.png">

        <!-- Bootstrap Core CSS -->
        <link href="assets3/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets3/css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="assets3/fonts/font.css" rel="stylesheet" type="text/css">
        <link href="assets3/fonts/font2.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!--[endif]-->

    </head>

    <body>

        <div class="brand"><a href="/sigbase/index.html" style="margin-left: 0px; margin-right: 400px; margin-bottom: 0px"><img src="assets3/img/logos/BHMN.png" class="" alt="" width="80"></a>
            SIG-BASE
            <a href="http://www.mar.mb" style="margin-left:400px; margin-right:0px; margin-bottom: 0px" ><img src="assets3/img/mb.png" class="" alt="bhmn" width="80" ></a></div> 

        <div class="address-bar">Sistema de Informações Gerenciais da Base de Hidrografia da Marinha em Niterói</div>

        <!-- Navigation -->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                    <a class="navbar-brand" href="../">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a class="page-scroll" href="#" style="color: black">Acesso ao Folha-N</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="../loginSigbase.jsp" style="color: black">Acesso ao Sig-base</a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Pesquisas <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../pesquisa/ResultadoClimaOrg.jsp?perg=0">Clima Organizacional</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="#" style="color: black">Como Utilizar?</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                    <a class="navbar-brand" href="../">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black">Serviço CNPA<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../sistemas/servico/trocadeServico.jsp">Troca de Serviço</a></li>
                                <li><a href="../sistemas/servico/logintrocaServico.jsp">Acesso ao sistema</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="page-scroll" href="#" style="color: black">BH-05 Programa Netuno</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="#" style="color: black">BH-20 Intendência</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="../telematica/home_telematica.html" style="color: black">BH-34 Telemática</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="../oficina/oficinabh50.html" style="color: black">BH-50 Apoio</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Clima Organizacional
                    </h2>
                    <hr>
                    <br> 
                    <br>
                    <p class="intro-text" align="center">Masculino: <%out.print(df.format((sexo.getMasc() / sexo.getTotal()) * 100));%>%</p>
                    <br> 
                    <p class="intro-text" align="center">Femnino: <%out.print(df.format((sexo.getFem() / sexo.getTotal()) * 100));%>%</p>
                    <br>                    
                    <h2 class="intro-text text-center">Com a nota de 1 a 10 como você avalia a BHMN como uma OM para se trabalhar?</h2>
                    <br>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <td><i class="center-block"></i>Nota 1</td>
                                <td><i class="center-block"></i>Nota 2</td>
                                <td><i class="center-block"></i>Nota 3</td>
                                <td><i class="center-block"></i>Nota 4</td>
                                <td><i class="center-block"></i>Nota 5</td>
                                <td><i class="center-block"></i>Nota 6</td>
                                <td><i class="center-block"></i>Nota 7</td>
                                <td><i class="center-block"></i>Nota 8</td>
                                <td><i class="center-block"></i>Nota 9</td>
                                <td><i class="center-block"></i>Nota 10</td>
                            </tr>
                            <tr>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN1() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN2() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN3() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN4() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN5() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN6() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN7() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN8() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN9() / nota.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((nota.getN10() / nota.getTotal()) * 100));%>%</td>
                            </tr>

                        </tbody>
                    </table>
                    <br><br>                    
                    <h2 class="intro-text text-center">Em sua opinião, em que habilidade o Comandante de sua OM mais se destaca?</h2>
                    <br>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <td><i class="center-block"></i>Relacionamento com as equipes</td>
                                <td><i class="center-block"></i>Pensamento Estratégico</td>
                                <td><i class="center-block"></i>Comunicação</td>
                                <td><i class="center-block"></i>Entrega de resultados</td>
                                <td><i class="center-block"></i>Motivação</td>
                                <td><i class="center-block"></i>Liderança</td>
                            </tr>
                            <tr>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN1() / habilidade.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN2() / habilidade.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN3() / habilidade.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN4() / habilidade.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN5() / habilidade.getTotal()) * 100));%>%</td>
                                <td><i class="center-block"></i><%out.print(df.format((habilidade.getN6() / habilidade.getTotal()) * 100));%>%</td>
                            </tr>

                        </tbody>
                    </table>
                    <br>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Clima Organizacional
                    </h2>
                    <hr>
                    <br> 
                    <h2 class="intro-text text-center">Selecione a Perguntas para exibir Resultado:</h2>
                    <br>
                    <form class="form-horizontal style-form" action="ResultadoClimaOrg.jsp" method="post">
                        <div class="form-group">
                            <label class="col-sm-5 col-sm-5 control-label">Pergunta:</label>
                            <div class="col-sm-3">
                                <select class="form-control" size="1" name="perg" required>
                                    <option value=""></option>
                                    <option value="1">Geral</option>
                                    <%for (int i = 5; i < 108; i++) {%>
                                    <option value="<%out.print(i - 4);%>">Pergunta <%out.print(i);%></option>
                                    <%}%>
                                </select>                            
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 col-sm-5 control-label"></label>
                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-default">Consultar Pergunta</button>
                            </div>
                        </div>
                    </form>
                    <br><br> 
                </div>
            </div>
        </div>
        <!-- /.container -->

        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal1" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Comunicado aos servidores ? Pesquisa GPTW</h4>
                    </div>
                    <div class="modal-body">                                          



                    </div>
                </div>
            </div>
        </div>


        <footer>
            <div class="container">
                <div class="row">
                    <br>
                    <div style="font-size:11px; padding-bottom: 30px" class="col-lg-12 text-center">
                        <p>Todos os Direitos Reservados © 2016 - Base de Hidrografia da Marinha em Niterói</p>
                        <p>Rua Barão de Jaceguai s/n - CEP: 24048-900 - Ponta da Armação - Niterói - RJ</p>
                        <p>Tel: 2189-3469 - Retelma: 8112-3469 - Fax: 2189-3467 </p>
                        <p>Tel: 2189-3186 - Retelma: 8112-3186 (Sala de Estado)</p>
                    </div>
                    <br>
                    <br>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="assets3/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="assets3/js/bootstrap.min.js"></script>

        <!-- Script to Activate the Carousel -->
        <script>
            $('.carousel').carousel({
                interval: 5000 //changes the speed
            })
        </script>
        <!--<script type="text/javascript">
            $(document).ready(function () {
                $('#myModal1').modal({
                    show: true
                });
            });
        </script>-->

    </body>

</html>
