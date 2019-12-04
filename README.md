# MySQLConnectionWeb

## Intellij를 사용하 때 [Spring + Maven + MySQL] 설정파일들을 어떻게 잡아야 하는지 기억하는 용도의 프로젝트

+ WAS 없이 Controller를 테스트할 수 있는 테스트코드 추가 (test>java>하위패키지>ControllerTest.java)

+ Springloaded로 코드 수정시 WAS 재가동할 필요없도록 hot-swap기능 추가

-------------------------------

## Prerequisites

* jdk1.8 (Open Jdk Zulu 사용)
* Spring (4.3.18.RELEASE)
  - JSP
  - Lombok
  - MVC Model
* MySQL DB
* Maven

--------------------------------

## Structure

1. test_db01

--------------------------------

## 에러 내용 및 해결 방법


1.Datasource Test
 * Error : The server time zone value ‘KST’ is unrecognized or represents more than one time zone
 * 원인 : mysql-connector-java 버전 5.1.X 이후 버전부터 KST 타임존을 인식하지 못함
 * Error 발생 파일 : applicationContext.xml
 * Error 코드 : DataSource 설정 url의 <property name="url" value="jdbc:mysql://127.0.0.1:3306/test_db01?useSSL=false"/>
 * 수정 코드 : <property name="url" value="jdbc:mysql://127.0.0.1:3306/test_db01?useSSL=false&amp;serverTimezone=UTC"/>

2.mysql Connection Test
 * Error : java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password'.
 * 원인 : mysql connector버전을 local에 설치한 DB 버전과 맞추지 않아 발생
 * Error 원인 파일 : pom.xml
 * 수정 코드 :
~~~
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
        <version>8.0.18</version>
    </dependency>
~~~

3.Jackson-databind
 * Error : java.lang.IllegalArgumentException: No converter found for return value of type ….
 * 원인 : Json으로 변환할 때 필요한 라이브러리를 pom.xml에 추가해서 적용된줄 알았는데, Project Structure > Artifacts 를 보니 적용이 안돼있어서 더블클릭으로 추가함.
 * Error 원인 파일 : pom.xml + 프로젝트에 라이브러리 미반영
 * 코드 : 
 ~~~
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.5.1</version>
</dependency>
~~~

4.MockMVC 를 이용한 Junit Test
 * Error : No mapping found for HTTP request with URI
 * 원인 : 내부 웹 관련 처리작업을 설정하는 것은 dispatcher-servlet.xml이나, 애플리케이션 컨텍스트 설정 파일위치를 applicationContext.xml로 잘못 지정
 * 해결 : ContextConfiguration 어노테이션의 위치를 dispatcher-servelt.xml 로 변경 : @ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml"})
