# SCPJM-Admin - Módulo Administração do Concurso

Frontend do Sistema Concurso de Membros voltado para gerenciamendo do concurso pelos membros comissão.

###  Compilação e empacotamento  
__Produção__ (config de profile do maven)  
`$ mvn clean package -Pprod `  
	
__Homologação__ (config de profile do maven)  
`$ mvn clean package -Phomolog `  

__Desenv__   
`$ mvn clean package `  
      
   
Nome final do pacote: target/__scpjm-admin.war__  
    
    
### Ambientes produção/desenvolvimento  
* No ambiente de __produção__ e __homologação__, o frontend e o backend(API) ficarão em um mesmo 'server'(tomcat), portanto responderão na mesma porta. É possível indicar o caminho da API em: 
    * src/main/webapp/src/environments/__environment.prod.ts__ 
    * src/main/webapp/src/environments/__environment.homolog.ts__
    
    
* No ambiente de __desenvolvimento__ (normalmente localhost), de acordo com o arquivo srv/main/resources/__application.properties__, cada serviço (frontend e backend) são ativados em portas distintas. A configuração da url da API fica em: 
    * src/main/webapp/src/environments/__environment.ts__
    
    