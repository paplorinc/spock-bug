import spock.lang.Specification

/*
 * Because of the nested assertions, it currently fails with:
 * NestedAssertTest.groovy: -1: The current scope already contains a variable of the name $spock_errorCollector
 * NestedAssertTest.groovy: -1: The current scope already contains a variable of the name $spock_valueRecorder
**/
class NestedAssertTest extends Specification {
    def "Test nested asserts"() {
        expect:
        true
    }

    /*
    * - Has to be in a separate method - calling directly doesn't fail
    * - Has to contain an outer and an inner assert
    * - Both have to be inside closures
    **/
    def nestedAssert() {
        tap {
            assert 0
            tap { assert 0 }
        }
    }
}
