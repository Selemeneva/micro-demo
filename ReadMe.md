# План проекта
2 новых модуля: 
- конфиг сервер (стартер) :
 <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-config</artifactId>
- Gateway : org.springframework.cloud
  spring-cloud-starter-gateway - общение через Gateway
Для конфиг сервера будет нужно место, откуда он берет конфиги - 
через отдельный гит-репозиторий. Туда поместить все local.yaml файлы.

- **Service Discovery (Eureka)** - сколько у нас микросервисов и  какие у них адреса (адресная книга)
Посылает всем сервисам запросы - живы ли сервисы. Если кто-то не отвечает, то 
Eureka его убирает из списка. Actuator.health - endpoint. 

- Gateway - сервер-маршрутизатор, через который мы ходим к другому сервису. Единая точка 
входа в приложение. 
Порядок действий: 
- добавляем конфиг-сервер
- поднимаем Eureka
- поднимаем stock-app, customer-app (stock-app идет в конфиг-сервер
за конфигами и регистрируется в Eureka)
- rest-clients (http) default bean - rest template. не удобен. не знаем конкретного адреса
spring cloud есть библиотека feign-client. Интегрирован с Eureka - идет в Eureka по имени
достает адрес. Во всех сервисах, в которых идет обращение к другим сервисам.
- Статистика - отдельный микросервис - ловит events от всех. 
