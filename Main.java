package geekbrains;

public class Main {

    public static void main(String[] args) {
            Person[] persArray = new Person[5];
            persArray[0]= new Person("Иван Иванов", "сантехник", "iivanov@remont.ru", 89993217659l,30000, 63);
            persArray[1]= new Person("Вася Попов", "химик", "Vpopov@explosion.ru", 89997682391l,330000, 28);
            persArray[2]= new Person("Катя Дмитриева", "блогер", "Kate.Dmitrieva@fd.com", 89994267567l,730000, 21);
            persArray[3]= new Person("Елизавета Ливанова", "бухгалтер", "ElizLivanova@money.ru", 89991115482l,60000, 52);
            persArray[4]= new Person("Анна Кулебякина", "пекарь", "AnnKul@pekarnya.ru", 89992546198l,55000, 33);
            for (int i = 0; i <persArray.length ; i++) {
                if(persArray[i].Age > 40){
                    persArray[i].GetInformation();
                }
            }
        }
    }

