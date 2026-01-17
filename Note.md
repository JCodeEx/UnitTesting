
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

JSONAssert::
When we use "JSONAssert.assertEquals(expectedResponse,actualResponse,true);"
here it will check all the parameters present in the actual-response and 
the expected-response and not considering any space commonly.
But when Strict if False:
JSONAssert.assertEquals(expectedResponse,actualResponse,false)
this will not check all but only check the expected value are present 
actual-response or not.but one more is the value of the present must be same as 
in the actual response.
NB- we have two response ans JasonAssert will check the response and where 
exactly difference it will tell.
