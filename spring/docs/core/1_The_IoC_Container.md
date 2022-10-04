스프링 프레임웤의 IoC container 를 다루는 방법은 AOP 와 관련이 있다.

# 1. The IoC Container

## 1.1. Introduction to the Spring IoC Container and Beans

- Inversion of Control 는 dependency injection 이라고도 알려짐
- 객체가 자신의 의존성을 생성자의 인자나, 팩토리 메서드로 정의하거나 객체가 만들어진 후 properties 를 셋하거나 properties 를 팩토리 메서드로 리턴받는 것을 말함
- 객체 스스로가 의존성을 정하는게 아니라 다른 무언가에 의해서 의존성이 정해지는 것을 말함
- container 가 빈이 생성될 때 의존성을 주입해줌


- `ApplicationContext` extends `BeanFactory`
- `ApplicationContext` 는 기능이 추가됨
  - AOP 통합
  - Message resource handling (국제화)
  - Event publication
  - 웹어플리케이션을 위한 `WebApplicationContext` 같은 Application-layer specific contexts


- 스프링에서 어플리케이션을 위한 객체들을 Spring IoC container 에서 관리하고 이들을 빈이라고 함
- 빈들은 Spring IoC container 에서 초기화되고, 조립되고 관리됨
- 빈들의 의존 관계 등의 설정은 container 가 configuration metadata 를 통해서 읽어들임  

## 1.2. Container Overview

- `ApplicationContext` 가 Spring Ioc container 임
- 빈을 초기화, 설정, 조립하는 책임을 가짐
- container 는 configuration metadata 를 통해서 빈을 초기화, 설정, 조립함
- configuration metadata 는 XML, Java @, Java code 등으로 작성가능함

![Figure 1. The Spring IoC container](https://docs.spring.io/spring-framework/docs/current/reference/html/images/container-magic.png)

Figure 1. The Spring IoC container

### 1.2.1. Configuration Metadata

- 위의 그림처럼 Spring IoC container 는 configuration metadata 가 필요함
- configuration metadata 는 3가지 방법이 있음
  - XML
  - Java @
  - Java code (얘를 주로 씀)
- 스프링 설정은 컨테이너가 관리하는 bean definition 라는 것으로 구성되어 있음


- 주로 아래 항목을 정의함
  - service layer objects
  - data access objects (DAOs)
  - infrastructure objects (Hibernate `SessionFactories` ...)
- domain objects 들은 정의하지 않음
- 그건 DAOs 나 비지니스 로직의 책임임
- 하지만 AspectJ 를 이용해 IoC 컨테이너 밖에서 생성된 빈을 제어할 수 있음

### 1.2.2. Instantiating a Container

- local file system, java `CLASSPATH`, 기타 등등으로부터 configuration metadata 를 읽으라고 `ApplicationContext` 의 생성자로 전달함
  ``` java
  ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
  ```
  
### 1.2.3. Using the Container

- `T getBean(String name, Class<T> requiredType)` 메서드를 이용해서 원하는 빈을 가져올 수 있음
  ```java
  // create and configure beans
  ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
  
  // retrieve configured instance
  PetStoreService service = context.getBean("petStore", PetStoreService.class);
  
  // use configured instance
  List<String> userList = service.getUsernameList();
  ```
