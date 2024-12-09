package com.fastcampus.tdd.ch02;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.fastcampus.tdd")
public class ArchUnitTests {
    @ArchTest
    public static final ArchRule 컨트롤러는_서비스패키지만_접근가능하다 =
            classes().that().resideInAnyPackage("..controller..")// 컨트롤러 안에 모든 클래스를 지칭
                    .should().accessClassesThat().resideInAnyPackage("..service..");

    @ArchTest
    public static final ArchRule 컨트롤러는_레파지토리패키지에_접근불가하다 =
            noClasses().that().resideInAnyPackage("..controller..")
                    .should().accessClassesThat().resideInAnyPackage("..repository..");

    @ArchTest
    public static final ArchRule controller접미사가_붙은_클래스는_controller패키지_안에_있어야한다=
            classes().that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("com.fastcampus.tdd.controller");
}
