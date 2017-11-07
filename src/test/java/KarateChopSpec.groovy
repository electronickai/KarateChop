import spock.lang.Specification
import spock.lang.Unroll

class KarateChopSpec extends Specification {

//    def classUnderTest = new KarateChopFunctional();
    def classUnderTest = new KarateChopLoop();
//    def classUnderTest = new KarateChopRecursive();
//    def classUnderTest = new KarateChopStream();
//    def classUnderTest = new KarateChopTreeOfSublists();

    @Unroll
    def "when #search isn't contained in #array -1 shall be returned"() {
        expect:
        classUnderTest.chop(search, new ArrayList<Integer>(array)) == -1

        where:
        search | array
        3      | []
        3      | [1]
        0      | [1,3,5]
        2      | [1,3,5]
        4      | [1,3,5]
        6      | [1,3,5]
        0      | [1,3,5,7]
        2      | [1,3,5,7]
        4      | [1,3,5,7]
        6      | [1,3,5,7]
        8      | [1,3,5,7]
    }

    @Unroll
    def "when #search is searched in #array, expected position is #position"() {
        expect:
        classUnderTest.chop(search, new ArrayList<Integer>(array)) == position

        where:
        search | array     || position
        1      | [1]       || 0
        1      | [1,3,5]   || 0
        3      | [1,3,5]   || 1
        5      | [1,3,5]   || 2
        1      | [1,3,5,7] || 0
        3      | [1,3,5,7] || 1
        5      | [1,3,5,7] || 2
        7      | [1,3,5,7] || 3
    }

}
