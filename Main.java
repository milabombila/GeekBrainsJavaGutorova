public class Main {
    public static void main(String[] args) {
        OneLinkedList names = new OneLinkedList();
        names.add("Mike");
        names.add("John");
        names.add("Jakub");
        System.out.println(names);
//
//
//

        TwoLinksList namesTwo = new TwoLinksList();
        namesTwo.add("Mike");
        namesTwo.add("John");
        namesTwo.add("Jakub");
        System.out.println(namesTwo);
        // code....
        namesTwo.add("Marry");
        namesTwo.add("Kaizerine");
        System.out.println(namesTwo);
//
//        names.add(5, "Tomas");
//        names.add(4, "UPD");
//        names.add(1, "UPD1");
////        names.add(10, "NEW");
//        System.out.println(names);

        System.out.println("Size: " + namesTwo.size());

        TwoLinksList.Iterator iterator = namesTwo.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (value != null)
            System.out.println(value);
        }
    }
}
