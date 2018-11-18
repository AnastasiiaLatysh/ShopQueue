package laba2_list;


import java.util.Calendar;

class SingleLinkedList {

    private Node head;
    private int size;

    SingleLinkedList(){
            head = null;
            size = 0;
        }

        void add(Note note){
        // add new Node to head if head is null
            if (head == null){
                head = new Node(note);
            } else {
                Node current = this.head;
                // while Node in list has next perform iterations
                while (current.next != null){
                    current = current.next;
                }
                // add to element which doesn't have link to next element new node
                current.next = new Node(note);
            }
            size++;
        }

        Note get (int index){
        // throw exception if index more then list size
            if (index >= size){
                throw new ArrayIndexOutOfBoundsException("Index is more than list size");
            }
            Node current = head;
            // if it is not first element in list, make iterations in order to get link to element which is placed
            // on i position in list
            for (int i = 1; i <= index; i++){
                current = current.next;
            }
            // return Note
            return current.note;
        }

        Note remove(int index){

            // throw exception if index more then list size
            Node current = head;

            if (index >= size){
                throw new ArrayIndexOutOfBoundsException("Index is more than list size");
            }

            // if head is element which should be deleted, link current head to element which is next for current head
            else if (index == 0){
                head = head.next;
            }
            else {
                Node previous = head;

                // perform iteration to get link to node which should be deleted
                for (int i = 1; i <= index; i++) {
                    previous = current;
                    current = current.next;
                }

                System.out.println("Previous node is: " + previous.note.toString());
                System.out.println("Next for Previous becomes " + current.next.note.getLastName() + " instead of " +
                        current.note.getLastName());
                // link next of previous node to next of element which should be deleted
                previous.next = current.next;
            }
            size --;
            return current.note;
        }

        int size(){
            return size;
        }

        void print(){
            for (int i = 0; i < size; i++){
                System.out.println(this.get(i).toString());
            }
        }

        void printAscByYear(){
            Note[] notes = new Note[size];
            // store objects of notes in newly created array
            for (int i = 0; i < size; i++){
                notes[i] = this.get(i);
            }

            // sort newly created array using bubble sort
            for (int i = 0; i < notes.length - 1; i++){
                for(int y = 0; y < notes.length - i - 1; y++){
                    if (notes[y].getYearOfBirth() > notes[y + 1].getYearOfBirth()){
                        Note temp = notes[y];
                        notes[y] = notes[y + 1];
                        notes[y + 1] = temp;

                    }
                }
            }

            // print notes sorted by year of birth
            System.out.println("\nNotes sorted by Year of Birth:");
            for (Note note: notes){
                System.out.println(note.toString());
            }

        }

        void printWithAgeLessThenAverage(){
        int sumOfAges = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // perform iterations in order to get total amount of Ages in list
        for (int i = 0; i < size; i++){
            sumOfAges += currentYear - this.get(i).getYearOfBirth();
        }

        // delete to size of list in order to get average age
        int averageAge = sumOfAges / size;

        System.out.println("\nSubscriber with age which is less then average age in the list:");
        for (int i = 0; i < size; i++){
            if (currentYear - this.get(i).getYearOfBirth() < averageAge){
                System.out.println(this.get(i).toString());
            }
        }
    }

}
