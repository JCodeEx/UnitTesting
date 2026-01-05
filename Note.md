
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




