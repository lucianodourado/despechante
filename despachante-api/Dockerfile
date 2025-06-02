# stage build
FROM maven AS dev
   
    ARG MVN_PROFILE
   
    WORKDIR  /var/app
   
    ADD . /var/app
    
    RUN mvn --no-transfer-progress clean package $MVN_PROFILE

# stage publish imagem
FROM openjdk AS publish
   
    WORKDIR /var/app
   
    COPY  --from=dev /var/app/target/despachante-api.war /var/app
  
    EXPOSE 8181
   
    ENTRYPOINT ["sh" , "-c" , "java $JAVA_OPTS  -jar /var/app/despachante-api.war"]
   
