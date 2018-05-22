# reservation-framework [![CircleCI](https://circleci.com/gh/asd-framework/reservframework.svg?style=svg)](https://circleci.com/gh/asd-framework/reservframework)
## Reservation Framework
A framework to implement the reservation system.

Presentation: [wiki](https://github.com/asd-framework/reservframework/wiki)

We designed a reservation web framework to implement the reservation-like systems more easily and quickly.

#### Team members:
- Professor: Hanhong Lu
- Wenqiang Li
- Yuliang Jin
- Cun Yang

## Reservation Website
We implemented a website based on out framework. This website offered two key features:
- Customers can make appointments from a web page.
- The system admin can process all the appointments from the customers by approval the appointments.

**Login page:**

<img width="600" src="https://user-images.githubusercontent.com/5343215/40284054-56c6397e-5c4e-11e8-8db9-75926f192321.png">

**Making new appointment:**

<img width="600" src="https://user-images.githubusercontent.com/5343215/40284056-56f5c69e-5c4e-11e8-92e8-bfe3088ff782.png">

**Processing the appointments:**

<img width="600" src="https://user-images.githubusercontent.com/5343215/40284053-56ab8642-5c4e-11e8-9065-a0aced2a27ff.png">

## Skills
- Java
- Servlet
- MySQL

## Applied Design Patterns (14):
<ul class="wiki-pages" data-filterable-for="wiki-pages-filter" data-filterable-type="substring">
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/01.-Abstract-Factory-%E2%88%9A">01. Abstract Factory √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/02.-Builder-%E2%88%9A">02. Builder √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/03.-Factory-Method">03. Factory Method</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/04.-Prototype">04. Prototype</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/05.-Singleton-%E2%88%9A">05. Singleton √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/06.-Adapter-%E2%88%9A">06. Adapter √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/07.-Bridge">07. Bridge</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/08.-Composite">08. Composite</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/09.-Decorator">09. Decorator</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/10.-Facade">10. Facade</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/11.-Flyweight-%E2%88%9A">11. Flyweight √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/12.-Proxy-%E2%88%9A">12. Proxy √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/13.-Chain-of-Responsibility-%E2%88%9A">13. Chain of Responsibility √</a>
    </li>
    <li>
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/14.-Command-%E2%88%9A">14. Command √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/15.-Interpreter">15. Interpreter</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/16.-Iterator-%E2%88%9A">16. Iterator √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/17.-Mediator">17. Mediator</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/18.-Memento-%E2%88%9A">18. Memento √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/19.-Observer">19. Observer</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/20.-State-%E2%88%9A">20. State √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/21.-Strategy-%E2%88%9A">21. Strategy √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/22.-Template-Method-%E2%88%9A">22. Template Method √</a>
    </li>
    <li class="wiki-more-pages">
      <a class="wiki-page-link" href="/asd-framework/reservframework/wiki/23.-Visitor-%E2%88%9A">23. Visitor √</a>
    </li>

  </ul>


## Servlet API
### Add an appointment
/appointment?action=add&firstname=james&lastname=liu&phonenumber=9871222234&email=james@mum.edu&starttime=2018-05-09.09:15:00&endtime=2018-05-09.10:15:00
### Get appointments of a day
/appointment?action=list&date=2018-04-21
### Confirm an appointment
/appointment?action=confirm&staffname=manager
