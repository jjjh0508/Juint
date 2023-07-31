package section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnootationTests {

    @Test
    @Disabled
    public void testIgnore(){
        /*테스트를 무시할 때 사용하는 어노테이션이다.
        * junit4에서 @Ignnore와 같은 기능을 제공한다.
        * */

    }


    @Test
    @Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
    public void testTimeOut() throws InterruptedException{
        Thread.sleep(900);
    }

    /*
    * @Tag를 사용하기 위한 규칙
    * 1. 태그는 공백이나 null를 허용하지 않는다.
    * 2. 다음 글자를 포함하면 안된다 . :           , ( ) $ ! |
    * */

    @Test
    @Tag("development")
    void testTag1(){
        System.out.println("development Tag : testTag1");
    }


    @Test
    @Tag("production")
    void testTag2() {
        System.out.println("production : Tag : testTag2");
    }

    @Test
    @Tags(value = {@Tag("development"),@Tag("production")})
    void testTags(){
        System.out.println("test Tags ");
    }

    /*
    * 테스트 메소드는 실행 순서가 보장되지 않지만 경우에 따라서는 (통합 테스트 환경 등
    * 테스트 순서가 중요한 경우도 있다.
    * 이러한 경우 클래스 레벨에 @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 어노테이션을 추가해주고
    * 각 테스트 메소드에 @Order 어노테이션으로 순서를 지정하면 테스트 순서를 설정할 수 있다.
    * 클래스에 작성한 테스트 메소드의 순서는 MethodOrder에 DisplayName, MethodeName, OrderAnnotation, Random 등이 있다.
    *
    * */
    @Test
    @Order(1)
    void testFirst() {}

    @Test
    @Order(2)
    void testSecond(){}

    @Test
    @Order(3)
    void testThird(){}


    /*
    * RepeatedTest는 명시된 숫자로 얼마나 테스트를 반복할 것인지를 지정해서 사용한다.
    * 반복된 테스트 메소드의 호출은 보통의 @Test 메소드들이랑 똑같이 동작한다.
    * */
    @RepeatedTest(10)
    void testRepeat(){}

}
