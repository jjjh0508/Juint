package com.jihwan.section02;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AssertJTest {

    @Test
    @DisplayName("문자열 테스트 하기")
    void testStringValidation() {
        String expected = "hello world";

        String actual = new String(expected);
        Assertions.assertThat(actual)
                .isNotEmpty() // "", null
                .isNotBlank()// "" , null, " "
                .contains("hello") //  포함 하고 있나
                .doesNotContain("hahahoho") // 포함 되지 않나
                .startsWith("h")// 시작하냐
                .endsWith("d")// 끝나냐
                .isEqualTo("hello world"); // 이거랑 같은
    }

    @Test
    @DisplayName("숫자 테스트 하기")
    void testIntegerValidation() {
        double pi = Math.PI;

        Double actual = Double.valueOf(pi);
        System.out.println(actual);
        Assertions.assertThat(actual)
                .isPositive()
                .isGreaterThan(3) // 이보다 크냐
                .isLessThan(4) // 이거보다 작냐
                .isEqualTo(Math.PI);

    }

    @Test
    @DisplayName("날짜 테스트 하기")
    void testLocalDateTimeValidation() {
        String birthDay = "2014-09-18T16:42:00.000";

        LocalDateTime thatDay = LocalDateTime.parse(birthDay);
        Assertions.assertThat(thatDay)
                .hasYear(2014)
                .hasMonthValue(9)
                .hasDayOfMonth(18)
                .isBetween("2014-01-01T00:00:00.000", "2014-12-31T23:59:59.999")
                .isBefore(LocalDateTime.now());
    }

    @Test
    @DisplayName("예외 테스트 하기")
    void testExceptionValidation() {
        Throwable thorw = AssertionsForClassTypes.catchThrowable(
                () -> {
                    throw new IllegalArgumentException("잘못된 파라미터를 입력하였습니다.");

                });
        Assertions.assertThat(thorw)
                .isInstanceOf(IllegalArgumentException.class) //타입 비교
                .hasMessageContaining("파라미터"); // 메세지를 포함하는지
    }


    @Test
    @DisplayName("예외 테스트하기2")
    void testExceptionValidation2() {
//        Assertions.assertThatThrownBy(
//                        () -> {
//                            throw new IllegalArgumentException(" 잘못된 파라미터를 입력하였습니다");
//                        }).isInstanceOf(IllegalArgumentException.class) // 타입 비교
//                .hasMessageContaining("잘못된"); // 메세지가 포함 됐는지

        /*자주 사용하는 예외처리에 대한 정의된 함수를 제공한다.
         * 1. assertThatNullPointerExcepiont
         * 2. assertThatIllegalArgumentException
         * 3. assertThatIllegalStateException
         * 4. assertThatIOException */
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");
                }).withMessageContaining("파라미터");


    }

    @Test
    @DisplayName("예외를 던지지 않는 경우 테스트하기")
    void testNoneException() {
        Assertions.assertThatCode(
                () -> {
                    System.out.println("안녕 예외가 없는 테스트");
                }
        ).doesNotThrowAnyException();
    }


//
//    @Test
//    void Test() {
//        Throwable throwable = new IllegalArgumentException();
//        boolean reuslt = (throwable instanceof  IllegalArgumentException);
//        org.junit.jupiter.api.Assertions.assertTrue(reuslt);
//
//    }


    @Test
    @DisplayName("filltering assertions 테스트하기")
    void testFilteringAssertions() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(1, "user04", "임꺽정", 19);

        List<Member> members = Arrays.asList(member1, member2, member3, member4);
        Assertions.assertThat(members)
                .filteredOn(m->m.getAge() > 20) //값을 꺼내서 비교하고
                .containsOnly(member3); //찾은값에 이 값이 있냐
    }

    @Test
    @DisplayName("객체의 프로퍼티 검증 테스트하기")
    void testPropertyValidation() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(1, "user04", "임꺽정", 19);
        List<Member> members = Arrays.asList(member1, member2, member3, member4);

        Assertions.assertThat(members)
                .filteredOn("age",20)
                .containsOnly(member1);
    }

    @Test
    @DisplayName("프로퍼티 추출 테스트하기")
    void testExtractProperty() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(1, "user04", "임꺽정", 19);
        List<Member> members = Arrays.asList(member1, member2, member3, member4);

        List<String> expected = Arrays.asList("홍길동", "유관순", "이순신", "임꺽정");

        Assertions.assertThat(members)
                .extracting("name", String.class)
                .containsAll(expected);
    }

    @Test
    @DisplayName("튜플로 추출하여 테스트하기")
    void testExtractPropertyTuple() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(1, "user04", "임꺽정", 19);
        List<Member> members = Arrays.asList(member1, member2, member3, member4);

        Assertions.assertThat(members)
                .extracting("name","age")
                .contains(
                        Tuple.tuple("홍길동",20), // 그룹화
                        Tuple.tuple("유관순",16)
                );
    }


}
