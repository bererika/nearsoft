# nearsoft
nearsoft java school test

Nombre: Erika Berenice Hernández Angulo

##Funcionalidad y ejemplos de uso

ChallengeApplication está creada utilizando Springboot, H4, Loombok y JPA

Tiene dos endpoints un POST y un GET, agrego ejemplos de los llamados:
###Ejemplo:
POST:
Request
http://localhost:8080/api/alias/
{
  "url": "www.google.com"
}

Response: status 200
WXIUD


GET:
Request
http://localhost:8080/api/alias/?alias=WXIUD

Response: status 200
www.google.com

###Otro ejemplo:
POST:
Request
http://localhost:8080/api/alias/
{
  "url": "https://github.com/bererika/nearsoft"
}

Response: status 200
httpsgthbcmbrrknrsft


GET:
Request
http://localhost:8080/api/alias/?alias=httpsgthbcmbrrknrsft
Response: status 200
https://github.com/bererika/nearsoft


##Información del API

Realicé dos "attempts" para generar los Alias para las Url de entrada.

La primera AliasGeneratorUtil, aqui se encuentran todos los casos para generar el alias de una URL en 
la misma clase. 
En ApiService.class se encuetra comentado su uso en las lineas 43 y 44.

La segunda, utilicé el patrón de diseño Chain of responsability en la clase AliasGenerators
para de esta manera menajar todos los casos posibles de la implementación, esto hace más robusto la aplicación
ya que si se desean agregar ó eliminar "formas" para generar alias no es necesario editar clases ajenas, sino 
extender las existentes. El uso de este "attempt" se encuentra en ApiService.class a partir de la línea 48.

Los datos se almacena in-memory con H2 durante la ejecución del programa.


	