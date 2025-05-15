# SCPJM-API (API - Sistema Concurso de Membros)

Backend do Sistema Concurso de Membros voltado para atender os módulos frontends (candidato e administração).

###  Compilação e empacotamento  
__Produção__ (config de profile do maven)  
`$ mvn clean package -Pprod `  
	
__Homologação__ (config de profile do maven)  
`$ mvn clean package -Phomolog `  

__Desenv__   
`$ mvn clean package `  
  
  
Nome final do pacote: target/__scpjm-api.war__  
  
  
### Ambientes produção, homologação e desenvolvimento  
* No ambiente de __produção__ e __homologação__:    
    * As configurações de BD, email, logs, chave criptográfica deverão ser isoladas por ambiente nos seguinte arquivo: srv/main/resources/__application.prod.properties__ ou srv/main/resources/__application.homolog.properties__  
    * O frontend e o backend(API) ficarão em um mesmo 'server'(tomcat), portanto, os serviços responderão na mesma porta.  
    
    
* No ambiente de desenvolvimento, de acordo com o arquivo srv/main/resources/__application.properties__, cada serviço (frontend e backend) são ativados em portas distintas.   

