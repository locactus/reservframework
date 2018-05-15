# reservation-framework [![CircleCI](https://circleci.com/gh/asd-framework/reservframework.svg?style=svg)](https://circleci.com/gh/asd-framework/reservframework)
ASD course project: A framework to implement the reservation system.


We plan to design a reservation  web framework  to implement the reservation-like systems more easily and quickly.
For example:
1. A system for customers to make a appointment with a hairdresser.
2. Or a system for patients to make a appointment with the doctors.

With this framework, we will implement a web system for DMV, to let the people use this web to make appointments with the examiner.


## Skills:
- Java
- Servlet
- MySQL

## Servlet API
### Add an appointment
/appointment?action=add&firstname=james&lastname=liu&phonenumber=9871222234&email=james@mum.edu&starttime=2018-05-09.09:15:00&endtime=2018-05-09.10:15:00
### Get appointments of a day
/appointment?action=list&date=2018-04-21
### Confirm an appointment
/appointment?action=confirm&staffname=manager