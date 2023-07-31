package section05.custom;

public class CustomAnnotationTests {

    @WindowsTest
    void windCustom(){
        System.out.println("테스트");
    }


    @MacTest
    void macCuston(){
        System.out.println("맥에서만 테스트 하게요");
    }


    @DevelopmentTest
    void devTest() {
        System.out.println("dev 테스트");
    }

    @ProductionTest
    void proTest() {
        System.out.println("prodution 테스트");
    }
}
