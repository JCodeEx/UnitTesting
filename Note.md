
SomeBusinessMockImpl business = new SomeBusinessMockImpl();
SomeDataService mockDataService = mock(SomeDataService.class);

@BeforeEach
public void before(){
business.setSomeDataService(mockDataService);
}

 on teh top  we are creating the mock object manually and also inject to
SomeBusinessMockImpl, so the same thing  will 
be done by MOCKITO framework as below
@InjectMock
SomeBusinessMockImpl business = new SomeBusinessMockImpl();
@Mock
SomeDataService mockDataService;
And we don't need to use the "before" method  now and the setter method of 
mock will do .

But the @RunWith(MockitoJunitRunner.class) we need to add on top of the class.

@ExtendWith(MockitoExtension.class) is used instead of  @RunWith(MockitoJunitRunner.class) which is used in old junit4
@RunWith is not showing because Spring Boot 4 uses JUnit 5, 
and @RunWith is a JUnit 4 annotation. You must use @ExtendWith(...) 
or Spring’s test annotations instead.
====================================
@Test
public void returnWithParameter(){
when(mock.get(0)).thenReturn("HelloJunit");
assertEquals("HelloJunit",mock.get(0));
assertEquals(null,mock.get(1));
}

here when we are calling a specific index then we will get the 

=================
Lets say we have 5 controller  and other component in our application and when  we do the start 
like normal spring boot application then all the components will start 
this is now a unit testing it is called integration testing .
SO if we cant to do (unit testing ) ,lets say one controller the we need to 
go with "Spring Mock MVC " framework  comes.

SO how do we write the Test for controller? use @WebMvcTest annotation on test class
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
}
and to run the test we need to add the @RunWith(SpringRunner.class) 
with the class.
@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
}



Old pom FIle :

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>4.0.1</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.javacodex</groupId>
<artifactId>unittesting</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>unittesting</name>
<description>Unit testing  for Spring Boot Application</description>
<url/>
<licenses>
<license/>
</licenses>
<developers>
<developer/>
</developers>
<scm>
<connection/>
<developerConnection/>
<tag/>
<url/>
</scm>
<properties>
<java.version>17</java.version>
</properties>
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webmvc-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
