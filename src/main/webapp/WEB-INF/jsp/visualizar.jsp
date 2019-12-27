<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Atualizar Cartorio</title>
    
     <style type="text/css">
	    .titulo{text-align: center;font-size: 30px;}
	 	#conteudo{text-align:center; font-size: 16px;font-family: sans-serif}
	 	#titulo-lista{margin-top: 50px; font-family: sans-serif}
	 	#btn-novo{background-color: #e8921d;padding: 25px;border-radius: 25px;font-family: sans-serif;font-size: 20px;margin-top: 50px;}
	 	.btn-acoes{padding: 7px;border-radius: 10px;font-size: 18px;background-color: #e8921d;margin: 10px;}
	    input{width: 300px;height: 25px;border-radius: 8px;margin: 15px;font-size: 16px}
	    table{margin-top: 2%;border-collapse: collapse;width: 100%;	}
 		th,td{padding: 10px; text-align: left; border-bottom: 1px solid #ddd; font-family: sans-serif}
    </style>
    
</head>
<body>
    <div>
        <div id="topo">
        <p class="titulo">Cartório: ${cartorio.nomeCartorio}</p>
            <hr/>
        </div>
        <div>
            <div id="conteudo">
                <form:form action="/" modelAttribute="cartorio" method="get">
                    <div>
                        <div>
                            <span>Id: ${cartorio.id}</span><br>
                            <span>Cartorio: ${cartorio.nomeCartorio}</span><br>
                        </div>
                        <div>
                            <button type="submit" class="btn-acoes">Pagina Inicial</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>