import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    public void nullElement(){
        DoublyLinkedList<String> nulllist = new DoublyLinkedList<>();
        assertThrows(NullPointerException.class, () -> nulllist.add(null));
    }

    @Test
    public void indexOut() {
        DoublyLinkedList<Integer> indexErrorTest = new DoublyLinkedList<>();
        indexErrorTest.add(0, 1);
        indexErrorTest.add(1, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> indexErrorTest.add(4,3));
    }

    @Test
    public void addTest(){
        DoublyLinkedList<Integer> addTester = new DoublyLinkedList<>();
        assertTrue(addTester.add(1));
        addTester.add(3);
        addTester.add(4);
        assertEquals(1, addTester.get(0));
//        assertTrue(addTester.contains(1));
//        assertTrue(addTester.add(5));
//        assertTrue(addTester.contains(5));
    }

    @Test
    public void addIntTest(){
        DoublyLinkedList<Integer> addIntTester = new DoublyLinkedList<>();
        addIntTester.add(0,1);
        addIntTester.add(1,2);
        addIntTester.add(2,3);
        assertEquals(Integer.valueOf(1), addIntTester.get(0));
        assertEquals(Integer.valueOf(2), addIntTester.get(1));
        assertEquals(Integer.valueOf(3), addIntTester.get(2));
    }

    @Test
    public void clearList() {
        DoublyLinkedList<Integer> clearTester = new DoublyLinkedList<>();
        clearTester.add(0, 3);
        clearTester.add(1, 5);
        clearTester.clear();
        assertTrue(clearTester.isEmpty());
        assertEquals(0, clearTester.size());
        clearTester.add(1);
        clearTester.add(2);
        clearTester.add(3);
        clearTester.clear();
        assertTrue(clearTester.isEmpty());
        assertEquals(0, clearTester.size());
    }

    @Test
    public void getTest(){
        DoublyLinkedList<Integer> getTester = new DoublyLinkedList<>();
        getTester.add(0,1);
        getTester.add(1,2);
        getTester.add(2,3);
        assertEquals(Integer.valueOf(1), getTester.get(0));
        assertEquals(Integer.valueOf(2), getTester.get(1));
        assertEquals(Integer.valueOf(3), getTester.get(2));
    }

    @Test
    public void emptyTest(){
        DoublyLinkedList<Integer> emptyTester = new DoublyLinkedList<>();
        assertTrue(emptyTester.isEmpty());
        emptyTester.add(3);
        emptyTester.clear();
        assertTrue(emptyTester.isEmpty());
        emptyTester.add(1);
        assertFalse(emptyTester.isEmpty());
    }

    @Test
    public void removeTester(){
        DoublyLinkedList<Integer> removeTester = new DoublyLinkedList<>();
        removeTester.add(1);
        removeTester.add(2);
        removeTester.add(3);
        assertEquals(2, removeTester.remove(1));
        assertEquals(2, removeTester.size());
        removeTester.add(1);
        removeTester.add(2);
        removeTester.add(3);
        removeTester.remove(0);
        assertEquals(3, removeTester.remove(0));
    }

    @Test
    public void setTester(){
        DoublyLinkedList<Integer> setTester = new DoublyLinkedList<>();
        setTester.add(1);
        setTester.add(2);
        setTester.add(3);
        setTester.set(0,0);
        assertEquals(Integer.valueOf(0), setTester.get(0));
        assertEquals(Integer.valueOf(2), setTester.set(1,3));
        assertEquals(3, setTester.size());
    }

    @Test
    public void sizeTester(){
        DoublyLinkedList<Integer> sizeTester = new DoublyLinkedList<>();
        sizeTester.add(1);
        sizeTester.add(2);
        sizeTester.add(3);
        assertEquals(3,sizeTester.size());
        sizeTester.add(0,8);
        sizeTester.add(8);
        assertEquals(5, sizeTester.size());
        sizeTester.remove(0);
        sizeTester.remove(2);
        sizeTester.remove(0);
        assertEquals(2, sizeTester.size());

    }

    @Test
    public void stringTester(){
        DoublyLinkedList<Integer> stringTester = new DoublyLinkedList<>();
        assertEquals("[(head) -> (tail)]", stringTester.toString());
        stringTester.add(1);
        stringTester.add(2);
        stringTester.add(3);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> (tail)]", stringTester.toString());
        stringTester.remove(2);
        assertEquals("[(head) -> 1 -> 2 -> (tail)]", stringTester.toString());
    }
}