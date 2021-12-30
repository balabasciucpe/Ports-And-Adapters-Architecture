                                                 Ports-And-Adapters-Architecture
                                                                           
An example of how to use Hexagonal Architecture in the Java World conform Domain Driven Design...

Ports and Adapters also know as Hexagonal Architecture

3 layere:

APPLICATION | CORE | INFRASTRUCTURE

the basic concept, and here he started to draw it on a paper, is to divide your application into three main parts:

application — defines how the outside world interact with an application, it is a gateway to an application core. It might be by Rest controllers, but it could be also by some kind of a message service (like Kafka, RabbitMQ, etc.), command line client or else,

core — here sits the business logic of your application. The goal is to have it written in a plain language so that an analyst or even non-technical person could understand.
 Inside of it we use a domain specific language, which can be easily understand by business people. And another thing, it should be agnostic of any Java framework (like Spring, Jakarta EE, Quarkus, Micronaut), because these are only scaffolding of an application. And the core is the heart of an application, something that encapsulates the logic.

infrastructure — it’s the last part, most of the applications does not only contain business logic but usually they also need to use some external systems, like database, queue, sFTP server, other application and so on.
 In this part we say how this communication will will be implemented (in a core we only say what is needed). For example, in order to persist data in a database we can use several approaches like Hibernate, plain Jdbc, jOOQ or whatever framework we like.

Core doesn’t know about an application and infrastructure layers. It should not know anything about the outside world.
Port it defines all the interactions that a core will have with anything outside. These ports are like contracts (or APIs) and can be divided into two groups incoming (primary) and outgoing (secondary). 
First one are responsible of how you can interact with business core (what commands you can use on it) and latter are used by the core to talk to the outside world.
deci incoming port vor fi interfete cu metode care pot fi apelate from outside to reach our inside part of the application
deci outcoming port vor fi interfete cu metode ce pot fi apelate from inside to outside gen DB 
ports are only definitions of what we would like to do. They are not saying of how to achieve them.
asta e implementat de Adapters
abstractizari pt. flexibilitate si mentabilitate

@transactional pe metode ce lucreaza asupra db, e ca plain jdbc cu getConnection, commit, catch SqlException, rollback -> declarative transaction management, avem si programatic cu TransactionTemplate
--> deci toate metodele ce lucreaza cu DaoObj.save/delete/etc trebe sa fie adnotate cu transactional, ar trebui ca clasa noastre de configuratie (@Configuration) sa fie adnotata cu @EnableTransactionManagement dar daca avem o dependenta spring data - *, va fi facuta automata
@Bean-urile sunt create in clase de configurare sau ne ajuta Spring cu @Stereotype Annotations precum @Service, @Repository, @Component, iar Bean-urile sunt in Container de Spring

Application: Controllers, EventHandlers,
-> In Controller luam Comenzi ca si RequestBody si Query ca sa interogam entitatea 
Core: Model, Ports(userServiceInterface ex. e portIn)
Infrastructure: mappers,  DaoAdapter, EventPublisherAdapter, ConfigurationClasses, la DaoAdapter, in acest caz folosim clasele si interfata noastra, in RunTime, Spring creaza o Implementare a interfetei ce extinde JpaRepository
...dar conform teoriei ar trebui sa fim agnostici de framework
