# MySQLConnectionWeb

## Intellij [Spring + Maven + MySQL] 설정 ~ 기본적인 Mybatis, Dao구현까지

+ WAS 없이 Controller를 테스트할 수 있는 Junit 테스트코드 추가 (test>java>하위패키지>ControllerTest.java)

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
- test01
- tbl_member

--------------------------------

## 삽질한 에러 내용 및 해결 방법


1.mysql Connection Test
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

2.Jackson-databind
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

3.Controller Test
 * Error : Circular view path [doA]: would dispatch back to the current handler URL [/doA] again
 * 원인 : ViewResolver 관련된 속성을 dispatcher-servlet.xml 에 정의했는데 테스트가 사용할 설정 파일 위치를 @ContextConfiguration(locations = {"file:web/WEB-INF/applicationContext.xml"}) 로 잡음 
 * 해결 : 설정 파일 위치에 dispatcher-servlet.xml 도 추가함
 * 코드 : 
 ~~~
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml", "file:web/WEB-INF/applicationContext.xml"})
~~~

4.Mybatis Exception
 * Error : 
 ~~~
org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.hyegyeong.todo.mappers.memberMapper.xml.selectMember
### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.hyegyeong.todo.mappers.memberMapper.xml.selectMember
~~~
 * 원인 : Dao 구현 코드에서 namespace 를 Mapper.xml 같은 형태로 선언
 ~~~
  private static final String NAMESPACE = "com.hyegyeong.todo.mappers.memberMapper.xml";
~~~
 * 수정 코드 : 
 ~~~
  private static final String NAMESPACE = "com.hyegyeong.todo.mappers.memberMapper";
~~~
