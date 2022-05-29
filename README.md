# Mi Portfolio - Mariano Perez

### Argentina Programa - [#YoProgramo](http://www.yoprogramo.org.ar/)

### Capa Backend

Desarrollada con [Spring Boot](https://spring.io/projects/spring-boot) y hosteada en [Heroku](https://dashboard.heroku.com/apps)

Repositorio de la capa frontend: [github.com/marandres9/portfolio-front](https://github.com/marandres9/portfolio-front)

La aplicaciión backend cuenta con un servicio de autenticación, el cual mediante un filtro es capaz de interceptar cualquier solicitud desde el frontend y veirificar si el usuario esta autorizado a acceder o a llevar a cabo operaciones sobre la base de datos. 

La aplicación provee únicamente dos endpoints a los que un usuario no autenticado con un token JWT puede acceder. Dichos endpoints son *"/portfolio/get"* y *"/authenticate"*, cuyas respectivas funciones son la de devolver un objeto DTO que contiene toda la información del portfolio que se encargará de mostrar la aplicación frontend, y la de autenticar a un usuario enviando las credenciales al servidor y devolviendo el token JWT o avisando que son inválidas. Esto es así ya que cualquier cliente debe poder visualizar el portfolio y iniciar sesión.

Por otra parte, cualquier operación que modifique los contenidos de la página deberá realizarla un usuario autorizado con un token JWT.

En la siguiente imagen se muestra la llamada a la API que devuelve los datos del portfolio. El objeto sería recibido por el frontend y distribuido en sus componentes.
![](img/get_portfolio.png)

