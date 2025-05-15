FROM repo.mpm.mp.br/base/node:10.22 AS dev

    RUN npm config set registry=https://registry.npmjs.org/

    RUN npm config set @mpm:registry=https://repo.mpm.mp.br/repository/npm/
   
    RUN npm install -g @angular/cli@10.1.0

    WORKDIR  /var/app

    COPY . /var/app

    # Instala as dependencias e compila a aplicacao
    WORKDIR  /var/app/src/main/webapp
  
    RUN npm install 
    

# stage build
FROM repo.mpm.mp.br/base/jdk:11-maven3.6 AS builder
  
    ARG MVN_PROFILE
  
    COPY  --from=dev /var/app /var/app
    
    WORKDIR  /var/app
  
    RUN mvn --no-transfer-progress clean package $MVN_PROFILE

# stage publish imagem
FROM repo.mpm.mp.br/base/jdk:11 AS publish
  
    WORKDIR /var/app
  
    COPY  --from=builder /var/app/target/despachante-app.war /var/app
  
    EXPOSE 8282
  
    ENTRYPOINT ["sh" , "-c" , "java $JAVA_OPTS  -jar /var/app/despachante-app.war"]
  
