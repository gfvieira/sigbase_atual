<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
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

        <br><br><br>
        <div class="container">
            <div class="row text-center" style="margin-right: 300px; margin-left: 300px" >
                <div class="box">
                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">
                            <strong>Sistema de troca de serviço da BHMN</strong>
                        </h2>
                        <hr>
                        <p style="font-size: 10px">Se você já possui acesso ao SIG-BASE, por favor utilize seu login e senha.</p>
                        <form  class="form login text-center" name="sigbase" action="" method="POST">
                            <div class="row">
                                <div class="form-group col-lg-12" >
                                    <label>Login:</label>
                                    <input class="form-control text-center" name="nip" id="nip" type="text" required="" placeholder="" autofocus>
                                    <font color="red">${mensagem}</font>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-lg-12" >
                                    <label>Senha:</label>
                                    <input class="form-control text-center" name="senha" id="senha" type="password" required placeholder="" autofocus>
                                </div>
                            </div>
                                <br>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <button type="submit" class="btn btn-default">Entrar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container -->
        <br><br>
        <br><br>
        <br><br>
        <br><br>
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
