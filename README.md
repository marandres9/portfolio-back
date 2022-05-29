# Mi Portfolio - Mariano Perez

### Argentina Programa - [#YoProgramo](http://www.yoprogramo.org.ar/)

### Capa Backend

Desarrollada con [Spring Boot](https://spring.io/projects/spring-boot) y hosteada en [Heroku](https://dashboard.heroku.com/apps)

Repositorio de la capa frontend: [github.com/marandres9/portfolio-front](https://github.com/marandres9/portfolio-front)

La aplicaciión backend cuenta con un servicio de autenticación, el cual mediante un filtro es capaz de interceptar cualquier solicitud desde el frontend y veirificar si el usuario esta autorizado a acceder o a llevar a cabo operaciones sobre la base de datos. La aplicación provee únicamente dos endpoints a los que un usuario no autenticado puede acceder.