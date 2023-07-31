package scetion02.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationTests {

    @BeforeAll
    public static void 테스트_실행전_딱한번_실행(){
        //테스트 코드 실행시 자원을 할당하는 경우
        System.out.println("BeforeAll 실행됨");
    }
    /*
    *  @Test ,@RepeatedTest , @ParameterizedTest , @TestFactory
    * 위의 테스트 메소드가 실행되기 전 실행이 되며 주로 테스트 하기전 필요한 목업 데이터를 미리 세팅해줄 목적으로 사용한다.
    * */
    @BeforeEach
    void beforeEach(){
        System.out.println("테스트 마다 실행전 실행됨");
    }



    @AfterAll
    public static void 테스트_종료후_딱한번_실행됨(){
        //테스트 코드 종료시 자원을 해제할 때 사용함
        System.out.println("AfterAll 실행됨");
    }
    /*
    * @Test ,@RepeatedTest , @ParameterizedTest , @TestFactory 들이
    * 실행된 이후 실행되며 주로 단위 테스트들이 수행된 이후 사용한 자원을 해제할 목적으로 사용한다.
    * */
    @AfterEach
    void afterEach(){
        System.out.println("테스트 마다 종료시 실행됨");
    }
    @Test
    void 고민영_엄살(){
        System.out.println("자꾸 쉬자고 하네");
    }

    @Test
    void 챗_상우(){
        System.out.println("질문을 해주세요 돈주세요");
    }
}
