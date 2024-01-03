import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Linked List da collection
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> altraLista = Arrays.asList(1,2,3,4,5);

        LinkedList<Integer> listaDue = new LinkedList<>(altraLista);

        linkedList.add(120);
        linkedList.addFirst(200);
        linkedList.addLast(1000);
        int elemento  = linkedList.get(1);
        System.out.println("Linked elementi: " + linkedList);

        int dimensione = linkedList.size();
        boolean isContenuto = linkedList.contains(120);

        linkedList.remove(1);
        int result = linkedList.removeFirst();
        result  = linkedList.removeLast();

        //Iterator
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            int el = iterator.next();
        }
    }
}