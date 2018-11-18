package laba2_list;

public class StartProgram {

    public static void main(String[] args){
        /*
    Описать структуру с именем NOTE, с полями: фамилия, номер телефона, год рождения. Сформировать односвязный список.
    Затем напечатать элементы списка по возрастанию, используя в качестве первичного ключа – год рождения.
    Затем напечатать информацию о тех абонентах, возраст которых меньше среднего возраста всех абонентов.
     */

        // create six objects (each one has Note type)
        Note note1 = new Note("A", "094858", 1971);
        Note note2 = new Note("B", "0000", 2000);
        Note note3 = new Note("C", "10939084", 1993);
        Note note4 = new Note("D", "094858", 1987);
        Note note5 = new Note("E", "0000", 2009);
        Note note6 = new Note("F", "10939084", 1994);
        SingleLinkedList singlyList = new SingleLinkedList();

        // add them to singly linked list
        singlyList.add(note1);
        singlyList.add(note2);
        singlyList.add(note3);
        singlyList.add(note4);
        singlyList.add(note5);
        singlyList.add(note6);

        System.out.println("Initial list is: ");
        singlyList.print();

        //remove note with name "E" (fifth one in list)
        System.out.println("Remove fifth node (node with name \"E\")");
        singlyList.remove(4);

        // check list after removal
        System.out.println("\nAfter remove:");
        System.out.println("Size is: " + singlyList.size());
        singlyList.print();

        // add fifth Note to list and check that Note becomes the last one in singly linked list
        singlyList.add(note5);
        System.out.println("\nAfter adding new Note to list:");
        singlyList.print();

        singlyList.printAscByYear();
        singlyList.printWithAgeLessThenAverage();

    }
}
