# GRC Demo #

Aplicación creada para prueba técnica de GRCSolutions Panamá
  
### Prerequesitos de Instalación ###

* Git  (https://git-scm.com/)

* Java JDK 1.8.0_91 ó mayor (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

* Servicios API públicos de [ https://jsonplaceholder.typicode.com ] deben estar retornando datos:
     https://jsonplaceholder.typicode.com/posts
     https://jsonplaceholder.typicode.com/users

### Prerequesitos de Ejecución ###


```bash

# Clonar este repositorio [ git clone https://github.com/fidelchavarria/grcdemo.git ]


Fidels-Air:~ Fidel$  git clone https://github.com/fidelchavarria/grcdemo.git
Cloning into 'grcdemo'...
remote: Counting objects: 969, done.
remote: Compressing objects: 100% (490/490), done.
remote: Total 969 (delta 477), reused 824 (delta 443)
Receiving objects: 100% (969/969), 29.66 MiB | 3.56 MiB/s, done.
Resolving deltas: 100% (477/477), done.



# Entrar a la carpeta  [cd grcdemo ]
Fidels-Air:~ Fidel$ cd grcdemo



# Ejecutar  [ java -jar target/grcdemo-1.1.0-SNAPSHOT.jar ]
Fidels-Air:grcdemo Fidel$ **java -jar target/grcdemo-1.1.0-SNAPSHOT.jar**

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.6.RELEASE)

2017-08-21 18:30:44.589  INFO 1850 --- [           main] net.grc.demo.WebApplication              : Starting WebApplication v1.1.0-SNAPSHOT on Fidels-Air.cpe.cableonda.net with PID 1850 (/Users/Fidel/grcdemo/target/grcdemo-1.1.0-SNAPSHOT.jar started by Fidel in /Users/Fidel/grcdemo)
2017-08-21 18:30:44.596  INFO 1850 --- [           main] net.grc.demo.WebApplication              : No active profile set, falling back to default profiles: default
2017-08-21 18:30:44.748  INFO 1850 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@2cdf8d8a: startup date [Mon Aug 21 18:30:44 EST 2017]; root of context hierarchy
2017-08-21 18:30:46.397  INFO 1850 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'restTemplate' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=localApiServiceClient; factoryMethodName=restTemplate; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [net/grc/demo/service/client/LocalApiServiceClient.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=remoteApiServiceClient; factoryMethodName=restTemplate; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [net/grc/demo/service/client/RemoteApiServiceClient.class]]
2017-08-21 18:30:49.144  INFO 1850 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-08-21 18:30:49.175  INFO 1850 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2017-08-21 18:30:49.178  INFO 1850 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.16
2017-08-21 18:30:49.390  INFO 1850 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-08-21 18:30:49.390  INFO 1850 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4646 ms
2017-08-21 18:30:49.746  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-08-21 18:30:49.749  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'webServlet' to [/console/*]
2017-08-21 18:30:49.756  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-08-21 18:30:49.758  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-08-21 18:30:49.758  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-08-21 18:30:49.758  INFO 1850 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-08-21 18:30:51.359  INFO 1850 --- [           main] j.LocalContainerEntityManagerFactoryBean : Building JPA container EntityManagerFactory for persistence unit 'default'
2017-08-21 18:30:51.406  INFO 1850 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
2017-08-21 18:30:51.681  INFO 1850 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.0.12.Final}
2017-08-21 18:30:51.685  INFO 1850 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2017-08-21 18:30:51.690  INFO 1850 --- [           main] org.hibernate.cfg.Environment            : HHH000021: Bytecode provider name : javassist
2017-08-21 18:30:51.864  INFO 1850 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
2017-08-21 18:30:52.381  INFO 1850 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2017-08-21 18:30:53.559  INFO 1850 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000227: Running hbm2ddl schema export
2017-08-21 18:30:53.591  INFO 1850 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000230: Schema export complete
2017-08-21 18:30:53.681  INFO 1850 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2017-08-21 18:30:54.708  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@2cdf8d8a: startup date [Mon Aug 21 18:30:44 EST 2017]; root of context hierarchy
2017-08-21 18:30:54.947  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/],methods=[POST]}" onto public java.lang.String net.grc.demo.view.controller.MainPageController.delete(org.springframework.ui.Model,java.lang.String) throws java.lang.Exception
2017-08-21 18:30:54.949  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/search],methods=[POST]}" onto public java.lang.String net.grc.demo.view.controller.MainPageController.search(org.springframework.ui.Model,java.lang.String[]) throws java.lang.Exception
2017-08-21 18:30:54.949  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/],methods=[GET]}" onto public java.lang.String net.grc.demo.view.controller.MainPageController.home(org.springframework.ui.Model) throws java.lang.Exception
2017-08-21 18:30:54.951  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/local/delete/{id}],methods=[DELETE]}" onto public void net.grc.demo.service.controller.HistoricQuerySearchController.delete(long)
2017-08-21 18:30:54.951  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/local/search]}" onto public java.util.List<net.grc.demo.model.QuerySearch> net.grc.demo.service.controller.HistoricQuerySearchController.search(java.lang.String[])
2017-08-21 18:30:54.952  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/local/queries],methods=[GET]}" onto public java.util.List<net.grc.demo.model.QuerySearch> net.grc.demo.service.controller.HistoricQuerySearchController.findAll()
2017-08-21 18:30:54.959  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-08-21 18:30:54.959  INFO 1850 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-08-21 18:30:55.042  INFO 1850 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-08-21 18:30:55.043  INFO 1850 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-08-21 18:30:55.139  INFO 1850 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-08-21 18:30:55.778  INFO 1850 --- [           main] o.s.w.s.v.f.FreeMarkerConfigurer         : ClassTemplateLoader for Spring macros added to FreeMarker configuration
2017-08-21 18:30:56.115  INFO 1850 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-08-21 18:30:56.256  INFO 1850 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-08-21 18:30:56.268  INFO 1850 --- [           main] net.grc.demo.WebApplication              : Started WebApplication in 12.664 seconds (JVM running for 13.667)
```

### Usar la Aplicacion 
   
   Abrir navegador web y apuntar a  -->   http://localhost:8080/

### Consola base de datos
   
   Abrir navegador web y apuntar a  -->   http://localhost:8080/console
   
   #Datos de conexion   
   
      Saved Settings:	Generic H2 (Embedded)
      Setting Name:	    Generic H2 (Embedded)
      Driver Class:     org.h2.Driver
      JDBC URL:         jdbc:h2:mem:example-app
      user:             sa
      password:         --- vacio ---

 
   # INFO
   
      Tabla :  TBL_QUERY_SEARCH
      sql: select * from TBL_QUERY_SEARCH


      NOTA: 
      La base de datos esta alojada en la memoria, si se reinicia la aplicacion.. 
      todos los datos persistidos anteriormente en la base de datos se perderan !!!


### Tecnologías Utilizadas ###

* spring-boot-web
* Free Marker
* JPA
* Hibernate
* H2 Database
* Junit
* Jquery
* Bootstrap
* HTML5
* CSS
* Javascript
* Logback
* Tomcat

### Contacto ###
  
* email: fidelchavarria@gmail.com
