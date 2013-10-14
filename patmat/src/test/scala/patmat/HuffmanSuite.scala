package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
    trait TestTrees {
        val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
        val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
        val l1 = Leaf('a', 5)
        val l2 = Leaf('b', 3)
        val l3 = Leaf('c', 1)

        val loremChars = string2Chars("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum egestas venenatis consectetur.")
        val loremTree = createCodeTree(string2Chars("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum egestas venenatis consectetur."))

        val testCodeTable = List(('a', List(1, 1)), ('b', List(0, 0)), ('c', List(0, 1)), ('d', List(1, 0)))

    }

    test("weight of a leaf") {
        new TestTrees {
            assert(weight(l1) === 5)
        }
    }

    test("weight of a larger tree") {
        new TestTrees {
            assert(weight(t1) === 5)
        }
    }

    test("weight of an even larger tree") {
        new TestTrees {
            assert(weight(t2) === 9)
        }
    }

    test("char of a leaf") {
        new TestTrees {
            assert(chars(l1) === List('a'))
        }
    }

    test("chars of a larger tree") {
        new TestTrees {
            assert(chars(t2) === List('a', 'b', 'd'))
        }
    }

    test("chars of an large tree") {
        new TestTrees {
            assert(chars(t1) === List('a', 'b'))
        }
    }

    test("string2chars(\"hello, world\")") {
        assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
    }

    test("times aaa") {
        assert(times(string2Chars("aaababbaaa")).head._2 === 7)
    }

    test("is singleton tree") {
        new TestTrees {
            assert(singleton(List[CodeTree](t1)))
        }
    }

    test("is NOT singleton tree") {
        new TestTrees {
            assert(!singleton(List[CodeTree](t1, t2)))
        }
    }

    test("is NOT singleton tree (empty)") {
        new TestTrees {
            assert(!singleton(List[CodeTree]()))
        }
    }

    test("until") {
        new TestTrees {
            assert(until(singleton, combine)(List(l1, l2, l3)) === Fork(Fork(l1, l2, List(l1.char, l2.char), l1.weight + l2.weight), l3, List(l1.char, l2.char, l3.char), l1.weight + l2.weight + l3.weight))
        }
    }

    test("makeOrderedLeafList for some frequency table") {
        assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
    }

    test("combine of some leaf list") {
        val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
        assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
    }

    test("test create tree should finish") {
        createCodeTree(string2Chars("hejhejhejdåoooooooooooooooo"))
    }

    test("decode") {
        assert(decode(createCodeTree(string2Chars("aabb")), List(0, 0, 1, 1)) === string2Chars("aabb"))
    }

    test("decode with french") {
        assert(decode(frenchCode, List(1, 1, 0)) === string2Chars("e"))
    }

    test("encodeOneChar") {
        val char = 'h'
        assert(decode(frenchCode, encodeOneChar(frenchCode, char, List())) == List(char))

    }

    test("decode and encode a very short text should be identity") {
        new TestTrees {
            assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
        }
    }
    test("decode and encode some lorem ipsum") {
        new TestTrees {
            assert(decode(createCodeTree(loremChars), encode(loremTree)(loremChars)) === loremChars)
        }
    }

    test("codeBits test") {
        new TestTrees {
            assert(codeBits(testCodeTable)('a') == List(1, 1))
            assert(codeBits(testCodeTable)('d') == List(1, 0))
        }
    }

    test("quick encode") {
        new TestTrees {
            assert(quickEncode(t2)("abd".toList)===List(0, 0, 0, 1, 1))
        }
    }
}
